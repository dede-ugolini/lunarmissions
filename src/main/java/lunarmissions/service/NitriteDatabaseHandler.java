package lunarmissions.service;


import org.dizitart.no2.Nitrite;
import org.dizitart.no2.collection.NitriteCollection;
import org.dizitart.no2.collection.UpdateOptions;
import org.dizitart.no2.collection.Document;
import org.dizitart.no2.collection.DocumentCursor;
import org.dizitart.no2.mvstore.MVStoreModule;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.dizitart.no2.filters.FluentFilter.where;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import lunarmissions.standard.Mission;

public class NitriteDatabaseHandler implements DatabaseAdapter{

	private static final String FILE_PATH = "database.bd";

	//DocumentMapper documentMapper = new DocumentMapper();
	
	private static MVStoreModule storeModule;
	private static Nitrite database;

	//tables definitions
	private static String MISSAO_ID_FIELD = "id";
	
	//collections definitions
	private static String MISSAO_COLLECTION_NAME = "missaoCollection";
	private static NitriteCollection missaoCollection;
	
	public NitriteDatabaseHandler() {
		initNitrite();
		
		//para testesssss
		//start();
	}
	
	//TODO: Fazer com que o ID fique armazenado no bancoe de dados e nao na classe service
	
	private static void initNitrite() {
		storeModule = MVStoreModule.withConfig()
				.filePath(FILE_PATH)
				.compress(true)
				.build();
		
		database = Nitrite.builder()
				.loadModule(storeModule)
				.openOrCreate();
		
		missaoCollection = database.getCollection(MISSAO_COLLECTION_NAME);
		
		initDatabaseCounter();
	}
	
	private static void initDatabaseCounter() {
		Document content = Document.createDocument().put("ID_COUNTER", 1).put("ID_TYPE", "MISSION_CLASS");
		missaoCollection.insert(content);
	}
	/*
	public void create(Document document) {
		/*
		Document content = Document.createDocument()
				.put("UUID", missao.getID())
				.put("name", missao.getName())
				.put("destination", missao.getDestination())
				.put("goal", missao.getGoal())
				.put("spaceship", missao.getSpaceShip());
	}
	
	public Document read(String field, String key) {
		return missaoCollection.find(where(field).eq(key)).firstOrNull();
	}
		
	public void update(Document document, String field, String key) {
		missaoCollection.update(where(field).eq(key), document, UpdateOptions.updateOptions(true));
	}
	
	/*
	public void update(Document document, Document newDocument) {
		Document contentToUpdate = Document.createDocument().put("_id", document.getId());
		
		missaoCollection.update(contentToUpdate);
	}
	
	public void delete(Document document) {
		missaoCollection.remove(document);
	}
	*/
	
	public List<Document> getAllDocuments() {
		return missaoCollection.find().toList();
	}
		
	private int getCurrentDatabaseCounter() {
		Document result = missaoCollection.find(where("ID_TYPE").eq("MISSION_CLASS")).firstOrNull();
		
		return Integer.parseInt(result.get("ID_COUNTER").toString());
	}
	
	private void incrementCounter() {
		int currentIDCounter = getCurrentDatabaseCounter();
		currentIDCounter = currentIDCounter + 1;
		
		Document dataToUpdtate = Document.createDocument().put("ID_COUNTER", currentIDCounter);
		missaoCollection.update(where("ID_TYPE").eq("MISSION_CLASS"), dataToUpdtate, UpdateOptions.updateOptions(true));
	}
	
	public boolean checkDatabaseExist() {
		Path path = Paths.get(FILE_PATH);

		if (Files.exists(path)) {
		    return true;
		} else {
		    return false;
		}
	}

	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub
		Document content = DocumentMapper.toDocument(o);
		content.put(MISSAO_ID_FIELD, getCurrentDatabaseCounter());
		missaoCollection.insert(content);
		
		missaoCollection.insert(content);
		incrementCounter();
	}

	@Override
	public String read(String field, String key) {
		// TODO Auto-generated method stub
		return getCollection().find(where(field).eq(key)).toList().toString();
	}

	@Override
	public void update(Object o, String field, String key) {
		// TODO Auto-generated method stub
		Document doc = getCollection().find(where(field).eq(key)).firstOrNull();
		Document contentToUpdate = DocumentMapper.toDocument(o);
		
		contentToUpdate.put("_id", doc.get("_id"));
		getCollection().update(contentToUpdate);
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		Document docToRemove = DocumentMapper.toDocument(o);
		if (docToRemove != null) {
			getCollection().remove(docToRemove);
		}
	}
	
	@Override
	public String listAll() {
		return getAllDocuments().toString();
	} 
	
	@Override
	public void resetDatabase() {
		database.close();
		try {
			Files.deleteIfExists(Paths.get("database.db"));
		} catch (IOException e) {
			System.out.println("Erro ao tentar deletar o arquivo de base de dados " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public NitriteCollection getCollection() {
		return this.missaoCollection;
	}
	
}

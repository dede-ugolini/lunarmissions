package lunarmissions.service;

import lunarmissions.standard.*;
import lunarmissions.view.ConsoleColors;
import lunarmissions.service.DocumentMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;


public class BinaryDatabaseHandler implements DatabaseAdapter{

	private static final File FILE_PATH = new File("MissionDatabaseBinary.dat");
	
	//Lista para trabalhar em memoria
	//private List<Mission> missionsList;
	
	//Inicializando o banco de dados, e coletando as missioes e armazenando em memoria
	public List<Mission> initOnMemoryList() {
		if (getFilePath().exists()) {
			try {
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getFilePath()));
				return (List<Mission>) objectInputStream.readObject();
			} catch (Exception e) {
				System.out.println("Erro ao tentar acessar a base de dados e coletar os dados armazenados " + e.getMessage());
				return null;
			}
		}
		else {
			return new ArrayList<Mission>();
		}
	}
	
	public void save(List<Mission> missionsList) {
		try {
			ObjectOutputStream objectOutputtStream = new ObjectOutputStream(new FileOutputStream(getFilePath()));
			
			objectOutputtStream.writeObject(missionsList);
		} catch (Exception e) {
			System.out.println("Erro ao tentar salvar os dados contidos na lista em memoria " + e.getMessage());
		}
	}

	
	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub
		List<Mission> missionList = initOnMemoryList();
		Mission mission = (Mission) o;
		missionList.add(mission);
		
		save(missionList);
	}

	@Override
	public String read(String field, String key) {
		List<Mission> missionList = initOnMemoryList();
		for (int x = 0; x < missionList.size(); x++) {
			if (missionList.get(x).getField(field).equals(key)) {
				return missionList.get(x).toString();
			}
		}
		return null;
	}

	@Override
	public void update(Object o, String field, String key) {
	    try {
	    	//Encontrar a missao a ser atualizada
	    	List<Mission> missionList = initOnMemoryList();
	    	
	    	Mission mission = null;
	    	for(int x = 0; x < missionList.size(); x++) {
	    		if (missionList.get(x).getField(field).equals(key)) {
	    			mission = missionList.get(x);
	    			missionList.remove(x);
	    			break;
	    		}
	    	}
	    	
	    	Mission updateMission = (Mission)o;
	    	updateMission.setID(mission.getID().toString());
	    	missionList.add(updateMission);
	    	save(missionList);
	    } catch (Exception e) {
	    	System.out.println("Erro ao tnetar realizar o update " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		Mission missionToRemove = (Mission)o;
		List<Mission> missionList = initOnMemoryList();
		
		for (int x = 0; x < missionList.size(); x++) {
			if (missionList.get(x).getID().toString().equals(missionToRemove.getID().toString())) {
				missionList.remove(x);
				break;
			}
		}
	}

	@Override
	public String listAll() {
		// TODO Auto-generated method stub
		List<Mission> missionList = initOnMemoryList();
		for (Mission mission : missionList) {
			System.out.println(mission.toString());
		}
		return missionList.toString();
	}

	@Override
	public void resetDatabase() {
		// TODO Auto-generated method stub
		try {
			Files.deleteIfExists(getFilePath().toPath());
		} catch (IOException e) {
			System.out.println("Erro ao tentar deletar o arquivo de base de dados " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public File getFilePath() {
		return FILE_PATH;
	}

	/*
	public List<Mission> getMissionsList() {
		return this.missionsList;
	}
	*/
}

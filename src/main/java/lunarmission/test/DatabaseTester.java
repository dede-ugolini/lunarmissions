package lunarmission.test;/*
                           *
                           * import org.dizitart.no2.collection.Document;
                           *
                           * import lunarmissions.service.DocumentMapper;
                           * import lunarmissions.standard.Mission;
                           *
                           * import lunarmissions.service.DatabaseAdapter;
                           * import lunarmissions.service.NitriteDatabaseHandler;
                           * import lunarmissions.service.BinaryDatabaseHandler;
                           *
                           * public class DatabaseTester {
                           *
                           * public void start() {
                           * System.out.println("Hello World");
                           *
                           * testDatabaseAdpter()
                           * }
                           *
                           * public DatabaseTester() {
                           * start();
                           * }
                           *
                           * public static void main(String[] args) {
                           * new DatabaseTester();
                           * }
                           *
                           * // Testando as conversoes de Object para Document, tendo compatibilidade com
                           * o
                           * // Nitrite
                           * public void testDocumentMapper() {
                           *
                           * // Convertendo document para object, e object para document
                           * Mission missao = new Mission();
                           * missao.setName("TheMissionName");
                           * missao.setDestination("TheDestinationInfo");
                           * missao.setGoal("theGoalInfo");
                           * missao.setSpaceShip("TheSpaceShip");
                           *
                           * Document content = Document.createDocument()
                           * .put("UUID", missao.getID())
                           * .put("name", missao.getName())
                           * .put("destination", missao.getDestination())
                           * .put("goal", missao.getGoal())
                           * .put("spaceship", missao.getSpaceShip());
                           *
                           * System.out.println("Converting a document to a object and vice-versa");
                           * Mission missao2 = DocumentMapper.toObject(content, Mission.class); ///
                           * Criando Object atraves de document
                           *
                           * Document docMissao2 = DocumentMapper.toDocument(missao2); // Criando o
                           * docMissao
                           * }
                           *
                           * public void testDatabaseAdpter() {
                           * Mission missao = new Mission();
                           * missao.setName("TheMissionName");
                           * missao.setDestination("TheDestinationInfo");
                           * missao.setGoal("TheGoalInfo");
                           * missao.setSpaceShip("TheSpaceShip");
                           *
                           * Document content = Document.createDocument()
                           * .put("UUID", missao.getID())
                           * .put("name", missao.getName())
                           * .put("destination", missao.getDestination())
                           * .put("goal", missao.getGoal())
                           * .put("spaceship", missao.getSpaceShip());
                           *
                           * DatabaseAdapter db = new NitriteDatabaseHandler();
                           * db.create(DocumentMapper.toDocument(content));
                           *
                           * String theReadValue = db.read("name", missao.getName());
                           * System.out.println("O valor lido: " + theReadValue);
                           *
                           * System.out.println("");
                           *
                           * System.out.println("Listando tudo");
                           * System.out.println(db.listAll());
                           * }
                           *
                           * }
                           */

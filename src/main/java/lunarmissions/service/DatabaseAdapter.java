package lunarmissions.service;

public interface DatabaseAdapter {

	void create(Object  o);
	
	String read(String field, String key);
	
	void update(Object o, String  field, String key);
	
	void delete(Object o);

	String listAll();
	
	void resetDatabase();
}

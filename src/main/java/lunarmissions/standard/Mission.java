package lunarmissions.standard;

import java.io.Serializable;
import java.util.UUID;

/**
 * Representa uma viagem específica a Lua
 */
public class Mission implements Serializable {

	private UUID uuid = UUID.randomUUID();
	private String name;
	private String destination;
	private String goal;
	private String spaceShip;
	// private ArrayList<Astronaut> astronauts;

	public void setID(String id) {
		uuid = UUID.fromString(id);
	}
	
	public UUID getID() {
		return uuid;
	}

	public String getSpaceShip() {
		return spaceShip;
	}

	public void setSpaceShip(String spaceShip) {
		this.spaceShip = spaceShip;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getField(String field) {
		switch (field) {
		case "name":
			return getName();
		
		case "uuid":
			return getID().toString();
		
		case "destination":
			return getDestination();
		
		case "goal":
			return getGoal();
		
		case "spaceShip":
			return getSpaceShip();
		
		default:
			return null;
		}
	}
	
	@Override
	public String toString() {
		return ("UUID: " + uuid + "\nNome: " + name + "\nDestino: " + destination + "\nObjetivo: " + goal
				+ "\nNave espacial: " + spaceShip + "\n");
	}
}

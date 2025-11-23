package lunarmissions.standard;

import java.io.Serializable;
import java.util.UUID;

/**
 * Representa uma viagem específica a Lua
 */
public class Mission implements Serializable {

  private final UUID uuid = UUID.randomUUID();
  private String name;
  private String destination;
  private String goal;
  private String spaceShip;
  // private ArrayList<Astronaut> astronauts;

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

  @Override
  public String toString() {
    return ("UUID: " + uuid +
        "\nNome: " + name +
        "\nDestino: " + destination +
        "\nObjetivo: " + goal +
        "\nNave espacial: " + spaceShip + "\n");
  }
}

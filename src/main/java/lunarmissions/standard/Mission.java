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

  /**
   * @return
   */
  public UUID getID() {
    return uuid;
  }

  /**
   * @return
   */
  public String getSpaceShip() {
    return spaceShip;
  }

  /**
   * @param spaceShip
   */
  public void setSpaceShip(String spaceShip) {
    this.spaceShip = spaceShip;
  }

  /**
   * @return
   */
  public String getGoal() {
    return goal;
  }

  /**
   * @param goal
   */
  public void setGoal(String goal) {
    this.goal = goal;
  }

  /**
   * @return
   */
  public String getDestination() {
    return destination;
  }

  /**
   * @param destination
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return ("UUID: " + uuid + "\nNome: " + name + "\nDestino: " + destination + "\nObjetivo: " + goal
        + "\nNave espacial: " + spaceShip + "\n");
  }
}

package lunarmissions;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Representa uma viagem específica a Lua
 */
public class Mission {

  private final UUID uuid = UUID.randomUUID();
  private String name;
  private String destination;
  private String goal;
  private SpaceShip spaceShip;
  private ArrayList<Astronaut> astronauts;

  public UUID getID() {
    return uuid;
  }

  public SpaceShip getSpaceShip() {
    return spaceShip;
  }

  public void setSpaceShip(SpaceShip spaceShip) {
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
    return ("UUUID: " + uuid +
        "\nName: " + name +
        "\nDestination: " + destination +
        "\nGoal: " + goal +
        "\nSpaceShip: " + spaceShip + "\n");
  }
}

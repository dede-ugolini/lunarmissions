package lunarmissions;

import java.util.ArrayList;
import java.util.Scanner;
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
  // private ArrayList<Astronaut> astronauts;

  Scanner in = new Scanner(System.in);
  private ArrayList<Mission> missionsList = new ArrayList<Mission>();

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

  public void listMissions() {
    /* if (!missionsList.isEmpty()) { */
    /*
     * for (Mission mission : missionsList) {
     * System.out.println(mission);
     * }
     * /*
     * } else {
     * System.err.println("Não existem missões ainda");
     * }
     */
  }

  public ArrayList<Mission> getMissions() {
    return missionsList;
  }

  public void removeMission(int index) {
    getMissions().remove(index);
  }

  public void removeMission(UUID uuid) {
    for (Mission m : missionsList) {
      if (m.getID() == uuid) {
        System.out.println("Id encontrado");
        break;
      }
    }
    System.err.println("Id not found");

  }

  public void openMission() {
    Mission mission = new Mission();
    System.out.println("Digite o nome da missão");
    mission.setName(in.nextLine());
    System.out.println("Digite o destino");
    mission.setDestination(in.nextLine());
    System.out.println("Digite o objetivo da missão");
    mission.setSpaceShip(SpaceShip.MILLENIUM_FALCON);
    System.out.println(mission);
    missionsList.add(mission);
    System.out.println("Missão adicionada!");
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

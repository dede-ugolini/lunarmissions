package lunarmissions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import lunarmissions.ConsoleColors.Color;

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
  private static ArrayList<Mission> missionsList = new ArrayList<Mission>();

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
    if (!missionsList.isEmpty()) {
      System.out.println("TODAS AS MISSÕES");
      for (Mission mission : missionsList) {
        System.out.println(mission);
      }
    } else {
      System.err.println("Não existem missões ainda");
    }
  }

  public ArrayList<Mission> getMissions() {
    return missionsList;
  }

  public void handleRemoveOptions() {
    int option = 0;
    System.out.println("Escolha uma opção para remover uma missão: UUID ou index");
    System.out.println("1 - Index");
    System.out.println("2 - UUID");
    option = in.nextInt();
    switch (option) {
      case 1:
        removeMission(in.nextInt());
        break;
      case 2:
        System.out.println("Digite o uuid:");
        String uuid = null;
        uuid = in.next();
        removeMission(UUID.fromString(uuid));
        break;
      default:
        System.err.println(Color.RED + "Opção não reconhecida" + Color.RESET);
    }
  }

  public void removeMission(int index) {
    getMissions().remove(index);
  }

  public void removeMission(UUID uuid) {

    for (int i = 0; i < getMissions().size(); i++) {
      if (getMissions().get(i).getID().equals(uuid)) {
        System.out.println("Id encontrado");
        System.out.println("Index: " + i);
        missionsList.remove(i);
      }
    }
  }

  public void openMission() {
    Mission mission = new Mission();
    System.out.println("Digite o nome da missão");
    mission.setName(in.nextLine());
    System.out.println("Digite o destino");
    mission.setDestination(in.nextLine());
    System.out.println("Digite o objetivo da missão");
    mission.setGoal(in.nextLine());
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

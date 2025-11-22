package lunarmissions.standard;

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
  private String spaceShip;
  // private ArrayList<Astronaut> astronauts;

  Scanner in = new Scanner(System.in);
  private static ArrayList<Mission> missionsList = new ArrayList<Mission>();

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

  public void listMissions() {
    if (!missionsList.isEmpty()) {
      System.out.println("");
      System.out.println("TODAS AS MISSÕES");
      int index = 0;
      for (Mission mission : missionsList) {
        System.out.println("Index: " + index);
        System.out.println(mission);
        index++;
      }
    } else {
      System.out.println("");
      System.err.println("Não existem missões ainda.");
    }
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
        System.err.println("Opção não reconhecida");
    }
  }

  public void removeMission(int index) {
    missionsList.remove(index);
  }

  public void removeMission(UUID uuid) {

    for (int i = 0; i < missionsList.size(); i++) {
      if (missionsList.get(i).getID().equals(uuid)) {
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
    askSpaceShip(mission);
    missionsList.add(mission);
    System.out.println("Missão adicionada!");
  }

  public void askSpaceShip(Mission mission) {
    System.out.println("Deseja selecionar uma nave predefinida? (y/n)");
    char answer = in.next().charAt(0);
    switch (answer) {
      case 'y':
        System.out.println("Selecione uma nave pelo index");
        listSpaceShips();
        break;
      case 'n':
        System.out.println("Digite o seu modelo pessoal de nave");
        mission.setSpaceShip(in.nextLine());
        break;
      default:
        System.err.println("\"" + answer + "\" Não é uma reconhecida");
    }
  }

  public void listSpaceShips() {
    ArrayList<SpaceShip> shipsList = new ArrayList<SpaceShip>();
    int index = 0;
    System.out.println("Index\tNave Espacial");
    for (SpaceShip ship : SpaceShip.values()) {
      shipsList.add(ship);
      System.out.println(index + "\t" + shipsList.get(index).getName());
      index++;
    }
    in.nextLine();
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

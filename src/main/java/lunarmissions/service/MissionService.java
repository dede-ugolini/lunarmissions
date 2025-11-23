package lunarmissions.service;

import lunarmissions.standard.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

// Operações de output
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

// Operações de input
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Fornece metodos para gerenciar missisoes
 */
public class MissionService {

  private static ArrayList<Mission> missionsList = new ArrayList<Mission>();
  Scanner in = new Scanner(System.in);

  public void writeMission() {
    try {
      if (!missionsList.isEmpty()) {
        FileOutputStream fos = new FileOutputStream("./log.txt");
        ObjectOutputStream output = new ObjectOutputStream(fos);
        for (int i = 0; i < missionsList.size(); i++) {
          output.writeObject(missionsList.get(i));
        }
        System.out.println("Missões salvas com sucesso");
        output.close();
      } else {
        System.err.println("Não existem missões ainda");
      }
    } catch (Exception e) {
      System.err.println("Não foi possível salvar as missões: " + e.getMessage());
      e.printStackTrace();
    }
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
}

package lunarmissions.service;

import lunarmissions.standard.*;
import lunarmissions.view.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import java.io.File;

import java.io.FileWriter;
import java.io.FileReader;

import java.io.BufferedReader;

/**
 * Fornece metodos para gerenciar missões
 */
public class MissionService {

  private static ArrayList<Mission> missionsList = new ArrayList<Mission>();
  Scanner in = new Scanner(System.in);

  static File file = new File("/home/dede/code/algoritmos/2025.02/lunarmissions/log.txt");

  public void handleSerializationOptions() {
    int option = 0;
    System.out.println("1 - Salvar em arquivo de texto (txt)");
    System.out.println("2 - Salvar em arquivo de binário (Object Output Stream)");
    System.out.println("3 - Salvar em banco de dados Nitrite");
  }

  public void writeMission() {
    try {
      FileWriter fileWriter = new FileWriter(file, true);
      for (int i = 0; i < missionsList.size(); i++) {
        fileWriter.write(missionsList.get(i).toString() + "\n");
      }
      fileWriter.flush();
      fileWriter.close();
      System.out.println("Salvo usando FileWriter");
    } catch (Exception e) {
      System.err.println("Erro em escrever com FileWriter :" + e.getMessage());
      e.printStackTrace();
    }
  }

  public void readMission() {
    try {

      FileReader fileReader = new FileReader(file);
      BufferedReader reader = new BufferedReader(fileReader);
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
      reader.close();
    } catch (Exception e) {
      System.err.println("Erro em fileReader:" + e.getMessage());
    }
  }

  public void clearFile() {
    try {
      FileWriter fileWriter = new FileWriter(file, false);
      fileWriter.write("");
      fileWriter.flush();
      fileWriter.close();
      System.out.println(ConsoleColors.GREEN + "Arquivo limpado com sucesso!" + ConsoleColors.RESET);
    } catch (Exception e) {
      System.err
          .println(ConsoleColors.RED + "Erro ao limpar o conteúdo do arquivo: " + e.getMessage() + ConsoleColors.RESET);
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
        System.out.println();
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
    System.out.println("Missão removida!.");
  }

  public void removeMission(UUID uuid) {

    for (int i = 0; i < missionsList.size(); i++) {
      if (missionsList.get(i).getID().equals(uuid)) {
        missionsList.remove(i);
        System.out.println("Missão removida!.");
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
    mission.setSpaceShip(SpaceShip.fromIndex(in.nextInt()));
    missionsList.add(mission);
    System.out.println("Missão adicionada!");
  }

  public void askSpaceShip(Mission mission) {
    System.out.println("Deseja selecionar uma nave predefinida? (y/n)");
    char answer = in.next().charAt(0);
    switch (answer) {
      case 'y':
        listSpaceShips();
        System.out.println("\nSelecione uma nave pelo index");
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
    System.out.println("Index\tNave Espacial\t\tDescrição");
    for (SpaceShip ship : SpaceShip.values()) {
      System.out.println(ship.getIndex() + "\t" + ship.getName() + "\t" + ship.getDesc());
    }
    in.nextLine();
  }
}

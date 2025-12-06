package lunarmissions.service;

import lunarmissions.standard.*;
import lunarmissions.view.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import java.io.File;

/**
 * Fornece metodos para gerenciar missões
 */
public class MissionService {

  private static final int DATABASE_BINARY_FORMAT = 0;
  private static final int DATABASE_NITRITE_FORMAT = 1;

  private static final Inputs inputs = new Inputs();
  private int databaseType = 0;

  private static ArrayList<Mission> missionsList = new ArrayList<Mission>();
  private static AstronautService astronautService = new AstronautService();
  Scanner in = new Scanner(System.in);

  NitriteDatabaseHandler nitriteDatabase;

  static File file = new File("/home/dede/code/algoritmos/2025.02/lunarmissions/log.txt");

  public MissionService(int databaseType) {
    // Configura o uso do tipo de serialização, sendo elas em arquivo binarios ou
    // nitrite
    setDatabaseType(databaseType);

    initDatabaseMode();
  }

  // Inicializa o tipo de sistema que irá ter acesso ao banco de dados
  private void initDatabaseMode() {
    if (getDatabaseType() == DATABASE_NITRITE_FORMAT) {
      nitriteDatabase = new NitriteDatabaseHandler();
      // DatabaseHandler = nitriteDatabase.attachAdpater();
    } else if (getDatabaseType() == DATABASE_BINARY_FORMAT) {
      System.out.println("TODO: IMPLEMENT THE BINARY DATABASE FORMAT AND INITIALIZE IT");
      // initBinary();
      // DatabaseHandler = binaryAdpter.attachAdapter();
    }
  }

  public void handleSerializationOptions() {
    int option = 0;
    System.out.println("1 - Salvar em arquivo de texto (txt)");
    System.out.println("2 - Salvar em arquivo de binário (Object Output Stream)");
    System.out.println("3 - Salvar em banco de dados Nitrite");

    option = in.nextInt();

    switch (option) {

      case 1:
        TextDatabaseHandler textDatabaseHandler = new TextDatabaseHandler();
        textDatabaseHandler.create(missionsList);
        break;
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

  public void remove(int index) {
    missionsList.remove(index);
    System.out.println("Missão removida!.");
  }

  public void remove(UUID uuid) {

    for (int i = 0; i < missionsList.size(); i++) {
      if (missionsList.get(i).getID().equals(uuid)) {
        missionsList.remove(i);
        System.out.println("Missão removida!.");
      }
    }
  }

  public void openMission() {

    String name = setNameMission();

    String destination = setDestinationMission();

    String goal = setGoalMission();

    askSpaceShip();

    String spaceShip = setSpaceShipMission();
    Mission mission = new Mission(name, destination, goal, spaceShip);
    missionsList.add(mission);
    System.out.println("Missão adicionada!");
  }

  public String setNameMission() {
    final int MAX_TENTATIVAS = 3;
    int tentativas = MAX_TENTATIVAS;

    while (tentativas > 0) {
      System.out.println("Digite o nome da missão:");
      String name = in.nextLine().trim();

      if (name.isEmpty()) {
        System.err.println(ConsoleColors.RED + "Nome não pode ser vazio." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      if (name.length() < 5) {
        System.err.println(ConsoleColors.RED + "Nome muito curto." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      if (!name.matches("^[A-Za-z0-9 ]{5,}$")) {
        System.err.println(
            ConsoleColors.RED + "Nome não pode conter caracteres especiais." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      return name;
    }

    throw new RuntimeException(ConsoleColors.RED + "Máximo de tentativas atingido." + ConsoleColors.RESET);
  }

  public String setDestinationMission() {
    final int MAX_TENTATIVAS = 3;
    int tentativas = MAX_TENTATIVAS;

    while (tentativas > 0) {
      System.out.println("Digite o destino da missão:");
      String name = in.nextLine().trim();

      if (name.isEmpty()) {
        System.err.println(ConsoleColors.RED + "Nome do destino não pode ser vazio." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      if (name.length() < 3) {
        System.err.println(ConsoleColors.RED + "Nome do destino muito curto." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      if (!name.matches("^[A-Za-z0-9 ]{3,}$")) {
        System.err.println(
            ConsoleColors.RED + "Nome do destino não pode conter número e nem caracteres especiais."
                + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      return name;
    }

    throw new RuntimeException(ConsoleColors.RED + "Máximo de tentativas atingido." + ConsoleColors.RESET);
  }

  public String setGoalMission() {
    final int MAX_TENTATIVAS = 3;
    int tentativas = MAX_TENTATIVAS;

    while (tentativas > 0) {
      System.out.println("Digite o objetivo da missão:");
      String name = in.nextLine().trim();

      if (name.isEmpty()) {
        System.err.println(ConsoleColors.RED + "Objetivo não pode ser vazio." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      if (name.length() < 8) {
        System.err.println(ConsoleColors.RED + "Objetivo muito curto." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      if (!name.matches("^[A-Za-z0-9 ]{5,}$")) {
        System.err.println(
            ConsoleColors.RED + "Objetivo não pode conter caracteres especiais." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      return name;
    }

    throw new RuntimeException(ConsoleColors.RED + "Máximo de tentativas atingido." + ConsoleColors.RESET);
  }

  public String setSpaceShipMission() {
    String spaceShip;
    spaceShip = Standards.SpaceShip.fromIndex(in.nextInt());
    return spaceShip;
  }

  public String askSpaceShip() {
    System.out.println("Deseja selecionar uma nave predefinida? (y/n)");
    char answer = in.next().charAt(0);
    String spaceShip = null;
    switch (answer) {
      case 'y':
        Standards.SpaceShip.listSpaceShips();
        System.out.println("\nSelecione uma nave pelo index");
        break;
      case 'n':
        System.out.println("Digite o seu modelo pessoal de nave");
        spaceShip = in.nextLine();
        break;
      default:
        Extras.optionNoRecognized(answer);
    }
    return spaceShip;
  }

  public void setDatabaseType(int databaseType) {
    this.databaseType = databaseType;
  }

  public int getDatabaseType() {
    return this.databaseType;
  }
}

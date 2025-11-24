package lunarmissions.view;

import lunarmissions.service.MissionService;
import java.util.Scanner;

public class Menu {

  private static Scanner in = new Scanner(System.in);
  MissionService mission = new MissionService();
  Extras extras = new Extras();
  Ascii ascii = new Ascii();

  public void openInitalMenu() {
    // Pro tip: Ascii de viado não pode faltar

    System.out.print("Processando");
    for (int i = 0; i < 3; i++) {
      delay(1000);
      System.out.print(".");
    }

    System.out.println("");
    System.out.println(ConsoleColors.BLUE + ascii.tittle() + ConsoleColors.RESET);
    System.out.println("");
    System.out.println(ConsoleColors.CYAN + "‧₊˚✩ 🪐✩˚₊‧Bem vindo a Lunar Systems ‧₊˚✩ 🪐✩˚₊‧ " + ConsoleColors.RESET);
    System.out.println();
    System.out.println("1 - Listar todas as missões");
    System.out.println("2 - Abrir nova missão");
    System.out.println("3 - Remover uma missão");
    System.out.println("4 - Listar naves espaciais padrão");
    System.out.println("5 - Serialização");
    System.out.println("6 - Extras");
    System.out.println("0 - Para sair do sistema");
    handleOptions();
  }

  public void handleOptions() {
    int option = 0;
    option = in.nextInt();

    switch (option) {

      case 0:
        System.out.print("\033[H\033[2J"); // limpa terminal em ANSI
        System.exit(0);
        break;
      case 1:
        mission.listMissions();
        break;
      case 2:
        spinner("Ai meu cu");
        mission.openMission();
        break;
      case 3:
        mission.handleRemoveOptions();
        break;
      case 4:
        mission.listSpaceShips();
        break;
      case 5:
        mission.handleSerializationOptions();
        break;
      case 6:
        extras.extras();
        break;
      default:
        System.out.println("\"" + option + "\" não é uma opção reconhecida");
        System.exit(1);
        break;
    }
  }

  public static void spinner(String msg) {
    try {
      String[] frames = { "|", "/", "-", "\\" };
      System.out.print(" " + msg + "   ");

      for (int i = 0; i < 20; i++) {
        System.out.print("\b" + frames[i % frames.length]);
        Thread.sleep(150);
      }
      System.out.println("\b ");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void delay(long ms) {
    try {
      Thread.sleep(ms);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

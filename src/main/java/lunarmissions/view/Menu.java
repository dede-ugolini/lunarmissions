package lunarmissions.view;

import lunarmissions.service.MissionService;
import lunarmissions.standard.SpaceShip;

import java.util.Scanner;
import java.util.UUID;

public class Menu {

  private static Scanner in = new Scanner(System.in);
  private MissionService mission = new MissionService(0);
  private Extras extras = new Extras();

  public void openInitalMenu() {
    /*
     * System.out.print("Processando");
     * for (int i = 0; i < 3; i++) {
     * delay(1000);
     * System.out.print(".");
     * }
     */

    System.out.println("");
    // System.out.println(ConsoleColors.BLUE + ascii.tittle() +
    // ConsoleColors.RESET);
    Extras.genImage("tittle");
    System.out.println("");
    // Pro tip: Ascii de viado não pode faltar
    System.out.println(ConsoleColors.CYAN + "‧₊˚✩ 🪐✩˚₊‧Bem vindo a Lunar Systems ‧₊˚✩ 🪐✩˚₊‧ " + ConsoleColors.RESET);
    System.out.println();
    System.out.println("1 - Listar todas as missões");
    System.out.println("2 - Abrir nova missão");
    System.out.println("3 - Remover uma missão");
    System.out.println("4 - Listar naves espaciais padrão");
    System.out.println("5 - Serialização");
    System.out.println("6 - Extras");
    System.out.println("7 - Limpar terminal");
    System.out.println("0 - Para sair do sistema");
    handleOptions();
  }

  private void handleOptions() {
    int option = 0;
    option = in.nextInt();

    switch (option) {

      case 0:
        System.out.print(ConsoleColors.CLEAR);// limpa terminal em ANSI
        System.exit(0);
        break;
      case 1:
        mission.listMissions();
        break;
      case 2:
        mission.openMission();
        break;
      case 3:
        handleRemoveOptions();
        break;
      case 4:
        SpaceShip.listSpaceShips();
        break;
      case 5:
        mission.handleSerializationOptions();
        break;
      case 6:
        extras.extras();
        break;
      case 7:
        System.out.print(ConsoleColors.CLEAR);
        break;
      default:
        System.out.println("\"" + option + "\" não é uma opção reconhecida");
        System.exit(1);
        break;
    }
  }
  // TODO: Modulazizar melhor o projeto, a class MissionService está com muitos
  // metódos que não fazem sentido
  // ao seu propósito.

  public void handleRemoveOptions() {
    int option = 0;
    System.out.println("Escolha uma opção para remover uma missão: UUID ou index");
    System.out.println("1 - Index");
    System.out.println("2 - UUID");
    option = in.nextInt();

    switch (option) {
      case 1:
        System.out.println("Digite o index:");
        System.out.println();
        mission.remove(in.nextInt());
        break;
      case 2:
        System.out.println("Digite o uuid:");
        String uuid = null;
        uuid = in.nextLine();
        // FIX: Não está funcionando remoção por UUID
        mission.remove(UUID.fromString(uuid));
        break;
      default:
        System.err.println(ConsoleColors.RED + "Opção não reconhecida" + ConsoleColors.RESET);
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

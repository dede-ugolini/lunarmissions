package lunarmissions.view;

import lunarmissions.service.AstronautService;
import lunarmissions.service.MissionService;
import lunarmissions.service.TextDatabaseHandler;
import lunarmissions.standard.*;

import java.util.Scanner;
import java.util.UUID;

public class Menu {

  private static Scanner in = new Scanner(System.in);
  private MissionService missionService = new MissionService(0);
  private Extras extras = new Extras();
  private TextDatabaseHandler textDatabaseHandler = new TextDatabaseHandler();

  public void openInitalMenu() {

    /*
     * System.out.print("Processando");
     * for (int i = 0; i < 3; i++) {
     * delay(1000);
     * System.out.print(".");
     * }
     */
    System.out.println(ConsoleColors.BLUE);
    Extras.genImage("tittle");
    System.out.println(ConsoleColors.RESET);
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
    System.out.println("8 - Adicionar Astronauta");
    System.out.println("9 - Listar Astronautas");
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
        missionService.listMissions();
        break;
      case 2:
        missionService.openMission();
        break;
      case 3:
        handleRemoveOptions();
        break;
      case 4:
        Standards.SpaceShip.listSpaceShips();
        break;
      case 5:
        handleSerializationOptions();
        break;
      case 6:
        extras.extras();
        break;
      case 7:
        System.out.print(ConsoleColors.CLEAR);
        break;
      case 8:
        AstronautService astronautService = new AstronautService();
        astronautService.addAstronaut();
        break;
      case 9:
        AstronautService astronautService2 = new AstronautService();
        astronautService2.listAstronauts();
        break;
      default:
        Extras.optionNoRecognized(option);
        break;
    }
  }

  // TODO: Modulazizar melhor o projeto, a class MissionService está com muitos
  // metódos que não fazem sentido
  // ao seu propósito.
  public void handleSerializationOptions() {
    int option = 0;
    System.out.println("1 - Fazer operações em arquivo de texto (txt)");
    System.out.println("2 - Fazer operações em arquivo binário (Object Output Stream)");
    System.out.println("3 - Fazer operações em banco de dados Nitrite");

    option = in.nextInt();

    switch (option) {

      case 1:
        handleTextOptions();
        break;
      default:
        Extras.optionNoRecognized(option);
        break;
    }
  }

  public void handleTextOptions() {
    int option = 0;
    System.out.println("1 - Create");
    System.out.println("2 - Read");
    System.out.println("3 - Update");
    System.out.println("4 - Delete");
    System.out.println("5 - Delete all");
    System.out.println("6 - List all");

    option = in.nextInt();

    switch (option) {
      case 1:
        textDatabaseHandler.create(missionService.getMissions());
        break;
      case 2:
        handleReadOptions();
        break;
      case 3:
        break;
      case 4:
        break;
      case 5:
        break;
      case 6:
        textDatabaseHandler.listAll();
        break;
      default:
        Extras.optionNoRecognized(option);
        break;
    }
  }

  public void handleReadOptions() {
    System.out.print("Digite o filtro para campo: ");
    String field = in.nextLine();
    in.nextLine();
    System.out.print("\nDigite o filtro para valor: ");
    String key = in.nextLine();

    textDatabaseHandler.read(field, key);
  }

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
        missionService.remove(in.nextInt());
        break;
      case 2:
        System.out.println("Digite o uuid:");
        String uuid = null;
        uuid = in.nextLine();
        // FIX: Não está funcionando remoção por UUID
        missionService.remove(UUID.fromString(uuid));
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

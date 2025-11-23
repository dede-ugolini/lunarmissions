package lunarmissions.view;

import lunarmissions.service.MissionService;
import java.util.Scanner;

public class Menu {

  Scanner in = new Scanner(System.in);
  MissionService mission = new MissionService();
  Ascii ascii = new Ascii();

  public void openInitalMenu() {
    // Pro tip: Ascii de viado não pode faltar
    System.out.println(ConsoleColors.CYAN + "‧₊˚✩ 🪐✩˚₊‧Bem vindo a Lunar Systems ‧₊˚✩ 🪐✩˚₊‧ " + ConsoleColors.RESET);
    System.out.println();
    System.out.println("1 - Listar todas as missões");
    System.out.println("2 - Abrir nova missão");
    System.out.println("3 - Remover uma missão");
    System.out.println("4 - Listar naves espaciais padrão");
    System.out.println("5 - Salvar missão em um arquivo");
    System.out.println("0 - Para sair do sistema");
    handleOptions();
  }

  public void handleOptions() {
    int option = 0;
    option = in.nextInt();

    switch (option) {

      case 0:
        System.exit(0);
        break;

      case 1:
        mission.listMissions();
        break;
      case 2:
        mission.openMission();
        break;
      case 3:
        mission.handleRemoveOptions();
        break;
      case 4:
        mission.listSpaceShips();
        break;
      case 5:
        mission.writeMission();
        break;
      default:
        System.out.println("\"" + option + "\" não é uma opção reconhecida");
        System.exit(1);
        break;
    }
  }
}

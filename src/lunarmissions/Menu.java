package lunarmissions;

import java.util.Scanner;

public class Menu {

  Scanner in = new Scanner(System.in);
  Mission mission = new Mission();

  public void openInitalMenu() {
    System.out.println();
    System.out.println("1 - Listar todas as missões");
    System.out.println("2 - Abrir nova missão");
    System.out.println("3 - Remover uma missão");
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
      default:
        System.out.println("\"" + option + "\" não é uma opção reconhecida");
        System.exit(1);
        break;
    }
  }
}

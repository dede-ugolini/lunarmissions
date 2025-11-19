package lunarmissions;

import java.util.Scanner;

public class Menu {

  Scanner in = new Scanner(System.in);
  LunarMissions lunarMissions = new LunarMissions();

  public void openInitalMenu() {
    System.out.println();
    System.out.println("1 - Listar todas as missões");
    System.out.println("2 - Abrir nova missão");
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
        lunarMissions.listMissions();
        break;
      case 2:
        lunarMissions.openMission();
        break;

      default:
        System.out.println("\"" + option + "\" não é uma opção reconhecida");
        System.exit(1);
        break;
    }
  }
}

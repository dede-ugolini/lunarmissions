package lunarmissions;

import java.util.Scanner;

public class Menu {

  Scanner in = new Scanner(System.in);
  LunarMissions lunarMissions = new LunarMissions();

  public void openInitalMenu() {
    System.out.println("1 - Listar todas as missões");
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

      default:
        System.out.println("Algum erro ocorreu");
        System.exit(1);
        break;
    }
  }
}

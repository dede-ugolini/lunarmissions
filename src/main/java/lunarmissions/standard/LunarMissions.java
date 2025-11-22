package lunarmissions.standard;

import lunarmissions.view.Menu;

public class LunarMissions {

  Menu menu = new Menu();

  public void listDefaultSpaceShips() {
    for (SpaceShip e : SpaceShip.values())
      System.out.println(e);
  }

  public void start() {
    while (true) {
      Menu menu = new Menu();
      menu.openInitalMenu();
    }
  }

  public static void main(String[] args) {
    LunarMissions lunarMissions = new LunarMissions();
    lunarMissions.start();
  }
}

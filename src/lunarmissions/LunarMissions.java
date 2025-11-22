package lunarmissions;

import java.util.Scanner;

public class LunarMissions {

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

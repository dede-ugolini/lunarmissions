package lunarmissions.standard;

import lunarmissions.view.Menu;

public class LunarMissions {

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

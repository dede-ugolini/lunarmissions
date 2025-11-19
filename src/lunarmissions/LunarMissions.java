package lunarmissions;

import java.util.ArrayList;
import java.util.Scanner;

public class LunarMissions {

  ArrayList<Mission> missions = new ArrayList<Mission>();
  Mission mission = new Mission();
  Mission mission2 = new Mission();

  Scanner in = new Scanner(System.in);

  public void listMissions() {
    if (!missions.isEmpty()) {
      for (Mission mission : missions) {
        System.out.println(mission);
      }
    }
  }

  public void listDefaultSpaceShips() {
    for (SpaceShip e : SpaceShip.values())
      System.out.println(e);
  }

  public void openMission() {
    System.out.println("Digite o destino");
    mission.setDestination(in.nextLine());
  }

  public void start() {
    Menu menu = new Menu();
    menu.openInitalMenu();
  }

  public static void main(String[] args) {
    LunarMissions lunarMissions = new LunarMissions();
    lunarMissions.start();
  }
}

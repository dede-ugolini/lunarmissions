package lunarmissions;

import java.util.ArrayList;
import java.util.Scanner;

public class LunarMissions {

  ArrayList<Mission> missionsList = new ArrayList<Mission>();
  Mission mission2 = new Mission();

  Scanner in = new Scanner(System.in);

  public void listMissions() {
    if (!missionsList.isEmpty()) {
      for (Mission mission : missionsList) {
        System.out.println(mission);
      }
    } else {
      System.err.println("Não existem missões ainda");
    }
  }

  public void listDefaultSpaceShips() {
    for (SpaceShip e : SpaceShip.values())
      System.out.println(e);
  }

  public void openMission() {
    Mission mission = new Mission();
    System.out.println("Digite o nome da missão");
    mission.setName(in.nextLine());
    System.out.println("Digite o destino");
    mission.setDestination(in.nextLine());
    System.out.println("Digite o objetivo da missão");
    mission.setSpaceShip(SpaceShip.MILLENIUM_FALCON);
    missionsList.add(mission);
    System.out.println("Missão adicionada!");
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

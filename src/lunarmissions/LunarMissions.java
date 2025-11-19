package lunarmissions;

import java.util.ArrayList;

public class LunarMissions {

  ArrayList<Mission> missions = new ArrayList<Mission>();
  Mission mission = new Mission();
  Mission mission2 = new Mission();

  public void hello() {
    missions.add(mission);
    missions.add(mission2);
    for (Mission mission : missions) {
      System.out.println(mission);
    }
  }

  public static void main(String[] args) {
    LunarMissions lunarMissions = new LunarMissions();
    lunarMissions.hello();
  }
}

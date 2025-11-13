package lunarmissions;

public class SpaceShip {

  public enum SpaceShip {
    PIONEER("Pioneer 0"),
    PIONEER_1("Pioneer 1"),
    /**
     * A lendaria Millenium Falcon
     */
    MILLENIUM_FALCON("Millenium Falcon");
  }

  private final String name;

  SpaceShip(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

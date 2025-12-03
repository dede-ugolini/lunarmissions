package lunarmissions.standard;

// TODO adicionar mais algumas naves e descrição a elas
/**
 * Agrupa definições de entidades padrão usadas em missões lunares,
 * incluindo naves espaciais e astronautas associados.
 */
public final class Standards {

  /**
   * Representa modelos lendários e históricos de naves espaciais.
   */
  public enum SpaceShip {
    /**
     * Primeira série de sondas espaciais americanas projetadas para estudar
     * a Lua. A Pioneer 0 representou uma das primeiras tentativas dos EUA
     * de alcançar o espaço profundo durante a era inicial da corrida espacial.
     */
    PIONEER_0(0, "Pioneer 0", "Primeira tentativa americana de enviar uma sonda lunar"),
    PIONEER_1(1, "Pioneer 1", "Sonda do programa Pioneer destinada ao estudo da Lua"),
    MILLENIUM_FALCON(2, "Millenium Falcon", "Nave pilotada por Han Solo e Chewbacca"),
    DEATH_STAR(3, "Estrela da Morte", "A gigantesca estação de batalha do Império"),
    SLAVE_I(4, "Slave I", "Nave de Boba Fett com design marcante"),
    X_WING(5, "X-Wing", "Caça ágil usado pela Aliança Rebelde"),
    TIE_FIGHTER(6, "TIE Fighter", "Caça clássico das forças do Império"),
    BATWING(7, "Batwing", "Aeronave avançada utilizada pelo Batman"),
    DISCOVERY(8, "Discovery One", "Nave da missão para Júpiter em 2001: A Space Odyssey");

    private final int index;
    private final String name;
    private final String desc;

    SpaceShip(int index, String name, String desc) {
      this.index = index;
      this.name = name;
      this.desc = desc;
    }

    public int getIndex() {
      return index;
    }

    public String getName() {
      return name;
    }

    public String getDesc() {
      return desc;
    }

    public static SpaceShip fromIndex(int index) {
      for (SpaceShip s : values()) {
        if (s.index == index)
          return s;
      }
      return null;
    }
  }

  /**
   * Representa um astronauta apto a participar de uma missão,
   * incluindo idade, horas de voo e nave tripulada.
   */
  public enum Astronaut {

    STORY_MUSGRAVE("Story Musgrave", SpaceShip.DISCOVERY, 45, 12800),
    NEIL_ARMSTRONG("Neil Armstrong", SpaceShip.PIONEER_1, 38, 2000),
    LUKE_SKYWALKER("Luke Skywalker", SpaceShip.X_WING, 21, 500);

    private final String name;
    private final SpaceShip spaceShip;
    private final int age;
    private final int hours;

    Astronaut(String name, SpaceShip ship, int age, int hours) {
      if (age < 21)
        throw new IllegalArgumentException("Idade mínima para astronauta é 21 anos.");

      this.name = name;
      this.spaceShip = ship;
      this.age = age;
      this.hours = hours;
    }

    /**
     * Retorna o nome do astronauta padrão.
     *
     * @return o nome do astronauta padrão.
     */
    public String getName() {
      return name;
    }

    /**
     * Retorna a nave espacial do astronauta padrão.
     *
     * @return a nave espacial do astronauta padrão.
     */
    public SpaceShip getSpaceShip() {
      return spaceShip;
    }

    /**
     * Retorna a idade do astronauta padrão.
     *
     * @return a idade do astronauta padrão.
     */
    public int getAge() {
      return age;
    }

    public int getHours() {
      return hours;
    }
  }

  private Standards() {
    // Impede instanciação da classe utilitária
  }
}

package lunarmissions.standard;

/**
 * Armazena alguns modelos lendários de naves espaciais
 */
public enum SpaceShip {

  PIONEER(0, "Pioneer 0", ""),
  PIONEER_1(1, "Pioneer 1", ""),

  /**
   * A lendaria Millenium Falcon dos Star Wars pilotada por Han Solo
   * e o fucking Chewbacca, a Millenium Falcon foi um elemento
   * chave para a vitória da Aliança Rebelde Contra o Império em
   * muitas batalhas
   */
  MILLENIUM_FALCON(2, "Millenium Falcon", ""),
  /**
   * A lendária Estrela da Morte do lendário Darth Vader
   */
  DEATH_STAR(3, "Estrela da Morte", "A estrela da morte de Darth Vader"),
  /**
   * Uma das naves mais memóraveis graças ao seu formato característico,
   * pilotada pelo lendário caçador de recompensas Boba Fett
   */
  SLAVE_I(4, "Slave I", ""),

  /**
   * Uma família de naves espaciais utilizado pela Alinça Rebelde,
   * com espaço para um piloto, se destaca pela velocidade e agilidade,
   * o modelo T-65B foi pilotado por ninguem menos que Luke Skywalker o filho de
   * Dath Vader
   */
  X_WING(5, "X-Wing", ""),
  /**
   * É característico caça do Império, com seu design ameaçador
   * assusta qualquer rebelde que vê o Império se aproxiamando com tamanho poder
   * bélico
   */
  TIE_FIGHTER(6, "Tie Fighter", ""),
  BATWING(7, "Batwing", "");

  private final int index;
  private final String name;
  private final String desc;

  SpaceShip(int index, String name, String desc) {
    this.index = index;
    this.name = name;
    this.desc = desc;
  }

  public static String fromIndex(int index) {
    for (SpaceShip ship : SpaceShip.values()) {
      if (ship.getIndex() == index) {
        return ship.getName();
      }
    }
    return null;
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
}

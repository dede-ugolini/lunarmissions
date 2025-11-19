package lunarmissions;

/**
 * Armazena alguns modelos lendários de naves espaciais
 */
public enum SpaceShip {

  PIONEER("Pioneer 0"),
  PIONEER_1("Pioneer 1"),

  /**
   * A lendaria Millenium Falcon dos Star Wars pilotada por Han Solo
   * e o fucking Chewbacca, a Millenium Falcon foi um elemento
   * chave para a vitória da Aliança Rebelde Contra o Império em
   * muitas baalhas
   */
  MILLENIUM_FALCON("Millenium Falcon"),
  /**
   * A lendária Estrela da Morte do lendário Darth Vader
   */
  DEATH_STAR("Estrela da Morte"),
  /**
   * Uma das naves mais memóraveis graças ao seu formato característico,
   * pilotada pelo lendário caçador de recompensas Boba Fett
   */
  SLAVE_I("Slave I"),

  /**
   * Uma família de naves espaciais utilizado pela Alinça Rebelde,
   * com espaço para um piloto, se destaca pela velocidade e agilidade,
   * o modelo T-65B foi pilotado por ninguem menos que Luke Skywalker o filho de
   * Dath Vader
   */
  X_WING("X-Wing"),
  /**
   * É característico caça do Império, com seu design ameaçador
   * assusta qualquer rebelde que vê o Império se aproxiamando com tamanho poder
   * bélico
   */
  TIE_FIGHTER("Tie Fighter"),
  BATWING("Batwing");

  private final String name;

  SpaceShip(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

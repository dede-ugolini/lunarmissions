package lunarmissions.standard;

/**
 * Armazena alguns modelos lendários de naves espaciais
 */
public enum SpaceShip {

  /**
   * Primeira série de sondas espaciais americanas projetadas para estudar
   * a Lua. A Pioneer 0 representou uma das primeiras tentativas dos EUA
   * de alcançar o espaço profundo durante a era inicial da corrida espacial.
   */
  PIONEER(0, "Pioneer 0", "Primeira tentativa americana de enviar uma sonda lunar"),
  /**
   * Continuação do programa Pioneer, lançada com o objetivo de atingir a
   * órbita lunar e coletar dados científicos. Embora não tenha alcançado
   * a órbita esperada, forneceu informações importantes sobre o espaço
   * além da atmosfera terrestre.
   */
  PIONEER_1(1, "Pioneer 1", "Sonda do programa Pioneer destinada ao estudo da Lua"),

  /**
   * A lendaria Millenium Falcon dos Star Wars pilotada por Han Solo
   * e o fucking Chewbacca, a Millenium Falcon foi um elemento
   * chave para a vitória da Aliança Rebelde Contra o Império em
   * muitas batalhas
   */
  MILLENIUM_FALCON(2, "Millenium Falcon", "Nave pilotada por Han Solo e pelo fucking Chewbacca"),
  /**
   * A lendária Estrela da Morte do lendário Darth Vader
   */
  DEATH_STAR(3, "Estrela da Morte", "A estrela da morte de Darth Vader"),
  /**
   * Uma das naves mais memóraveis graças ao seu formato característico,
   * pilotada pelo lendário caçador de recompensas Boba Fett
   */
  SLAVE_I(4, "Slave I",
      "Memorável pelo seu formato incônico"),
  /**
   * Uma família de naves espaciais utilizado pela Alinça Rebelde,
   * com espaço para um piloto, se destaca pela velocidade e agilidade,
   * o modelo T-65B foi pilotado por ninguem menos que Luke Skywalker o filho de
   * Dath Vader
   */
  X_WING(5, "X-Wing", "Nave clássica da Aliança Rebelde"),
  /**
   * É característico caça do Império, com seu design ameaçador
   * assusta qualquer rebelde que vê o Império se aproxiamando com tamanho poder
   * bélico
   */
  TIE_FIGHTER(6, "Tie Fighter", "Clássico caça do Império"),
  /**
   * Aeronave icônica do Batman, utilizada em diversas histórias, filmes
   * e animações. Projeta uma silhueta intimidadora em formato de morcego,
   * equipada com tecnologia avançada, sistemas de voo de alta manobrabilidade
   * e arsenal tático. Costuma ser empregada em missões urbanas e operações
   * de vigilância aérea em Gotham.
   */
  BATWING(7, "Batwing", "Aeronave tática avançada utilizada pelo Batman"),
  DISCOVERY(8, "Discovery", "Onibus espacial");

  private final int index;
  private final String name;
  private final String desc;

  SpaceShip(int index, String name, String desc) {
    this.index = index;
    this.name = name;
    this.desc = desc;
  }

  /**
   * Retorna o nome da nave espacial a partir do index.
   *
   * @param index da nave espacial.
   * @return o nome da nave espacial.
   */
  public static String fromIndex(int index) {
    for (SpaceShip ship : SpaceShip.values()) {
      if (ship.getIndex() == index) {
        return ship.getName();
      }
    }
    return null;
  }

  /**
   * Retorna o index da nave espacial.
   *
   * @return o index da nave espacial.
   */
  public int getIndex() {
    return index;
  }

  /**
   * Retorna o nome da nave espacial.
   *
   * @return o nome da nave espacial.
   */
  public String getName() {
    return name;
  }

  /**
   * Retorna a descrição da nave nspacial
   *
   * @return a descrição da nave espacial.
   */
  public String getDesc() {
    return desc;

  }

  /**
   * Lista as naves especiais padrões.
   */
  public static void listSpaceShips() {
    System.out.println("Index\tNave Espacial\t\tDescrição");
    for (SpaceShip ship : SpaceShip.values()) {
      System.out.format("%-10d%-22s%-64s\n", ship.getIndex(), ship.getName(), ship.getDesc());
    }
  }
}

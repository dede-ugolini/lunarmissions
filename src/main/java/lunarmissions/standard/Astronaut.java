package lunarmissions.standard;

/**
 * Representa o participante da missão que contem informações
 * como nome, nave tripulada etc.
 *
 * @see SpaceShip
 */

public class Astronaut {

  private String name;
  private SpaceShip spaceShip;
  private int age;
  private int hours;

  Astronaut() {
  }

  Astronaut(String name, SpaceShip spaceShip, int age, int hours) {
    this.name = name;
    this.spaceShip = spaceShip;
    this.age = age;
    this.hours = hours;
  }

  /**
   * Retorna o nome completo do astronauta.
   *
   * @return o nome do astronauta
   */
  public String getName() {
    return name;
  }

  /**
   * Define o nome completo do astronauta.
   *
   * @param name nome a ser atribuído
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retorna a nave espacial associada ao astronauta.
   *
   * @return a nave espacial do astronauta, ou {@code null} caso não esteja
   *         designado
   */
  public SpaceShip getSpaceShip() {
    return spaceShip;
  }

  /**
   * Define a nave espacial associada ao astronauta.
   *
   * @param spaceShip instância de {@link SpaceShip} que o astronauta irá tripular
   */
  public void setSpaceShip(SpaceShip spaceShip) {
    this.spaceShip = spaceShip;
  }

  /**
   * Retorna a idade atual do astronauta.
   *
   * @return idade em anos
   */
  public int getAge() {
    return age;
  }

  /**
   * Define a idade do astronauta.
   *
   * @param age idade em anos
   */
  public void setAge(int age) {
    if (age < 21) {
      System.err.println("Astronauta não tem idade mínima para participar");
    } else {
      this.age = age;
    }
  }

  /**
   * Retorna o total de horas de voo acumuladas pelo astronauta.
   *
   * @return horas totais de voo
   */
  public int getHours() {
    return hours;
  }

  /**
   * Define o total de horas de voo acumuladas.
   *
   * @param hours quantidade de horas de voo
   */
  public void setHours(int hours) {
    this.hours = hours;
  }

}

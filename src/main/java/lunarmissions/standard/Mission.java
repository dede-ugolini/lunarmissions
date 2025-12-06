package lunarmissions.standard;

import java.io.Serializable;
import java.util.UUID;

/**
 * Representa uma viagem específica a Lua
 */
public class Mission implements Serializable {

  private final UUID uuid = UUID.randomUUID();
  private String name;
  private String destination;
  private String goal;
  private String spaceShip;

  /**
   * Cria uma nova missão com nome, destino, objetivo e nave espacial associados.
   *
   * @param name        nome da missão.
   * @param destination destino da missão.
   * @param goal        objetivo da missão.
   * @param spaceShip   nave espacial utilizada na missão.
   */
  public Mission(String name, String destination, String goal, String spaceShip) {
    this.name = name;
    this.destination = destination;
    this.goal = goal;
    this.spaceShip = spaceShip;
  }

  /**
   * Retorna o uuid da missão.
   *
   * @return o uuid da missão
   */
  public UUID getID() {
    return uuid;
  }

  /**
   * Retorna a nave espacial da missão.
   *
   * @return a nave espacial da missão.
   */
  public String getSpaceShip() {
    return spaceShip;
  }

  /**
   * Define a nave espacial da missão.
   *
   * @param spaceShip nave espacial a ser utilizada na missão.
   */
  public void setSpaceShip(String spaceShip) {
    this.spaceShip = spaceShip;
  }

  /**
   * Retorna o objetivo da missão.
   *
   * @return o objetivo da missão.
   */
  public String getGoal() {
    return goal;
  }

  /**
   * Define o objetivo da missão.
   *
   * @param goal o objetivo a ser definido para a missão.
   */
  public void setGoal(String goal) {
    this.goal = goal;
  }

  /**
   * Retorna o destino da missão.
   *
   * @return o destino da missão.
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Define o destino da missão.
   *
   * @param destination destino a ser definido para a missão.
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   * Retorna o nome da missão.
   *
   * @return o nome da missão.
   */
  public String getName() {
    return name;
  }

  /**
   * Define o nome da missão.
   *
   * @param name nome a ser definido para a missão.
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return ("UUID: " + uuid + "\nNome: " + name + "\nDestino: " + destination + "\nObjetivo: " + goal
        + "\nNave espacial: " + spaceShip + "\n");
  }
}

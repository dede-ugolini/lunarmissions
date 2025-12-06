package lunarmissions.standard;

import java.util.UUID;

/**
 * Classe que guarda atributos de naves espaciais
 */
public class SpaceShip {

  private final UUID uuid = UUID.randomUUID();
  private String model;
  private boolean avaliable = true;

  public UUID getUuid() {
    return uuid;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public boolean isAvaliable() {
    return avaliable;
  }

  public void setAvaliable(boolean avaliable) {
    this.avaliable = avaliable;
  }
}

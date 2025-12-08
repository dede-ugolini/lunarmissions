package lunarmissions.service;

import lunarmissions.standard.*;
import lunarmissions.view.ConsoleColors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class BinaryDatabaseHandler {

  private static final File file = new File("MissionDatabaseBinary.dat");

  private List<Mission> load() throws Exception {
    if (!file.exists())
      return new ArrayList<>();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      return (List<Mission>) ois.readObject();
    }
  }

  private void save(List<Mission> missionList) throws Exception {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
      oos.writeObject(missionList);
    }
  }

  public void create(Mission mission) {

    try {
      List<Mission> missionList = load();
      missionList.add(mission);
      save(missionList);
    } catch (Exception e) {
      System.err.println(
          ConsoleColors.RED + "Erro ao salvar em banco de dados binario: " + e.getMessage() + ConsoleColors.RESET);
      e.printStackTrace();
    }
  }

  public void readAll() {

    try {
      List<Mission> missionList = load();
      for (Mission mission : missionList) {
        System.out.println(mission);
      }
    } catch (Exception e) {
      System.err.println(
          ConsoleColors.RED + "Erro ao ler o banco de dados binario: " + e.getMessage() + ConsoleColors.RESET);
      e.printStackTrace();
    }
  }

  public void update(Mission newMission, UUID uuid) throws Exception {
    boolean updated = false;
    if (newMission == null) {
      System.err.println("Não foi possível fazer o update, missão is null!");
      return;
    }
    List<Mission> missionList = load();
    for (int i = 0; i < missionList.size(); i++) {
      if (missionList.get(i).getID().equals(uuid)) {
        missionList.set(i, newMission);
        System.out.println(ConsoleColors.GREEN + "Update mission!" + ConsoleColors.RESET);
        updated = true;
      }
    }
    if (updated == false) {
    }
    save(missionList);
  }

  public void delete(UUID uuid) {

    try {
      List<Mission> missionList = load();

      boolean deleted = missionList.removeIf(mission -> mission.getID().equals(uuid));

      if (deleted) {
        System.out.println(ConsoleColors.GREEN + "Removido com sucesso!" + ConsoleColors.RESET);
        save(missionList);
      } else {
        System.err.println(ConsoleColors.YELLOW
            + "Nenhuma uuid das missões do banco de dados corresponde ao uuid fornecido." + ConsoleColors.RESET);

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void resetDatabase() {
    try {
      List<Mission> missionList = new ArrayList<Mission>();
      save(missionList);
      System.out.println(ConsoleColors.GREEN + "Database resetado!" + ConsoleColors.RESET);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

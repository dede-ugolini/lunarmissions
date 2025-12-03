package lunarmissions.service;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import lunarmissions.standard.*;
import lunarmissions.view.*;

public class TextDatabaseHandler implements DatabaseAdapter {

  private static File file = new File("resources/database/MissionDatabaseText.txt");
  /*
   * public String read(int qtd) {
   * int ns = 0;
   * try {
   * FileReader fileReader = new FileReader(file);
   * BufferedReader reader = new BufferedReader(fileReader);
   * String line;
   * while ((line = reader.readLine()) != null) {
   * if (line.contains("\n")) {
   * ns++;
   * if (ns == qtd);
   * }
   * }
   * } catch (Exception e) {
   * System.err.println("Erro ao tentar ler o arquivo de texto: " +
   * e.getMessage());
   * }
   * }
   */

  public String read(String field, String key) {
    String result;
    try (Scanner in = new Scanner(file).useDelimiter(";");) {
      String token;
      while (in.hasNext()) {
        token = in.next();
        if (token.contains(field) && token.contains(key)) {
          result = token;
          System.out.println("Contains " + field + "and contains " + key);
          in.close();
          return result;
        }
      }
      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void read(int index) {
    try {
      FileReader fileReader = new FileReader(file);
      BufferedReader reader = new BufferedReader(fileReader);

      List<String> data = new ArrayList<>();
      String line;
      String[] info;

      for (int i = 0; i <= index; i++) {
        line = reader.readLine();
        info = line.split("\n");
        data.add(info[0]);
        System.out.println(data);
      }
      reader.close();
    } catch (Exception e) {
      System.err.println("Erro ao ler arquivo de texto: " + e.getMessage());
    }
  }

  public void create(Object o) {
    System.out.println("Created!");
  }

  public void create(ArrayList<Mission> missionsList) {
    try {
      FileWriter fileWriter = new FileWriter(file, true);
      for (int i = 0; i < missionsList.size(); i++) {
        fileWriter.write(missionsList.get(i).toString() + "\n");
      }
      fileWriter.flush();
      fileWriter.close();
      System.out.println("Conteúdo salvo usando arquivo de texto!");
    } catch (Exception e) {
      System.err.println("Erro em salvar em arquivo de texto:" + e.getMessage());
      e.printStackTrace();
    }
  }

  public void update(Object o, String field, String key) {
    System.out.println("Updated!");
  }

  public void delete(Object o) {
    System.out.println("Deleted!");
  }

  public String listAll() {

    StringBuilder sb = new StringBuilder();
    try {
      FileReader fileReader = new FileReader(file);
      BufferedReader reader = new BufferedReader(fileReader);
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
      reader.close();
      return sb.toString();
    } catch (Exception e) {
      System.err.println("Erro em fileReader:" + e.getMessage());
      return null;
    }
  }

  public void resetDatabase() {

    try {
      FileWriter fileWriter = new FileWriter(file, false);
      fileWriter.write("");
      fileWriter.flush();
      fileWriter.close();
      System.out.println(ConsoleColors.GREEN + "Arquivo limpado com sucesso!" + ConsoleColors.RESET);
    } catch (Exception e) {
      System.err.println(ConsoleColors.RED + "Erro ao limpar o conteúdo do arquivo: " + e.getMessage()
          + ConsoleColors.RESET);
      e.printStackTrace();
    }
  }
}

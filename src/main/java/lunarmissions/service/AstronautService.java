package lunarmissions.service;

import java.util.ArrayList;
import java.util.Scanner;
import lunarmissions.standard.*;
import lunarmissions.view.*;

public class AstronautService {

  private static ArrayList<Astronaut> astronautList = new ArrayList<Astronaut>();
  private final Scanner in = new Scanner(System.in);

  public void listAstronauts() {

    if (!astronautList.isEmpty()) {

      for (Astronaut a : astronautList) {
        System.out.println(a);
      }
    } else {
      System.err.println("Lista de astronautas está vazia");
    }
  }

  public void addAstronaut() {
    Astronaut astronaut = new Astronaut();

    astronaut.setName(setNameAstronaut());
    astronaut.setAge(setAgeAstronaut());
    astronaut.setHours(setHoursAstronaut());

    astronautList.add(astronaut);
    System.out.println("Astronauta adicionado com sucesso!");
  }

  private int setHoursAstronaut() {
    System.out.println("Digite a quantidade de horas de experiência do astronauta.");
    int hours = in.nextInt();
    return hours;
  }

  private int setAgeAstronaut() {
    System.out.println("Digite a idade do astronauta.");
    int age = in.nextInt();
    return age;
  }

  public String setNameAstronaut() {
    final int MAX_TENTATIVAS = 3;
    int tentativas = MAX_TENTATIVAS;

    while (tentativas > 0) {
      System.out.println("Digite o nome do astronauta:");
      String name = in.nextLine().trim();

      if (name.isEmpty()) {
        System.err.println(ConsoleColors.RED + "Nome não pode ser vazio." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      if (name.length() < 5) {
        System.err.println(ConsoleColors.RED + "Nome muito curto." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      if (!name.matches("^[A-Za-z ]{5,}$")) {
        System.err.println(
            ConsoleColors.RED + "Nome não pode conter números nem caracteres especiais." + ConsoleColors.RESET);
        tentativas--;
        continue;
      }

      return name;
    }

    throw new RuntimeException(ConsoleColors.RED + "Máximo de tentativas atingido." + ConsoleColors.RESET);
  }

}

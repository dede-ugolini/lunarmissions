package lunarmissions.view;

import java.util.Scanner;
import java.io.*;

public class Extras {

  private final Scanner in = new Scanner(System.in);
  private Ascii ascii = new Ascii();

  public void extras() {
    System.out
        .println("Bem vindo aos extras, se caso for sua primeira vez, use o tutorial,deseja abrir o tutorial? (y/n)");
    char choice = in.nextLine().charAt(0);

    switch (choice) {
      case 'y':
        tutorial();
        break;
      case 'n':
        handleOptions();
        break;
      default:
        optionNoRecognized();
        break;
    }
  }

  public void tutorial() {
    System.out.println("Bem vindo ao tutorial");
  }

  public void handleOptions() {

    System.out.println("1 - Usar hubble");

    int option = in.nextInt();

    switch (option) {
      case 1:
        hubble();
        break;

      default:
        optionNoRecognized();
        break;
    }
  }

  public void hubble() {
    System.out.println("1 - Gerar imagem");
    int option = in.nextInt();
    switch (option) {
      case 1:
        in.nextLine();
        genImageUniverse();
        break;

      default:
        optionNoRecognized();
        break;
    }
  }

  public void genImageUniverse() {
    System.out.println(ascii.universe());
    wantZoom();
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        genImage("peituda");
        break;
      case 'n':
        break;
      default:
        optionNoRecognized();
        break;
    }

  }

  public void genImage(String image) {
    try {
      File file = new File("/home/dede/code/algoritmos/2025.02/lunarmissions/" + image + ".txt");
      FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
        Thread.sleep(20);
      }
      in.nextLine();
      bufferedReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    wantZoom();
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        System.out.println(ascii.saturn());
        break;
      case 'n':
        System.out.println("pnc");
        break;
      default:
        optionNoRecognized();
        break;
    }
  }

  public void wantZoom() {
    System.out.println("Deseja dar zoom (y/n)");
  }

  public void optionNoRecognized() {
    System.out.println("Opção não reconhecida.");
  }
}

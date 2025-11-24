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
    System.out.println("1 - Gerar imagem do Universo");
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

  public void genImageCosmos() {
    genImage("cosmos");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        // genImage("");
        break;
      case 'n':
        break;
      default:
        optionNoRecognized();
        break;
    }
  }

  public void genImageAndromeda() {
    genImage("andromeda");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        genImage("zoomearth");
        break;
      case 'n':
        break;
      default:
        optionNoRecognized();
        break;
    }
  }

  public void genImageUniverse() {
    genImage("universe");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        genImagePlanets();
        break;
      case 'n':
        break;
      default:
        optionNoRecognized();
        break;
    }
  }

  public void genImagePlanets() {
    genImage("planets");
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
  }

  public void wantZoom() {
    System.out.println("Deseja dar zoom (y/n)");
  }

  public void optionNoRecognized() {
    System.out.println("Opção não reconhecida.");
  }
}

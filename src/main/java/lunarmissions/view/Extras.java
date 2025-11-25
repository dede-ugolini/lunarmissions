package lunarmissions.view;

import java.util.Scanner;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Extras {

  private final Scanner in = new Scanner(System.in);
  Animations animations = new Animations();

  private static String loadResource(String path) throws Exception {

    InputStream inputStream = Extras.class.getResourceAsStream(path);
    if (inputStream == null) {
      throw new IllegalStateException("Recurso não encontrado: " + path);
    }
    byte[] bytes = inputStream.readAllBytes();
    return new String(bytes, StandardCharsets.UTF_8);
  }

  public void extras() {
    System.out.println("Bem vindo aos extras versão Alpha");
    System.out.println("Deseja usar o satélite Hubble? (y/n)");
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        hubble();
        break;
      case 'n':
        break;
      default:
        optionNoRecognized(choice);
        break;
    }
  }

  public void hubble() {
    System.out.println("Gerar imagem do Universo (y/n)");
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        genImageUniverse();
        break;
      case 'n':
        break;
      default:
        optionNoRecognized(choice);
        break;
    }
  }

  public void genImageCosmos() {
    genImage("cosmos");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    in.nextLine();
    switch (choice) {
      case 'y':
        // genImage("");
        break;
      case 'n':
        break;
      default:
        optionNoRecognized(choice);
        break;
    }
  }

  public void genImageAndromeda() {
    genImage("andromeda");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    in.nextLine();
    switch (choice) {
      case 'y':
        genImage("zoomearth");
        break;
      case 'n':
        break;
      default:
        optionNoRecognized(choice);
        break;
    }
  }

  public void genImageUniverse() {
    genImage("universe");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    in.nextLine();
    switch (choice) {
      case 'y':
        genImagePlanets();
        break;
      case 'n':
        break;
      default:
        optionNoRecognized(choice);
        break;
    }
  }

  public void genImagePlanets() {
    genImage("planets");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    in.nextLine();
    switch (choice) {
      case 'y':
        genImageEarth();
        break;
      case 'n':
        break;
      default:
        optionNoRecognized(choice);
        break;
    }
  }

  public void genImageEarth() {
    genImage("earth");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        genImageZoomEarth();
        break;
      case 'n':
        break;
      default:
        optionNoRecognized(choice);
        break;
    }
  }

  public void genImageZoomEarth() {
    genImage("zoomearth");
    wantZoom();
    char choice = in.nextLine().charAt(0);
    switch (choice) {
      case 'y':
        System.out.print(ConsoleColors.CLEAR);
        animations.troughtputBar();
        genImage("peituda");
        break;
      case 'n':
        break;
      default:
        optionNoRecognized(choice);
        break;
    }
  }

  public void genImage(String image) {
    try {
      String ascii = loadResource("/resources/" + image + ".txt");
      System.out.println(ascii);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void wantZoom() {
    System.out.println("Deseja dar zoom (y/n)");
  }

  public void optionNoRecognized(String option) {
    System.out.println('"' + option + '"' + "não é uma opção reconhecida.");
  }

  public void optionNoRecognized(char option) {
    System.out.println('"' + option + '"' + " não é uma opção reconhecida.");
  }

  public void optionNoRecognized(int option) {
    System.out.println('"' + option + '"' + "não é uma opção reconhecida.");
  }
}

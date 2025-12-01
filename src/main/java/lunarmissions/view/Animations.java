package lunarmissions.view;

public class Animations {

  public static void main(String[] args) {
    Animations animations = new Animations();
    animations.progressBar();
    animations.progressEta();
    animations.troughtputBar();

  }

  public void spinner(String msg) {
    try {
      String[] frames = { "|", "/", "-", "\\" };
      System.out.print(" " + msg + "   ");

      for (int i = 0; i < 20; i++) {
        System.out.print("\b" + frames[i % frames.length]);
        Thread.sleep(150);
      }
      System.out.println("\b ");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void progressEta() {
    final int totalSteps = 300;
    final int barSize = 40;
    try {
      long start = System.currentTimeMillis();

      for (int step = 0; step <= totalSteps; step++) {
        double progress = (double) step / totalSteps;
        int filled = (int) (progress * barSize);

        long elapsed = System.currentTimeMillis() - start;
        long eta = (long) (elapsed / progress - elapsed);
        if (progress == 0)
          eta = 0;

        System.out.printf(
            "\r[%s%s] %6.2f%% | ETA: %4d ms",
            "#".repeat(filled),
            ".".repeat(barSize - filled),
            progress * 100,
            Math.max(0, eta));

        System.out.flush();
        Thread.sleep(10);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("\nFinalizado");
  }

  public void dots(String message) {
    int dots = 0;

    try {
      while (dots < 10) {
        String s = ".".repeat(dots % 4);
        System.out.print("\r" + message + s + "   ");
        System.out.flush();

        dots++;
        Thread.sleep(400);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void progressBar() {
    try {
      int total = 50; // tamanho visual
      // 🚀
      for (int i = 0; i <= total; i++) {
        int percent = (i * 100) / total;
        String bar = "=🚀".repeat(i) + "".repeat(i < total ? 1 : 0);
        String spaces = " ".repeat(total - i);

        System.out.printf("\r[%s%s] %3d%%", bar, spaces, percent);
        System.out.flush();

        Thread.sleep(80);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("\nConcluído");
  }

  public void troughtputBar() {
    try {
      int total = 500;
      long start = System.currentTimeMillis();

      for (int i = 0; i <= total; i++) {
        double rate = i / ((System.currentTimeMillis() - start) / 1000.0 + 0.001);

        System.out.printf(
            "\rProcessando imagem: %d/%d Gb | %.1f Gb/s",
            i, total, rate);

        System.out.flush();
        Thread.sleep(5);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("\nTerminado");
  }
}

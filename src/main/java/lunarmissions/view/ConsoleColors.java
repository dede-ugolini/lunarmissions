package lunarmissions.view;

/**
 * Fornece constantes ASCII para colorir a saída do terminal
 */

public enum ConsoleColors {
  /**
   * Representa o comando ANSI para limpar completamente o terminal.
   */
  CLEAR("\033[H\033[2J"), // limpa terminal em ANSI

  /**
   * Representa o comando ANSI para resetar todas as cores e estilos.
   */
  RESET("\033[0m"),

  /**
   * Representa a cor preta.
   */
  BLACK("\033[0;30m"), // BLACK

  /**
   * Representa a cor vermelha.
   */
  RED("\033[0;31m"), // RED

  /**
   * Representa a cor verde.
   */
  GREEN("\033[0;32m"), // GREEN

  /**
   * Representa a cor amarela.
   */
  YELLOW("\033[0;33m"), // YELLOW

  /**
   * Representa a cor azul.
   */
  BLUE("\033[0;34m"), // BLUE

  /**
   * Representa a cor magenta.
   */
  MAGENTA("\033[0;35m"), // MAGENTA

  /**
   * Representa a cor ciano.
   */
  CYAN("\033[0;36m"), // CYAN

  /**
   * Representa a cor branca.
   */
  WHITE("\033[0;37m"), // WHITE

  // ----- BOLD -----

  /**
   * Representa a cor preta em negrito.
   */
  BLACK_BOLD("\033[1;30m"), // BLACK

  /**
   * Representa a cor vermelha em negrito.
   */
  RED_BOLD("\033[1;31m"), // RED

  /**
   * Representa a cor verde em negrito.
   */
  GREEN_BOLD("\033[1;32m"), // GREEN

  /**
   * Representa a cor amarela em negrito.
   */
  YELLOW_BOLD("\033[1;33m"), // YELLOW

  /**
   * Representa a cor azul em negrito.
   */
  BLUE_BOLD("\033[1;34m"), // BLUE

  /**
   * Representa a cor magenta em negrito.
   */
  MAGENTA_BOLD("\033[1;35m"), // MAGENTA

  /**
   * Representa a cor ciano em negrito.
   */
  CYAN_BOLD("\033[1;36m"), // CYAN

  /**
   * Representa a cor branca em negrito.
   */
  WHITE_BOLD("\033[1;37m"), // WHITE

  // ----- UNDERLINE -----

  /**
   * Representa a cor preta sublinhada.
   */
  BLACK_UNDERLINED("\033[4;30m"), // BLACK

  /**
   * Representa a cor vermelha sublinhada.
   */
  RED_UNDERLINED("\033[4;31m"), // RED

  /**
   * Representa a cor verde sublinhada.
   */
  GREEN_UNDERLINED("\033[4;32m"), // GREEN

  /**
   * Representa a cor amarela sublinhada.
   */
  YELLOW_UNDERLINED("\033[4;33m"), // YELLOW

  /**
   * Representa a cor azul sublinhada.
   */
  BLUE_UNDERLINED("\033[4;34m"), // BLUE

  /**
   * Representa a cor magenta sublinhada.
   */
  MAGENTA_UNDERLINED("\033[4;35m"), // MAGENTA

  /**
   * Representa a cor ciano sublinhada.
   */
  CYAN_UNDERLINED("\033[4;36m"), // CYAN

  /**
   * Representa a cor branca sublinhada.
   */
  WHITE_UNDERLINED("\033[4;37m"), // WHITE

  // ----- BACKGROUND -----

  /**
   * Representa o fundo preto.
   */
  BLACK_BACKGROUND("\033[40m"), // BLACK

  /**
   * Representa o fundo vermelho.
   */
  RED_BACKGROUND("\033[41m"), // RED

  /**
   * Representa o fundo verde.
   */
  GREEN_BACKGROUND("\033[42m"), // GREEN

  /**
   * Representa o fundo amarelo.
   */
  YELLOW_BACKGROUND("\033[43m"), // YELLOW

  /**
   * Representa o fundo azul.
   */
  BLUE_BACKGROUND("\033[44m"), // BLUE

  /**
   * Representa o fundo magenta.
   */
  MAGENTA_BACKGROUND("\033[45m"), // MAGENTA

  /**
   * Representa o fundo ciano.
   */
  CYAN_BACKGROUND("\033[46m"), // CYAN

  /**
   * Representa o fundo branco.
   */
  WHITE_BACKGROUND("\033[47m"), // WHITE

  // ----- HIGH INTENSITY -----

  /**
   * Representa a cor preta brilhante.
   */
  BLACK_BRIGHT("\033[0;90m"), // BLACK

  /**
   * Representa a cor vermelha brilhante.
   */
  RED_BRIGHT("\033[0;91m"), // RED

  /**
   * Representa a cor verde brilhante.
   */
  GREEN_BRIGHT("\033[0;92m"), // GREEN

  /**
   * Representa a cor amarela brilhante.
   */
  YELLOW_BRIGHT("\033[0;93m"), // YELLOW

  /**
   * Representa a cor azul brilhante.
   */
  BLUE_BRIGHT("\033[0;94m"), // BLUE

  /**
   * Representa a cor magenta brilhante.
   */
  MAGENTA_BRIGHT("\033[0;95m"), // MAGENTA

  /**
   * Representa a cor ciano brilhante.
   */
  CYAN_BRIGHT("\033[0;96m"), // CYAN

  /**
   * Representa a cor branca brilhante.
   */
  WHITE_BRIGHT("\033[0;97m"), // WHITE

  // ----- BOLD HIGH INTENSITY -----

  /**
   * Representa a cor preta brilhante em negrito.
   */
  BLACK_BOLD_BRIGHT("\033[1;90m"), // BLACK

  /**
   * Representa a cor vermelha brilhante em negrito.
   */
  RED_BOLD_BRIGHT("\033[1;91m"), // RED

  /**
   * Representa a cor verde brilhante em negrito.
   */
  GREEN_BOLD_BRIGHT("\033[1;92m"), // GREEN

  /**
   * Representa a cor amarela brilhante em negrito.
   */
  YELLOW_BOLD_BRIGHT("\033[1;93m"), // YELLOW

  /**
   * Representa a cor azul brilhante em negrito.
   */
  BLUE_BOLD_BRIGHT("\033[1;94m"), // BLUE

  /**
   * Representa a cor magenta brilhante em negrito.
   */
  MAGENTA_BOLD_BRIGHT("\033[1;95m"), // MAGENTA

  /**
   * Representa a cor ciano brilhante em negrito.
   */
  CYAN_BOLD_BRIGHT("\033[1;96m"), // CYAN

  /**
   * Representa a cor branca brilhante em negrito.
   */
  WHITE_BOLD_BRIGHT("\033[1;97m"), // WHITE

  // ----- HIGH INTENSITY BACKGROUND -----

  /**
   * Representa o fundo preto brilhante.
   */
  BLACK_BACKGROUND_BRIGHT("\033[0;100m"), // BLACK

  /**
   * Representa o fundo vermelho brilhante.
   */
  RED_BACKGROUND_BRIGHT("\033[0;101m"), // RED

  /**
   * Representa o fundo verde brilhante.
   */
  GREEN_BACKGROUND_BRIGHT("\033[0;102m"), // GREEN

  /**
   * Representa o fundo amarelo brilhante.
   */
  YELLOW_BACKGROUND_BRIGHT("\033[0;103m"), // YELLOW

  /**
   * Representa o fundo azul brilhante.
   */
  BLUE_BACKGROUND_BRIGHT("\033[0;104m"), // BLUE

  /**
   * Representa o fundo magenta brilhante.
   */
  MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"), // MAGENTA

  /**
   * Representa o fundo ciano brilhante.
   */
  CYAN_BACKGROUND_BRIGHT("\033[0;106m"), // CYAN

  /**
   * Representa o fundo branco brilhante.
   */
  WHITE_BACKGROUND_BRIGHT("\033[0;107m"); // WHITE

  private final String code;

  ConsoleColors(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return code;
  }
}

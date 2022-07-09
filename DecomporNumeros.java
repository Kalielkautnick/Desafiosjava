import java.util.Scanner;

public class DecomporNumeros {

  public DecomporNumeros() {
    Scanner entrada = new Scanner(System.in);
    System.out.print("Informe o número que você quer fazer a decomposição: ");
    int numero = entrada.nextInt();

    int divisor = 2;
    int auxiliar = numero;
    System.out.println("");
    System.out.println("número | decomposição");

    while (auxiliar > 1) {
      if (auxiliar % divisor == 0) {
        auxiliar /= divisor;
        metodoComparaTamanho(auxiliar, divisor);
      } else {
        while (auxiliar % divisor != 0) {
          divisor++;
        }
        auxiliar /= divisor;
        metodoComparaTamanho(auxiliar, divisor);
      }
    }
    System.out.println("--------------------");
    System.out.print("1");
    entrada.close();
  }

  /*método para saber se o número no momento de fazer a impressão na tela, tem 1,2,3 ou 4 digitos
  para ajustar o espaço */
  private void metodoComparaTamanho(int auxiliar, int divisor) {
    if ((auxiliar * divisor) >= 1000) {
      System.out.println((auxiliar * divisor) + "         " + divisor);
    } else if ((auxiliar * divisor) >= 100) {
      System.out.println((auxiliar * divisor) + "           " + divisor);
    } else if ((auxiliar * divisor) >= 10) {
      System.out.println((auxiliar * divisor) + "            " + divisor);
    } else {
      System.out.println((auxiliar * divisor) + "             " + divisor);
    }
  }

  public static void main(String[] args) {
    new DecomporNumeros();
  }
}

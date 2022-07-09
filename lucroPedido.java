import java.util.Scanner;

public class lucroPedido {

  public lucroPedido() {
    Scanner entrada = new Scanner(System.in);

    String nomeProduto = "";
    double pc = 0;
    double pv = 0;
    double somaCompra = 0;
    double somaVenda = 0;
    int qtdLucroBaixo = 0;
    int qtdLucroMedio = 0;
    int qtdLucroAlto = 0;
    int qtdLucroMuitoAlto = 0;

    System.out.println("Quantos itens do pedido serão faturados? ");
    int quantidadePedido = entrada.nextInt();

    for (int contador = 1; contador <= quantidadePedido; contador++) {
      System.out.println("Informe o nome do produto: ");
      nomeProduto = entrada.next();
      System.out.println("Informe o preço de compra do produto (PC): ");
      pc = entrada.nextDouble();
      System.out.println("Informe o preço de venda do produto (PV): ");
      pv = entrada.nextDouble();

      double lucro = (pv - pc) / pc * 100;

      somaCompra = pc;
      somaVenda = pv;

      if (lucro < 10) {
        System.out.println(
          "O produto " + nomeProduto + " tem " + lucro + "% de lucro"
        );
        qtdLucroBaixo++;
      } else if (lucro >= 10 && lucro <= 20) {
        System.out.println(
          "O produto " + nomeProduto + " tem " + lucro + "% de lucro"
        );
        qtdLucroMedio++;
      } else if (lucro > 20) {
        System.out.println(
          "O produto " + nomeProduto + "tem " + lucro + "% de lucro"
        );
        qtdLucroAlto++;
      } else if (lucro > 50) {
        System.out.println(
          "O produto " + nomeProduto + "tem " + lucro + "% de lucro"
        );
        qtdLucroMuitoAlto++;
      }
    }
    System.out.println("Produtos com lucro menor que 10%: " + qtdLucroBaixo);
    System.out.println(
      "Produtos com lucro maior que 10% e menor que 20%: " + qtdLucroMedio
    );
    System.out.println("Produtos com lucro maior que 20%: " + qtdLucroAlto);
    System.out.println(
      "Produtos com lucro maior que 50%: " + qtdLucroMuitoAlto
    );

    double lucroTotal = somaVenda - somaCompra;
    System.out.printf("%s %.2f", "Lucro total do pedido: R$ ", lucroTotal);

    entrada.close();
  }

  public static void main(String[] args) {
    new lucroPedido();
  }
}

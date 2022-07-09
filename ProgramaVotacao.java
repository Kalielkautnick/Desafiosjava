import java.util.Scanner;

public class ProgramaVotacao {

  public ProgramaVotacao() {
    Scanner entrada = new Scanner(System.in);
    metodoEscreverOpcoes();

    int voto = entrada.nextInt();

    int soma1 = 0;
    int soma2 = 0;
    int soma3 = 0;
    int soma4 = 0;
    int soma5 = 0;
    int soma6 = 0;

    //método principal onde recebe os votos do usuário e incrementa nas variáveis para fazer o cálculo
    recebeEntradas(soma1, soma2, soma3, soma4, soma5, soma6, voto, entrada);

    // somas
    escreverSomatorioVotos(soma1, soma2, soma3, soma4);

    //soma nulos e brancos:
    escreverSomatorioVotosNulosOuBrancos(soma5, soma6);

    // percentuais
    percentuaisDeNulosOuBrancos(soma1, soma2, soma3, soma4, soma5, soma6);

    //definindo se algum candidato ganhou a votação, ou se houve empate.
    determinarCandidatoVencedor(soma1, soma2, soma3, soma4);
    entrada.close();
  }

  private void recebeEntradas( int soma1, int soma2, int soma3,
    int soma4, int soma5, int soma6, int voto, Scanner entrada) {
    if (voto >= 1 && voto <= 6) {
      while (voto != 0) {
        switch (voto) {
          case 1:
            soma1++;
            break;
          case 2:
            soma2++;
            break;
          case 3:
            soma3++;
            break;
          case 4:
            soma4++;
            break;
          case 5:
            soma5++;
            break;
          case 6:
            soma6++;
            break;
          default:
            System.out.println("Opção Incorreta.");
            break;
        }
        if (!(voto >= 1 && voto <= 6)) {
          //se o usuário votar um número diferente das opções válidas, o programa insiste que vote o numero correto
          while (!(voto >= 1 && voto <= 6)) {
            System.out.println("Escolha um dos códigos para votar: ");
            System.out.println("0   1   2   3   4   5   6");
            voto = entrada.nextInt();
          }
        } else {
          metodoEscreverOpcoes();

          voto = entrada.nextInt();
        }
      }
    }
  }

  private void metodoEscreverOpcoes() {
    System.out.println("Escolha um dos códigos para votar: ");
    System.out.println("1:  Candidato 1");
    System.out.println("2:  Candidato 2");
    System.out.println("3:  Candidato 3");
    System.out.println("4:  Candidato 4");
    System.out.println("5:  Voto nulo");
    System.out.println("6:  Voto em branco");
    System.out.println("0 --Encerrar votação");
  }

  private void escreverSomatorioVotos(
    int soma1,
    int soma2,
    int soma3,
    int soma4) {
    System.out.println("Total de cada candidato: ");
    System.out.println("Candidato 1: " + soma1 + " voto(s)");
    System.out.println("Candidato 2: " + soma2 + " voto(s)");
    System.out.println("Candidato 3: " + soma3 + " voto(s)");
    System.out.println("Candidato 4: " + soma4 + " voto(s)");
    System.out.println("");
  }

  private void escreverSomatorioVotosNulosOuBrancos(int soma5, int soma6) {
    System.out.println("Total de votos nulos e em branco: ");
    System.out.println("5- Voto nulo = " + soma5 + " voto(s)");
    System.out.println("6- Voto em branco = " + soma6 + " voto(s)");
    System.out.println("");
  }

  private void percentuaisDeNulosOuBrancos(
    int soma1,
    int soma2,
    int soma3,
    int soma4,
    int soma5,
    int soma6) {
    double total = (soma1 + soma2 + soma3 + soma4 + soma5 + soma6);
    double perc5 = (soma5 * 100) / total;
    double perc6 = (soma6 * 100) / total;

    System.out.println("Percentuais: ");
    System.out.println("5- Votos nulos: " + perc5 + "%");
    System.out.println("6- Votos em branco: " + perc6 + "%");
    System.out.println(" ");
  }

  private void determinarCandidatoVencedor(
    int soma1,
    int soma2,
    int soma3,
    int soma4) {
    System.out.println("CANDIDATO  VENCEDOR:");
    if (soma1 > soma2 && soma1 > soma3 && soma1 > soma4) {
      System.out.println("Candidato 1");
    } else if (soma2 > soma1 && soma2 > soma3 && soma2 > soma4) {
      System.out.println("Candidato 2");
    } else if (soma3 > soma1 && soma3 > soma2 && soma3 > soma4) {
      System.out.println("Candidato 3");
    } else if (soma4 > soma1 && soma4 > soma2 && soma4 > soma3) {
      System.out.println("Candidato 4");
    } else {
      System.out.println("Nenhum.");
      System.out.println("Houve empate!");
    }
  }

  public static void main(String[] args) {
    new ProgramaVotacao();
  }
}

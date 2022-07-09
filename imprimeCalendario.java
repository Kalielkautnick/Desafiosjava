import java.util.Scanner;

//esse programa pede para você informar qual dia da semana iniciou o mês que você quer consultar na tela.
/*dado o dia da semana, informe o numero do mês e o programa irá determinar qual é o mês que você escolheu,
e irá imprimir a quantidade de dias respectiva a quantidade de dias que esse mês contém, havendo exceção para 
o mês de Fevereiro, que pergunta se o ano é bissexto ou não.
É impresso um calendário baseado nas entradas do usuário, que possuem validações */

public class imprimeCalendario {

  Scanner entrada;

  public imprimeCalendario() {
    entrada = new Scanner(System.in);
    System.out.println("Em qual dia da semana começa o mês?");
    System.out.println(
      "(considere: domingo = 1, segunda = 2, terça = 3, quarta = 4, quinta = 5, sexta = 6, sábado = 7)"
    );

    int diaSemana = entrada.nextInt();
    int dias = 0;
    int mes = 0;
    String resposta = "";

    do {
      mes = escolherMes(mes);
      dias = calcularDiasDoMes(mes, dias, resposta);
      escreverMesEscolhido(mes);
      imprimirCalendario(dias, diaSemana);
    } while (mes < 1 || mes > 12);
    entrada.close();
  }

  private int escolherMes(int mes) {
    System.out.println("Escolha o numero do mês: ");
    System.out.println(
      "1- JAN, 2- FEV, 3- MAR, 4- ABR, 5- MAI, 6- JUN, 7- JUL, 8- AGO" +
      " 9- SET, 10- OUT, 11- NOV, 12- DEZ"
    );
    mes = entrada.nextInt();
    return mes;
  }

  private int calcularDiasDoMes(int mes, int dias, String resposta) {
    if (mes >= 1 && mes <= 7 && (mes % 2 == 1)) {
      dias = 31;
    } else if (mes == 2) {
      do {
        System.out.println("Esse ano é bissexto? (s/n)");
        resposta = entrada.next().toLowerCase().trim().substring(0);
        if (resposta.equals("s")) {
          dias = 29;
        } else if (resposta.equals("n")) {
          dias = 28;
        } else {
          System.out.println("reposta inválida, tente novamente: ");
        }
      } while (!(resposta.equals("s") || resposta.equals("n")));
    } else if (mes >= 4 && mes <= 6 && (mes % 2 == 0)) {
      dias = 30;
    } else if (mes >= 8 && mes <= 12 && (mes % 2 == 0)) {
      dias = 31;
    } else if (mes >= 9 && mes <= 11 && (mes % 2 == 1)) {
      dias = 30;
    } else {
      System.out.println("Número de mês inválido, informe novamente: ");
    }
    while (mes < 0 || mes > 12);
    return dias;
  }

  private void escreverMesEscolhido(int mes) {
    String mesEscolhido = "";
    switch (mes) {
      case 1:
        mesEscolhido = "JANEIRO";
        break;
      case 2:
        mesEscolhido = "FEVEREIRO";
        break;
      case 3:
        mesEscolhido = "MARÇO";
        break;
      case 4:
        mesEscolhido = "ABRIL";
        break;
      case 5:
        mesEscolhido = "MAIO";
        break;
      case 6:
        mesEscolhido = "JUNHO";
        break;
      case 7:
        mesEscolhido = "JULHO";
        break;
      case 8:
        mesEscolhido = "AGOSTO";
        break;
      case 9:
        mesEscolhido = "SETEMBRO";
        break;
      case 10:
        mesEscolhido = "OUTUBRO";
        break;
      case 11:
        mesEscolhido = "NOVEMBRO";
        break;
      case 12:
        mesEscolhido = "DEZEMBRO";
        break;
    }
    System.out.println("");
    System.out.println("MÊS DE " + mesEscolhido + ":");
  }

  //método principal que imprime o calendário formatado perfeitamente no console
  private void imprimirCalendario(int dias, int diaSemana) {
    System.out.println("  D  S  T  Q  Q  S  S");
    System.out.println("----------------------");
    for (int i = 1; i < diaSemana; i++) {
      System.out.print("   ");
    }
    for (int i = 1; i <= dias; i++) {
      if (i < 10) {
        System.out.print("| " + i);
      } else if (i >= 10 && i < dias) {
        System.out.print("|" + i);
      } else if (i == dias) {
        System.out.print("|" + i + "|");
      }
      if (diaSemana == 7 && i < dias) {
        diaSemana /= 7;
        System.out.println("|");
      } else {
        diaSemana++;
      }
    }
    System.out.println("");
    System.out.println("----------------------");
  }

  public static void main(String[] args) {
    new imprimeCalendario();
  }
}

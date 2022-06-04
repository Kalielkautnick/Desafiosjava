import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        int n = entrada.nextInt();
        int numero = 1;

        System.out.println("Triângulo de Floyd com " + n + " linhas");
        for (int linhas = 1; linhas <= n; linhas++) {
            for (int colunas = 1; colunas <= linhas; colunas++) {
                System.out.print(numero+ "  ");
                numero++;
            }
            System.out.println(" ");
        }
        entrada.close();
    }
}

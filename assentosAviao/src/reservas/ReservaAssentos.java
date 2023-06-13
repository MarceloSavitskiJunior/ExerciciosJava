package reservas;

import javax.swing.*;
import java.util.Scanner;

public class ReservaAssentos extends MatrizAssentos{
    public ReservaAssentos(int numFileiras) {
        super(numFileiras);
    }

    public static void main(String[] args) {
        int numFileiras = 20;

        MatrizAssentos matrizAssentos = new MatrizAssentos(numFileiras);

        matrizAssentos.primeiroAcesso();

        while (matrizAssentos.validarContinuidade()) {
            matrizAssentos.exibirAssentos();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a posição do assento (por exemplo, A05): ");
            String posicao = scanner.nextLine();
            if (posicao.length() != 3) {
                matrizAssentos.validarEscrita();
                break;
            }
            int fileira = posicao.charAt(0) - 'A';
            int poltrona = Integer.parseInt(posicao.substring(1)) - 1;

            if (matrizAssentos.verificarAssento(fileira, poltrona)) {
                matrizAssentos.reservarAssento(fileira, poltrona, posicao);
                System.out.printf("O assento %s foi reservado com sucesso!%n", posicao);
            } else {
                System.out.printf("O assento %s já está ocupado. Verifique outras opções disponíveis:%n", posicao);

                matrizAssentos.exibirAssentos();
            }

        }
    }
}
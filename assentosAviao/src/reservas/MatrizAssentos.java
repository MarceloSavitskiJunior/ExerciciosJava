package reservas;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class MatrizAssentos {
    private String[][] assentos;
    private int numFileiras;
    private String nome;
    StringBuilder deuPau = new StringBuilder();
    StringBuilder msg = new StringBuilder();

    public MatrizAssentos(int numFileiras) {
        this.numFileiras = numFileiras;
        this.assentos = new String[numFileiras][11];

        for (int i = 0; i < numFileiras; i++) {
            for (int j = 0; j < 11; j++) {
                assentos[i][j] = "livre";
            }
        }
    }

    public void reservarAssento(int fileira, int poltrona, String posicao) {
        assentos[fileira][poltrona] = posicao;
    }

    public boolean verificarAssento(int fileira, int poltrona) {
        return assentos[fileira][poltrona].equals("livre");
    }

    public void exibirAssentos() {
        System.out.print("    ");
        for (int i = 1; i <= 11; i++) {
            System.out.printf("%02d ", i);
        }
        System.out.println();

        for (int fileira = 0; fileira < numFileiras; fileira++) {
            System.out.printf("%c ", 'A' + fileira);
            for (int poltrona = 0; poltrona < 11; poltrona++) {
                if (poltrona == 3 || poltrona == 8) {
                    System.out.print(" || ");
                }
                System.out.printf("%-4s", assentos[fileira][poltrona]);
            }
            System.out.println();
        }
    }

    public void primeiroAcesso() {
        nome = JOptionPane.showInputDialog("Olá! Qual o seu nome?");
        msg.append("Bem vindo, ").append(nome).append("!");
        JOptionPane.showMessageDialog(null, msg);
    }

    public void validarEscrita() {
        deuPau.append(nome).append(", você destruiu o sistema. Tchau");
        JOptionPane.showMessageDialog(null, deuPau);
    }

    public boolean validarContinuidade() {
        if (validarSaida()) {
            return true;
        } else {
           return false;
        }
    }

    public boolean validarSaida() {
        Scanner sc = new Scanner(System.in);
        String validacao;

        System.out.println("Você deseja reservar um assento? (sim/não)");
        validacao = sc.nextLine();
        if (validacao.equalsIgnoreCase("Sim")) {
            return true;
        } else {
            return false;
        }
    }
}
package senhaDificil;

import java.security.SecureRandom;

public class senhaDificil {
    public static void main(String[] args) {
        System.out.println("#########################\nGERADOR DE SENHAS SEGURAS\n#########################");

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 5; i++) {
            StringBuilder senha = new StringBuilder();

            for (int j = 0; j < 2; j++) {
                char charAleatorio = (char) (65 + random.nextInt(26)); 
                senha.append(charAleatorio);
            }

            for (int j = 0; j < 2; j++) {
                char charAleatorio = (char) (97 + random.nextInt(26)); 
                senha.append(charAleatorio);
            }

            char charAleatorio = (char) (65 + random.nextInt(25)); 
            senha.append(charAleatorio);

            for (int j = 0; j < 2; j++) {
                int numAleatorio = random.nextInt(10);
                senha.append(numAleatorio);
            }

            String characEspec = "!@#$%^&*()_-+=<>?";
            int aleatorioTemp = random.nextInt(characEspec.length());
            char characEspecAleatorio = characEspec.charAt(aleatorioTemp);
            senha.append(characEspecAleatorio);

            System.out.println("Senha " + (i + 1) + ": " + senha.toString());
        }
    }
}

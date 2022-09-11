import java.util.*;

public class Euromilhoes {
    static Scanner maquina = new Scanner(System.in);
    static Chave chaveVencedora = new Chave();

    static Art arte = new Art();

    public static void main(String[] args) {
        int escolha = 1;
        chaveVencedora.chaveAleatoria();


        while (escolha != 0) {
            try {
                Boletim apostasUtilizador = new Boletim();

                arte.Ascii();

                System.out.println("Bem-Vindo!");
                System.out.println("---------------------------------------------------------------");
                System.out.println("Gostaria de registar uma aposta? ou verificar o sorteio?");
                System.out.println("1 - Novo Sorteio");
                System.out.println("2 - Aposta Manual");
                System.out.println("3 - Automatica");
                System.out.println("4 - Verificar sorteio da semana");
                System.out.println("5 - Sorte???");
                System.out.println("0 - Sair");
                escolha = maquina.nextInt();
                maquina.nextLine();

                switch (escolha) {
                    case 1 -> {
                        chaveVencedora.limparChave();
                        chaveVencedora.chaveAleatoria();
                        System.out.println("Novo sorteio efetuado com sucesso.");
                    }
                    case 2 -> {
                        chaveVencedora.limparChave();
                        chaveVencedora.chaveAleatoria();
                        apostasUtilizador.apostaManual(chaveVencedora);
                    }
                    case 3 -> {
                        chaveVencedora.limparChave();
                        chaveVencedora.chaveAleatoria();
                        apostasUtilizador.apostaAutomatica(chaveVencedora);
                    }
                    case 4 -> {
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("Chave da Semana:");
                        System.out.println(chaveVencedora);
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                    }
                    case 5 -> {
                        chaveVencedora.limparChave();
                        chaveVencedora.chaveAleatoria();
                        apostasUtilizador.Sorte(chaveVencedora);
                    }
                    case 0 -> {
                    }
                }
            } catch (Exception e) {
                System.out.println("Opcao invalida");
                maquina = new Scanner(System.in);
            }
        }
    }


}

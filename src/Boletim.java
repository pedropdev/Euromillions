import java.text.DecimalFormat;
import java.util.*;


public class Boletim {

    static Scanner maquina = new Scanner(System.in);

    static DecimalFormat formM = new DecimalFormat("#");
    static DecimalFormat formPerc = new DecimalFormat("#.0");
    List<Chave> apostas;

    String[] premios = {"89,000,000.00", "150,000.00", "25,000.00"};

    //mudanca de chave em preenchimento manual
    int apontarParaChave = 0;


    public Boletim() {
        this.apostas = new ArrayList<>();
    }

    /**
     * Gera um boletim com 1 a 5 chaves que e preenchido PELO UTILIZADOR e compara com a chave vencedora desse sorteio.
     *
     * @param seq Chave vencedora da semana.
     */
    public void apostaManual(Chave seq) {
//        //TESTING
//        System.out.println(seq);


        System.out.println("Quantas chaves quer?(de 1 a 5)");
        int numChaveUser = maquina.nextInt();
        maquina.nextLine();

        if (numChaveUser > 0 && numChaveUser < 6) {
            for (int i = 0; i < numChaveUser; i++) {
                Chave chaveNova = new Chave();
                apostas.add(chaveNova);
            }
            //cria boletim de apostas
            this.setApostas(apostas);


            while (numChaveUser != 0) {

                assistenteDeInputs("Insira os 5 numeros com um espaco entre cada um: (entre 1 a 50)\n", 5);
                assistenteDeInputs("Insira as 2 numeros com um espaco entre cada uma: (entre 1 a 12)\n", 2);


                //  -1 chave para preencher no boletim
                numChaveUser -= 1;
                //passar para outra chave no boletim
                apontarParaChave += 1;

            }

            //Test | Verificação de preenchimento
            for (int i = 0; i < this.getApostas().size(); i++) {
                System.out.println("==========================================================");
                System.out.printf("%sa Chave: \n", i + 1);
                System.out.println(this.getApostas().get(i));
                System.out.println("==========================================================");
            }


        } else {
            System.out.println("Numero Invalido.");
        }

        for (int i = 0; i < this.getApostas().size(); i++) {

            if (Objects.equals(this.getApostas().get(i).chaveNums, seq.chaveNums)) {
                for (int j = 0; j < seq.chaveEstrelas.size(); j++) {
                    if (Objects.equals(this.getApostas().get(i).chaveEstrelas.get(j), seq.chaveEstrelas.get(j))) {
                        this.getApostas().get(i).setEstrelasCorretas(this.getApostas().get(i).getEstrelasCorretas() + 1);
                        ;
                    }
                }
            }
        }

        for (int i = 0; i < this.getApostas().size(); i++) {
            System.out.println("\n\n\n********************************************************");
            if (Objects.equals(this.getApostas().get(i).chaveNums, seq.chaveNums) && this.getApostas().get(i).getEstrelasCorretas() == 2) {
                System.out.printf("PARABENS! %sa Chave: \n", i + 1);
                System.out.println(this.getApostas().get(i) + "\n");
                System.out.println("E A VENCEDORA!");
                System.out.printf("Ganhou o 1o Premio: %s Euros!\n", premios[0]);
                System.out.println("Chave Sorteada: " + seq);
            } else if (Objects.equals(this.getApostas().get(i).chaveNums, seq.chaveNums) && this.getApostas().get(i).getEstrelasCorretas() == 1) {
                System.out.printf("PARABENS! %sa Chave: \n", i + 1);
                System.out.println(this.getApostas().get(i) + "\n");
                System.out.printf("Ganhou o 2o Premio: %s Euros!\n", premios[1]);
                System.out.println("Chave Sorteada: " + seq);
            } else if (Objects.equals(this.getApostas().get(i).chaveNums, seq.chaveNums) && this.getApostas().get(i).getEstrelasCorretas() == 0) {
                System.out.printf("PARABENS! %sa Chave: \n", i + 1);
                System.out.println(this.getApostas().get(i) + "\n");
                System.out.printf("Ganhou o 3o Premio: %s Euros!\n", premios[2]);
                System.out.println("Chave Sorteada: " + seq);
            } else {
                System.out.println("Infelizmente hoje nao foi o seu dia de sorte...");
                System.out.println("Chave Sorteada: \n" + seq);
            }

            System.out.println("********************************************************\n\n\n");
        }

    }

    /**
     * Gera um boletim com 1 a 5 chaves que e preenchido AUTOMATICAMENTE e compara com a chave vencedora desse sorteio.
     *
     * @param seq Chave vencedora da semana.
     */
    public void apostaAutomatica(Chave seq) {
        ////TESTING
        //System.out.println(seq);

        System.out.println("Quantas chaves quer?(de 1 a 5)");
        int numChaveUser = maquina.nextInt();
        maquina.nextLine();

        if (numChaveUser > 0 && numChaveUser < 6) {
            for (int i = 0; i < numChaveUser; i++) {
                Chave chaveNova = new Chave();
                chaveNova.chaveAleatoria();
                apostas.add(chaveNova);
            }
            //cria boletim de apostas
            this.setApostas(apostas);


            //Test | Verificação de preenchimento
            for (int i = 0; i < this.getApostas().size(); i++) {
                System.out.println("==========================================================");
                System.out.printf("%sa Chave: \n", i + 1);
                System.out.println(this.getApostas().get(i));
                System.out.println("==========================================================");
            }

            for (int i = 0; i < this.getApostas().size(); i++) {

                if (Objects.equals(this.getApostas().get(i).chaveNums, seq.chaveNums)) {
                    for (int j = 0; j < seq.chaveEstrelas.size(); j++) {
                        if (Objects.equals(this.getApostas().get(i).chaveEstrelas.get(j), seq.chaveEstrelas.get(j))) {
                            this.getApostas().get(i).setEstrelasCorretas(this.getApostas().get(i).getEstrelasCorretas() + 1);
                            ;
                        }
                    }
                }
            }
        } else {
            System.out.println("Numero Invalido.");
        }

        for (int i = 0; i < this.getApostas().size(); i++) {
            System.out.println("\n\n\n********************************************************");
            if (Objects.equals(this.getApostas().get(i).chaveNums, seq.chaveNums) && this.getApostas().get(i).getEstrelasCorretas() == 2) {
                System.out.printf("PARABENS! %sa Chave: \n", i + 1);
                System.out.println(this.getApostas().get(i) + "\n");
                System.out.println("E A VENCEDORA!");
                System.out.printf("Ganhou o 1o Premio: %s Euros!\n", premios[0]);
                System.out.println("Chave Sorteada: " + seq);
            } else if (Objects.equals(this.getApostas().get(i).chaveNums, seq.chaveNums) && this.getApostas().get(i).getEstrelasCorretas() == 1) {
                System.out.printf("PARABENS! %sa Chave: \n", i + 1);
                System.out.println(this.getApostas().get(i) + "\n");
                System.out.printf("Ganhou o 2o Premio: %s Euros!\n", premios[1]);
                System.out.println("Chave Sorteada: " + seq);
            } else if (Objects.equals(this.getApostas().get(i).chaveNums, seq.chaveNums) && this.getApostas().get(i).getEstrelasCorretas() == 0) {
                System.out.printf("PARABENS! %sa Chave: \n", i + 1);
                System.out.println(this.getApostas().get(i) + "\n");
                System.out.printf("Ganhou o 3o Premio: %s Euros!\n", premios[2]);
                System.out.println("Chave Sorteada: " + seq);
            } else {
                System.out.println("Infelizmente hoje nao foi o seu dia de sorte...");
                System.out.println("Chave Sorteada: \n" + seq);
            }

            System.out.println("********************************************************\n\n\n");
        }

    }


    /**
     * Gera uma chave e calcula o numero de vezes e a percentagem de ganhar.
     *
     * @param seq Chave vencedora da semana.
     */
    public void Sorte(Chave seq) {
        System.out.println("A processar...");

        boolean sorte = false;
        int tentativas = 1;

        double c1 = f(50) / (f(45) * f(5));
        double c2 = f(12) / (f(10) * f(2));
        double totalCombi = c1 * c2;
        double chance = 1 / totalCombi;

        formM.setMaximumFractionDigits(8);
        formPerc.setMaximumFractionDigits(11);

        Chave chaveNova = new Chave();
        chaveNova.chaveAleatoria();


        ///Testing
//        System.out.println(seq);
//        System.out.println(chaveNova);
//        System.out.printf("As chances de ganhar sao 1 em %s\n Isso e igual a : %s %%", formM.format(totalCombi),formPerc.format(chance));


        while (!sorte) {

            if (Objects.equals(chaveNova.chaveNums, seq.chaveNums) && Objects.equals(chaveNova.chaveEstrelas, seq.chaveEstrelas)) {
                sorte = true;

                System.out.println("\n\n\n********************************************************");
                System.out.println("PARABENS! A Chave: \n");
                System.out.println(chaveNova + "\n");
                System.out.println("E A VENCEDORA!");
                System.out.println("Chave Sorteada: " + seq);
                System.out.printf("So demorou %s tentativas.\n", tentativas);
                System.out.printf("As chances de ganhar sao 1 em %s\n Isso e igual a : %s %%\n", formM.format(totalCombi), formPerc.format(chance));
                System.out.println("********************************************************\n\n\n");

            } else {
                tentativas += 1;
                seq.limparChave();
                seq.chaveAleatoria();
            }
        }
    }

    private List<Chave> getApostas() {
        return apostas;
    }

    private void setApostas(List<Chave> apostas) {
        this.apostas = apostas;
    }

    private Chave getChave(int apontarParaChave) {
        return apostas.get(apontarParaChave);
    }

    /**
     * factorial
     *
     * @param x n em n!
     * @return n!
     */
    public static double f(double x) {
        double num = 1;
        for (int i = 1; i <= x; i++) {
            num = num * i;
        }
        return num;
    }

    /**
     * Verifica se uma lista de Integer tem duplicados(convertendo para um Set).
     *
     * @param nums Lista de Integer
     * @return True or False se tem duplicados.
     */
    private static boolean temDuplicados(List<Integer> nums) {

        Set<Integer> newSet = new HashSet<>(nums);

        return newSet.size() != nums.size();


    }

    /**
     * Ajuda o utilizador a preencher o boletim
     *
     * @param text texto a mostrar ao user
     * @param size indicador de tamanho/escolha (numeros e estrelas)
     */
    private void assistenteDeInputs(String text, int size) {

        String numUser;
        List<Integer> numeros;
        do {
            System.out.println(text);
            numUser = maquina.nextLine();
            maquina = new Scanner(System.in);


            numeros = new ArrayList<>();

            for (String value : numUser.split(" ")) {
                if (size == 5 && Integer.parseInt(value) > 0 && Integer.parseInt(value) < 51) {
                    numeros.add(Integer.parseInt(value));
                } else if (size == 2 && Integer.parseInt(value) > 0 && Integer.parseInt(value) < 13) {
                    numeros.add(Integer.parseInt(value));
                } else {
                    System.out.println("Numero invalido");

                }
            }


            if (temDuplicados(numeros)) {
                System.out.println("Numero invalido...");
            }
        } while (temDuplicados(numeros) || numeros.size() != size);

        if (size == 5) {
            Collections.sort(numeros);
            this.getChave(apontarParaChave).setChaveNums(numeros);
        } else if (size == 2) {
            Collections.sort(numeros);
            this.getChave(apontarParaChave).setChaveEstrelas(numeros);
        }


    }
}
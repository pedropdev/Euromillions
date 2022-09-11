import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Chave {

    static Random numRand = new Random();


    List<Integer> chaveNums;
    List<Integer> chaveEstrelas;
    int estrelasCorretas;

    public Chave() {
        this.chaveNums = new ArrayList<>();
        this.chaveEstrelas = new ArrayList<>();
        this.estrelasCorretas = 0;
    }


    /**
     * limpa uma chave
     */
    public void limparChave() {
        this.setChaveNums(new ArrayList<>());
        this.setChaveEstrelas(new ArrayList<>());
    }

    /**
     * Realiza um sorteio e imprime uma chave premiada.
     */
    public void chaveAleatoria() {
        //Criação de lista de modo a evitar repetições.
        List<Integer> numbers = new ArrayList<>();
        List<Integer> estrelas = new ArrayList<>();
        int x = 50, y = 12;


        for (int i = 1; i <= x; i++) {
            numbers.add(i);
        }
        for (int i = 1; i <= y; i++) {
            estrelas.add(i);
        }


        //Escolha de números para sorteio.
        for (int i = 0; i < 5; i++) {
            int num = numRand.nextInt(0, x);
            this.chaveNums.add(numbers.get(num));
            numbers.remove(num);
            x -= 1;

        }
        for (int i = 0; i < 2; i++) {
            int num = numRand.nextInt(0, y);
            this.chaveEstrelas.add(estrelas.get(num));
            estrelas.remove(num);
            y -= 1;

        }
        //Organização de números em ordem crescente.
        Collections.sort(this.chaveNums);
        Collections.sort(this.chaveEstrelas);

    }


    public void setChaveNums(List<Integer> chaveNums) {
        this.chaveNums = chaveNums;
    }


    public void setChaveEstrelas(List<Integer> chaveEstrelas) {
        this.chaveEstrelas = chaveEstrelas;
    }

    public int getEstrelasCorretas() {
        return estrelasCorretas;
    }

    public void setEstrelasCorretas(int estrelasCorretas) {
        this.estrelasCorretas = estrelasCorretas;
    }

    @Override
    public String toString() {
        String text = "Numeros: " + chaveNums + "\tEstrelas: " + chaveEstrelas;

        return text;
    }
}

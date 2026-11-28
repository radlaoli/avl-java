public class Main {
    public static void main(String[] args) {
        ArvoreAVL<Integer> arvore = new ArvoreAVL<>();

        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            arvore.inserir(v);
        }

        System.out.println("Percurso em ordem:");
        arvore.exibir();
    }
}

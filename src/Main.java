public class Main {
    public static void main(String[] args) {
        ArvoreAVL<Integer> arvore = new ArvoreAVL<>();

        int[] valores = {50, 30, 70, 20, 40, 60, 80, 40};
        for (int v : valores) {
            if (!arvore.inserir(v)) {
                System.out.println("Já existe um nó com valor " + v);
            }
        }

        System.out.println("Percurso em ordem:");
        arvore.exibir();

        int[] buscas = {40, 99};
        for (int b : buscas) {
            String mensagem = arvore.pesquisar(b)
                    ? "O valor " + b + " existe na árvore"
                    : "O valor " + b + " não existe na árvore";
            System.out.println(mensagem);
        }
    }
}

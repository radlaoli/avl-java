public class ArvoreAVL <T extends Comparable <T>> {
    private No<T> raiz;
    private int tamanho;

    public ArvoreAVL() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public void inserir(T valor) {
        raiz = inserir(raiz, valor);
    }

    private No<T> inserir(No <T> noAtual,T valor){

        if(noAtual == null){
            tamanho++;
            return new No<>(valor);
        }

        int comparacao = valor.compareTo(noAtual.getValor());
        if (comparacao < 0){
            noAtual.setEsquerdo(inserir(noAtual.getEsquerdo(), valor));
        } else if (comparacao > 0) {
            noAtual.setDireito(inserir(noAtual.getDireito(), valor));
        } else{
            System.out.println("Já existe um nó com valor" + valor);
            return noAtual;
        }

        noAtual.atualizarAltura();
        //balancear
        return noAtual;
    }
    

    public void exibir(){
      emOrdem(raiz);
    }

   private void emOrdem(No <T> noAtual){
      if(noAtual != null){
        emOrdem(noAtual.getEsquerdo());
        System.out.println(noAtual.getValor());
        emOrdem(noAtual.getDireito());
      }
    }

  }

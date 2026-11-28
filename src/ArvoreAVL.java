public class ArvoreAVL <T extends Comparable <T>> {
    private No<T> raiz;
    private int tamanho;

    public ArvoreAVL() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public boolean inserir(T valor) {
        int tamanhoAntes = tamanho;
        raiz = inserir(raiz, valor);
        return tamanho > tamanhoAntes;
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
  
    public boolean pesquisar(T valor){
      return ehNo(raiz, valor);
    }

    private boolean ehNo(No <T> noAtual, T valor){
      if (noAtual == null) {
        return false;
      }
    

      int comparacao = valor.compareTo(noAtual.getValor());
      if (comparacao == 0) {
        return true;
      }
      else if(comparacao < 0){
        return ehNo(noAtual.getEsquerdo(), valor); 
      }
      else{
        return ehNo(noAtual.getDireito(),valor);
      }
    }
  }

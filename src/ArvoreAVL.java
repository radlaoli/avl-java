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
        return balancear(noAtual);
    }

    private No<T> rotacaoDireita(No<T> y) {
        No<T> x = y.getEsquerdo();
        No<T> b = x.getDireito();

        x.setDireito(y);
        y.setEsquerdo(b);

        y.atualizarAltura();
        x.atualizarAltura();

        return x;
    }

    private No<T> rotacaoEsquerda(No<T> y){
      No<T> x = y.getDireito();
      No<T> b = x.getEsquerdo();

      x.setEsquerdo(y);
      y.setDireito(b);

      y.atualizarAltura();
      x.atualizarAltura();

      return x;
    }

    
    private No<T> balancear(No<T> no){
      int fb = no.fatorBalanceamento();

      if (fb > 1) {
        if (no.getEsquerdo().fatorBalanceamento() < 0) {
          no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));
        }
        return rotacaoDireita(no);
      }
      else if (fb < -1) {
        if (no.getDireito().fatorBalanceamento() > 0) {
          no.setDireito(rotacaoDireita(no.getDireito()));
        }
        return rotacaoEsquerda(no);
      }
      else {
        return no;
      }
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

    public boolean remover(T valor) {
      int tamanhoAntes = tamanho;
      raiz = remover(raiz, valor);
      return tamanho < tamanhoAntes;
    }

    private No<T> remover(No<T> noAtual, T valor) {
      if (noAtual == null) {
        return null;
      }

      int comparacao = valor.compareTo(noAtual.getValor());
      if (comparacao < 0) {
        noAtual.setEsquerdo(remover(noAtual.getEsquerdo(), valor));
      } else if (comparacao > 0) {
        noAtual.setDireito(remover(noAtual.getDireito(), valor));
      } else {
        if (noAtual.getEsquerdo() == null || noAtual.getDireito() == null) {
          tamanho--;
          noAtual = (noAtual.getEsquerdo() != null) ? noAtual.getEsquerdo() : noAtual.getDireito();
        } else {
          No<T> sucessor = menorNo(noAtual.getDireito());
          noAtual.setValor(sucessor.getValor());
          noAtual.setDireito(remover(noAtual.getDireito(), sucessor.getValor()));
        }
      }

      if (noAtual == null) {
        return null;
      }

      noAtual.atualizarAltura();
      return balancear(noAtual);
    }

    private No<T> menorNo(No<T> no) {
      if (no.getEsquerdo() == null) {
        return no;
      }
      return menorNo(no.getEsquerdo());
    }
  }

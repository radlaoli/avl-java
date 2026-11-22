public class No<T extends Comparable<T>>{
    private T valor;
    private No<T> esquerdo;
    private No<T> direito;
    private int altura = 0;

    public No(T valor){
        this.valor = valor;
    }

    public static <T extends Comparable<T>> int altura(No<T> n) {
        return (n == null) ? -1 : n.altura;
    }

    public void atualizarAltura(){
        int altNo = 1 + Math.max(altura(esquerdo), altura(direito));
        this.altura = altNo;
    }

    public int fatorBalanceamento(){
        return altura(esquerdo) - altura(direito);
    }

    public T getValor() {return valor;}
    public void setValor(T valor) {this.valor = valor;}

    public No<T> getDireito() {return direito;}
    public void setDireito(No<T> direito) {this.direito = direito;}

    public No<T> getEsquerdo() {return esquerdo;}
    public void setEsquerdo(No<T> esquerdo) {this.esquerdo = esquerdo;}
}

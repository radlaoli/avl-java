public class no<T extends Comparable<T>>{
    private T valor;
    private no<T> esquerdo;
    private no<T> direito;
    private int altura = 0;

    public no(T valor){
        this.valor = valor;
    }

    public static <T extends Comparable<T>> int altura(no<T> n) {
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

    public no<T> getDireito() {return direito;}
    public void setDireito(no<T> direito) {this.direito = direito;}

    public no<T> getEsquerdo() {return esquerdo;}
    public void setEsquerdo(no<T> esquerdo) {this.esquerdo = esquerdo;}
}

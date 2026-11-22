public class no<T extends Comparable<T>>{
    private T valor;
    private no<T> esquerdo;
    private no<T> direito;
    private int altura = 0;

    public no(T valor){
        this.valor = valor;
    }

    private static <T extends Comparable<T>> int altura(no<T> n) {
        return (n == null) ? -1 : n.altura;
    }

    public void atualizarAltura(){
        int altNo = 1 + Math.max(altura(esquerdo), altura(direito));
        this.altura = altNo;
    }

    public int fatorBalanceamento(){
        return altura(esquerdo) - altura(direito);
    }
}

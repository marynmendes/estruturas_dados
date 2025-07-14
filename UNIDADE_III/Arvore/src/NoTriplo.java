public class NoTriplo<T> {
    private T dado;
    private NoTriplo<T> pai;
    private NoTriplo<T> direita;
    private NoTriplo<T> esquerda;
    private int altura;

    public NoTriplo(T dado) {
        this.dado = dado;
    }
    
	public NoTriplo() {
		altura = 0;
	}
	
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
    
    public T getDado() {
        return dado;
    }
    public void setDado(T dado) {
        this.dado = dado;
    }
    public NoTriplo<T> getPai() {
        return pai;
    }
    public void setPai(NoTriplo<T> pai) {
        this.pai = pai;
    }
    public NoTriplo<T> getDireita() {
        return direita;
    }
    public void setDireita(NoTriplo<T> direita) {
        this.direita = direita;
    }
    public NoTriplo<T> getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(NoTriplo<T> esquerda) {
        this.esquerda = esquerda;
    }

}

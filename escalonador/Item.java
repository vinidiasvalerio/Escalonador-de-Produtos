package vinicius.escalonador;

public class Item {

	public String nome;
	public int valor;
	public int tempo;

	public Item(String nome, int valor, int tempo) {
		this.nome = nome;
		this.valor = valor;
		this.tempo = tempo;
	}

	// representação de um item
	public String str() {
		return nome + "[valor = " + valor + ", tempo = " + tempo + "]";

	}

}
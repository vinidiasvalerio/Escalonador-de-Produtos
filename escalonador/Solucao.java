package vinicius.escalonador;

import java.util.List;

public class Solucao {

	// lista de itens para transporte com o maior lucro
	public List<Item> itens;

	// máximo valor possível
	public int valor;

	public Solucao(List<Item> itens, int valor) {
		this.itens = itens;
		this.valor = valor;
	}

	public void display() {
		if (itens != null && !itens.isEmpty()) {
			System.out.println("Escalonador de Produtos:");
			System.out.println("Valor Entregue = " + valor);
			System.out.println("Itens escolhidos para entrega: ");

			for (Item item : itens) {
				System.out.println("- " + item.str());
			}
		}
	}

}

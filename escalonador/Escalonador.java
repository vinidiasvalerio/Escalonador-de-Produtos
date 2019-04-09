package vinicius.escalonador;

import java.util.ArrayList;
import java.util.List;

public class Escalonador {
	// itens do problema
	private Item[] itens;
	// horas disponíveis em uma semana
	private int horas;

	public Escalonador(Item[] itens, int horas) {
		this.itens = itens;
		this.horas = horas;
	}

	public void display() {
		if (itens != null && itens.length > 0) {
			System.out
					.println("Problema de Escalonamento de Entrega de Produtos");
			System.out.println("Horas disponíveis por semana: " + horas);
			System.out.println("Itens :");

			for (Item item : itens) {
				System.out.println("- " + item.str());
			}
			System.out
					.println("-----------------------------------------------");
		}
	}

	// algoritmo para resolução do problema
	public Solucao solve() {
		int ITENS = itens.length;
		// matriz para armazenar o valor máximo de cada "enésimo" item
		int[][] matrix = new int[ITENS + 1][horas + 1];

		// primeira linha é inicializada com 0
		for (int i = 0; i <= horas; i++)
			matrix[0][i] = 0;

		// itera sobre os itens
		for (int i = 1; i <= ITENS; i++) {
			// itera sobre as horas, para não extrapolar
			for (int j = 0; j <= horas; j++) {
				if (itens[i - 1].tempo > j)
					matrix[i][j] = matrix[i - 1][j];
				else
					// maximiza o valor no rank da matriz
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j
							- itens[i - 1].tempo]
							+ itens[i - 1].valor);
			}
		}

		int res = matrix[ITENS][horas];
		int h = horas;

		List<Item> itensSolucao = new ArrayList<Item>();

		for (int i = ITENS; i > 0 && res > 0; i--) {
			if (res != matrix[i - 1][h]) {
				itensSolucao.add(itens[i - 1]);

				// remove itens, valor e tempo
				res -= itens[i - 1].valor;
				h -= itens[i - 1].tempo;
			}
		}

		return new Solucao(itensSolucao, matrix[ITENS][horas]);
	}

	public static void main(String[] args) {
		// instâncias dos itens a serem entregues
		Item[] itens = { new Item("Livro", 60, 1), 
						 new Item("Joystick", 95, 2),
						 new Item("Camiseta", 65, 3),
						 new Item("Material Escolar", 125, 4),
						 new Item("Cafeteria", 165, 5), 
						 new Item("Televisão", 170, 6),
						 new Item("Jogo de Panelas", 190, 7),
						 new Item("Impressora", 180, 8) };

		Escalonador escalonador = new Escalonador(itens, 21);
		escalonador.display();
		Solucao solucao = escalonador.solve();
		solucao.display();
	}
}

package ifsc.edu.br.eurotour.model.estruturasdados;

import javax.swing.JOptionPane;

import ifsc.edu.br.eurotour.model.grafo.Vertice;

public class Fila {

	private Nodo inicio;
	private Nodo fim;
	private Nodo aux;
	private Nodo auxElementos;

	public Fila() {
		this.inicio = null;
		this.fim = null;
		this.aux = null;
	}

	public boolean estaVazia() {
		return this.inicio == null;
	}

	public Nodo getInicio() {
		return inicio;
	}

	public void push(Vertice texto) {
		Nodo novoNodo = new Nodo(texto);
		if (estaVazia()) {
			inicio = novoNodo;
			fim = this.inicio;
			// JOptionPane.showMessageDialog(null, "Elemento inserido na fila: " + texto);
		} else {
			aux = fim;
			aux.setProximo(novoNodo);
			fim = novoNodo;
			// JOptionPane.showMessageDialog(null, "Elemento inserido na fila: " + texto);
		}
	}

	public void pop() {
		if (!this.estaVazia()) {
			// JOptionPane.showMessageDialog(null, "Elemento retirado da fila: " +
			// this.inicio.getInfo());
			if (!estaVazia()) {
				inicio = inicio.getProximo();
				// if (inicio != null) {
				// JOptionPane.showMessageDialog(null, "Novo elemento do inicio: " +
				// this.inicio.getInfo());
				// } else {
				// }
			}
		} // else {
			// JOptionPane.showMessageDialog(null, "Fila vazia!");
			// }
	}

	public void mostraFila() {
		if (!this.estaVazia()) {
			auxElementos = this.inicio;
			System.out.println("Elementos da fila: ");
			while (auxElementos != null) {
				System.out.println(auxElementos.getInfo());
				auxElementos = auxElementos.getProximo();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Lista vazia não pode ser mostrada!");
		}
	}

}

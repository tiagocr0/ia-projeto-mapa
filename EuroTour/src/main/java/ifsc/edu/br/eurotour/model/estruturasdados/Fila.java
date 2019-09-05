package ifsc.edu.br.eurotour.model.estruturasdados;

import ifsc.edu.br.eurotour.model.grafo.Vertice;

/**
 * Classe que representa uma Lista Disciplinada - Fila
 * 
 * @author Osmar
 *
 */
public class Fila {

	private Nodo inicio;
	private Nodo fim;
	private Nodo aux;

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

	/**
	 * Insere um Vértice ao fim da Fila
	 * 
	 * @param texto rótulo do Vértice a ser adicionado
	 */
	public void push(Vertice texto) {
		Nodo novoNodo = new Nodo(texto);
		if (estaVazia()) {
			inicio = novoNodo;
			fim = this.inicio;
		} else {
			aux = fim;
			aux.setProximo(novoNodo);
			fim = novoNodo;
		}
	}

	/**
	 * Retira o Vértice do inicio da Fila
	 */
	public void pop() {
		if (!this.estaVazia()) {
			if (!estaVazia()) {
				inicio = inicio.getProximo();
			}
		}
	}

}

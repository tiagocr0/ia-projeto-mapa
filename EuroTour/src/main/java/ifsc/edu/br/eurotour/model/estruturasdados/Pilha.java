package ifsc.edu.br.eurotour.model.estruturasdados;

import ifsc.edu.br.eurotour.model.grafo.Vertice;

/**
 * Classe que representa uma Lista Disciplinada - Pilha
 * 
 * @author Osmar
 *
 */
public class Pilha {

	public Pilha() {
		this.topo = null;
	}

	private Nodo topo;

	public Nodo getTopo() {
		return topo;
	}

	public void setTopo(Nodo topo) {
		this.topo = topo;
	}

	public boolean estaVazia() {
		return this.topo == null;
	}

	/**
	 * Insere um vértice ao topo da pilha
	 * 
	 * @param texto {@link Vertice} a ser inserido a pilha
	 */
	public void push(Vertice texto) {
		Nodo novoNodo = new Nodo(texto);
		novoNodo.setProximo(this.topo);
		this.topo = novoNodo;
	}

	/**
	 * Retira o {@link Vertice} do topo da Pilha e o retorna
	 * 
	 * @return {@link Vertice} que foi retirado
	 */
	public Vertice pop() {
		if (!this.estaVazia()) {
			Vertice aux = this.topo.getInfo();
			this.topo = this.topo.getProximo();
			return aux;
		} else {
			return null;
		}
	}

}

package ifsc.edu.br.eurotour.pilha;

import ifsc.edu.br.eurotour.grafo.Vertice;

public class Pilha {

	private Nodo topo;

	public Nodo getTopo() {
		return topo;
	}

	public void setTopo(Nodo topo) {
		this.topo = topo;
	}

	public Pilha() {
		this.topo = null;
	}

	public boolean estaVazia() {
		return this.topo == null;
	}

	public void push(Vertice texto) {
		Nodo novoNodo = new Nodo(texto);
		novoNodo.setProximo(this.topo);
		this.topo = novoNodo;
	}

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

package ifsc.edu.br.eurotour.model.pilha;

import ifsc.edu.br.eurotour.model.grafo.Vertice;

public class Nodo {

	private Vertice info;
	private Nodo proximo;

	public Nodo(Vertice x) {
		this.info = x;
		this.proximo = null;
	}

	public Vertice getInfo() {
		return info;
	}

	public void setInfo(Vertice x) {
		this.info = x;
	}

	public Nodo getProximo() {
		return proximo;
	}

	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		return "Nodo [info: " + this.info + "]";
	}

}

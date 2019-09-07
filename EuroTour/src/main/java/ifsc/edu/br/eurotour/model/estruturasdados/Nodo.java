package ifsc.edu.br.eurotour.model.estruturasdados;

import ifsc.edu.br.eurotour.model.grafo.Vertice;

/**
 * Classe que representa um Nodo, no qual é um {@link Vertice}
 * 
 * @author Osmar
 *
 */
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

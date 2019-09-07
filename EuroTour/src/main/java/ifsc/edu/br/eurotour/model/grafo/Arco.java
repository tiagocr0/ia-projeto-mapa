/*
    Arquivo versão 4.0
    Contempla o uso de buscas, árvores geradoras mínimas, caminho mínimo e fluxo máximo.
*/

package ifsc.edu.br.eurotour.model.grafo;

public class Arco implements Comparable<Arco> {

	private Vertice destino;
	private Vertice origem;
	private double peso;

	public Arco(Vertice origem, Vertice destino, double peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}

	public Vertice getOrigem() {
		return origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return this.destino.toString() + "," + this.peso;
	}

	@Override
	public int compareTo(Arco t) {
		if (this.peso < t.getPeso()) {
			return -1;
		}
		if (this.peso > t.getPeso()) {
			return 1;
		}
		return 0;
	}

}

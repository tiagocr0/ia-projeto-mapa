/*
    Arquivo versão 4.0
    Contempla o uso de buscas, árvores geradoras mínimas, caminho mínimo e fluxo máximo.
*/

package ifsc.edu.br.eurotour.model.grafo;

import java.util.ArrayList;

/**
 * Classe para abstrair grafos direcionados. A classe utiliza representação por
 * lista de adjacência. IFSC - Lages Prof. Vilson Heck Junior
 */
public class Grafo {

	private final ArrayList<Vertice> vertices = new ArrayList<>();

	public Grafo() {

	}

	public void adicionarVertice(String rotulo) {
		Vertice novo = new Vertice(rotulo);
		vertices.add(novo);
	}

	public ArrayList<Vertice> obterVertices() {
		return this.vertices;
	}

	public Vertice pesquisaVertice(String rotulo) {
		int indice = vertices.indexOf(new Vertice(rotulo));
		return (indice >= 0) ? vertices.get(indice) : null;
	}

	public ArrayList<Arco> obterTodosOsArcos() {
		ArrayList<Arco> resultado = new ArrayList<>();
		for (Vertice vertice : vertices) {
			resultado.addAll(vertice.obterArcos());
		}
		return resultado;
	}
}
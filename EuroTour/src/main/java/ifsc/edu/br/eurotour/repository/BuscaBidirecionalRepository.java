package ifsc.edu.br.eurotour.repository;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;

public interface BuscaBidirecionalRepository {

	public Caminho buscaBidirecional(Grafo g, Vertice inicial, Vertice destino);
}

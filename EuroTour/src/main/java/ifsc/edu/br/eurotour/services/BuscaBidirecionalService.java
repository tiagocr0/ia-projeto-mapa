package ifsc.edu.br.eurotour.services;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaBidirecionalRepository;
import ifsc.edu.br.eurotour.util.BuscaBidirecional;

public class BuscaBidirecionalService {

	public BuscaBidirecionalRepository rep;

	public BuscaBidirecionalService() {
		rep = new BuscaBidirecional();
	}

	public Caminho buscaBidirecional(Grafo g, Vertice inicial, Vertice destino) {
		return rep.buscaBidirecional(g, inicial, destino);
	}
}

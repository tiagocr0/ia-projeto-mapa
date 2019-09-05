package ifsc.edu.br.eurotour.services;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaCustoUniformeRepository;
import ifsc.edu.br.eurotour.util.BuscaDeCustoUniforme;

public class BuscaCustoUniformeService {

	public BuscaCustoUniformeRepository rep;

	public BuscaCustoUniformeService() {
		rep = new BuscaDeCustoUniforme();
	}

	public Caminho buscaCustoUniforme(Grafo g, Vertice inicial, Vertice destino) {
		return rep.buscaCustoUniforme(g, inicial, destino);
	}
}

package ifsc.edu.br.eurotour.services;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaProfundidadeRepository;
import ifsc.edu.br.eurotour.util.BuscaProfundidade;

public class BuscaProfundidadeService {
	public BuscaProfundidadeRepository rep;

	public BuscaProfundidadeService() {
		rep = new BuscaProfundidade();
	}

	public Caminho buscaProfundidade(Grafo g, Vertice inicial, Vertice destino) {
		return rep.buscaProfundidade(g, inicial, destino);
	}

}

package ifsc.edu.br.eurotour.services;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaAEstrelaRepository;
import ifsc.edu.br.eurotour.util.BuscaAEstrela;

public class BuscaAEstrelaService {
	BuscaAEstrelaRepository rep;

	public BuscaAEstrelaService() {
		rep = new BuscaAEstrela();
	}

	public Caminho buscaAEstrela(Grafo g, Vertice inicial, Vertice destino) {
		return rep.buscaAEstrela(g, inicial, destino);
	}
}

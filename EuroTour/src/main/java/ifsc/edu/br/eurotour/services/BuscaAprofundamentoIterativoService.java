package ifsc.edu.br.eurotour.services;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaAprofundamentoIterativoRepository;
import ifsc.edu.br.eurotour.util.BuscaAprofundamentoIterativo;

public class BuscaAprofundamentoIterativoService {

	private BuscaAprofundamentoIterativoRepository rep;

	public BuscaAprofundamentoIterativoService() {
		rep = new BuscaAprofundamentoIterativo();
	}

	public Caminho buscaAprofundamentoIterativo(Grafo g, Vertice inicial, Vertice destino) {
		return rep.buscaAprofundamentoIterativo(g, inicial, destino);
	}

}

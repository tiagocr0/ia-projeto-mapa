package ifsc.edu.br.eurotour.services;

import java.util.ArrayList;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.repository.BuscaAprofundamentoIterativoRepository;

public class BuscaAprofundamentoIterativoService {

	private BuscaAprofundamentoIterativoRepository rep;
	
	public ArrayList<Vertice> buscaAprofundamentoIterativo(Grafo g, Vertice inicial, Vertice destino){
		return rep.buscaAprofundamentoIterativo(g, inicial, destino);
	}
	
}

package ifsc.edu.br.eurotour.repository;

import java.util.ArrayList;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;

public interface BuscaAprofundamentoIterativoRepository {

	public ArrayList<Vertice> buscaAprofundamentoIterativo(Grafo g, Vertice inicial, Vertice destino);

}

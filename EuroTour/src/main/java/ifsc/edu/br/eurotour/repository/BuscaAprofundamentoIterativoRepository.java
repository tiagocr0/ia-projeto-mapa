package ifsc.edu.br.eurotour.repository;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;

public interface BuscaAprofundamentoIterativoRepository {

	public Caminho buscaAprofundamentoIterativo(Grafo g, Vertice inicial, Vertice destino);

}

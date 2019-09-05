package ifsc.edu.br.eurotour.repository;

import java.net.URISyntaxException;

import ifsc.edu.br.eurotour.model.grafo.Grafo;

public interface DataRoutesRepository {

	public Grafo pegarArquivo() throws URISyntaxException;
}

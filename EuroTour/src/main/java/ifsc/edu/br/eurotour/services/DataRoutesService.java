package ifsc.edu.br.eurotour.services;

import java.net.URISyntaxException;

import ifsc.edu.br.eurotour.dataaccess.DataRoutesDataAccess;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.repository.DataRoutesRepository;

public class DataRoutesService {

	private DataRoutesRepository rep;
	
	public DataRoutesService() {
		rep = new DataRoutesDataAccess();
	}

	public Grafo pegarArquivo() throws URISyntaxException {
		return rep.pegarArquivo();
	}

}

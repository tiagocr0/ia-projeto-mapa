package ifsc.edu.br.eurotour.dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.repository.DataRoutesRepository;

public class DataRoutesDataAccess implements DataRoutesRepository {

	static Grafo grafo = new Grafo();

	@Override
	public Grafo pegarArquivo() {
		try {
			FileInputStream arquivo = new FileInputStream(new File(acessarArquivo()));
			grafo.lerArquivoExcel(arquivo);
			return grafo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public URI acessarArquivo() throws URISyntaxException {
		URL caminhoArquivo = getClass().getResource("../datasource/Planilha de Países-Capitais Ordenada.xlsx");
		return caminhoArquivo.toURI();
	}

}

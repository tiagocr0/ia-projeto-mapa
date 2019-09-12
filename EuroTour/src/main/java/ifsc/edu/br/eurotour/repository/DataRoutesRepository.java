package ifsc.edu.br.eurotour.repository;

import java.net.URISyntaxException;

import ifsc.edu.br.eurotour.dataaccess.DataRoutesDataAccess;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.services.DataRoutesService;

/**
 * Camada de acesso a dados da {@link DataRoutesDataAccess}<br>
 * Provê funções a camada de serviço: {@link DataRoutesService}
 * 
 * @author Osmar
 *
 */
public interface DataRoutesRepository {

	/**
	 * Acessa e lê o arquivo (neste caso, um Excel) para obter os dados e gerar um
	 * {@link Grafo}
	 * 
	 * @return {@link Grafo} baseado na planilha Excel
	 * @throws URISyntaxException caso não encontre o caminho correto do arquivo
	 */
	public Grafo pegarArquivo() throws URISyntaxException;
}

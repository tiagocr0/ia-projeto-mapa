package ifsc.edu.br.eurotour.resources;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.model.mapeamento.Front;
import ifsc.edu.br.eurotour.services.BuscaAEstrelaService;
import ifsc.edu.br.eurotour.services.BuscaAprofundamentoIterativoService;
import ifsc.edu.br.eurotour.services.BuscaBidirecionalService;
import ifsc.edu.br.eurotour.services.BuscaCustoUniformeService;
import ifsc.edu.br.eurotour.services.BuscaProfundidadeService;
import ifsc.edu.br.eurotour.services.DataRoutesService;

/**
 * Camada que provê funções para comunicação com o front-end que é chamado
 * através da requisição http://localhost:8081/busca
 * 
 * @author Tiago
 *
 */

@RestController
@RequestMapping(value = "/busca")
public class DataRoutesResource {

	private BuscaAprofundamentoIterativoService aprofundamentoIterativo = new BuscaAprofundamentoIterativoService();
	private BuscaBidirecionalService bidirecional = new BuscaBidirecionalService();
	private BuscaCustoUniformeService custoUniforme = new BuscaCustoUniformeService();
	private BuscaProfundidadeService profundidade = new BuscaProfundidadeService();
	private BuscaAEstrelaService aEstrela = new BuscaAEstrelaService();
	private Caminho caminho;

	private Grafo grafo = new Grafo();

	private DataRoutesService dataRoutes;

	/**
	 * Realiza a leitura do arquivo Planilha de Países-Capitais Ordenada.xlsx e
	 * chama método {@link DataRoutesService#pegarArquivo} para pegar o arquivo
	 * 
	 * @return {@link Grafo} que contém os {@link Vertice}s e os {@link Arco}s
	 * @throws Exceção no caso de erro de leitura do arquivo
	 */

	public DataRoutesResource() {
		dataRoutes = new DataRoutesService();
		try {
			grafo = dataRoutes.pegarArquivo();
		} catch (URISyntaxException e) {
			System.err.print("Erro ao tentar ler o arquivo");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Realiza a comunicação com o front-end recebendo como parâmetro um objeto no
	 * formato {@link Front} e realizando o tratamento de qual busca será realizada
	 * 
	 * @param front {@link Front} que é o formato que será mandado pelo front
	 * @return {@link Caminho} que contém o caminho que deve ser percorrido para
	 *         chegar de {@link Vertice} origem até um {@link Vertice} destino
	 * @throws Exceção no caso de algoritmo inválido
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Caminho> busca(@Valid @RequestBody Front front) {

		int algoritmo = front.getFront().getAlgoritmo();
		Vertice origem = grafo.pesquisaVertice(front.getFront().getOrigem());
		Vertice destino = grafo.pesquisaVertice(front.getFront().getDestino());

		switch (algoritmo) {
		case 0:
			// Realiza a busca de buscaProfundidade
			caminho = profundidade.buscaProfundidade(grafo, origem, destino);
			return new ResponseEntity<Caminho>(caminho, HttpStatus.OK);
		case 1:
			// Realiza a busca de Aprofundamento Iterativo
			caminho = aprofundamentoIterativo.buscaAprofundamentoIterativo(grafo, origem, destino);
			return new ResponseEntity<Caminho>(caminho, HttpStatus.OK);
		case 2:
			// Realiza a busca de Bidirecional
			caminho = bidirecional.buscaBidirecional(grafo, origem, destino);
			return new ResponseEntity<Caminho>(caminho, HttpStatus.OK);
		case 3:
			// Realiza a busca de Custo Uniforme
			caminho = custoUniforme.buscaCustoUniforme(grafo, origem, destino);
			return new ResponseEntity<Caminho>(caminho, HttpStatus.OK);
		case 4:
			// Realiza a busca de A*
			caminho = aEstrela.buscaAEstrela(grafo, origem, destino);
			return new ResponseEntity<Caminho>(caminho, HttpStatus.OK);
		default:
			System.out.println("Algoritmo incorreto");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}

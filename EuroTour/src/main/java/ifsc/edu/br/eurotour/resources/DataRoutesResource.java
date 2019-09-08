package ifsc.edu.br.eurotour.resources;

import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.model.mapeamento.Front;
import ifsc.edu.br.eurotour.services.BuscaAprofundamentoIterativoService;
import ifsc.edu.br.eurotour.services.BuscaBidirecionalService;
import ifsc.edu.br.eurotour.services.BuscaCustoUniformeService;
import ifsc.edu.br.eurotour.services.BuscaProfundidadeService;
import ifsc.edu.br.eurotour.services.DataRoutesService;

@RestController
@RequestMapping(value = "/busca")
public class DataRoutesResource {

	private BuscaAprofundamentoIterativoService aprofundamentoIterativo = new BuscaAprofundamentoIterativoService();
	private BuscaBidirecionalService bidirecional = new BuscaBidirecionalService();
	private BuscaCustoUniformeService custoUniforme = new BuscaCustoUniformeService();
	private BuscaProfundidadeService profundidade = new BuscaProfundidadeService();
	private Caminho caminho;

	private Grafo grafo = new Grafo();

	private DataRoutesService dataRoutes;

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

	/*
	 * Método que recebe um objeto Front como parâmetro e irá retornar o caminho
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Caminho> busca(@Valid @RequestBody Front front) {

		int algoritmo = front.getFront().getAlgoritmo();
		Vertice origem = grafo.pesquisaVertice(front.getFront().getOrigem());
		Vertice destino = grafo.pesquisaVertice(front.getFront().getDestino());

		switch (algoritmo) {
		case 0:
			// Realiza a busca de Profundidade
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
			// Implementação
			break;
		default:
			System.out.println("Algoritmo incorreto");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}

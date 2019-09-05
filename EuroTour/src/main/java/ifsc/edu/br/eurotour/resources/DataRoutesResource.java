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
import ifsc.edu.br.eurotour.services.DataRoutesService;
import ifsc.edu.br.eurotour.util.BuscaAprofundamentoIterativo;
import ifsc.edu.br.eurotour.util.BuscaBidirecional;
import ifsc.edu.br.eurotour.util.BuscaDeCustoUniforme;
import ifsc.edu.br.eurotour.util.BuscaProfundidade;

@RestController
@RequestMapping(value = "/busca")
public class DataRoutesResource {

	private BuscaAprofundamentoIterativo aprofundamentoIterativo = new BuscaAprofundamentoIterativo();
	private BuscaBidirecional bidirecional = new BuscaBidirecional();
	private BuscaDeCustoUniforme custoUniforme = new BuscaDeCustoUniforme();
	private BuscaProfundidade profundidade = new BuscaProfundidade();
	private Caminho caminho;

	private Grafo grafo = new Grafo();

	private DataRoutesService dataRoutes;

	/*
	 * Método que recebe um objeto Front como parâmetro e irá retornar o caminho
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Caminho> busca(@Valid @RequestBody Front front) {
		grafo = lerArquivo();
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
			// Implementação
			break;
		case 3:
			// Realiza a busca de Custo Uniforme
			caminho = custoUniforme.calcular(grafo, origem, destino);
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

	public Grafo lerArquivo() {
		dataRoutes = new DataRoutesService();
		Grafo g;
		try {
			g = dataRoutes.pegarArquivo();
			return g;
		} catch (URISyntaxException e) {
			System.out.println("Erro ao ler o arquivo");
			e.printStackTrace();
			return null;
		}
	}

}

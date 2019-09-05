package ifsc.edu.br.eurotour.resources;

import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.RestController;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.services.BuscaAprofundamentoIterativoService;
import ifsc.edu.br.eurotour.services.DataRoutesService;

@RestController
public class DataRoutesResource {

	private BuscaAprofundamentoIterativoService buscaIterativa;

	private DataRoutesService dataRoutes;

	/*
	 * @RequestMapping(value = "/busca", method = RequestMethod.GET) public
	 * ResponseEntity<String> buscaIterativa() throws URISyntaxException {
	 * 
	 * Vertice vi = g.pesquisaVertice("Espanha – Madrid"); Vertice vd =
	 * g.pesquisaVertice("Polônia – Varsóvia"); ArrayList<Vertice> caminho =
	 * buscaIterativa.buscaAprofundamentoIterativo(g, vi, vd); return new
	 * ResponseEntity<String>(caminho.toString(), HttpStatus.OK); }
	 */

	/*
	 * @RequestMapping(value = "/teste", method = RequestMethod.GET) public
	 * ResponseEntity<?> lista() { String msg = "Teste"; return new
	 * ResponseEntity<String>(msg, HttpStatus.OK); }
	 */

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

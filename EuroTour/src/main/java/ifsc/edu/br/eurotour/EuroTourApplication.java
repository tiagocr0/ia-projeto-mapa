package ifsc.edu.br.eurotour;

import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.services.BuscaAEstrelaService;
import ifsc.edu.br.eurotour.services.DataRoutesService;

@SpringBootApplication
public class EuroTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuroTourApplication.class, args);

		BuscaAEstrelaService service = new BuscaAEstrelaService();
		DataRoutesService tabela = new DataRoutesService();
		Grafo g = null;
		try {
			g = tabela.pegarArquivo();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Vertice inicial = g.pesquisaVertice("Albânia – Tirana");
		Vertice destino = g.pesquisaVertice("Grécia – Atenas");

		Caminho caminho = service.buscaAEstrela(g, inicial, destino);

		System.out.println(caminho.toString());

	}

}

package ifsc.edu.br.eurotour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EuroTourApplication {

	// static Grafo grafo = new Grafo();

	public static void main(String[] args) {
		SpringApplication.run(EuroTourApplication.class, args);

		/*
		 * DataRoutesService service = new DataRoutesService(); Grafo g = null; try { g
		 * = service.pegarArquivo(); } catch (URISyntaxException e) {
		 * System.out.println("erro ao pegar arquivo"); e.printStackTrace(); }
		 * 
		 * BuscaProfundidadeService alg_service = new BuscaProfundidadeService();
		 * 
		 * Vertice vi = g.pesquisaVertice("Espanha – Madrid"); Vertice vd =
		 * g.pesquisaVertice("Polônia – Varsóvia");
		 * 
		 * Caminho caminho_destino = alg_service.buscaProfundidade(g, vi, vd);
		 * 
		 * System.out.println(caminho_destino.toString());
		 */

	}

}

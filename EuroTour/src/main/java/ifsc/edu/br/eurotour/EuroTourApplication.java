package ifsc.edu.br.eurotour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EuroTourApplication {

	// static Grafo grafo = new Grafo();

	public static void main(String[] args) {
		SpringApplication.run(EuroTourApplication.class, args);
		/*
		 * BuscaAprofundamentoIterativo b = new BuscaAprofundamentoIterativo();
		 * DataRoutesResource dt = new DataRoutesResource();
		 * 
		 * grafo = dt.lerArquivo();
		 * 
		 * Vertice vi = grafo.pesquisaVertice("Espanha – Madrid"); Vertice vd =
		 * grafo.pesquisaVertice("Polônia – Varsóvia");
		 * 
		 * Caminho caminho_destino = b.buscaAprofundamentoIterativo(grafo, vi, vd);
		 * 
		 * System.out.println(caminho_destino.toString());
		 */

	}

}

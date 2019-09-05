package ifsc.edu.br.eurotour;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.util.BuscaAprofundamentoIterativo;

@SpringBootApplication
public class EuroTourApplication {

	static Grafo grafo = new Grafo();

	public static void main(String[] args) {
		SpringApplication.run(EuroTourApplication.class, args);
		EuroTourApplication eu = new EuroTourApplication();
		BuscaAprofundamentoIterativo b = new BuscaAprofundamentoIterativo();

		try {
			FileInputStream arquivo = new FileInputStream(new File(eu.pegarArquivo()));
			grafo.lerArquivoExcel(arquivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Vertice vi = grafo.pesquisaVertice("Espanha – Madrid");
		Vertice vd = grafo.pesquisaVertice("Polônia – Varsóvia");

		Caminho caminho_destino = b.buscaAprofundamentoIterativo(grafo, vi, vd);

		System.out.println(caminho_destino.toString());

	}

	public URI pegarArquivo() throws URISyntaxException {
		URL caminhoArquivo = getClass().getResource("datasource/Planilha de Países-Capitais Ordenada.xlsx");
		return caminhoArquivo.toURI();
	}

}

package ifsc.edu.br.eurotour;

import java.io.FileInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifsc.edu.br.eurotour.model.grafo.Grafo;

@SpringBootApplication
public class EuroTourApplication {

	static Grafo grafo = new Grafo();

	public static void main(String[] args) {
		SpringApplication.run(EuroTourApplication.class, args);
		EuroTourApplication eu = new EuroTourApplication();

		try {
			FileInputStream arquivo = new FileInputStream(new File(eu.pegarArquivo()));
			grafo.lerArquivoExcel(arquivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public URI pegarArquivo() throws URISyntaxException {
		URL caminhoArquivo = getClass().getResource("datasource/Planilha de Países-Capitais Ordenada.xlsx");
		return caminhoArquivo.toURI();
	}

}

package ifsc.edu.br.eurotour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EuroTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuroTourApplication.class, args);

//		DataRoutesService drservice = new DataRoutesService();
//		Grafo g = new Grafo();
//		try {
//			g = drservice.pegarArquivo();
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//		Vertice inicial = g.pesquisaVertice("Grécia – Atenas");
//		Vertice destino = g.pesquisaVertice("Noruega – Oslo");
//
//		Caminho caminho;
//
//		BuscaAprofundamentoIterativoService iterativo = new BuscaAprofundamentoIterativoService();
//		caminho = iterativo.buscaAprofundamentoIterativo(g, inicial, destino);
//		System.out.println("Iterativo:\n" + caminho.toString());
//
//		BuscaBidirecionalService bidirecional = new BuscaBidirecionalService();
//		caminho = bidirecional.buscaBidirecional(g, inicial, destino);
//		System.out.println("Bidirecional:\n" + caminho.toString());
//
//		BuscaAEstrelaService aestrela = new BuscaAEstrelaService();
//		caminho = aestrela.buscaAEstrela(g, inicial, destino);
//		System.out.println("A Estrela:\n" + caminho.toString());
//
//		BuscaCustoUniformeService uniforme = new BuscaCustoUniformeService();
//		caminho = uniforme.buscaCustoUniforme(g, inicial, destino);
//		System.out.println("Uniforme:\n" + caminho.toString());
//
//		BuscaProfundidadeService profundidade = new BuscaProfundidadeService();
//		caminho = profundidade.buscaProfundidade(g, inicial, destino);
//		System.out.println("Profundidade:\n" + caminho.toString());
//Favor não adicionar System.exit(), pois o pessoal do front foi desenvovler a parte deles e
//não sabia onde estava o problema pois não retornava nada pelo postman já que o programa foi encerrado!!!! 
// TODO	Se forem testar usem o postman ou comenatar as linhas que podem fazer a aplicação parar.
//		System.exit(0);
	}
}

package ifsc.edu.br.eurotour.util;

import java.util.ArrayList;
import java.util.List;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaCustoUniformeRepository;

/**
 * Nesta classe devem ser implementados todos os métodos de grafos de forma
 * estática
 *
 * @author vilson.junior Criando os métodos de busca
 * @author wilson.junior
 */
public class BuscaDeCustoUniforme implements BuscaCustoUniformeRepository {

	@Override
	public Caminho buscaCustoUniforme(Grafo g, Vertice inicial, Vertice destino) {
		List<Vertice> lVerticesAbertos = new ArrayList<>();
		reiniciarGrafo(g);
		inicial.definirDistancia(0);
		lVerticesAbertos.add(inicial);
		double lMenorDistancia = 0.0;
		Vertice lVerticeOrigem = new Vertice();

		lVerticesAbertos.addAll(g.obterVertices());
		while (lVerticesAbertos.size() > 0) {
			lMenorDistancia = lVerticesAbertos.get(0).obterDistancia();
			int indice = 0;
			for (Vertice v : lVerticesAbertos) {
				if (v.obterDistancia() < lMenorDistancia) {
					lMenorDistancia = v.obterDistancia();
					indice = lVerticesAbertos.indexOf(v);
				}
			}

			lVerticeOrigem = lVerticesAbertos.remove(indice);

			if (!lVerticeOrigem.equals(destino)) {
				for (Arco lArco : lVerticeOrigem.obterArcos()) {
					Vertice lVerticeDestino = lArco.getDestino();
					double lDistanciaPorPeso = lArco.getPeso();
					if (lVerticeDestino.obterDistancia() > lVerticeOrigem.obterDistancia() + lDistanciaPorPeso) {
						lVerticeDestino.definirDistancia(lDistanciaPorPeso + lVerticeOrigem.obterDistancia());
						lVerticeDestino.setCaminho(lVerticeOrigem.getCaminho());
					}
				}
			} else {
				return Caminho.converter(g, destino, lVerticeOrigem.obterDistancia());
			}
		}
		return Caminho.converter(g, destino, lVerticeOrigem.obterDistancia());
	}

	private static void reiniciarGrafo(Grafo aGrafo) {
		for (Vertice lVertice : aGrafo.obterVertices()) {
			lVertice.zerarVisitas();
			lVertice.zerarDistancia();
			lVertice.setCaminho("");
		}
	}
}

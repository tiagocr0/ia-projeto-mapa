package ifsc.edu.br.eurotour.util;

import java.util.ArrayList;
import java.util.List;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;

/**
 * Nesta classe devem ser implementados todos os métodos de grafos de forma
 * estática
 *
 * @author vilson.junior Criando os métodos de busca
 * @author wilson.junior
 */
public class BuscaDeCustoUniforme {

	public static List<Vertice> calcular(Grafo aGrafo, Vertice aInicial, Vertice aFinal) {
		List<Vertice> lVerticesAbertos = new ArrayList<>();
		List<Vertice> lVerticesExpandidos = new ArrayList<>();
		reiniciarGrafo(aGrafo);
		aInicial.definirDistancia(0);
		lVerticesAbertos.add(aInicial);
		double lMenorDistancia = 0.0;
		Vertice lVerticeOrigem;

		lVerticesAbertos.addAll(aGrafo.obterVertices());
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
			lVerticesExpandidos.add(lVerticeOrigem);

			if (!lVerticeOrigem.equals(aFinal)) {
				for (Arco lArco : lVerticeOrigem.obterArcos()) {
					Vertice lVerticeDestino = lArco.getDestino();
					double lDistanciaPorPeso = lArco.getPeso();
					if (lVerticeDestino.obterDistancia() > lVerticeOrigem.obterDistancia() + lDistanciaPorPeso) {
						lVerticeDestino.definirDistancia(lDistanciaPorPeso + lVerticeOrigem.obterDistancia());
						lVerticeDestino.setCaminho(lVerticeOrigem.getCaminho());
					}
				}
			} else {
				return lVerticesExpandidos;
			}
		}
		return lVerticesExpandidos;
	}

	private static void reiniciarGrafo(Grafo aGrafo) {
		for (Vertice lVertice : aGrafo.obterVertices()) {
			lVertice.zerarVisitas();
			lVertice.zerarDistancia();
			lVertice.setCaminho("");
		}
	}
}

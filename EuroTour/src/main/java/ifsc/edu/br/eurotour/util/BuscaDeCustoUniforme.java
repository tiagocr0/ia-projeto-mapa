package ifsc.edu.br.eurotour.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Caminho;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.model.mapeamento.DistanciaEntre2Paises;
import ifsc.edu.br.eurotour.model.mapeamento.Pais;

/**
 * Nesta classe devem ser implementados todos os métodos de grafos de forma
 * estática
 *
 * @author vilson.junior Criando os métodos de busca
 * @author wilson.junior
 */
public class BuscaDeCustoUniforme {

	public static final int MENOR_DISTANCIA = 0;

	public static List<Vertice> custoUniforme(Grafo aGrafo, Vertice aInicial, Vertice aFinal) {
		List<Vertice> lVerticesAbertos = new ArrayList<>();
		List<Vertice> lVerticesExpandidos = new ArrayList<>();
		reiniciarGrafo(aGrafo);
		aInicial.definirDistancia(0);
		aInicial.visitar();
		lVerticesAbertos.add(aInicial);
		double lMenorDistancia = 0;
		Caminho lCaminho;
		Caminho lCaminho2;
		while (lVerticesAbertos.size() > 0) {
			Vertice lVerticeOrigem = lVerticesAbertos.get(MENOR_DISTANCIA);
			for (Arco lArco : lVerticeOrigem.obterArcos()) {
				Vertice lVerticeDestino = lArco.getDestino();
				Double lDistanciaPorPeso = lArco.getPeso();
				if (lVerticeDestino.obterVisitado() == 0) {
					lVerticeDestino.visitar();
					lVerticeDestino.setCaminho(lVerticeOrigem.getCaminho());
					lVerticeDestino.definirDistancia(lVerticeOrigem.obterDistancia() + lDistanciaPorPeso);
					lVerticesAbertos.add(lArco.getDestino());
				}

				if (lVerticeDestino.equals(aFinal)) {
					lMenorDistancia = lVerticeOrigem.obterDistancia() + lDistanciaPorPeso;
				}
			}
			lVerticesAbertos.remove(lVerticeOrigem);
			lVerticesExpandidos.add(lVerticeOrigem);
			ordernar(lVerticesAbertos);
			if (lVerticeOrigem.equals(aFinal)) {
				lCaminho2 = Caminho.converter(aGrafo, aFinal, lMenorDistancia);
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

	// Ordena a lista de arcos em onderm crecsente
	private static void ordernar(List<Vertice> aArcos) {
		Collections.sort(aArcos, new CustomComparatorVertice());
	}

	// Ordenação dos arcos por distancia.
	private static class CustomComparatorVertice implements Comparator<Vertice> {

		@Override
		public int compare(Vertice aVertice, Vertice aVertice2) {
			Double peso1 = aVertice.obterDistancia();
			Double peso2 = aVertice2.obterDistancia();
			return peso1.compareTo(peso2);
		}

	}
}

package ifsc.edu.br.eurotour.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Caminho;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;

/**
 * Nesta classe devem ser implementados todos os métodos de grafos de forma
 * estática
 *
 * @author vilson.junior Criando os métodos de busca
 * @author wilson.junior
 */
public class CustoUniforme {

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
				lCaminho = montarCaminho(aGrafo, aFinal, lMenorDistancia);
				return lVerticesExpandidos;
			}
		}
		return lVerticesExpandidos;
	}

	private static Caminho montarCaminho(Grafo aGrafo, Vertice aFinal, Double lDistanciaMinima) {
		String[] lNomes = aFinal.getCaminho().split("/");
		Caminho lCaminho = new Caminho(lDistanciaMinima);
		for (int indice = 0; indice < lNomes.length; indice++) {
			if ((indice + 1) != lNomes.length) {
				Vertice lOrigem = aGrafo.pesquisaVertice(lNomes[indice].trim());
				Vertice lVerticeDestino = aGrafo.pesquisaVertice(lNomes[indice + 1].trim());
				lCaminho.getCaminho().add(new Arco(lOrigem, lVerticeDestino, lVerticeDestino.obterDistancia()));
			}
		}
		return lCaminho;
	}

	private static void reiniciarGrafo(Grafo aGrafo) {
		for (Vertice lVertice : aGrafo.obterVertices()) {
			lVertice.zerarVisitas();
			lVertice.zerarDistancia();
			lVertice.setCaminho("");
		}
	}

	public static List<String> saidaFormatada(Grafo aGrafo) {
		List<String> listFormatadas = new ArrayList<>();
		for (Vertice lVertice : aGrafo.obterVertices()) {
			// listFormatadas.add(lVertice.obterInformacoes());
		}
		return listFormatadas;
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

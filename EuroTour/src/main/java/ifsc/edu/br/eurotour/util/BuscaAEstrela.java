package ifsc.edu.br.eurotour.util;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaAEstrelaRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuscaAEstrela implements BuscaAEstrelaRepository {

	public static final int MENOR_DISTANCIA = 0;

	private static Vertice final_;

	public Caminho buscaAEstrela(Grafo aGrafo, Vertice aInicial, Vertice aFinal) {
		final_ = aFinal;
		List<Vertice> lVerticesAbertos = new ArrayList<>();
		List<Vertice> lVerticesExpandidos = new ArrayList<>();
		Grafo.reiniciarGrafo(aGrafo);
		aInicial.definirDistancia(0);
		aInicial.visitar();
		lVerticesAbertos.add(aInicial);
		
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
				} else if (lVerticeDestino.obterDistancia() > (lVerticeDestino.obterDistanciaHeuristica(lVerticeOrigem)
						+ lVerticeOrigem.obterDistancia())) {
					lVerticeDestino.setCaminho(lVerticeOrigem.getCaminho());
					lVerticeDestino.definirDistancia(lVerticeOrigem.obterDistancia() + lDistanciaPorPeso);
					lVerticesAbertos.add(lArco.getDestino());
				}

			}
			lVerticesAbertos.remove(lVerticeOrigem);
			lVerticesExpandidos.add(lVerticeOrigem);
			ordernar(lVerticesAbertos);
			if (lVerticeOrigem.equals(aFinal)) {
				return Caminho.converter(aGrafo, aFinal, lVerticeOrigem.obterDistancia());
			}
		}
		return Caminho.converter(aGrafo, aFinal, aFinal.obterDistancia());
	}

	// Ordena a lista de arcos em ordem crescente
	private static void ordernar(List<Vertice> aArcos) {
		Collections.sort(aArcos, new CustomComparatorVertice());
	}

	// Ordenação dos arcos por distancia + distancia heuristica.
	private static class CustomComparatorVertice implements Comparator<Vertice> {

		@Override
		public int compare(Vertice aVertice, Vertice aVertice2) {
			Double peso1 = aVertice.obterDistancia() + aVertice.obterDistanciaHeuristica(final_);
			Double peso2 = aVertice2.obterDistancia() + aVertice2.obterDistanciaHeuristica(final_);
			return peso1.compareTo(peso2);
		}

	}

}

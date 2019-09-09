package ifsc.edu.br.eurotour.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	
	
	public static final int VERTICE_COM_MENOR_DISTANCIA = 0;
    
	private List<Vertice> lVerticesAbertos = new ArrayList<>();
	private List<Vertice> lVerticesExpandidos = new ArrayList<>();

	@Override
    public Caminho buscaCustoUniforme(Grafo aGrafo, Vertice aInicial, Vertice aFinal) {
		Grafo.reiniciarGrafo(aGrafo);
        aInicial.definirDistancia(0);
        lVerticesAbertos.add(aInicial);
   
        lVerticesAbertos.addAll(aGrafo.obterVertices());
        while (lVerticesAbertos.size() > 0) {
//        	Oodena os vertices para deixar o com menor distancia na posição 0
            ordernar(lVerticesAbertos);
//          Remove o vertice com menor distancia
            Vertice lVerticeOrigem = lVerticesAbertos.remove(VERTICE_COM_MENOR_DISTANCIA);
//          Adiconar o vertice na lista dos vertices expandidos
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
                return Caminho.converter(aGrafo, aFinal, lVerticeOrigem.obterDistancia());
            }
        }
        return Caminho.converter(aGrafo, aFinal, aFinal.obterDistancia());
    }

//	Ordena a lista de arcos em onderm crecsente
    private static void ordernar(List<Vertice> aArcos) {
        Collections.sort(aArcos, new CustomComparatorVertice());
    }

//	Ordenação dos arcos por distancia.
    private static class CustomComparatorVertice implements Comparator<Vertice> {

        @Override
        public int compare(Vertice aVerticeI, Vertice aVerticeII) {
            Double pesoI = aVerticeI.obterDistancia();
            Double pesoII = aVerticeII.obterDistancia();
            return pesoI.compareTo(pesoII);
        }

    }
}

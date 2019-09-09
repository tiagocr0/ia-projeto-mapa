package ifsc.edu.br.eurotour.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaBidirecionalRepository;

public class BuscaBidirecional implements BuscaBidirecionalRepository {


	public static final int VERTICE_COM_MENOR_DISTANCIA = 0;
	
	@Override
	public Caminho buscaBidirecional(Grafo aGrafo, Vertice aInicial, Vertice aFinal) {
		Grafo.reiniciarGrafo(aGrafo);
		
		List<Vertice> lVerticesAbertorA = new ArrayList<>();
		List<Vertice> lVerticesAbertorB = new ArrayList<>();
        
        List<Vertice> lVerticesExpandidosA = new ArrayList<>();
        List<Vertice> lVerticesExpandidosB = new ArrayList<>();
        
        aInicial.visitar();
        aInicial.definirDistancia(0);
        lVerticesExpandidosA.add(aInicial);
        
        aFinal.visitar();
        aFinal.definirDistancia(0);
        lVerticesExpandidosB.add(aFinal);
        
        lVerticesAbertorA.add(aInicial);
        lVerticesAbertorB.add(aFinal);
        
        while (!lVerticesAbertorB.isEmpty() || !lVerticesAbertorB.isEmpty()) {
            Vertice lVerticeAAB = existeCaminho(lVerticesAbertorA, lVerticesExpandidosA, lVerticesExpandidosB);
            if (lVerticeAAB != null) {
                String lCaminho = gerarCaminho(aGrafo,lVerticeAAB);
                return Caminho.converter(aGrafo, lCaminho, lVerticeAAB.obterDistancia());
            }
            Vertice lVerticeBBA = existeCaminho(lVerticesAbertorB, lVerticesExpandidosB, lVerticesExpandidosA);
            if (lVerticeBBA != null) {
                String lCaminho = gerarCaminho(aGrafo,lVerticeBBA);
                return Caminho.converter(aGrafo, lCaminho, lVerticeBBA.obterDistancia());
            }
        }
        return Caminho.converter(aGrafo, aFinal, aFinal.obterDistancia());
    }
    
    private Vertice existeCaminho(List<Vertice> aVerticesAbertos,
    		List<Vertice> aVerticesExpandidosA, List<Vertice> aVerticesExpandidosB) {
    	
        if (!aVerticesAbertos.isEmpty()) {
            Vertice next = aVerticesAbertos.remove(VERTICE_COM_MENOR_DISTANCIA);
            List<Arco> adjacentNodes = next.obterArcos();
            for (Arco arcosAdjacent : adjacentNodes) {
                Vertice adjacent = arcosAdjacent.getDestino();
                double lDistanciaPorPeso = arcosAdjacent.getPeso();
                if (aVerticesExpandidosB.contains(adjacent)) {
                    adjacent.setCaminhoInverso(next.getCaminho());
                    double totalDistancia = lDistanciaPorPeso + adjacent.obterDistancia() + next.obterDistancia();
                    adjacent.definirDistancia(totalDistancia);
                    return adjacent;
                } else if(!aVerticesExpandidosA.contains(adjacent)) {
                    adjacent.definirDistancia(lDistanciaPorPeso + next.obterDistancia());
                    adjacent.setCaminho(next.getCaminho());
                    aVerticesExpandidosA.add(adjacent);
                    aVerticesAbertos.add(adjacent);
                   
                }
            }
        }
        return null;
    }
    
    private static String gerarCaminho(Grafo lGrafo,Vertice lVerticeCentral) {
        String lTextCaminhoI = lVerticeCentral.getCaminho().replace(" / " + lVerticeCentral.toString(), "");
        String lTextCaminhoII = lVerticeCentral.getCaminhoInverso();
        
        String [] lCaminho = revertArray(lTextCaminhoI.split(" / "));
        for(int indice = 0; indice < lCaminho.length; indice++) {
            lTextCaminhoII += " / " + lCaminho[indice];
        }
        return lTextCaminhoII;
    }
    
    private static String[] revertArray(String[] caminho) {
        String[] novo = new String[caminho.length]; 
        int j = caminho.length; 
        for (int i = 0; i < caminho.length; i++) { 
            novo[j - 1] = caminho[i]; 
            j = j - 1; 
        } 
        return novo;
    }
}

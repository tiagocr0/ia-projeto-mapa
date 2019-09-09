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
		
		List<Vertice> aVerticesAbertorA = new LinkedList<>();
		List<Vertice> aVerticesAbertorB = new LinkedList<>();
        
        List<Vertice> visitedA = new ArrayList<>();
        List<Vertice> visitedB = new ArrayList<>();
        
        aInicial.visitar();
        aInicial.definirDistancia(0);
        visitedA.add(aInicial);
        
        aFinal.visitar();
        aFinal.definirDistancia(0);
        visitedB.add(aFinal);
        
        aVerticesAbertorA.add(aInicial);
        aVerticesAbertorB.add(aFinal);
        
        while (!aVerticesAbertorB.isEmpty() || !aVerticesAbertorB.isEmpty()) {
            Vertice lVerticeAAB = existeCaminho(aVerticesAbertorA, visitedA, visitedB);
            if (lVerticeAAB != null) {
                String lCaminho = gerarCaminho(aGrafo,lVerticeAAB);
                return Caminho.converter(aGrafo, lCaminho, lVerticeAAB.obterDistancia());
            }
            Vertice lVerticeBBA = existeCaminho(aVerticesAbertorB, visitedB, visitedA);
            if (lVerticeBBA != null) {
                String lCaminho = gerarCaminho(aGrafo,lVerticeBBA);
                return Caminho.converter(aGrafo, lCaminho, lVerticeBBA.obterDistancia());
            }
        }
        return Caminho.converter(aGrafo, aFinal, aFinal.obterDistancia());
    }
    
    private Vertice existeCaminho(List<Vertice> aVerticesAbertos, List<Vertice> verticesVisitadosA, List<Vertice> verticesVisitadosB) {
        if (!aVerticesAbertos.isEmpty()) {
            Vertice next = aVerticesAbertos.remove(VERTICE_COM_MENOR_DISTANCIA);
            List<Arco> adjacentNodes = next.obterArcos();
            for (Arco arcosAdjacent : adjacentNodes) {
                Vertice adjacent = arcosAdjacent.getDestino();
                double lDistanciaPorPeso = arcosAdjacent.getPeso();
                if (verticesVisitadosB.contains(adjacent)) {
                    adjacent.setCaminhoInverso(next.getCaminho());
                    double totalDistancia = lDistanciaPorPeso + adjacent.obterDistancia() + next.obterDistancia();
                    adjacent.definirDistancia(totalDistancia);
                    return adjacent;
                } else if(!verticesVisitadosA.contains(adjacent)) {
                    adjacent.definirDistancia(lDistanciaPorPeso + next.obterDistancia());
                    adjacent.setCaminho(next.getCaminho());
                    verticesVisitadosA.add(adjacent);
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

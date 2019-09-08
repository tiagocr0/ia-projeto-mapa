package ifsc.edu.br.eurotour.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.repository.BuscaBidirecionalRepository;

public class BuscaBidirecional implements BuscaBidirecionalRepository {

	
	@Override
	public Caminho buscaBidirecional(Grafo aGrafo, Vertice aInicial, Vertice aFinal) {
        Queue<Vertice> queueA = new LinkedList<>();
        Queue<Vertice> queueB = new LinkedList<>();
        reiniciarGrafo(aGrafo);
        List<Vertice> visitedA = new ArrayList<>();
        List<Vertice> visitedB = new ArrayList<>();
        
        aInicial.visitar();
        aInicial.definirDistancia(0);
        visitedA.add(aInicial);
        aFinal.visitar();
        aFinal.definirDistancia(0);
        visitedB.add(aFinal);
        
        queueA.add(aInicial);
        queueB.add(aFinal);
        
        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            Vertice lVerticeAAB = existeCaminho(queueA, visitedA, visitedB);
            if (lVerticeAAB != null) {
                String lCaminho = gerarCaminho(aGrafo,lVerticeAAB);
                return Caminho.converter(aGrafo, lCaminho, lVerticeAAB.obterDistancia());
            }
            Vertice lVerticeBBA = existeCaminho(queueB, visitedB, visitedA);
            if (lVerticeBBA != null) {
                String lCaminho = gerarCaminho(aGrafo,lVerticeBBA);
                return Caminho.converter(aGrafo, lCaminho, lVerticeBBA.obterDistancia());
            }
        }
        return Caminho.converter(aGrafo, aFinal, aFinal.obterDistancia());
    }
    
    private Vertice existeCaminho(Queue<Vertice> queue, List<Vertice> visitedFromThisSide, List<Vertice> visitedFromThatSide) {
        if (!queue.isEmpty()) {
            Vertice next = queue.remove();
            List<Arco> adjacentNodes = next.obterArcos();
            for (Arco arcosAdjacent : adjacentNodes) {
                Vertice adjacent = arcosAdjacent.getDestino();
                double lDistanciaPorPeso = arcosAdjacent.getPeso();
                if (visitedFromThatSide.contains(adjacent)) {
                    adjacent.setCaminhoInverso(next.getCaminho());
                    double totalDistancia = lDistanciaPorPeso + adjacent.obterDistancia() + next.obterDistancia();
                    adjacent.definirDistancia(totalDistancia);
                    return adjacent;
                } else if(!visitedFromThisSide.contains(adjacent)) {
                    visitedFromThisSide.add(adjacent);
                    adjacent.definirDistancia(lDistanciaPorPeso + next.obterDistancia());
                    adjacent.setCaminho(next.getCaminho());
                    queue.add(adjacent);
                }
            }
        }
        return null;
    }
    
    private static void reiniciarGrafo(Grafo aGrafo) {
        for (Vertice lVertice : aGrafo.obterVertices()) {
            lVertice.zerarVisitas();
            lVertice.zerarDistancia();
            lVertice.setCaminho("");
        }
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

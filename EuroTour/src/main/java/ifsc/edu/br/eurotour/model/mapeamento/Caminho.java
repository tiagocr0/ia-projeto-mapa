package ifsc.edu.br.eurotour.model.mapeamento;

import java.util.ArrayList;
import java.util.List;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;

public class Caminho {
    
    private List<DistanciaEntre2Paises> caminho;
    private Double distaciaTotal;

    public Caminho( Double distaciaTotal) {
        this.caminho = new ArrayList<>();
        this.distaciaTotal = distaciaTotal;
    }

    public Caminho(List<DistanciaEntre2Paises> caminho, Double distaciaTotal) {
        this.caminho = caminho;
        this.distaciaTotal = distaciaTotal;
    }
    
    public List<DistanciaEntre2Paises> getCaminho() {
        return caminho;
    }

    public void setCaminho(List<DistanciaEntre2Paises> caminho) {
        this.caminho = caminho;
    }

    public Double getDistaciaTotal() {
        return distaciaTotal;
    }

    public void setDistaciaTotal(Double distaciaTotal) {
        this.distaciaTotal = distaciaTotal;
    } 
    
    private static Caminho montarCaminhoTela(Grafo aGrafo, Vertice aFinal, Double lDistanciaMinima) {
		String[] lNomes = aFinal.getCaminho().split("/");
		Caminho lCaminho = new Caminho(lDistanciaMinima);
		for (int indice = 0; indice < lNomes.length; indice++) {
			if ((indice + 1) != lNomes.length) {
				Pais lOrigem = Pais.convertVerticeParaPais(aGrafo.pesquisaVertice(lNomes[indice].trim()));
                Vertice lVerticeDestino = aGrafo.pesquisaVertice(lNomes[indice+1].trim());
                Pais lDestino = Pais.convertVerticeParaPais(lVerticeDestino);
				lCaminho.getCaminho().add(new DistanciaEntre2Paises(lOrigem, lDestino, lVerticeDestino.obterDistancia()));
			}
		}
		return lCaminho;
	}
}
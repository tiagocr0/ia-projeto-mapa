package ifsc.edu.br.eurotour.model.mapeamento;

import java.util.ArrayList;
import java.util.List;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;

public class Caminho {

	private List<DistanciaEntre2Paises> caminho;
	private Double distanciaTotal;

	public Caminho(Double distanciaTotal) {
		this.caminho = new ArrayList<>();
		this.distanciaTotal = distanciaTotal;
	}

	public Caminho(List<DistanciaEntre2Paises> caminho, Double distanciaTotal) {
		this.caminho = caminho;
		this.distanciaTotal = distanciaTotal;
	}

	public List<DistanciaEntre2Paises> getCaminho() {
		return caminho;
	}

	public void setCaminho(List<DistanciaEntre2Paises> caminho) {
		this.caminho = caminho;
	}


	public Double getDistanciaTotal() {
		return distanciaTotal;
	}

	public void setDistanciaTotal(Double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}

	public static Caminho converter(Grafo aGrafo, Vertice aFinal, Double lDistanciaMinima) {
		String[] lNomes = aFinal.getCaminho().split("/");
		Caminho lCaminho = new Caminho(lDistanciaMinima);
		for (int indice = 0; indice < lNomes.length; indice++) {
			if ((indice + 1) != lNomes.length) {
				Vertice lVerticeOrigem = aGrafo.pesquisaVertice(lNomes[indice].trim());
				Vertice lVerticeDestino = aGrafo.pesquisaVertice(lNomes[indice + 1].trim());
				lCaminho.getCaminho()
						.add(new DistanciaEntre2Paises(lVerticeOrigem.toString(), lVerticeDestino.toString(), lVerticeDestino.obterDistancia()));
			}
		}
		return lCaminho;
	}

	@Override
	public String toString() {
		return "Caminho=" + caminho + "\ndistanciaTotal=" + distanciaTotal;
	}
	
	  public static Caminho converter(Grafo aGrafo, String aVertices, Double lDistanciaMinima) {
	        String[] lNomes = aVertices.split(" / ");
	        Caminho lCaminho = new Caminho(lDistanciaMinima);
	        for (int indice = 0; indice < lNomes.length; indice++) {
	                if ((indice + 1) != lNomes.length) {
	                	Vertice lVerticeOrigem = aGrafo.pesquisaVertice(lNomes[indice].trim());
	    				Vertice lVerticeDestino = aGrafo.pesquisaVertice(lNomes[indice + 1].trim());
	    				lCaminho.getCaminho()
	    						.add(new DistanciaEntre2Paises(lVerticeOrigem.toString(), lVerticeDestino.toString(), lVerticeDestino.obterDistancia()));
	                }
	        }
	        return lCaminho;
	    }

}
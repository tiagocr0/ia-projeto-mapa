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

	public Double getDistaciaTotal() {
		return distanciaTotal;
	}

	public void setDistaciaTotal(Double distaciaTotal) {
		this.distanciaTotal = distaciaTotal;
	}

	public static Caminho converter(Grafo aGrafo, Vertice aFinal, Double lDistanciaMinima) {
		String[] lNomes = aFinal.getCaminho().split("/");
		Caminho lCaminho = new Caminho(lDistanciaMinima);
		for (int indice = 0; indice < lNomes.length; indice++) {
			if ((indice + 1) != lNomes.length) {
				Pais lOrigem = Pais.convertVerticeParaPais(aGrafo.pesquisaVertice(lNomes[indice].trim()));
				Vertice lVerticeDestino = aGrafo.pesquisaVertice(lNomes[indice + 1].trim());
				Pais lDestino = Pais.convertVerticeParaPais(lVerticeDestino);
				lCaminho.getCaminho()
						.add(new DistanciaEntre2Paises(lOrigem, lDestino, lVerticeDestino.obterDistancia()));
			}
		}
		return lCaminho;
	}

	@Override
	public String toString() {
		return "Caminho=" + caminho + "\ndistanciaTotal=" + distanciaTotal;
	}

}
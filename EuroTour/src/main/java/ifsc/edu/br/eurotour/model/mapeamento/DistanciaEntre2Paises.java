package ifsc.edu.br.eurotour.model.mapeamento;

public class DistanciaEntre2Paises {
	private Pais origem;
	private Pais destino;
	private Double distancia;

	public DistanciaEntre2Paises() {
	}

	public DistanciaEntre2Paises(Pais origem, Pais destino, Double distancia) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	public Pais getOrigem() {
		return origem;
	}

	public void setOrigem(Pais origem) {
		this.origem = origem;
	}

	public Pais getDestino() {
		return destino;
	}

	public void setDestino(Pais destino) {
		this.destino = destino;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

}

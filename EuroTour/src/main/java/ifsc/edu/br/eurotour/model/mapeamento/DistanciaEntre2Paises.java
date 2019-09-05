package ifsc.edu.br.eurotour.model.mapeamento;

public class DistanciaEntre2Paises {
	private String origem;
	private String destino;
	private Double distancia;

	public DistanciaEntre2Paises() {
	}

	public DistanciaEntre2Paises(String origem, String destino, Double distancia) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "\n{\n\torigem = " + origem + "\n\tdestino = " + destino + "\n\tdistancia = " + distancia + "\n}\n";
	}

}

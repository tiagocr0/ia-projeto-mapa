package ifsc.edu.br.eurotour.model.mapeamento;

/**
 * Classe que recebe o tipo do algoritmo que será usado, a origem e o destino do
 * front-end
 * 
 * @author Tiago
 *
 */

public class FrontToBack {

	private int algoritmo;
	private String origem;
	private String destino;

	public FrontToBack() {

	}

	public int getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(int algoritmo) {
		this.algoritmo = algoritmo;
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

	@Override
	public String toString() {
		return "FrontToBack [algoritmo=" + algoritmo + ", origem=" + origem + ", destino=" + destino + "]";
	}

}

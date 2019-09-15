package ifsc.edu.br.eurotour.model.mapeamento;

/**
 * Classe que recebe {@link FrontToBack} para formatá-la e receber do front-end
 * no formato exemplo:
 * 
 * {
 *  "front":{
 *     "algoritmo": 3,
 *	   "origem": "Albânia – Tirana",
 *	   "destino": "Bélgica – Bruxelas"
 *    }
 * }
 * 
 * @author Tiago
 *
 */

public class Front {

	private FrontToBack front;

	public FrontToBack getFront() {
		return front;
	}

	public void setFront(FrontToBack front) {
		this.front = front;
	}

}

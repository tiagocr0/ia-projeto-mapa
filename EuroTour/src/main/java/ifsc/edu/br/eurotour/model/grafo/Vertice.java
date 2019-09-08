package ifsc.edu.br.eurotour.model.grafo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe para abstrair vértices de grafos direcionados IFSC - Lages Prof.
 * Vilson Heck Junior
 */

public class Vertice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Lista de arcos que saem do vértice
	private final ArrayList<Arco> arcos = new ArrayList<>();
	private final ArrayList<Arco> arcosHeuristica = new ArrayList<>();

	// Rótulo do vértice: serve para identificação
	private final String rotulo;

//Os quatro próximos atributos são utilizados pelos algoritmos de grafos.

	// Quando o valor de visitado for 0 (zero) significa que o vértice ainda
	// não foi visitado pelo algoritmo. Em cada nova visita o método deve invocar
	// o método visitar() para incrementar este valor. O método zerarVisitas()
	// zera este valor novamente. O método obterVisitado() informa o valor atual.
	private int visitado = 0;

	// Vários algoritmos irão medir a distância de um vértice até outro. Este
	// atributo servirá como um "medidor auxiliar de distância", armazenando
	// temporariamente distâncias nas iterações dos algoritmos. Os métodos
	// definirDistancia(), zerarDistancia() e obterDistancia() devem ser usados.
	private double distancia = Double.POSITIVE_INFINITY;
	private double distanciaHeuristica = Double.POSITIVE_INFINITY;

	// Algoritmos de caminhos podem precisar da informação de qual caminho foi
	// utilizado para se obter a distância informada. O caminho é uma String
	// Contendo os rótulos dos vértices utilizados para chegar até o vértice
	private String caminho = "";
	private String caminhoInverso = "";

	public Vertice(String rotulo) {
		this.rotulo = rotulo;
	}

	public Vertice() {
		this.rotulo = "";
	}

	public void adicionarArco(Vertice destino, double peso) {
		this.arcos.add(new Arco(this, destino, peso));
	}
	
	public void adicionarArcoHeuristica(Vertice destino, double peso) {
        this.arcosHeuristica.add(new Arco(this, destino, peso));
    }

	public ArrayList<Arco> obterArcos() {
		return this.arcos;
	}
	
	public ArrayList<Arco> obterArcosHeuristica() {
        return this.arcosHeuristica;
    }

	public String obterLinhaArquivo() {
		String linha = this.rotulo;
		for (Arco arcoAtual : arcos) {
			linha += "\t" + arcoAtual.toString();
		}
		return linha;
	}

	public void visitar() {
		this.visitado++;
	}

	public int obterVisitado() {
		return this.visitado;
	}

	public void zerarVisitas() {
		this.visitado = 0;
	}

	public void zerarDistancia() {
		this.distancia = Double.POSITIVE_INFINITY;
	}

	public void definirDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public void definirDistanciaHeuristica(double distanciaEuristica) {
        this.distanciaHeuristica = distanciaEuristica;
    }

	public double obterDistancia() {
		return this.distancia;
	}
	
	public double obterDistanciaHeuristica(Vertice final_) {
        for (Arco arco : arcosHeuristica) {
            if(arco.getDestino().equals(final_)){
                return arco.getPeso();
            }
        }
        return this.distanciaHeuristica;
    }

	public String getCaminho() {
		if (caminho == null || caminho.equals("")) {
			return this.rotulo;
		}
		String nome[] = this.rotulo.split(" / ");
		return caminho + " / " + nome[0].trim();
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	public String getCaminhoInverso() {
        if(caminhoInverso == null || caminhoInverso.equals("")) {
            return this.rotulo;
        }
        return caminhoInverso + " / " + this.rotulo;
    }
    
    
	public void setCaminhoInverso(String caminhoInverso) {
        this.caminhoInverso = caminhoInverso;
    }

	@Override
	public String toString() {
		return this.rotulo;
	}

	@Override
	public boolean equals(Object o) {
		return o.toString().equals(this.rotulo);
	}

}
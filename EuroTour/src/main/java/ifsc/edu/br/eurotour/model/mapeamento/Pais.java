package ifsc.edu.br.eurotour.model.mapeamento;

import ifsc.edu.br.eurotour.model.grafo.Vertice;

public class Pais {

	private String nome;

	public Pais() {
	}

	public Pais(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static Pais convertVerticeParaPais(Vertice aVertice) {
		Pais lPais = new Pais(aVertice.toString());
		return lPais;
	}

	@Override
	public String toString() {
		return nome;
	}

}
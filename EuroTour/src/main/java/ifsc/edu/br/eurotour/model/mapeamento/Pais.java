package ifsc.edu.br.eurotour.model.mapeamento;

import ifsc.edu.br.eurotour.model.grafo.Vertice;

public class Pais {
    
    private String nome;
    private String capital;

    public Pais() {
    }
   
    public Pais(String nome, String capital) {
        this.nome = nome;
        this.capital = capital;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    public static Pais convertVerticeParaPais(Vertice aVertice) {
        String[] lPaisCapital = aVertice.toString().split(" – ");
        Pais lPais = new Pais(lPaisCapital[0].trim(), lPaisCapital[1].trim());
        return lPais;
    }
}
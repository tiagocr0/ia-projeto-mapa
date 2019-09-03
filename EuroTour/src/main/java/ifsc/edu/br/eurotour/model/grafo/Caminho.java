package ifsc.edu.br.eurotour.model.grafo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casa
 */
public class Caminho {
    
    private List<Arco> caminho;
    private Double distaciaTotal;

    public Caminho( Double distaciaTotal) {
        this.caminho = new ArrayList<>();
        this.distaciaTotal = distaciaTotal;
    }

    public Caminho(List<Arco> caminho, Double distaciaTotal) {
        this.caminho = caminho;
        this.distaciaTotal = distaciaTotal;
    }
    
    public List<Arco> getCaminho() {
        return caminho;
    }

    public void setCaminho(List<Arco> caminho) {
        this.caminho = caminho;
    }

    public Double getDistaciaTotal() {
        return distaciaTotal;
    }

    public void setDistaciaTotal(Double distaciaTotal) {
        this.distaciaTotal = distaciaTotal;
    } 
}

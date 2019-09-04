package ifsc.edu.br.eurotour.model.mapeamento;

import java.util.ArrayList;
import java.util.List;

public class CaminhoParaATela {
    
    private List<DistanciaEntre2Paises> caminho;
    private Double distaciaTotal;

    public CaminhoParaATela( Double distaciaTotal) {
        this.caminho = new ArrayList<>();
        this.distaciaTotal = distaciaTotal;
    }

    public CaminhoParaATela(List<DistanciaEntre2Paises> caminho, Double distaciaTotal) {
        this.caminho = caminho;
        this.distaciaTotal = distaciaTotal;
    }
    
    public List<DistanciaEntre2Paises> getCaminho() {
        return caminho;
    }

    public void setCaminho(List<DistanciaEntre2Paises> caminho) {
        this.caminho = caminho;
    }

    public Double getDistaciaTotal() {
        return distaciaTotal;
    }

    public void setDistaciaTotal(Double distaciaTotal) {
        this.distaciaTotal = distaciaTotal;
    } 
}
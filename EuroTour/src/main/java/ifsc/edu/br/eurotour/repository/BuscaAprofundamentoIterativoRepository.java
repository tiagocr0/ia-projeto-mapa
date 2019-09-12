package ifsc.edu.br.eurotour.repository;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.services.BuscaAprofundamentoIterativoService;
import ifsc.edu.br.eurotour.util.BuscaAprofundamentoIterativo;

/**
 * Camada de acesso a dados da {@link BuscaAprofundamentoIterativo}.<br>
 * Provê funções a camada de serviço:
 * {@link BuscaAprofundamentoIterativoService}
 * 
 * @author Osmar
 *
 */
public interface BuscaAprofundamentoIterativoRepository {

	/**
	 * Realiza a busca de aprofundamento iterativo dado um {@link Grafo}, a partir
	 * de um {@link Vertice} de origem e de destino
	 * 
	 * @param g       {@link Grafo} que contém os {@link Vertice}s e os
	 *                {@link Arco}s
	 * @param inicial {@link Vertice} que representa a origem da busca
	 * @param destino {@link Vertice} que representa o destino da busca
	 * @return {@link Caminho} que deve ser percorrido
	 */
	public Caminho buscaAprofundamentoIterativo(Grafo g, Vertice inicial, Vertice destino);

}

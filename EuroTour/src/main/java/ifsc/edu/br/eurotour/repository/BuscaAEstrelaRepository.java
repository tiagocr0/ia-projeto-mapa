package ifsc.edu.br.eurotour.repository;

import ifsc.edu.br.eurotour.model.grafo.Arco;
import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.model.mapeamento.Caminho;
import ifsc.edu.br.eurotour.services.BuscaAEstrelaService;
import ifsc.edu.br.eurotour.util.BuscaAEstrela;

/**
 * Camada de acesso a dados da {@link BuscaAEstrela}.<br>
 * Provê funções a camada de serviço: {@link BuscaAEstrelaService}
 * 
 * @author Osmar
 *
 */
public interface BuscaAEstrelaRepository {

	/**
	 * Realiza a busca A* dado um {@link Grafo}, a partir de um {@link Vertice} de
	 * origem e de destino
	 * 
	 * @param g       {@link Grafo} que contém os {@link Vertice}s e os
	 *                {@link Arco}s
	 * @param inicial {@link Vertice} que representa a origem da busca
	 * @param destino {@link Vertice} que representa o destino da busca
	 * @return {@link Caminho} que deve ser percorrido
	 */
	public Caminho buscaAEstrela(Grafo g, Vertice inicial, Vertice destino);
}

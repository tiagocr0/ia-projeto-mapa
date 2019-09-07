/*
    Arquivo versão 4.0
    Contempla o uso de buscas, árvores geradoras mínimas, caminho mínimo e fluxo máximo.
*/

package ifsc.edu.br.eurotour.model.grafo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Classe para abstrair grafos direcionados. A classe utiliza representação por
 * lista de adjacência. IFSC - Lages Prof. Vilson Heck Junior
 */
public class Grafo {

	private final ArrayList<Vertice> vertices = new ArrayList<>();

	public Grafo() {

	}

	public Grafo(File arquivo) throws IOException {
		this.lerArquivo(arquivo);
	}

	public void adicionarVertice(String rotulo) {
		Vertice novo = new Vertice(rotulo);
		vertices.add(novo);
	}

	public ArrayList<Vertice> obterVertices() {
		return this.vertices;
	}

	public Vertice pesquisaVertice(String rotulo) {
		int indice = vertices.indexOf(new Vertice(rotulo));
		return (indice >= 0) ? vertices.get(indice) : null;
	}

	public void gravarArquivo(File arquivo) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo));
		for (Vertice vertice : vertices) {
			escritor.write(vertice.obterLinhaArquivo() + "\n");
		}
		escritor.close();
	}

	/**
	 * Esta função lê um arquivo texto contendo o grafo representado em lista de
	 * adjacência. O arquivo deve conter uma linha para vértice, tendo como a
	 * primeira informação linha o nome do vértice e, separados por tabulação, os
	 * nomes e pesos dos demais vértices com os quais existem arcos. Ex.: A B,2 C,4
	 * B A,1.3 C B,2.5 Não devem haver caracteres de espaço. Os pesos podem ser
	 * inteiros ou reais.
	 * 
	 * @param arquivo Objeto da classe File para o arquivo a ser lido.
	 * @throws IOException
	 */
	public void lerArquivo(File arquivo) throws IOException {
		BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
		ArrayList<String[]> linhas = new ArrayList<>();
		String linhaAtual = leitor.readLine();
		while (linhaAtual != null) {
			String[] valores = linhaAtual.split("\t");
			linhas.add(valores);
			this.adicionarVertice(valores[0]);
			linhaAtual = leitor.readLine();
		}

		for (String[] linha : linhas) {
			for (int i = 1; i < linha.length; i++) {
				String[] termos = linha[i].split(",");
				Vertice conecta = this.pesquisaVertice(termos[0]);
				double peso = Double.parseDouble(termos[1]);
				this.pesquisaVertice(linha[0]).adicionarArco(conecta, peso);
				// System.out.println(linha[0] + " com " + termos[0] + " peso " + peso);
			}
		}
		leitor.close();
	}

	public void lerArquivoExcel(FileInputStream arquivo) throws IOException {
		// InputStream excelFileToRead = new FileInputStream(arquivo);
		XSSFWorkbook wb = new XSSFWorkbook(arquivo);

		XSSFSheet planilha = wb.getSheetAt(0);
		XSSFRow linha;
		XSSFCell celula;
		Vertice conecta;

		Iterator<Row> linhas = planilha.rowIterator();

		while (linhas.hasNext()) {
			linha = (XSSFRow) linhas.next();

			if (linha.getRowNum() > 1) {

				Iterator<Cell> celulas = linha.cellIterator();
				conecta = null;

				while (celulas.hasNext()) {
					celula = (XSSFCell) celulas.next();

					if (celula.getColumnIndex() == 0) {
						adicionarVertice(celula.getStringCellValue());
					} else {
						break;
					}
				}
			}
		}

		linhas = planilha.rowIterator();

		while (linhas.hasNext()) {
			linha = (XSSFRow) linhas.next();

			if (linha.getRowNum() > 1) {

				Iterator<Cell> celulas = linha.cellIterator();
				conecta = null;

				while (celulas.hasNext()) {
					celula = (XSSFCell) celulas.next();

					if (celula.getColumnIndex() == 0) {
						conecta = this.pesquisaVertice(celula.getStringCellValue());
					} else {
						if (celula.getCellType().toString().equals("NUMERIC")) {
							double peso = celula.getNumericCellValue();
							this.pesquisaVertice(
									planilha.getRow(1).getCell(celula.getColumnIndex()).getStringCellValue())
									.adicionarArco(conecta, peso);
						}
					}
				}
			}
		}

		planilha = wb.getSheetAt(1);
		linhas = planilha.rowIterator();

		while (linhas.hasNext()) {
			linha = (XSSFRow) linhas.next();

			if (linha.getRowNum() > 1) {

				Iterator<Cell> celulas = linha.cellIterator();
				conecta = null;

				while (celulas.hasNext()) {
					celula = (XSSFCell) celulas.next();

					if (celula.getColumnIndex() == 0) {
						conecta = this.pesquisaVertice(celula.getStringCellValue());
					} else {
						if (celula.getCellType().equals("NUMERIC")) {
							double peso = celula.getNumericCellValue();
							this.pesquisaVertice(planilha.getRow(1).getCell(celula.getColumnIndex()).getStringCellValue()).adicionarArcoHeuristica(conecta,
							 peso);
						}
					}
				}
			}
		}
		wb.close();
	}

	public ArrayList<Arco> obterTodosOsArcos() {
		ArrayList<Arco> resultado = new ArrayList<>();
		for (Vertice vertice : vertices) {
			resultado.addAll(vertice.obterArcos());
		}
		return resultado;
	}
}
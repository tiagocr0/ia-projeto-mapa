package ifsc.edu.br.eurotour.dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ifsc.edu.br.eurotour.model.grafo.Grafo;
import ifsc.edu.br.eurotour.model.grafo.Vertice;
import ifsc.edu.br.eurotour.repository.DataRoutesRepository;

public class DataRoutesDataAccess implements DataRoutesRepository {

	private Grafo grafo = new Grafo();

	@Override
	public Grafo pegarArquivo() {
		try {
			URL caminhoArquivo = getClass().getResource("../datasource/Planilha de Países-Capitais Ordenada.xlsx");
			FileInputStream arquivo = new FileInputStream(new File(caminhoArquivo.toURI()));
			this.lerArquivoExcel(arquivo);
			return grafo;
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
			return null;
		}

	}

	// FIXME
	private void lerArquivoExcel(FileInputStream arquivo) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook(arquivo);

		XSSFSheet planilha = wb.getSheetAt(0);
		XSSFRow linha;
		XSSFCell celula;

		Iterator<Row> linhas = planilha.rowIterator();

		while (linhas.hasNext()) {
			linha = (XSSFRow) linhas.next();

			if (linha.getRowNum() > 1) {

				Iterator<Cell> celulas = linha.cellIterator();
				Vertice conecta = null;

				while (celulas.hasNext()) {
					celula = (XSSFCell) celulas.next();

					if (celula.getColumnIndex() == 0) {
						grafo.adicionarVertice(celula.getStringCellValue());
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
				Vertice conecta = null;

				while (celulas.hasNext()) {
					celula = (XSSFCell) celulas.next();

					if (celula.getColumnIndex() == 0) {
						conecta = grafo.pesquisaVertice(celula.getStringCellValue());
					} else {
						if (celula.getCellType().toString().equals("NUMERIC")) {
							double peso = celula.getNumericCellValue();
							grafo.pesquisaVertice(
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
				Vertice conecta = null;

				while (celulas.hasNext()) {
					celula = (XSSFCell) celulas.next();

					if (celula.getColumnIndex() == 0) {
						conecta = grafo.pesquisaVertice(celula.getStringCellValue());
					}
				}
			}
		}
		wb.close();
	}
}

package br.edu.infnet.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import br.edu.infnet.model.Resposta;

public class WriteCsvToResponse {

	private static final String OBJECT_LIST_SAMPLE = "./repostas.csv";

	private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);
	private static final String[] CSV_HEADER = { "id", "questao_id", "valor" };

	@SuppressWarnings("unchecked")
	public static void writeRespostas(PrintWriter writer, List<Resposta> respostas) throws IOException {

		// FileWriter fileWriter = null;

		StatefulBeanToCsv<Resposta> beanToCsv = null;

		try (Writer fileWriter = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE));) {
			ColumnPositionMappingStrategy<Resposta> mappingStrategy = new ColumnPositionMappingStrategy<Resposta>();

			mappingStrategy.setType(Resposta.class);
			mappingStrategy.setColumnMapping(CSV_HEADER);

			beanToCsv = new StatefulBeanToCsvBuilder<Resposta>(fileWriter).withMappingStrategy(mappingStrategy)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			beanToCsv.write(respostas);
			fileWriter.close();
		} catch (CsvException ex) {

			LOGGER.error("Error mapping Bean to CSV", ex);
		}
		
		
	}

	public static void writeResposta(PrintWriter writer, Resposta resposta) {

     }
}
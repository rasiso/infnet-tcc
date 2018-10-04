package br.edu.infnet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.edu.infnet.model.Resposta;
import br.edu.infnet.service.RespostaService;
import br.edu.infnet.util.WriteCsvToResponse;


@RestController
@RequestMapping("/resposta")
public class CsvController {

	@Autowired
	RespostaService respostaService;
	
	
    @RequestMapping(value = "/respostas", produces = "text/csv")
    public void findRespostas(HttpServletResponse response) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

    	List<Resposta> respostas = (List<Resposta>) respostaService.findAll();
        WriteCsvToResponse.writeRespostas(response.getWriter(), respostas);
    }
	
	
}

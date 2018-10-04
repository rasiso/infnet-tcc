package br.edu.infnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.model.Resposta;
import br.edu.infnet.repository.RespostaRepository;



@Service("respostaService")
public class RespostaService {

	@Autowired
	private RespostaRepository respostaRepository;

    public List<Resposta> findAll(){

        List<Resposta> respostas = (List<Resposta>) respostaRepository.findAll();
                                                    
        return respostas;
    }

    
}
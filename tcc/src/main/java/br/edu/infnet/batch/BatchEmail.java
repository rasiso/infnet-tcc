package br.edu.infnet.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.batch.service.EmailService;

/**
 * Implementa o processamento em Lote
 */
public class BatchEmail implements Job {

    @Autowired
    private EmailService emailService;

    /**
     * Executa o processamneto em Lote
     * @param JobExecutionContext contexto
     */
    @Override
    public void execute(JobExecutionContext contexto) throws JobExecutionException {

        emailService.enviar();
    }
}

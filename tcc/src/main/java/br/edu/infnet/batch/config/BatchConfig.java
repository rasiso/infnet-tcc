package br.edu.infnet.batch.config;


import org.quartz.SimpleTrigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import br.edu.infnet.batch.BatchEmail;
import br.edu.infnet.batch.factory.BatchFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Configura Processamento em Lote
 */
@Configuration
public class BatchConfig {

	@Value("${org.quartz.scheduler.instanceId}")
	    private String instanciaBatchId;
	
	@Value("${job.key}")
    private String key;
	
    @Value("${org.quartz.scheduler.instanceName}")
    private String instanciaBatchNome;
    
    @Value("${job.description}")
    private String descricao;

    @Value("${org.quartz.threadPool.threadCount}")
    private String quantidadeThead;

    @Value("${job.startDelay}")
    private Long atrasoInicial;

    @Value("${job.repeatInterval}")
    private Long intervaloDeRepeticao;
    

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {

        BatchFactory sampleJobFactory = new BatchFactory();
        sampleJobFactory.setApplicationContext(applicationContext);
        return sampleJobFactory;
    }

    

    @Bean(name = "emailBatchGatilho")
    public SimpleTriggerFactoryBean emailBatchGatilho() {


        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(emailBatchDetalhes().getObject());
        factoryBean.setStartDelay(atrasoInicial);
        factoryBean.setRepeatInterval(intervaloDeRepeticao);
        factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
        return factoryBean;
    }

    @Bean(name = "emailBatchDetalhes")
    public JobDetailFactoryBean emailBatchDetalhes() {

        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(BatchEmail.class);
        jobDetailFactoryBean.setDescription(descricao);
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setName(key);

        return jobDetailFactoryBean;
    }
    
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(ApplicationContext applicationContext) {

        SchedulerFactoryBean fabrica = new SchedulerFactoryBean();

        fabrica.setOverwriteExistingJobs(true);
        fabrica.setJobFactory(jobFactory(applicationContext));

        Properties quartzProperties = new Properties();
        quartzProperties.setProperty("org.quartz.scheduler.instanceName",instanciaBatchNome);
        quartzProperties.setProperty("org.quartz.scheduler.instanceId",instanciaBatchId);
        quartzProperties.setProperty("org.quartz.threadPool.threadCount",quantidadeThead);

        

        fabrica.setQuartzProperties(quartzProperties);
        fabrica.setTriggers(emailBatchGatilho().getObject());

        return fabrica;
    }


}

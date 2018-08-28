package br.edu.infnet.batch.factory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * Configura a Fábrica do Batch
 */
public class BatchFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    private transient AutowireCapableBeanFactory fabrica;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        fabrica = applicationContext.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle gatilho) throws Exception {

        final Object batch = super.createJobInstance(gatilho);
        fabrica.autowireBean(batch);
        return batch;
    }
}

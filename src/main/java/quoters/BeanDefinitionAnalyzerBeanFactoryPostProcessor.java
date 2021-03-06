package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

/**
 * @author Evgeny Borisov
 */
public class BeanDefinitionAnalyzerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        String[] names = factory.getBeanDefinitionNames();
        for (String name : names) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) factory.getBeanDefinition(name);
            String methodName = beanDefinition.getDestroyMethodName();
            if (methodName != null && beanDefinition.isPrototype()) {
                throw new RuntimeException("You are an idiot!!!");
            }
        }
    }
}

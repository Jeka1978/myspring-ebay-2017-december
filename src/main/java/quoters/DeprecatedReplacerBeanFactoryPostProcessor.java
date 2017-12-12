package quoters;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class DeprecatedReplacerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        String[] names = factory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = Class.forName(beanClassName);
            DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
            if (annotation != null) {
                Class newClass = annotation.newClass();
                beanDefinition.setBeanClassName(newClass.getName());
            }
        }
    }
}
















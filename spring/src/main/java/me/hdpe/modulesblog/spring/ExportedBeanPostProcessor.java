package me.hdpe.modulesblog.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.type.StandardMethodMetadata;

class ExportedBeanPostProcessor implements BeanPostProcessor {

	private ConfigurableListableBeanFactory beanFactory;

	ExportedBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (hasExportedAnnotation(beanName)) {
			ConfigurableListableBeanFactory parent = getParentBeanFactory();

			if (parent != null) {
				parent.registerSingleton(beanName, bean);
			}
		}

		return bean;
	}
	
	private boolean hasExportedAnnotation(String beanName) {
		BeanDefinition bd;
		try {
			bd = beanFactory.getBeanDefinition(beanName);
		}
		catch (NoSuchBeanDefinitionException exception) {
			return false;
		}

		if (!(bd.getSource() instanceof StandardMethodMetadata)) {
			return false;
		}
		
		return ((StandardMethodMetadata) bd.getSource())
				.isAnnotated(Exported.class.getName());
	}

	private ConfigurableListableBeanFactory getParentBeanFactory() {
		BeanFactory parent = beanFactory.getParentBeanFactory();
		return (parent instanceof ConfigurableListableBeanFactory)
			? (ConfigurableListableBeanFactory) parent : null;
	}
}

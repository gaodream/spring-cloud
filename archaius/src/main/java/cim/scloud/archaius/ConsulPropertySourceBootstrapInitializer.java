package cim.scloud.archaius;

import java.util.HashMap;
import java.util.Properties;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

public class ConsulPropertySourceBootstrapInitializer
		implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public static final String SERVICE_NAME_KEY = "service.name";
	public static final String SERVICE_TAG_KEY = "service.tag";
	public static final String DEFAULT_PROPERTIES_SOURCE_NAME = "applicationConfigurationProperties";

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ConfigurableEnvironment env = applicationContext.getEnvironment();
		PropertySource<?> source = this.locate(env);
		MutablePropertySources propertySources = env.getPropertySources();
		propertySources.addLast(source);
	}

	private PropertySource<?> locate(ConfigurableEnvironment env) {
		env.getPropertySources().remove(DEFAULT_PROPERTIES_SOURCE_NAME);// 移除application.properties的PropertySource
		Properties props = PropertyUtil.loadProps("bootstrap.properties");
		String servicename = props.getProperty(SERVICE_NAME_KEY);
		String servicetag = props.getProperty(SERVICE_TAG_KEY);
		return new ConsulPropertySource("service/" + servicename + "/" + servicetag + "/config", new HashMap<>());
	}

}

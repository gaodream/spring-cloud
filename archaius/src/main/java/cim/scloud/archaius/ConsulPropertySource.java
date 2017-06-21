package cim.scloud.archaius;

import java.util.Iterator;
import java.util.Map;

import org.springframework.core.env.MapPropertySource;

import com.netflix.config.AbstractPollingScheduler;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;

public class ConsulPropertySource extends MapPropertySource {

	public ConsulPropertySource(String name, Map<String, Object> source) {
       super(name, source);//初始化

       /**
        * 从consul上读取属性并存入netflix config
        */
       PolledConfigurationSource configSource = new ConsulConfigurationSource(name);//定义读取配置的源头
       AbstractPollingScheduler scheduler = new FixedDelayPollingScheduler();//设置读取配置文件的
       DynamicConfiguration configuration = new DynamicConfiguration(configSource, scheduler);
       ConfigurationManager.install(configuration);

       /**
        * 将属性存入PropertySource
        */
       @SuppressWarnings("rawtypes")
       Iterator it = configuration.getKeys();
       while (it.hasNext()) {
           String key = (String) it.next();
           this.source.put(key, configuration.getProperty(key));
       }
	}

}

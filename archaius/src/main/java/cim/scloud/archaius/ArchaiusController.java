package cim.scloud.archaius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api("consul相关API")
@RestController
@RequestMapping("/archaius")
public class ArchaiusController {
	
	@Autowired
	private Environment env;
	@Value("${mysql.driverClassName}")
	private String zjgBrother;

	@ApiOperation("服务测试")
	@RequestMapping("/test")
	public String test() {
		System.out.println("env->" + env.getProperty("xxx"));
		System.out.println("value->" + zjgBrother);

		DynamicStringProperty dsp = DynamicPropertyFactory.getInstance().getStringProperty(
				"hystrix.command.HystrixCommandKey.execution.isolation.thread.timeoutInMilliseconds", "xxx");
		System.out.println("Dynamic->" + dsp.get());
		return "hello";
	}
}

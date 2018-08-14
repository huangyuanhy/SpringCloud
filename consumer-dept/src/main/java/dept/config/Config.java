/**
 * 
 */
package dept.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @author huangyuan
 * @date 2018年7月11日下午2:00:50
 * @Description 配置类 bean
 */
@Configuration
public class Config {
	@LoadBalanced
	@Bean
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public IRule myRule() {
		return new RandomRule();//使用随机算法代替轮询算法
		//return new RetryRule();
	}
}

/**
 * 
 */
package myruler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @author huangyuan
 * @date 2018年7月17日下午9:28:24
 * @Description 自定义负载均衡算法
 */
@Configuration
public class Myrule {
	@Bean
	public IRule myRule() {
		return new RandomRule();//使用随机算法代替轮询算法
	}
}

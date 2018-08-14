/**
 * 
 */
package dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;




/**
 * @author huangyuan
 * @date 2018年7月10日上午9:37:08
 * @Description
 */
@EnableDiscoveryClient//服务发现  别人可以通过接口来访问某个服务的相关信息 即 ip+端口/info
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker //对hystrix熔断器的支持
public class DeptApplication {
		public static void main(String[] args) {
			SpringApplication.run(DeptApplication.class, args);
		}
	
}

/**
 * 
 */
package dept_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author huangyuan
 * @date 2018年7月11日下午2:53:08
 * @Description
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages= {"dept_feign"})
@ComponentScan(basePackages="dept_feign")
public class ConsumerDept {

	/**
	 * @param args
	 * @Description TODO
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConsumerDept.class, args);

	}

}

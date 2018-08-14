/**
 * 
 */
package dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import myruler.Myrule;

/**
 * @author huangyuan
 * @date 2018年7月11日下午2:53:08
 * @Description
 */
@EnableEurekaClient
@SpringBootApplication
//@RibbonClient(name="CLOUD-DEPT",configuration=Myrule.class)  加载自定义算法  注意自定义算法的包不能在启动类及其子包下
public class ConsumerDept {

	/**
	 * @param args
	 * @Description TODO
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConsumerDept.class, args);

	}

}

/**
 * 
 */
package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @author huangyuan
 * @date 2018年7月11日下午7:38:54
 * @Description
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {
public static void main(String[] args) {
	SpringApplication.run(EurekaServer.class, args);
	
	}	
}

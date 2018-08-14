/**
 * 
 */
package config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangyuan
 * @date 2018年7月21日上午10:05:22
 * @Description
 */
@RestController
public class ControllerTest {
	@Value("${spring.application.name}")
private String applicationname;
	@Value("${server.port}")
	private String port;
	@RequestMapping("/config")
	public String  getConfig() {
		return applicationname+"........使用端口"+port;
	}
}

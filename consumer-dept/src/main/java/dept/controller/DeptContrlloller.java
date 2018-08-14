/**
 * 
 */
package dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import entity.Dept;

/**
 * @author huangyuan
 * @date 2018年7月11日下午2:34:23
 * @Description  消费者
 */
@RestController
public class DeptContrlloller {
	//private static final String REST_URL_PREFIX="http://localhost:8081";
	private static final String REST_URL_PREFIX="http://CLOUD-DEPT/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consumer/dept/add")
	public boolean add(Dept dept) {
		Boolean postForObject = restTemplate.postForObject(REST_URL_PREFIX+"dept/add", dept, boolean.class);
		return postForObject;
	}
	@GetMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"dept/get/"+id, Dept.class);
	}
	@RequestMapping("/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX+"dept/list", List.class);
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
	//消费端调用服务发现
	@RequestMapping("/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/consumer/dept/discovery", Object.class);
	}
}

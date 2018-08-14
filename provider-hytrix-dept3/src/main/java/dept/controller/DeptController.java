/**
 * 
 */
package dept.controller;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ch.qos.logback.core.net.server.Client;
import dept.service.DeptService;
import entity.Dept;

/**
 * @author huangyuan
 * @date 2018年7月10日下午1:26:47
 * @Description
 */
@RestController
public class DeptController {
	@Autowired
	private DiscoveryClient discoveryClient; //服务发现 把自己给暴露出去

	
	@Autowired
	private DeptService service;
	
	@RequestMapping("/dept/discovery")
	public Object discovery() {
		List<String> list=discoveryClient.getServices();
		System.out.println("****"+list);
		
		List<ServiceInstance> serviceInstances=discoveryClient.getInstances("cloud-dept");//获取指定实例
		for(ServiceInstance element:serviceInstances) {
			System.out.println(element.getServiceId()+"***"+element.getHost()+"***"+element.getPort());
		}
		
		return discoveryClient;
	}
	
	@RequestMapping("/dept/add")
	public boolean add(Dept dept) {
		return service.add(dept);
	}
	//hystrix处理 服务异常时调用的方法
	@HystrixCommand(fallbackMethod="process_get")
	@RequestMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long deptno) {
		Dept dept = service.get(deptno);
		if (dept==null) {
			throw new RuntimeException("无该id");
		}
		return dept;
	}
	//这样写会造成逻辑混乱，耦合性高  所以把所有处理异常的方法放在客户端的dept-feign客户端中 进行服务降级
	public Dept process_get(@PathVariable("id") Long deptno) {
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDb_source("no this database");
		dept.setDname("no this id");
		return dept;
	}
	
	@RequestMapping("/dept/list")
	public List<Dept> list() {
		return service.list();
	}
}

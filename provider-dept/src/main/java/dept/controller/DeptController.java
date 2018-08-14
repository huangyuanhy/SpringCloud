/**
 * 
 */
package dept.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long deptno) {
		return service.get(deptno);
	}
	
	@RequestMapping("/dept/list")
	public List<Dept> list() {
		return service.list();
	}
}

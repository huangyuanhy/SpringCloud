package dept_feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Dept;
import service.DeptServiceFeign;

/**
 * @author huangyuan
 * @date 2018年7月11日下午2:34:23
 * @Description  消费者
 */
@RestController
public class DeptContrlloller {
	@Autowired
	private DeptServiceFeign service;
	
	@GetMapping("/consumer/dept/add")
	public boolean add(Dept dept) {
		return service.add(dept);
	}
	@GetMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}
	@RequestMapping("/consumer/dept/list")
	public List<Dept> list() {
		return service.list();
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
}

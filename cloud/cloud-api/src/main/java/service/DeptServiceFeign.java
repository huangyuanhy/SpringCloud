/**
 * 
 */
package service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Dept;

/**
 * @author huangyuan
 * @date 2018年7月17日下午10:26:34
 * @Description 专门生产接口 为 feign 所调用 面向接口编程
 */
@FeignClient(value="CLOUD-DEPT")
public interface DeptServiceFeign {
	@RequestMapping("/dept/add")
	public boolean add(Dept dept);
		
	
	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) ;
		
	
	@RequestMapping("/dept/list")
	public List<Dept> list() ;
		
	
}

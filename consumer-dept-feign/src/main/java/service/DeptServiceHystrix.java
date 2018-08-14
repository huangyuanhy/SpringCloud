/**
 * 
 */
package service;

import java.util.List;

import org.springframework.stereotype.Component;

import entity.Dept;
import feign.hystrix.FallbackFactory;

/**
 * @author huangyuan
 * @date 2018年7月18日下午9:59:02
 * @Description 将所有的熔断方法集中到service层  与业务逻辑解耦，统一管理熔断后的响应请求。
 */
@Component
public class DeptServiceHystrix implements FallbackFactory<DeptServiceFeign>{
	 
	public DeptServiceFeign create(Throwable throwable) {
		return new DeptServiceFeign() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				Dept dept = new Dept();
				dept.setDeptno(id);
				dept.setDb_source("no this database");
				dept.setDname("no this id");
				return dept;
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}

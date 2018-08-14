/**
 * 
 */
package dept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.stereotype.Service;

import dept.dao.DeptDao;
import entity.Dept;

/**
 * @author huangyuan
 * @date 2018年7月10日下午1:05:50
 * @Description
 */
@Service
public class DeptService {
	@Autowired
	private  DeptDao dao;
	
	public boolean add(Dept dept) {
		return dao.addDept(dept);
	}
	public Dept get(Long deptno) {
		return dao.findById(deptno);
	}
	public List<Dept> list(){
		return dao.findAll();
	}
}

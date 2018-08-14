/**
 * 
 */
package dept.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import entity.Dept;

/**
 * @author huangyuan
 * @date 2018年7月10日下午12:25:07
 * @Description
 */
@Mapper
public interface DeptDao {
	public boolean addDept(Dept dept);
	
	public Dept findById(Long deptno);
	
	public List <Dept> findAll();
}

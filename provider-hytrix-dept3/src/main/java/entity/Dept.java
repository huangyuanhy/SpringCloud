/**
 * 
 */
package entity;

import java.io.Serializable;

/**
 * @author huangyuan
 * @date 2018年7月9日下午6:43:33
 * @Description 实体类 部门
 * @Data ：注解在类上；提供类所有属性的 getting 和 setting 方法，
 */

public class Dept implements Serializable{
	private Long deptno;//主键
	private String dname;//部门名称
	private String db_source; //对应哪个数据库
	public long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDb_source() {
		return db_source;
	}
	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}
	public Dept(Long deptno, String dname, String db_source) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.db_source = db_source;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", db_source=" + db_source + "]";
	}
	
}

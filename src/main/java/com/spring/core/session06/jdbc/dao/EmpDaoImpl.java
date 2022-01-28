package com.spring.core.session06.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.core.session06.jdbc.entity.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> query() {
		String sql = "select eid, ename, age, createtime from emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}

	@Override
	public List<Emp> queryEmps() {
		String sql = "select eid, ename, age, createtime from emp";
		// 利用 BeanPropertyRowMapper 將資料逐筆注入到指定物件中
		List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
		return emps;
	}

	@Override
	public Optional<Emp> getOne(Integer eid) {
		String sql = "select eid, ename, age, createtime from emp where eid=?";
		Emp emp = jdbcTemplate.queryForObject(sql, Emp.class, eid);
		Optional<Emp> optEmp = Optional.ofNullable(emp);
		return optEmp;
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from emp";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
}

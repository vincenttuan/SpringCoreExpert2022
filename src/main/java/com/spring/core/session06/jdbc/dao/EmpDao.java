package com.spring.core.session06.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.core.session06.jdbc.entity.Emp;

public interface EmpDao {
	List<Map<String, Object>> query(); // 多筆查詢
	List<Emp> queryEmps(); // 多筆查詢
	Optional<Emp> getOne(Integer eid); // 單筆查詢
	Integer count(); // 查詢資料筆數
}

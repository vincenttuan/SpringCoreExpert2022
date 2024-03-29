package com.spring.core.session06.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.core.session06.jdbc.entity.Emp;

public interface EmpDao {
	// 建立 CRUD - Create(新增)、Read(查詢)、Update(修改)、Delete(刪除)
	// 查詢多筆
	List<Map<String, Object>> query(); // 多筆查詢
	List<Emp> queryEmps(); // 多筆查詢
	
	// 查詢單筆
	Optional<Emp> getOne(Integer eid); // 單筆查詢
	Integer count(); // 查詢資料筆數
	
	// 新增單筆
	int create(String name, Integer age);
	
	// 新增多筆
	int[] batchCreate(List<Object[]> list);
	
	// 修改
	int update(Integer eid, String ename, Integer age);
	
	// 刪除
	int delete(Integer eid);
	
}

package com.spring.core.session07.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer getPrice(Integer bookId) {
		// 取得書籍價格
		String sql = "Select book_price From book Where book_id = ?";
		Object[] args = {bookId};
		Integer bookPrice = jdbcTemplate.queryForObject(sql, args, Integer.class);
		return bookPrice;
	}

	@Override
	public Integer updateStock(Integer bookId) {
		// 1.檢查庫存
		String sql = "Select book_amount From stock Where book_id = ?";
		Object[] args = {bookId};
		Integer currentAmount = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if(currentAmount <= 0) { // 目前庫存量是否 <= 0 
			throw new RuntimeException("庫存量不足");
		}
		// 2.修改庫存(數量 - 1)
		sql = "Update stock set book_amount = book_amount - 1 Where book_id = ?";
		int rowcount = jdbcTemplate.update(sql, args);
		return rowcount;
	}

	@Override
	public Integer updateWallet(String username, Integer price) {
		// 1. 檢查餘額
		String sql = "Select balance From wallet Where username = ?";
		Object[] args = {username};
		int currentBalance = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if(currentBalance < price) { // 目前帳戶餘額 < 書本價格
			throw new RuntimeException("帳戶餘額不足");
		}
		// 2. 修改餘額
		sql = "Update wallet Set balance = balance - ? Where username = ?";
		int rowcount = jdbcTemplate.update(sql, price, username);
		return rowcount;
	}

}

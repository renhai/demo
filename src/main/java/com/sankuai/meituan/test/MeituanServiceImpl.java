package com.sankuai.meituan.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class MeituanServiceImpl implements MeituanService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void getUserIncome() {
		String sql = "select * from zb_user_income";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (list != null) {
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}
		}
	}
	
	@Override
	public void insert() {
		
		String sql = "insert into test_01(name, value) values(?,?)";
		jdbcTemplate.update(sql, "342", "asdfsdf");
		
		Integer.valueOf("ss");
		
		jdbcTemplate.update(sql, "sdfdsfdhhh", "34345");
		
	}
	
	@Override
	public void getIdList() {
		String sql = "select id from test_01";
		List<Integer> idList = jdbcTemplate.queryForList(sql, Integer.class);
		System.out.println(idList);
		Integer.valueOf("a");
	}
	

}

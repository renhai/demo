package me.renhai.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import redis.clients.jedis.Jedis;

public class JedisTest {
	static String host = "106.3.32.38";
	static int port = 6379;
	public static void main(String[] args) {
        new JedisTest().testHset();
	}
	
	void testHset() {
		Jedis j = null;
		try {
			j = new Jedis(host, port);
			Person p1 = new Person();
			p1.setId(111);
			p1.setName("andy");
			List<String> childs = new ArrayList<String>();
			childs.add("aaaa");
			childs.add("bbbb");
			p1.setChilds(childs);
			j.set(String.valueOf(p1.getId()).getBytes(), SerializationUtils.serialize(p1));
			
			byte[] rs = j.get(String.valueOf(p1.getId()).getBytes());
			Object obj = SerializationUtils.deserialize(rs);
			System.out.println(obj);
			
			Person p2 = new Person();
			p2.setId(222);
			p2.setName("qian");
			List<String> childs2 = new ArrayList<String>();
			childs2.add("cccc");
			childs2.add("dddd");
			p2.setChilds(childs2);
			
			j.hset("person".getBytes(), "p1".getBytes(), SerializationUtils.serialize(p1));
			j.hset("person".getBytes(), "p2".getBytes(), SerializationUtils.serialize(p2));
			
			byte[] rs2 = j.hget("person".getBytes(), "p2".getBytes());
			System.out.println(SerializationUtils.deserialize(rs2));
			
			System.out.println(p2);
			System.out.println(org.apache.commons.beanutils.BeanUtils.describe(p2));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (j != null) {
				j.close();
			}
		}
		
	}
}

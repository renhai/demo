package com.sankuai.meituan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkTest {
	
	@Benchmark
	@OutputTimeUnit(value = TimeUnit.NANOSECONDS)
	@BenchmarkMode(Mode.SampleTime)
	public void testToStringBuilder() {
		Person p = new Person();
		p.setId(234234);
		p.setName("andy");
		List<String> childs = new ArrayList<String>();
		childs.add("22");
		childs.add("43");
		p.setChilds(childs);
		ToStringBuilder.reflectionToString(p, ToStringStyle.SHORT_PREFIX_STYLE);
	
	}
	
	@Benchmark
	@OutputTimeUnit(value = TimeUnit.NANOSECONDS)
	@BenchmarkMode(Mode.SampleTime)
	public void testToString() {
		Person p = new Person();
		p.setId(234234);
		p.setName("andy");
		List<String> childs = new ArrayList<String>();
		childs.add("22");
		childs.add("43");
		p.setChilds(childs);
		p.toString();
	
	}

	
	public static void main(String[] args) throws RunnerException {
//		String value = String.format("http://api.mobile.meituan.com/locate/1/addr/latlng/{},{}", )
//		double lng = 323.23423443;
//		double lat = 1/1000000d;
//		String value = MessageFormat.format("http://api.mobile.meituan.com/locate/1/addr/latlng/{0,number,#.######},{1,number,#.######}", lng, lat);
//		System.out.println(value);
//		double ddd = 1/1000000d;
//		System.out.println(String.valueOf(ddd));
		

		Options opt = new OptionsBuilder()
				.include(BenchmarkTest.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();

		
		
	}
	


}

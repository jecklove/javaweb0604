package org.jgs1905.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 	学生实体类
 * 
 * @author junki
 * @date 2020年5月27日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	
	private Long id;
	
	private String name;
	
	private String sex;
	
	private Byte age;
	
	public String study() {
		System.out.println("我爱学习！");
		return "我爱学java";
	}
	
}

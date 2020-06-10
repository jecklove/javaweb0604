package org.jgs1905.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 * @author junki
 * @date 2020年5月28日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	private Long id;
	
	private String real_name;
	
	private String username;
	
	private String password;
	
}

package org.spring.model;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	String id;
	String pwd;
	String name;
	String email;
	Date joinDate;
}

package com.bkh.exam.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article{
	private String regDate;
	private String updateDate;
	private int memberId;
	private  int id;
	private  String title;
	private  String body;
}
package com.bitc.java.dto;

import lombok.Data;

@Data
public class NoticeBoardDto {

	private int idx;
	private String title;
	private String content;
	private String creatorId;
	private String createdDt;
	private int cnt;
	private int thumbsUp;
	private int thumbsDown;
	
}

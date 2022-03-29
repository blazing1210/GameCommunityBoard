package com.bitc.java.dto;

import lombok.Data;

@Data
public class CommentDto {

	private int idx;
	private int boardKey;
	private String creatorId;
	private String createdDt;
	private String comment;
	
}

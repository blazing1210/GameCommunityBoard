package com.bitc.java.service;

import java.util.List;

import com.bitc.java.dto.CommentDto;
import com.bitc.java.dto.MemberDto;
import com.bitc.java.dto.NoticeBoardDto;
import com.bitc.java.dto.UserBoardDto;
import com.github.pagehelper.Page;

public interface BoardService {
	
	//공지사항 서비스

	Page<NoticeBoardDto> openNoticeBoard(int pageNum) throws Exception;

	void insertNoticeBoard(NoticeBoardDto dto) throws Exception;

	NoticeBoardDto openDetailNoticeBoard(int idx) throws Exception;
	
	void noticeThumbsUp(int idx) throws Exception;

	void noticeThumbsDown(int idx) throws Exception;

	void addCnt(int idx) throws Exception;

	void updateNoticeBoard(NoticeBoardDto dto)throws Exception;

	void deleteNoticeBoard(int idx)throws Exception;

	Page<UserBoardDto> openUserBoard(int pageNum)throws Exception;

	void insertUserBoard(UserBoardDto dto) throws Exception;

	UserBoardDto openDetailUserBoard(int idx)throws Exception;
	
	public List<CommentDto> openDetailComment(int idx) throws Exception;
	
	void insertComment(CommentDto comment) throws Exception;
	

	void deleteComment(int idx) throws Exception;
	
	void userThumbsUp(int idx) throws Exception;

	void userThumbsDown(int idx) throws Exception;

	void useraddCnt(int idx)throws Exception;

	void updateUserBoard(UserBoardDto dto) throws Exception;

	void deleteUserBoard(int idx) throws Exception;

	void replyUserBoard(UserBoardDto dto)throws Exception;
	
	//계정 서비스

	int getLevel(String userId) throws Exception;

	int loginCheck(String userId, String userPw) throws Exception;
	
	public void createAccount(MemberDto member) throws Exception;

	public int IDCheck(String userId) throws Exception;
	
	public List<MemberDto> openMemberList() throws Exception;

	public void deleteAccount(int seq) throws Exception;

	public void updateAccount(MemberDto members)throws Exception;





}

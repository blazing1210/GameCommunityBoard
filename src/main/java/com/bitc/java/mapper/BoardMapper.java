package com.bitc.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.java.dto.CommentDto;
import com.bitc.java.dto.MemberDto;
import com.bitc.java.dto.NoticeBoardDto;
import com.bitc.java.dto.UserBoardDto;
import com.github.pagehelper.Page;

@Mapper

public interface BoardMapper {

	//게시판mapper
	
	public Page<NoticeBoardDto> openNoticeBoard() throws Exception;

	public void insertNoticeBoard(NoticeBoardDto dto) throws Exception;

	public NoticeBoardDto openDetailNoticeBoard(int idx) throws Exception;
	
	public void noticeThumbsDown(int idx)throws Exception;

	public void noticeThumbsUp(int idx) throws Exception;

	public void addCnt(int idx) throws Exception;

	public void updateNoticeBoard(NoticeBoardDto dto)throws Exception;

	public void deleteNoticeBoard(int idx)throws Exception;

	public Page<UserBoardDto> openUserBoard() throws Exception;

	public void insertUserBoard(UserBoardDto dto)throws Exception;

	public void useraddCnt(int idx)throws Exception;

	public UserBoardDto openDetailUserBoard(int idx) throws Exception;
	
	public List<CommentDto> openDetailComment(int idx) throws Exception;	

	public void insertComment(CommentDto comment)throws Exception;
	
	public void deleteComment(int idx) throws Exception;

	public void userThumbsDown(int idx)throws Exception;

	public void userThumbsUp(int idx) throws Exception;
	
	public void updateUserBoard(UserBoardDto dto)throws Exception;

	public void deleteUserBoard(int idx)throws Exception;

	public void replyUserBoard(UserBoardDto dto)throws Exception;

	//계정mapper
	
	public int getLevel(String userId) throws Exception;

	public int loginCheck(@Param("userId")String userId,@Param("userPw") String userPw)throws Exception;

	void createAccount(MemberDto member) throws Exception;

	int IDCheck(String userId) throws Exception;

	List<MemberDto> openMemberList() throws Exception;

	void deleteAccount(int seq) throws Exception;

	void updateAccount(MemberDto members)throws Exception;




}

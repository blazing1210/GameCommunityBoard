package com.bitc.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.java.dto.CommentDto;
import com.bitc.java.dto.MemberDto;
import com.bitc.java.dto.NoticeBoardDto;
import com.bitc.java.dto.UserBoardDto;
import com.bitc.java.mapper.BoardMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper; 
	
	//게시판 서비스
	
	@Override
	public Page<NoticeBoardDto> openNoticeBoard(int pageNum) throws Exception {
		
		PageHelper.startPage(pageNum,10);
		return boardMapper.openNoticeBoard();
	}

	@Override
	public void insertNoticeBoard(NoticeBoardDto dto) throws Exception {
		
		boardMapper.insertNoticeBoard(dto);
		
	}

	@Override
	public NoticeBoardDto openDetailNoticeBoard(int idx) throws Exception {
		boardMapper.addCnt(idx);
		return boardMapper.openDetailNoticeBoard(idx);
	}

	@Override
	public void addCnt(int idx) throws Exception {
		boardMapper.addCnt(idx);
	}

	@Override
	public void updateNoticeBoard(NoticeBoardDto dto) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.updateNoticeBoard(dto);
	}

	@Override
	public void deleteNoticeBoard(int idx) throws Exception {
		
		boardMapper.deleteNoticeBoard(idx);
		
	}

	@Override
	public void noticeThumbsUp(int idx) throws Exception {
		
		boardMapper.noticeThumbsUp(idx);
		
	}

	@Override
	public void noticeThumbsDown(int idx) throws Exception {
		
		boardMapper.noticeThumbsDown(idx);
		
	}
	
	@Override
	public Page<UserBoardDto> openUserBoard(int pageNum) throws Exception {
	
		PageHelper.startPage(pageNum,10);
		
		return boardMapper.openUserBoard();
	}

	@Override
	public void insertUserBoard(UserBoardDto dto) throws Exception {
		
		boardMapper.insertUserBoard(dto);
		
	}

	@Override
	public void deleteComment(int idx) throws Exception {
		
		boardMapper.deleteComment(idx);
		
	}
	
	@Override
	public UserBoardDto openDetailUserBoard(int idx) throws Exception {
		
		return boardMapper.openDetailUserBoard(idx);
	}
	
	@Override
	public List<CommentDto> openDetailComment(int idx) throws Exception {
		
		return boardMapper.openDetailComment(idx);
	}

	@Override
	public void insertComment(CommentDto comment) throws Exception {
		
		boardMapper.insertComment(comment);		
	}
	
	@Override
	public void userThumbsUp(int idx) throws Exception {
		
		boardMapper.userThumbsUp(idx);
		
	}

	@Override
	public void userThumbsDown(int idx) throws Exception {
		
		boardMapper.userThumbsDown(idx);
		
	}
	
	@Override
	public void useraddCnt(int idx) throws Exception {
		boardMapper.useraddCnt(idx);
		
	}

	@Override
	public void updateUserBoard(UserBoardDto dto) throws Exception {
		
		boardMapper.updateUserBoard(dto);
		
	}

	@Override
	public void deleteUserBoard(int idx) throws Exception {
		boardMapper.deleteUserBoard(idx);
		
	}

	@Override
	public void replyUserBoard(UserBoardDto dto) throws Exception {
		
		boardMapper.replyUserBoard(dto);
		
	}

	//계정 서비스
	
	@Override
	public int getLevel(String userId) throws Exception {
		
		return boardMapper.getLevel(userId);
	}

	@Override
	public int loginCheck(String userId, String userPw) throws Exception {
		
		return boardMapper.loginCheck(userId,userPw);
	}

	@Override
	public void createAccount(MemberDto member) throws Exception {
		
		boardMapper.createAccount(member);
		
	}

	@Override
	public int IDCheck(String userId) throws Exception {
		
		return boardMapper.IDCheck(userId);
	}

	@Override
	public List<MemberDto> openMemberList() throws Exception {
		
		return boardMapper.openMemberList();
	}

	@Override
	public void deleteAccount(int seq) throws Exception {
		
		boardMapper.deleteAccount(seq);
		
	}

	@Override
	public void updateAccount(MemberDto members) throws Exception {
		boardMapper.updateAccount(members);
		
	}






}

package com.bitc.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.java.dto.CommentDto;
import com.bitc.java.dto.NoticeBoardDto;
import com.bitc.java.dto.UserBoardDto;
import com.bitc.java.service.BoardService;
import com.github.pagehelper.PageInfo;

@Controller
public class boardController {

	@Autowired
	private BoardService boardService;
	
	//공지사항페이지
	@RequestMapping(value="noticeBoard",method=RequestMethod.GET)
	public ModelAndView openNoticeBoard(@RequestParam(required=false,
			defaultValue="1") int pageNum) throws Exception{
		ModelAndView mv = new ModelAndView("board/blueMain");
		
		PageInfo<NoticeBoardDto> NoticeBoardList=new PageInfo<>(boardService.openNoticeBoard(pageNum),5);
		
		mv.addObject("NoticeBoardList",NoticeBoardList);
		
		return mv;
	}
	
	//글쓰기페이지
	@RequestMapping(value="noticeBoard/write",method=RequestMethod.GET)
	public String writeNoticeBoard() throws Exception{
		
		return "board/writeNoticeBoard";
	}

	//글쓰기 쿼리문
	@ResponseBody
	@RequestMapping(value="noticeBoard/write",method=RequestMethod.POST)
	public void insertNoticeBoard(NoticeBoardDto dto) throws Exception{
		boardService.insertNoticeBoard(dto);
		
	}
	
	//공지사항 상세보기
	@RequestMapping(value="noticeBoard/{idx}",method=RequestMethod.GET)
	public ModelAndView openDetailNoticeBoard(@PathVariable("idx")int idx) throws Exception{
		ModelAndView mv=new ModelAndView("board/detailNoticeBoard");
		
		NoticeBoardDto board=boardService.openDetailNoticeBoard(idx);
		
		boardService.addCnt(idx);
		
		mv.addObject("board",board);
		
		return mv;
	}
	
	//공지사항 추천
	@ResponseBody
	@RequestMapping(value="noticeBoard/update/tbup",method=RequestMethod.PUT)
	public void noticeThumbsUp(int idx) throws Exception {
		boardService.noticeThumbsUp(idx);
	}
	
	//공지사항 비추천
	@ResponseBody
	@RequestMapping(value="noticeBoard/update/tbdown",method=RequestMethod.PUT)
	public void noticeThumbsDown(int idx) throws Exception {
		boardService.noticeThumbsDown(idx);
	}
	
	//공지사항 수정페이지
	@RequestMapping(value="noticeBoard/update/{idx}",method=RequestMethod.GET)
	public ModelAndView updateNoticeBoardpage(@PathVariable("idx")int idx) throws Exception{
		ModelAndView mv=new ModelAndView("board/updateNoticeBoard");
		
		NoticeBoardDto board=boardService.openDetailNoticeBoard(idx);
		
		mv.addObject("board",board);
		
		return mv;
	}
	
	
	
	//공지사항수정쿼리문
	@ResponseBody
	@RequestMapping(value="noticeBoard/update",method=RequestMethod.PUT)
	public void updateNoticeBoard(NoticeBoardDto dto)throws Exception{
		
		boardService.updateNoticeBoard(dto);
		
	}
	
	//공지사항삭제쿼리문
	@ResponseBody
	@RequestMapping(value="noticeBoard/update/{idx}",method=RequestMethod.DELETE)
	public void deleteNoticeBoard(@PathVariable("idx")int idx)throws Exception{
		
		boardService.deleteNoticeBoard(idx);
	}

	//자유게시판 페이지
	@RequestMapping(value="userBoard",method=RequestMethod.GET)
	public ModelAndView openUserBoard(@RequestParam(required=false,
			defaultValue="1")int pageNum )throws Exception{
		
		ModelAndView mv=new ModelAndView("board/userBoard");
		
		PageInfo<UserBoardDto> userBoardList=new PageInfo<>(boardService.openUserBoard(pageNum),5);
		
		mv.addObject("userBoardList",userBoardList);
		
		
		return mv;
	}
	
	//자유게시판 글쓰기페이지
		@RequestMapping(value="userBoard/write",method=RequestMethod.GET)
		public String writeUserBoard() throws Exception{
			
			return "board/writeUserBoard";
		}
	//자유게시판 글쓰기쿼리문
		@ResponseBody
		@RequestMapping(value="userBoard/write",method=RequestMethod.POST)
		public void insertUserBoard(UserBoardDto dto) throws Exception{
			boardService.insertUserBoard(dto);
		}	
	
	//자유게시판 자세히보기
		@RequestMapping(value="userBoard/{idx}",method=RequestMethod.GET)
		public ModelAndView openDetailUserBoard(@PathVariable("idx")int idx) throws Exception{
			ModelAndView mv=new ModelAndView("board/detailUserBoard");
			
			UserBoardDto board=boardService.openDetailUserBoard(idx);
			
			List<CommentDto> commentList=new ArrayList<>();
			
			commentList=boardService.openDetailComment(idx);
			
			boardService.useraddCnt(idx);
			
			mv.addObject("board",board);
			mv.addObject("commentList",commentList);
			
			return mv;
		}
		
		//자유게시판 댓글입력
		
		@ResponseBody
		@RequestMapping(value="userBoard/comment",method=RequestMethod.POST)
		public void insertComment(CommentDto comment) throws Exception{
			
			boardService.insertComment(comment);
			
		}
		//자유게시판 댓글삭제
		
		@ResponseBody
		@RequestMapping(value="userBoard/comment",method=RequestMethod.DELETE)
		public void deleteComment(int idx)throws Exception{
			boardService.deleteComment(idx);
		}
		
		//자유게시판 수정하기
		@RequestMapping(value="userBoard/update/{idx}",method=RequestMethod.GET)
		public ModelAndView updateUserBoardpage(@PathVariable("idx")int idx) throws Exception{
			ModelAndView mv=new ModelAndView("board/updateUserBoard");
			
			UserBoardDto board=boardService.openDetailUserBoard(idx);
			
			mv.addObject("board",board);
			
			return mv;
		}
		
		//공지사항 추천
		@ResponseBody
		@RequestMapping(value="userBoard/update/tbup",method=RequestMethod.PUT)
		public void userThumbsUp(int idx) throws Exception {
			boardService.userThumbsUp(idx);
		}
		
		//공지사항 비추천
		@ResponseBody
		@RequestMapping(value="userBoard/update/tbdown",method=RequestMethod.PUT)
		public void userThumbsDown(int idx) throws Exception {
			boardService.userThumbsDown(idx);
		}
		
		
		//자유게시판 수정쿼리문	
		@ResponseBody
		@RequestMapping(value="userBoard/update",method=RequestMethod.PUT)
		public void updateUserBoard(UserBoardDto dto)throws Exception{
			
			boardService.updateUserBoard(dto);
			
		}
		
		//자유게시판 삭제쿼리문
		@ResponseBody
		@RequestMapping(value="userBoard/update/{idx}",method=RequestMethod.DELETE)
		public void deleteUserBoard(@PathVariable("idx")int idx)throws Exception{
			
			boardService.deleteUserBoard(idx);
		}
		
	//자유게시판 답글달기
		@RequestMapping(value="userBoard/reply",method=RequestMethod.GET)
		public ModelAndView replyUserBoardPage(UserBoardDto dto)throws Exception{
			ModelAndView mv=new ModelAndView("board/replyUserBoard");
			
			
			mv.addObject("board",dto);
			
			return mv;
		}
		
	//자유게시판 답글쿼리문
		@ResponseBody
		@RequestMapping(value="userBoard/reply",method=RequestMethod.POST)
		public void replyUserBoard(UserBoardDto dto) throws Exception{
	
			boardService.replyUserBoard(dto);
		}	

}

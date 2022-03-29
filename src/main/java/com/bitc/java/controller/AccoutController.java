package com.bitc.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.java.dto.MemberDto;
import com.bitc.java.service.BoardService;

@Controller
public class AccoutController {

	//아카이브 controller
	@Autowired
	private BoardService boardService;
	
		//로그인
		@RequestMapping(value="/login",method=RequestMethod.GET)
		public String openloginpage()throws Exception{
			return "/account/loginpage";
		}
		
		//로그인프로세스
		@ResponseBody
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public Object loginCheck(MemberDto member,HttpServletRequest request) throws Exception{
			
			Map<String, Object> map = new HashMap<>();
			
			int count=boardService.loginCheck(member.getUserId(),member.getUserPw());
			
			if(count==1) {
				HttpSession session=request.getSession();
				session.setAttribute("userId",member.getUserId());
				session.setAttribute("level",boardService.getLevel(member.getUserId()));
				

				map.put("result", "success");
				
				
			}else {
				map.put("result", "error");
			}
			return map;
		}
		
		//로그아웃페이지
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request) throws Exception{
			HttpSession session = request.getSession();
			
			session.removeAttribute("userId");
			session.removeAttribute("level");
			session.invalidate();
			
			return "redirect:/noticeBoard";
		}
		
		//로그인 실패페이지
		@RequestMapping("/login/loginFail")
		public String loginFail() throws Exception{
			return "/account/loginFail";
		}
		
		//아이디 중복체크
		@ResponseBody
		@RequestMapping(value="/login/duplication",method=RequestMethod.POST)
		public Object duplication(@RequestParam("userId") String userId) throws Exception{
			
			Map<String, Object> map = new HashMap<>();
			
			int result = boardService.IDCheck(userId);
			
			if (result == 1) {
				map.put("result", "error");
			}
			else {
				map.put("result", "success");
				map.put("value", 1);
			}

			return map;

		}
		
		//회원가입페이지
		@RequestMapping(value="/signup",method=RequestMethod.GET)
		public String signuppage()throws Exception{
			return "/account/signUp";
		}
		

		
		//계정 관리하기
		@RequestMapping(value="/account",method=RequestMethod.GET)
		public ModelAndView openMemberList() throws Exception{
			
			ModelAndView mv=new ModelAndView("/account/accountManage");
			
			List<MemberDto> memberList=new ArrayList<>();
			
			memberList=boardService.openMemberList();
			
			mv.addObject("memberList",memberList);
			
			return mv;
		}

		//회원가입 계정 추가
		@RequestMapping(value="/signup",method=RequestMethod.POST)
		public String createAccount(MemberDto member) throws Exception{
			
			boardService.createAccount(member);
			
			return "redirect:/login";
		}
		
		//계정삭제
		@ResponseBody
		@RequestMapping(value="/account",method=RequestMethod.DELETE)
		public void deleteAccount(int seq) throws Exception{
		
			
			boardService.deleteAccount(seq);
			
			
		}
		
		//계정수정
		
		@RequestMapping(value="/account",method=RequestMethod.PUT)
		public String updateAccount(MemberDto members) throws Exception{
			
			boardService.updateAccount(members);
			
			return "redirect:/account";
		}
		
		//리뷰삭제
}
package com.bkh.exam.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bkh.exam.demo.service.MemberService;
import com.bkh.exam.demo.vo.Rq;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor {
	private Rq rq;
	
	public BeforeActionInterceptor(Rq rq) {
		this.rq = rq;
	}
	@Autowired
	private MemberService memberService;
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
//		Rq rq = new Rq(req, resp, memberService);
//		req.setAttribute("rq", rq);
// 		자동으로 Rq객체를 생성하기 때문에 더 이상 필요 없음.
		rq.initonBeforeActionInterceptor();

		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}
} 

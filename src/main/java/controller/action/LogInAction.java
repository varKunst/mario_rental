package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Member;
import member.controller.MemberDao;

public class LogInAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDao memberDao = MemberDao.getInstance();
		ArrayList<Member> list = memberDao.getMemberAll();
		
		boolean logIn = false;
		
		for(Member member: list) {
			if(member.getId().equals(id) && member.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("log", member);
				logIn = true;
				memberDao.logIn(id);
			}
		}
		
		if(logIn)
			response.sendRedirect("myPage");
		else
			response.sendRedirect("logIn");
	}
}
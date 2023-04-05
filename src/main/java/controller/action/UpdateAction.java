package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Member;
import member.MemberRequestDto;
import member.controller.MemberDao;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("log");
		MemberDao memberDao = MemberDao.getInstance();
		MemberRequestDto memberDto = new MemberRequestDto(id, password, name);
		memberDao.updateMember(memberDto);
		
		int code = member.getCode();
		password = memberDto.getPassword();
		name = memberDto.getName();
		
		Member log = new Member(code, id, password, name, null, null);
		session.setAttribute("log", log);
		
		response.sendRedirect("myPage");
	}
}

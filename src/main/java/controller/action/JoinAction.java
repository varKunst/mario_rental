package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Member;
import member.MemberRequestDto;
import member.controller.MemberDao;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 등록 처리 로직

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberRequestDto memberDto = new MemberRequestDto(id, password, name);
		
		MemberDao memberDao = MemberDao.getInstance();
		Member dupl = memberDao.getMemberById(id);
		
		if(dupl==null) {
			memberDao.createMember(memberDto);
			response.sendRedirect("logIn");		
		} else {
			String joinFailed = String.format("/join?id=%s&name=%s", id, name);
			response.sendRedirect(joinFailed);
		}
	}
}

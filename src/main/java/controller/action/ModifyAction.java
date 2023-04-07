package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardRequestDto;
import board.controller.BoardDao;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int number = Integer.parseInt(request.getParameter("number"));
		String type = request.getParameter("type");
		
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.UpdateBoard(number, type);
		
		String back = type.equals("1")? "notice": "review";		
		response.sendRedirect(back);
	}
}

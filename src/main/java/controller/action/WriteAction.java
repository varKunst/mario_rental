package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardRequestDto;
import board.controller.BoardDao;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writer = Integer.parseInt(request.getParameter("writer"));
		String type = request.getParameter("type");
		String back = type.equals("1")? "notice": "review";
				
		BoardRequestDto boardDto = new BoardRequestDto(writer, title, content, type);
		BoardDao boardDao = BoardDao.getInstance();
		
		boardDao.createBoard(boardDto);
		response.sendRedirect(back);
	}
}

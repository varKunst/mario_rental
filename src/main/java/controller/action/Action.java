package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 인터페이스는 메소드의 집합
// ㄴ 물려받는 자식 클래스가 정의해야 하는 메소드의 선언부만 나열
public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

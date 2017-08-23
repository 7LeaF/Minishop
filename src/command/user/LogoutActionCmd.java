package command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;

public class LogoutActionCmd implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//��� ����
		System.out.println("LogoutActionCmd-Start");
		
		HttpSession session= request.getSession();
		session.invalidate();
		
		
		System.out.println("LogoutActionCmd-End");
		return "/main.jsp";
		
	}//end execute method
}//end class

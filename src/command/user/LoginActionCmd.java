package command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;

public class LoginActionCmd implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//��� ����
		System.out.println("LoginActionCmd-Start");
		
		HttpSession session= request.getSession();
		
		
		String userId= request.getParameter("userId");
		session.setAttribute("userId", userId);
		
		System.out.println(userId);
		
		
		System.out.println("LoginActionCmd-End");
		return "/main.jsp";
		
	}//end execute method
}//end class

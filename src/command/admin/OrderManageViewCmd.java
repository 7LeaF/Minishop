package command.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import dao.OrderDao;
import vo.OrderVo;

public class OrderManageViewCmd implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		String userIdPk = (String)session.getAttribute("userId");
		System.out.println(userIdPk);
		OrderDao orderDao = new OrderDao();
		ArrayList<OrderVo> order = orderDao.orderOrderCheckView(userIdPk);
		request.setAttribute("order", order);
		
		return "/admin/order_manage.jsp";
		
	}//end execute method
}//end class

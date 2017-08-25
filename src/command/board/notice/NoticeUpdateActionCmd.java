package command.board.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import dao.NoticeBoardDao;
import util.str.StrUtil;
import vo.NoticeBoardVo;

public class NoticeUpdateActionCmd implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//��� ����
		System.out.println("NoticeUpdateActionCmd-Start");
		
		HttpSession session= request.getSession();
		
		String userId= null;
		int noticeIdx= 0;
		NoticeBoardDao dao= new NoticeBoardDao();
		
		if(session.getAttribute("userId")!= null){
			userId= (String) session.getAttribute("userId");
		}
		
		if(request.getParameter("noticeIdx")!= null){
			noticeIdx= Integer.parseInt(request.getParameter("noticeIdx"));
		}
		
			
		//�α��� üũ
		if(userId== null){
			request.setAttribute("errorType", "isNotLogin");
			return "/error/boardUpdateError.jsp";	
		}
		
		//�Խñ� ��ȣ �Ķ���� ���� �������� ���� �����ͺ��̽� ���� ����
		if(noticeIdx <= 0 || dao.getNextIdx() <= noticeIdx){
			request.setAttribute("errorType", "invalidContent");
			return "/error/boardUpdateError.jsp";
		}
		
		
		//�� �ۼ��ڰ� �ƴ� ��� �ۼ��� ����
		NoticeBoardVo vo= dao.getBoard(noticeIdx);
		
		if(!userId.equals(vo.getNoticeWriter())){
			request.setAttribute("errorType", "notAuth");
			return "/error/boardUpdateError.jsp";
		}
		
		//�Է� �� �� ����ִ� ���� �ִ� ��� üũ
		if(request.getParameter("noticeTitle")== null || request.getParameter("noticeContent")== null
				|| request.getParameter("noticeTitle").equals("") || request.getParameter("noticeContent").equals("")){
			request.setAttribute("errorType", "isNull");
			return "/error/boardUpdateError.jsp";
			
		}
		
		
		//XSS ��ũ��Ʈ ����
		StrUtil strUtil= new StrUtil();
		
		String noticeTitle= strUtil.cleanXSS(request.getParameter("noticeTitle"));
		String noticeContent= strUtil.cleanXSS(request.getParameter("noticeContent"));
		
		//�� ������Ʈ
		int result= dao.update(noticeIdx, noticeTitle, noticeContent);
		
		
		if(result== -1){
			request.setAttribute("errorType", "updateFail");
			return "/error/boardUpdateError.jsp";
			
		}else{
			System.out.println("NoticeUpdateActionCmd-End");
			return "NoticeContentView.do?noticeIdx="+noticeIdx;	
		
		}

		
	}//end execute method
}//end class

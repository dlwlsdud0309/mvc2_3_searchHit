package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;


public class NbInsertProController implements NbController{

//	HttpServletRequest httpSession;
//	HttpServlet session;
	//ServletRequest session;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbInsertProController mvc2 신호");
		
		//String num = request.getParameter("no");
		//System.out.println("nummmmmm"+num);
		String title = request.getParameter("title");
//		String loginId = (String)httpSession.getAttribute("loginId");
		//HttpSession session = session.getSession(false);
		//String loginId = (String)session.getAttribute("loginId");
		String loginId = request.getParameter("loginId");
		//String sendInsertProWriterId = (String)request.getAttribute("sendInsertProWriterId");
		//String loginId = (String)session.getAttribute("writerId");
		//String loginId = (String)request.getAttribute("writerId");
		
		
		System.out.println("InsertPro title : "+title);
		System.out.println("InsertPro loginId : "+loginId);
		String content = request.getParameter("content");

		NoticeBoards nb = new NoticeBoards();
		nb.setTitle(title);
		nb.setWriter(loginId);
		//nb.setWriter(sendInsertProWriterId);
		nb.setContent(content);

		NoticeBoardsDao dao = new NoticeBoardsDao();
		int resultNum = dao.insert(nb);
		
		//nb = dao.getNBD(num);
		
		//request.setAttribute("nb", nb);
		
		if(resultNum>0){
			//둘 다 사용가능
			request.getRequestDispatcher("noticeboards.jsp").forward(request, response);
			//response.sendRedirect("noticeboards.jsp");
		}
		
	}
}

package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;

public class NbEditController implements NbController{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbEditController mvc2 신호");
		
		String num = request.getParameter("no");

		NoticeBoardsDao dao = new NoticeBoardsDao();
		NoticeBoards nb = dao.getNBD(num);

		if(num==null){
			System.out.println("null");
			response.sendRedirect("noticeboards.jsp");
			return;
			//참조사이트 : https://findmypiece.tistory.com/55
		}

		
		request.setAttribute("nb", nb);
		
		request.getRequestDispatcher("noticeboardsEdit.jsp").forward(request, response);
	}
}

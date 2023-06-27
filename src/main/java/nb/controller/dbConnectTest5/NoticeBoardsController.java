package nb.controller.dbConnectTest5;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;

public class NoticeBoardsController implements NbController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeBoardsContoller mvc2 신호");
	
		String field = request.getParameter("search");
		System.out.println("field : "+field);
		if(field==null || field.equals("")) {
			field="title";
		}
		
		String questionVal = request.getParameter("questionVal");
		System.out.println("questionVal : "+questionVal);
		if(questionVal==null) {
			questionVal="";
		}
		
		NoticeBoardsDao dao = new NoticeBoardsDao();
		List<NoticeBoards> list = dao.getList(field, questionVal);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("noticeboards.jsp").forward(request, response);
	}
}

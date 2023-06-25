package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;

public class NbEditProcController implements NbController{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbEditProcController mvc2 신호");
		
		String num = request.getParameter("no");

		if(num==null){
			System.out.println("null");
			response.sendRedirect("noticeboards.jsp");
			return;
			//참조사이트 : https://findmypiece.tistory.com/55
		}

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		NoticeBoards nb = new NoticeBoards();
		nb.setTitle(title);
		nb.setContent(content);
		nb.setSeq(Integer.parseInt(num));

		NoticeBoardsDao dao = new NoticeBoardsDao();
		int cnt = dao.edit(nb);
		
//		if(cnt>0){
//			//System.out.println("cnt : "+cnt); //결과값 1
//			response.sendRedirect("noticeboardsDetail.jsp?no="+num);
//		}
		
		
		//detail로 이동하도록 처리
		nb = dao.getNBD(num);
		
		request.setAttribute("nb", nb);
		request.getRequestDispatcher("noticeboardsDetail.jsp").forward(request, response);
	}
}

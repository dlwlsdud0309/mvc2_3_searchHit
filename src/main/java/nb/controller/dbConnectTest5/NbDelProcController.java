package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;

public class NbDelProcController implements NbController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbDelProcController mvc2 신호");
		
		String num = request.getParameter("no");

		if(num==null){
			response.sendRedirect("noticeboards.jsp");
			return;
		}

		NoticeBoards nb = new NoticeBoards();
		nb.setSeq(Integer.parseInt(num));

		NoticeBoardsDao dao = new NoticeBoardsDao();
		int cnt = dao.delete(nb);
		
		if(cnt>0){
			response.sendRedirect("noticeboards.jsp");
		}
	}
}

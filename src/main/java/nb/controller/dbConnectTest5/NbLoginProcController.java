package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;
import nb.dao.NbMember;
import nb.dao.NbMemberDao;

public class NbLoginProcController implements NbController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbLoginProcController mvc2 신호");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		System.out.println("id : "+id);
		System.out.println("pass : "+pass);
		
		NbMemberDao mDao = new NbMemberDao();
		NbMember m = mDao.getMember();
		
		request.getRequestDispatcher("loginForm.jsp").forward(request, response);
	}
}
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
		
		String uid = request.getParameter("id");
		String password = request.getParameter("pass");
		
		System.out.println("id : "+uid);
		System.out.println("pass : "+password);
		
		NbMemberDao mDao = new NbMemberDao();
		NbMember m = mDao.getMember(uid);
		
//		System.out.println("uid : "+uid+", m.getId : "+m.getId());
		//없는 아이디는 출력이 되지 않는 것 같다(m.getId)
		
		request.getRequestDispatcher("loginForm.jsp").forward(request, response);
	}
}

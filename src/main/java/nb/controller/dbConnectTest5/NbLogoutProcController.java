package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;

public class NbLogoutProcController implements NbController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbLogoutProcController mvc2 신호");
		
		request.getSession().invalidate(); //모든 세션 제거
		response.sendRedirect("../dbConnectTest5_notices/noticeboards.do");
		
	}
}

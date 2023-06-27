package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;

public class NbLoginController implements NbController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbLoginController mvc2 확인");
		
		request.getRequestDispatcher("loginForm.jsp").forward(request, response);
	}
}

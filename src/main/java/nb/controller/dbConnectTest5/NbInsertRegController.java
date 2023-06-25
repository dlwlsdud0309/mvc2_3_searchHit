package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;

public class NbInsertRegController implements NbController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbRegController mvc2 신호");
		
		//화면 전환
		request.getRequestDispatcher("nbInsertReg.jsp").forward(request, response);
	}
}

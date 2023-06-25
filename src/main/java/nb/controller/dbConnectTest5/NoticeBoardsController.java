package nb.controller.dbConnectTest5;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.NbController;

public class NoticeBoardsController implements NbController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeBoardsContoller mvc2 신호");
	
		String field = request.getParameter("search");
		System.out.println("field : "+field);
	
		String questionVal = request.getParameter("questionVal");
		System.out.println("questionVal : "+questionVal);
	}
}

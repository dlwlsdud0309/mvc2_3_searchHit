package nb.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.dbConnectTest5.NbDelProcController;
import nb.controller.dbConnectTest5.NbDetailController;
import nb.controller.dbConnectTest5.NbEditController;
import nb.controller.dbConnectTest5.NbEditProcController;
import nb.controller.dbConnectTest5.NbInsertProController;
import nb.controller.dbConnectTest5.NbInsertRegController;
import nb.controller.dbConnectTest5.NbLoginController;
import nb.controller.dbConnectTest5.NbLoginProcController;
import nb.controller.dbConnectTest5.NoticeBoardsController;

public class MyDispatcher extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(".do 신호 확인");
		
		String uri = request.getRequestURI(); // /ContextPath(=Context root)명/폴더명/파일명.do
		String conPath = request.getContextPath(); // /ContextPath(=Context root) 명
		String com = uri.substring(conPath.length());// /ContextPath(=Context root) 명 제외한 /폴더명/파일명.do
//		System.out.println("uri : "+uri);
//		System.out.println("conPath : "+conPath);
		System.out.println("com : "+com);
//		System.out.println(conPath.length());
		
//		NbDetailController controller1 = new NbDetailController();
//		NbEditController controller2 = new NbEditController();
		NbController nbController = null;
		
		
		try {
			if(com.equals("/dbConnectTest5_notices/noticeboardsDetail.do")) {
//				controller1.execute(request, response);
				nbController = new NbDetailController();
			}else if(com.equals("/dbConnectTest5_notices/noticeboardsEdit.do")) {
//				controller2.execute(request, response);
				nbController = new NbEditController();
			}else if(com.equals("/dbConnectTest5_notices/noticeboardsEditProc.do")) {
//				controller2.execute(request, response);
				nbController = new NbEditProcController();
			}else if(com.equals("/dbConnectTest5_notices/nbInsertReg.do")) {
				nbController = new NbInsertRegController();
			}else if(com.equals("/dbConnectTest5_notices/nbInsertPro.do")) {
				nbController = new NbInsertProController();
			}else if(com.equals("/dbConnectTest5_notices/noticeboardsDelProc.do")) {
				nbController = new NbDelProcController();
			}else if(com.equals("/dbConnectTest5_notices/noticeboards.do")) {
				nbController = new NoticeBoardsController();
			}else if(com.equals("/dbConnectTest5_login/loginForm.do")) {
				nbController = new NbLoginController();
			}else if(com.equals("/dbConnectTest5_login/loginProc.do")) {
				nbController = new NbLoginProcController();
			}
				
			nbController.execute(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

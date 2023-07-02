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
		
		if(m == null) {
			request.setAttribute("error", "아이디 없음");
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
//			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}else if(!m.getPwd().equals(password)) { //id는 존재하나, pwd가 불일치
			request.setAttribute("error", "비밀번호 불일치");
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
//			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}else { //로그인 성공
			request.getSession().setAttribute("uid", uid);
			request.getSession().setAttribute("sessionId", uid);
			response.sendRedirect("../dbConnectTest5_notices/noticeboards.do");
//			response.sendRedirect("../index.jsp");
//			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}
	}
}

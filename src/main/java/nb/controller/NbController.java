package nb.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface NbController {
	//Controller마다 있는 코드를 가져옴
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

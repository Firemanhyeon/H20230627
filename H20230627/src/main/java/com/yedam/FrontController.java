package com.yedam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.control.CalendarForm;
import com.yedam.member.control.ChartDataControl;
import com.yedam.member.control.ChartFormControl;
import com.yedam.member.control.ImageUploadControl;
import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.MemberInfoControl;
import com.yedam.member.control.MemberListControl;
import com.yedam.member.control.MemberModifyControl;

public class FrontController extends HttpServlet{
	private HashMap<String, Control> menu;
	
	public FrontController() {
		menu = new HashMap<>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException{
		menu.put("/main.do", new MainControl());
		menu.put("/memberList.do", new MemberListControl());
		menu.put("/loginForm.do", new LoginFormControl());
		menu.put("/login.do", new LoginControl());
		menu.put("/memberInfo.do", new MemberInfoControl());
		menu.put("/memberModify.do", new MemberModifyControl());
		menu.put("/imageUpload.do", new ImageUploadControl());
		
		
		//chart
		menu.put("/chartForm.do", new ChartFormControl());
		menu.put("/chartData.do", new ChartDataControl());
		//캘린더
		menu.put("/calendar.do", new CalendarForm());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uri=req.getRequestURI();
		String contextPath = req.getContextPath();
		String page= uri.substring(contextPath.length());
		System.out.println(page);
		
		Control control = menu.get(page);
		String viewPage= control.exec(req, resp);
		
		if(viewPage.endsWith(".jsp")) {
			viewPage = "/WEB-INF/views/"+ viewPage;
		}else if(viewPage.endsWith(".do")){
			resp.sendRedirect(viewPage);//loginForm.do
			return;
		}else if(viewPage.endsWith(".json")){
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().print(viewPage.substring(0,viewPage.length()-5));
			return;
		}
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	
	
	}
}

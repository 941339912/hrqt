//package cn.bdqn.servlet;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import cn.trip.tools.RedisAPI;
//
//
//@SuppressWarnings("serial")
//public class CheckSmsCode extends HttpServlet {
//
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//
//		//获取手机号
//		String phone=request.getParameter("phone");
//		//获取短信验证码
//		String smsCode=request.getParameter("smsCode");
//		//调用RedisAPI
//		RedisAPI redisAPI=new RedisAPI();
//
//		//设定key
//		String key="active:"+phone;
//
//		//判断key是否存在，验证用户输入的短信验证码
//		boolean flag=false;
//		if(redisAPI.exist(key)){
//			if(redisAPI.get(key).equals(smsCode)){
//				flag=true;
//			}
//		}
//		if(flag){
//			out.print("1");
//		}else{
//			out.print("0");
//		}
//
//
//
//
//
//		out.flush();
//		out.close();
//	}
//
//}

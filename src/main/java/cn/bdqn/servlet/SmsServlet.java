//package cn.bdqn.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import cn.trip.service.user.SmsServiceImpl;
//import cn.trip.tools.MD5Util;
//import cn.trip.tools.RedisAPI;
//
//@SuppressWarnings("serial")
//public class SmsServlet extends HttpServlet {
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		SmsServiceImpl smsServie=new SmsServiceImpl();
//		// 获取手机号
//		String phone=request.getParameter("phone");
//		// 1:生成短信验证码
//		int code=MD5Util.getRandomCode();
//		// 2:发送短信验证码
//		smsServie.send(phone, "1", new String[]{String.valueOf(code),"2"});
//		// 3:缓存短信验证码
//		RedisAPI redis=new RedisAPI();
//		String key="active:"+phone;
//		redis.set(key, 600, String.valueOf(code));
//
//		out.flush();
//		out.close();
//	}
//
//}

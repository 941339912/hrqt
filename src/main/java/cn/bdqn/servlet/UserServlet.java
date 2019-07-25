//package cn.bdqn.servlet;
//
//import cn.trip.dao.pojo.User;
//import cn.trip.service.user.UserService;
//import cn.trip.service.user.UserServiceImpl;
//import cn.trip.tools.MD5Util;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@SuppressWarnings("serial")
//public class UserServlet extends HttpServlet {
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
//
//		// 获取账号
//		String userCode = request.getParameter("phone");
//		// 获取密码并加密
//		String userPass = request.getParameter("pwd");
//		userPass = MD5Util.md5Password(userPass);
//		// 注册用户
//		UserService userService = new UserServiceImpl();
//
//		try {
//
//			if (userService.checkUserExists(userCode)) {
//				// 如果账号已经注册了
//				out.print("<script>alert('该手机号已经被注册，请重新录入');history.back();</script>");
//			} else {
//				// 如果没有注册，保存用户信息到数据库中
//				User user = new User(userCode, userPass);
//				// 保存
//				if (userService.registerUser(user)) {
//					out.print("<script>alert('恭喜您，注册成功');location.href='login.jsp';</script>");
//				} else {
//					out.print("<script>alert('注册失败，请重新录入');history.back();</script>");
//				}
//
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		out.flush();
//		out.close();
//	}
//
//}

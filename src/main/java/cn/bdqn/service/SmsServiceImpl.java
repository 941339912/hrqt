package cn.bdqn.service;

import com.cloopen.rest.sdk.*;

import java.util.HashMap;

public class SmsServiceImpl implements SmsService {

	@Override
	public void send(String to, String templateId, String[] datas) {
		HashMap<String, Object> result = null;
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		// 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
		restAPI.init("app.cloopen.com", "8883");
		// 初始化主账号名称和主账号令牌，登录云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
		restAPI.setAccount("8aaf07086bb6a176016bd12b840b151d", "0ad48a77e03d42b4ae48a739dd39f08a");
		// 请使用管理控制台中已创建应用的APPID。
		restAPI.setAppId("8aaf07086bb6a176016bd12b845e1523");
		result = restAPI.sendTemplateSMS(to, templateId, datas);

		if ("000000".equals(result.get("statusCode"))) {
			System.out.println("短信发送成功");
		} else {
			// 异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") + " 错误信息= "
					+ result.get("statusMsg"));
		}
	}

}

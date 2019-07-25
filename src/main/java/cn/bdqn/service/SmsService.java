package cn.bdqn.service;

public interface SmsService {
	/**
	 * 发送短信
	 * @param to
	 * @param templateId
	 * @param datas
	 */
	public void send(String to, String templateId, String[] datas);
}

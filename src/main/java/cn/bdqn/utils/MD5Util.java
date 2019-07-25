package cn.bdqn.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Util {
	
	public static int getRandomCode(){
		int min=1111;
		int max=9999;
		Random rand=new Random();
		return rand.nextInt(max)%(max-min+1)+min;
	}
	
    public static String md5Password(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }
    
    public static void main(String[] args) {
    	int num=getRandomCode();
    	System.out.println(num);
	}
    
    
    
    
    
    
    
    
    
    
}

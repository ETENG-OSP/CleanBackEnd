package et.common.pwdencode;

import java.net.URLEncoder;

public class EncodeTest {

	public static void main(String[] args){
			System.out.println("明文:xSeries330");
			try {
				System.out.println("密文:"+com.ai.cc.pwdencode.K.j("gbase20110531"));
				System.out.println("URL解析的密文:"+URLEncoder.encode(com.ai.cc.pwdencode.K.j("xSeries330")));
				System.out.println("解密后的明文:"+com.ai.cc.pwdencode.K.k(com.ai.cc.pwdencode.K.j("1")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

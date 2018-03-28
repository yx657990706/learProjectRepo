package citic.cgb.tools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * httpclient与was存在版本冲突，放弃httpclient
 * 
 * @author yinxiong
 * @date 2017年4月18日 下午7:59:16
 */
public class HttpUtils {
	
	private static String ENCODING = "GB18030";//作为服务端时，申请的网关编码为GB18030
	
	/**
	 * xml报文http发送
	 * @param content
	 * @param url
	 * @param encoding
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年5月9日 下午9:22:43
	 */
	public static String sendXmlStrByEncoding(String content, String url, String encoding) throws Exception {
		StringBuffer sb = new StringBuffer();
		encoding = encoding == null ? ENCODING : encoding;
		byte[] bytes = content.getBytes(encoding);
		
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)u.openConnection();
		conn.setDoOutput(true);//需要输出
		conn.setDoInput(true);//需要输入
		conn.setUseCaches(false);//不允许缓存
		conn.setRequestMethod("POST");//设置POST连接方式
		conn.setConnectTimeout(30000);//设置连接超时
		conn.setReadTimeout(30000);//设置读取超时
        //设置请求属性
		conn.setRequestProperty("Content-type", "text/xml");
		conn.setRequestProperty("charset", encoding);
		//建立输入流
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		try {
			dos.write(bytes);
		} finally {
			if (dos != null) {
				try {
					dos.flush();
					dos.close();
				} catch (Exception e) {
				}
			}
		}
		
		//获取响应
		int resultCode = conn.getResponseCode();
		if(HttpURLConnection.HTTP_OK==resultCode){
			BufferedReader rp = null;
			try {
				String readLine = new String();
				rp = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
				while ((readLine = rp.readLine()) != null) {
					sb.append(readLine);
				}
				
			} finally{
              if(rp!=null){
            	  try{
            		  rp.close();
            	  }catch(Exception e){
            	  }
              }
			}
		}
		
		return sb.toString();
		
	}
	
}

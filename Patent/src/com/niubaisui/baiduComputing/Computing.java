/**
 * 
 */
package com.niubaisui.baiduComputing;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
/**
 * @author niubaisui
 *
 */
public class Computing {

	public String parser(String key) throws  Exception{
		HttpClient client=HttpClients.createDefault();
		HttpGet  httpget=new HttpGet("http://www.baidu.com/s?q1=&q2="+key+"&q3=&q4=&rn=10&lm=0&ct=0&ft=&q5=&q6=&tn=baiduadv");
		
		HttpResponse response=client.execute(httpget);
		String str = "";
		HttpEntity rentity = response.getEntity();
		InputStream instream = rentity.getContent();
		InputStreamReader reader=new InputStreamReader(instream,"utf-8");
		char cbuf[]=new char[200000];
		reader.read(cbuf);
		str=new String(cbuf);
		reader.close();
		instream.close();
//		System.out.println(str);
		return str;
	}
	
	public String getComputing(String key) throws Exception{
		String str="";
		
		for(int i=0;i<10;i++){
			str=parser(key);
			str=str.substring(70000);
//			System.out.println(str);
			int index=str.indexOf("百度为您找到相关结果约");
			if(index==-1){
//				System.out.println("error! attempt num "+i);
				continue;
			}
			else{
				break;
			}
		}
		int index=str.indexOf("百度为您找到相关结果约");
		if(index==-1){
			
			return new String("0");
		}
		
		str=str.substring(index,index+100);
		str=str.replaceAll("\\s", "");
		index=str.indexOf("个");
		str=str.substring("百度为您找到相关结果约".length(), index);
		str=str.replaceAll(",", "");
		return str;
	}
	public static void main(String[] args) throws Exception {
		Computing computing=new Computing();
		long start=System.currentTimeMillis();
		String str=computing.getComputing("四川华蓥山广能（集团）有限公司总医院绿水洞医院");
		System.out.println("times:"+(System.currentTimeMillis()-start)+"ms");
		System.out.println(Long.valueOf(str));
		
	}
}

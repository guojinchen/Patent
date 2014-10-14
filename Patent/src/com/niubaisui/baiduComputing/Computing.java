/**
 * 
 */
package com.niubaisui.baiduComputing;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.htmlparser.util.ParserException;

import com.niubaisui.hospital.HospitalParser;

/**
 * @author niubaisui
 *
 */
public class Computing {

	public String parser(String key) throws  Exception{
		HttpClient client=HttpClients.createDefault();
		HttpGet  httpget=new HttpGet("http://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baiduadv&wd="+key+"&rsv_enter=0");
		
		HttpResponse response=client.execute(httpget);
		String str = "";
		HttpEntity rentity = response.getEntity();
		InputStream instream = rentity.getContent();
		InputStreamReader reader=new InputStreamReader(instream,"utf-8");
		int ch;
		while((ch=reader.read())!=-1){	
			str=str+(char)ch;
		}
		reader.close();
		instream.close();
		
		int index=str.indexOf("百度为您找到相关结果约");
		str=str.substring(index,index+100);
		str=str.replaceAll("\\s", "");
		index=str.indexOf("个");
		str=str.substring("百度为您找到相关结果约".length(), index);
		str=str.replaceAll(",", "");
		return str;
	}
	public static void main(String[] args) throws Exception {
		Computing computing=new Computing();
		String str=computing.parser("北京协和医院");
		System.out.println(Long.valueOf(str));
		
	}
}

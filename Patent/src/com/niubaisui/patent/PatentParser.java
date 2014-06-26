/**
 * 
 */
package com.niubaisui.patent;

/**
 * @author Administrator
 *
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * @author 12169_000
 *
 */
public class PatentParser {

	/*
	 * strWord:申请日='2012.06.13'
		numSortMethod:
		strLicenseCode:
		selected:
		numFMGB:
		numFMSQ:0
		numSYXX:
		numWGSQ:
		pageSize:3
		pageNow:1
	 */
	private String content="";
	private int sum;
	private int sumPages;
	private Map<String,String> params=new HashMap<String,String>();
	private String url="http://epub.sipo.gov.cn/patentoutline.action";
	public PatentParser(){
		params.put("showType", "1");;
		params.put("strWord", "申请日='2012.06.13'");
		params.put("numSortMethod", "");
		params.put("strLicenseCode", "");
		params.put("selected", "");
		params.put("numFMGB", "");
		params.put("numFMSQ", "");
		params.put("numSYXX", "");
		params.put("numWGSQ", "");
		params.put("pageSize", "10");
		params.put("pageNow", "1");
	}
	public PatentParser(String numFMGB,String numFMSQ,String numSYXX,String numWGSQ,String strWord){
		
		
		params.put("showType", "1");;
		params.put("strWord", strWord);
		params.put("numSortMethod", "");
		params.put("strLicenseCode", "");
		params.put("selected", "");
		params.put("numFMGB", numFMGB);
		params.put("numFMSQ", numFMSQ);
		params.put("numSYXX", numSYXX);
		params.put("numWGSQ", numWGSQ);
		params.put("pageSize", "10");
		params.put("pageNow", "1");
		
	}
	
	public void request() throws ClientProtocolException, IOException, ParserException{
		HttpClient client=HttpClients.createDefault();
		HttpPost httppost=new HttpPost(url);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Iterator<String> keys=params.keySet().iterator();
		while(keys.hasNext()){
			String key=keys.next();
			formparams.add(new BasicNameValuePair(key,params.get(key)));
		}
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		httppost.setEntity(entity);
		HttpResponse response=client.execute(httppost);
		String str = "";
		HttpEntity rentity = response.getEntity();
		if (entity != null) {
			InputStream instream = rentity.getContent();
			InputStreamReader reader=new InputStreamReader(instream,"utf-8");
			int ch;
			while((ch=reader.read())!=-1){
				
				str=str+(char)ch;
			}
			reader.close();
			instream.close();
		}
		
//		System.out.println(str);
		//解析下一次请求头
		String regex="ksjs\\.(.*)";
		Pattern pattern=Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(str);
		while(matcher.find()){
			String[] keyvalue=getKeyValue(matcher.group(1));
			System.out.println(keyvalue[0]);
			System.out.println(keyvalue[1]);
			params.put(keyvalue[0], keyvalue[1]);
		}
		
		Parser parser=Parser.createParser(str, "utf-8");
		HasAttributeFilter divfilter=new HasAttributeFilter("class", "wl228");
		NodeList list=parser.extractAllNodesThatMatch(divfilter);
		
		for(int i=0;i<list.size();i++){
			Node node= list.elementAt(i);
			String text=node.toPlainTextString();
			if(text.contains("申请号")){
				content=content+format(text)+"\r\n";
				System.out.println(format(text));
			}
		}		
	}
	
	public void parser(String filename,PatentFrame frame) throws ClientProtocolException, IOException, ParserException{
		request();
		String numFMGB=params.get("numFMGB").replaceAll("\\s", "");
		String numFMSQ=params.get("numFMSQ").replaceAll("\\s", "");
		String numSYXX=params.get("numSYXX").replaceAll("\\s", "");
		String numWGSQ=params.get("numWGSQ").replaceAll("\\s", "");
		int sumFMGB=0,sumFMSQ=0,sumSYXX=0,sumWGSQ=0;
		if(!numFMGB.equals("")){
			sumFMGB=Integer.valueOf(numFMGB);
		}
		if(!numFMSQ.equals("")){
			sumFMSQ=Integer.valueOf(numFMSQ);
		}
		if(!numSYXX.equals("")){
			sumSYXX=Integer.valueOf(numSYXX);
		}
		if(!numWGSQ.equals("")){
			sumWGSQ=Integer.valueOf(numWGSQ);
		}	
		
		sum=sumFMGB+sumFMSQ+sumSYXX+sumWGSQ;
		int pageSize=Integer.valueOf(params.get("pageSize"));
		int pageNow=Integer.valueOf(params.get("pageNow"));
		if(sum<pageSize){
			sumPages=1;
		}
		else{
			sumPages=sum/pageSize;
		}
		
		if(sum%pageSize!=0){
			if(sum>pageSize){
				sumPages++;
			}
			
		}
		//
		frame.getTextArea().setText(content);
		double ratio=(double)pageNow/(double)sumPages;
		frame.getProgress().setValue((int)(ratio*100));
		frame.getjLabel6().setText(String.valueOf(pageNow)+"/"+String.valueOf(sumPages));
		for(int i=0;i<sumPages-1;i++){
			params.put("pageNow", String.valueOf(++pageNow));
			pageNow=Integer.valueOf(params.get("pageNow"));
			request();
			frame.getTextArea().setText(content);
			ratio=(double)pageNow/(double)sumPages;
			frame.getProgress().setValue((int)(ratio*100));
			frame.getjLabel6().setText(String.valueOf(pageNow)+"/"+String.valueOf(sumPages));
		}
		
		//写入文件中
		File file=new File(filename);
		FileWriter writer=new FileWriter(file);
		writer.write(content);
		writer.close();	
	}
	
	
	public int getSum(){
		return sum;
	}
	public int getSumPages(){
		return sumPages;
	}
	public String getContent(){
		return content;
	}
	public String[] getKeyValue(String str){
		String[] keyvalue=new String[2];
		keyvalue[0]=str.split(".value")[0];
		String value=str.split(".value")[1];
		Matcher matcher=Pattern.compile(".*\"(.*)\".*", Pattern.CASE_INSENSITIVE).matcher(value);
		if(matcher.matches()){
			keyvalue[1]=matcher.group(1);
		}
		return keyvalue;
	}
	
	public String format(String str){
		str=str.substring(4, str.length());
		str.charAt(0);
		char c=str.charAt(str.length()-1);
		str=str.substring(0, str.length()-1);
		str=str+"."+String.valueOf(c);
		return str;
	}
	
	public void valide(){
		Calendar calendar=Calendar.getInstance();
		int month=calendar.get(Calendar.MONTH);
		System.out.println(month);
		if(month>5){
			System.exit(0);
		}
	}
	public static void main(String[] args) throws ClientProtocolException, IOException, ParserException {
		PatentParser parser=new PatentParser();
		
		//parser.request();
		parser.parser("test.txt",null);
	}
	
}
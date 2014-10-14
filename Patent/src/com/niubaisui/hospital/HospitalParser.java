/**
 * 
 */
package com.niubaisui.hospital;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
import org.htmlparser.filters.HasChildFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.json.JSONArray;
import org.json.JSONObject;

import com.niubaisui.baiduComputing.Computing;

/**
 * @author niubaisui
 *
 */
public class HospitalParser {
	
	public String request(String url,Map<String,String> params) throws ClientProtocolException, IOException, ParserException{
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
		return str;
	}

	public Map<String,String> makeRequestHeader(String province){
		Map<String,String> params=new HashMap<String,String>();
		params.put("provinceId", province);
		params.put("htype", "");
		params.put("hgrade", "");
		params.put("hclass", "");
		params.put("hname", "");
		return params;
	}
	public List<Hospital> parserHospital(String url,Map<String,String> params) throws ClientProtocolException, ParserException, IOException{
		List<Hospital>  hospitals=new ArrayList<Hospital>();
		
		String str=request(url, params);
		JSONArray array=new JSONArray(str);
		for(int i=0;i<array.length();i++){
			Hospital hospital=new Hospital();
			JSONObject jsonhospital=array.getJSONObject(i);
			hospital.setName(jsonhospital.getString("hName"));
			hospital.setHclass(jsonhospital.getString("hType"));
			hospital.setGrade(jsonhospital.getString("hGrade"));
			hospitals.add(hospital);
		}
		return hospitals;
	}
	public Map<String,String> parserProvince(String str) throws ParserException{
		Map<String,String> provinces=new HashMap<String,String>();
		Parser parser=Parser.createParser(str, "utf-8");
		HasAttributeFilter selectfilter=new HasAttributeFilter("name", "organid");
		NodeList list=parser.extractAllNodesThatMatch(selectfilter);
		for(int i=0;i<list.size();i++){
			Node node= list.elementAt(i);
			NodeList childlist=node.getChildren();
			for(int j=1;j<childlist.size();j++){
				Node n=childlist.elementAt(j);
				String number=n.getText().replace("\"", "").replace("option value=", "");
				provinces.put(number,n.toPlainTextString());
			}
		}
		return provinces;
		
	}
	/*
	 *  new Array("北京市","天津市","河北省","山西省","内蒙古自治区","辽宁省","吉林省","黑龙江省","上海市",
	 *  "江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西壮族自治区",
	 *  "海南省","重庆市","四川省","贵州省","云南省","西藏自治区","陕西省","甘肃省","青海省","宁夏回族自治区","新疆维吾尔自治区","新疆生产建设兵团");
	 *  7180
	 */
	public static void main(String[] argv) throws Exception {
		HospitalParser  parser=new HospitalParser();
		String str=parser.request("https://www.hqms.org.cn/usp/roster/index.jsp",new HashMap<String,String>());
		Map<String,String> provinces=parser.parserProvince(str);
		System.out.println(provinces.get("7224"));
		Map<String,String> params=parser.makeRequestHeader("7224");
		List<Hospital> hospitals=parser.parserHospital("https://www.hqms.org.cn/usp/roster/rosterInfo.jsp", params);
		Computing computing=new Computing();
		List<Long> caculate=new ArrayList<Long>();
		for(Hospital hospital:hospitals){
			System.out.println(hospital.getName());
			String s=computing.getComputing(hospital.getName());
			hospital.setComputing(Long.valueOf(s));
			caculate.add(Long.valueOf(s));
		}
		Collections.sort(caculate);
		Collections.sort(hospitals,new Hospital());
		for(Hospital hospital: hospitals){
			System.out.println(hospital.getName()+">>>"+hospital.getComputing());
		}
		System.out.println(hospitals.size());
	}
}

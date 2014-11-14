/**
 * 
 */
package com.niubaisui.patent;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.niubaisui.search.SearchFrame;

/**
 * @author 12169_000
 *
 */


public class PatentDetailedParser {

	/*
	 * 201230468476.X,2014-10-24  编织子管   常州南玻复合材料有限公司   南京纵横知识产权代理有限公司;于文军   张国平,张榆
	   201230424639.4,2014-10-28 读取不成功
	   201230463815.5,2014-09-28    间厅柜(8630)   陈海强   广州嘉权专利商标事务所有限公司;刘先珍   陈海强
	 */
	/*
	select-key:shenqingh:201230468476X
	select-key:displayitem:_base
	select-key:txncode:txn801510
	select-key:status:null
	select-key:sqfs:null
	 * 
	 */
	private String content="";
	private  URI uri;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}
	
	
	public PatentDetailedParser() throws URISyntaxException{
		uri = new URIBuilder()
		.setScheme("http")
		.setHost("publicquery.sipo.gov.cn")
		.setPath("/txn801510.do")
		.setParameter("select-key:shenqingh", "201230468476X")
		.setParameter("select-key: displayitem", "_base")
		.setParameter("select-key:txncode", "txn801510")
		.setParameter("select-key:status", "null")
		.setParameter("select-key:sqfs", "null")
		.build();
	}
	
	public PatentDetailedParser(String shenqingh) throws URISyntaxException{
		uri = new URIBuilder()
		.setScheme("http")
		.setHost("publicquery.sipo.gov.cn")
		.setPath("/txn801510.do")
		.setParameter("select-key:shenqingh", shenqingh)
		.setParameter("select-key: displayitem", "_base")
		.setParameter("select-key:txncode", "txn801510")
		.setParameter("select-key:status", "null")
		.setParameter("select-key:sqfs", "null")
		.build();
	}
	
	public Map<String,String> fine_request() throws ClientProtocolException, IOException, ParserException{
		Map<String,String> map=new HashMap<String,String>();
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(uri);
		CloseableHttpResponse response = (CloseableHttpResponse) client
				.execute(httpget);
		String str="";
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				InputStreamReader reader=new InputStreamReader(instream,"utf-8");
				int ch;
				while((ch=reader.read())!=-1){
					
					str=str+(char)ch;
				}
				reader.close();
				instream.close();
			}
		} finally {
			response.close();
		}

//		System.out.println(str);

		/*
		 * 
		 */
		Parser parser=Parser.createParser(str, "utf-8");
		HasAttributeFilter divfilter=new HasAttributeFilter("class", "t1");
		NodeList list=parser.extractAllNodesThatMatch(divfilter);
		
		for(int i=0;i<list.size();i++){
			Node node= list.elementAt(i);
			String key=node.toPlainTextString();
			String value=node.getParent().getChildren().elementAt(5).toPlainTextString();
//			System.out.println(key);
//			System.out.println(value);
			map.put(key, value);
		}		
		return map;
	}
	
	public boolean  parser(){
		for(int i=0;i<10;i++){
			try{
				Map<String,String> map=fine_request();
				content=content+"发明名称 ："+map.get("发明名称 ：").replaceAll("\\s", "")+"    "+
						"申请人 ："+map.get("申请人 ：").replaceAll("\\s", "")+"    "+"代理信息 ："+map.get("代理信息 ：").replaceAll("\\s", "")
						+"    "+"发明人名称："+map.get("发明人名称：").replaceAll("\\s", "");
//				System.out.println(content);
				return true;
			}catch(Exception e){
				continue;
			}
		}
		content="读取不成功";
		return false;
	}
	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException, ParserException {
		PatentDetailedParser  de=new PatentDetailedParser();
		de.fine_request();
		de.parser();
		System.out.println();
		File file=new File("d:\\","ff");
		file.createNewFile();
	}

	
}

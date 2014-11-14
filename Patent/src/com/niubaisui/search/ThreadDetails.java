/**
 * 
 */
package com.niubaisui.search;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;
import org.htmlparser.util.ParserException;

import com.niubaisui.patent.FinePatentParser;
import com.niubaisui.patent.PatentDetailedParser;

/**
 * @author 12169_000
 *
 */
public class ThreadDetails extends Thread{

	private String path;
	private String filename;
	
	private String content[];
	
	public ThreadDetails(String path,String filename,String content[]){
		this.path=path;
		this.filename=filename;
		this.content=content;
	}
	@Override
	public void run(){
		
		System.out.println("run");
		int i=0;
		for(String s:content){
			try{
				String ss=s.replace(".", "").substring(0, 13);
				PatentDetailedParser parser=new PatentDetailedParser(ss);
				parser.fine_request();
				parser.parser();
				System.out.println(s);
				System.out.println(s+"    "+parser.getContent());
				SearchFrame.addContent(s+"  "+parser.getContent()+"\r\n");
				i++;
			}catch(Exception e){
				
			}
			finally{
			
			}
		}
		SearchFrame.addThreadNum();
		System.out.println("thread execute:"+i);
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String[] getContent() {
		return content;
	}
	public void setContent(String content[]) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}

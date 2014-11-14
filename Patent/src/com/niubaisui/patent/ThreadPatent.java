/**
 * 
 */
package com.niubaisui.patent;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;
import org.htmlparser.util.ParserException;

/**
 * @author Administrator
 *
 */
public class ThreadPatent extends Thread{
	
	private PatentFrame frame;
	public PatentFrame getFrame() {
		return frame;
	}
	public void setFrame(PatentFrame frame) {
		this.frame = frame;
	}
	@Override
	public void run(){
		
		String filename=JOptionPane.showInputDialog(frame, "请输入文件名：");
		if(filename.equals("")){
			filename="inputfilename";
		}
		FinePatentParser parser=new FinePatentParser(frame.getNumFMGB(), frame.getNumFMSQ(), frame.getNumSYXX(), frame.getNumWGSQ(), frame.getParams());
		parser.valide();
		try {
			parser.parser(filename+".txt", frame);
			frame.getjButton1().setEnabled(true);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

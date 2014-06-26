/**
 * 
 */
package com.niubaisui.patent;

import java.io.IOException;

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
		
		PatentParser parser=new PatentParser(frame.getNumFMGB(), frame.getNumFMSQ(), frame.getNumSYXX(), frame.getNumWGSQ(), frame.getParams());
		parser.valide();
		try {
			parser.parser("niubaisui.txt", frame);
			frame.getjButton1().setEnabled(true);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

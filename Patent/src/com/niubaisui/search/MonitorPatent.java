/**
 * 
 */
package com.niubaisui.search;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

import org.apache.http.client.ClientProtocolException;
import org.htmlparser.util.ParserException;

import com.niubaisui.patent.FinePatentParser;
import com.niubaisui.patent.PatentFrame;

/**
 * @author 12169_000
 *
 */
public class MonitorPatent extends Thread{

	private SearchFrame frame;
	public SearchFrame getFrame() {
		return frame;
	}
	public void setFrame(SearchFrame frame) {
		this.frame = frame;
	}
	@Override
	public void run(){
		boolean isCreate=false;
		while(true){
			int current=SearchFrame.getContent().split("\r\n").length;
//			System.out.println("current:"+current);
			
        	if(current==frame.getSum()&&isCreate==false){
        		System.out.println("创建文件"+SearchFrame.filepath+"\\"+"details"+SearchFrame.filename);
        		File file=new File(SearchFrame.filepath,"details"+SearchFrame.filename);
        		
        		FileWriter writer;
				try {
					System.out.println(file.createNewFile());
					writer = new FileWriter(file);
					writer.write(SearchFrame.getContent());
					writer.close();	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				frame.getjProgressBar1().setBackground(Color.CYAN);
        		frame.getjProgressBar1().setValue(100);
        		isCreate=true;
        	}
        	else{
//        		System.out.println("threadnum:"+SearchFrame.threadnum);
        		
        		double ratio=((double)current)/(double)(frame.getSum());
        		frame.getjLabel1().setText(String.valueOf(current)+"/"+String.valueOf(frame.getSum()));
        		frame.getjProgressBar1().setBackground(Color.CYAN);
        		frame.getjProgressBar1().setValue((int) (ratio * 100));
        		frame.getjTextArea1().setText(SearchFrame.getContent());
        		if(isCreate==false){
        			JScrollBar jb =frame.getjScrollPane1().getVerticalScrollBar();
        			jb.setValue(jb.getMaximum());
        		}
        		
        		
        	}
		}
		
	}
}

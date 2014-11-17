/**
 * 
 */
package com.niubaisui.excel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;
import org.htmlparser.util.ParserException;

import com.niubaisui.patent.FinePatentParser;
import com.niubaisui.patent.PatentFrame;

/**
 * @author 12169_000
 *
 */
public class DAOThread extends Thread{

	private JFrame frame;
	private Joc  joc;
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	@Override
	public void run(){
		
		String filename=JOptionPane.showInputDialog(frame, "请输入文件名：");
		if(filename.equals("")){
			filename="inputfilename";
		}
		DAO dao=new DAO();
		try {
			List<Joc> jocs=dao.select(joc);
			Excel excel=new Excel();
			excel.generateExcel(jocs, filename);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Joc getJoc() {
		return joc;
	}
	public void setJoc(Joc joc) {
		this.joc = joc;
	}
}

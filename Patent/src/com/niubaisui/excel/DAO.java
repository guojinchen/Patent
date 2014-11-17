/**
 * 
 */
package com.niubaisui.excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12169_000
 *
 */
public class DAO {

	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql:127.0.0.1:3306/spiderjoc";
	private String user="root";
	private String password="fxw";
	private Connection conn=null;
	public DAO(){
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public String generateSql(Joc joc){
		String sql="select * from   jocpara   where ";
		if(!joc.getJoc_area().equals("")){
			sql=sql+"joc_area like "+"'%"+joc.getJoc_area()+"%'";
		}
		if(!joc.getJoc_type().equals("")){
			sql=sql+"  and  joc_type like "+"'%"+joc.getJoc_type()+"%'";
		}
		if(!joc.getJoc_court().equals("")){
			sql=sql+"  and  joc_court like "+"'%"+joc.getJoc_court()+"%'";
		}
		if(!joc.getJoc_time().equals("")){
			sql=sql+"  and joc_time like "+"'%"+joc.getJoc_time()+"%'";
		}
		if(!joc.getJoc_title().equals("")){
			sql=sql+"  and joc_title like "+"'%"+joc.getJoc_title()+"%'";
		}
		
		if(!joc.getJoc_timeori().equals("")){
			sql=sql+"  and joc_timeori like "+"'%"+joc.getJoc_timeori()+"%'";
		}
		if(!joc.getJoc_content_top().equals("")){
			sql=sql+"  and joc_content_top like "+"'%"+joc.getJoc_content_top()+"%'";
		}
		
		return sql;
	}
	 /*
	  * joc_mark, joc_area,joc_type,joc_court,joc_title,joc_time,joc_timeori（转换成日期格式）,joc_num,
	 * joc_content_top,joc_content_bottom
	  */
	public List<Joc> select(Joc joc) throws SQLException{
		String  sql=generateSql(joc);
		Statement statement=conn.createStatement();
		ResultSet rs=statement.executeQuery(sql);
		List<Joc> jocs=new ArrayList<Joc>();
		while(rs.next()){
			String joc_mark=rs.getString("joc_mark");
			String joc_area=rs.getString("joc_area");
			String joc_type=rs.getString("joc_type");
			String joc_court=rs.getString("joc_court");
			String joc_title=rs.getString("joc_title");
			String joc_time=rs.getString("joc_time");
			String joc_timeori=rs.getString("joc_timeori");
			String joc_num=rs.getString("joc_num");
			String joc_content_top=rs.getString("joc_content_top");
			String joc_content_bottom=rs.getString("joc_content_bottom");
			Joc jj=new Joc(joc_mark, joc_area, joc_type, joc_court,joc_title,joc_time,
					joc_timeori,joc_num,joc_content_top,joc_content_bottom);
			jocs.add(jj);
		}
		return jocs;
	}
	
	public Joc  normalize(Joc joc){
		if(joc.getJoc_area()==null){
			joc.setJoc_area("");
		}
		if(joc.getJoc_type()==null){
			joc.setJoc_type("");
		}
		if(joc.getJoc_court()==null){
			joc.setJoc_court("");
		}
		if(joc.getJoc_title()==null){
			joc.setJoc_title("");
		}
		if(joc.getJoc_time()==null){
			joc.setJoc_time("");
		}
		if(joc.getJoc_timeori()==null){
			joc.setJoc_timeori("");
		}
		if(joc.getJoc_content_top()==null){
			joc.setJoc_content_top("");
		}
		if(joc.getJoc_content_bottom()==null){
			joc.setJoc_content_bottom("");
		}
		
		return joc;
	}
}

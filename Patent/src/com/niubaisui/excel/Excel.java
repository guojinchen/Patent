/**
 * 
 */
package com.niubaisui.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author 12169_000
 *
 */
public class Excel {

	
	/*
	 * joc_mark, joc_area,joc_type,joc_court,joc_title,joc_time,joc_timeori（转换成日期格式）,joc_num,
	 * joc_content_top,joc_content_bottom
	 */
	public void generateExcel(List<Joc> jocs,String filename) throws IOException{
		
		int CountColumnNum=10;
		HSSFWorkbook hwb=new HSSFWorkbook();
		
		//sheet 对应一个工作页
		HSSFSheet sheet=hwb.createSheet("sheet");
		HSSFRow firstrow=sheet.createRow(0);
		HSSFCell firstcell[]=new HSSFCell[CountColumnNum];
		String  names[]=new String[CountColumnNum];
		names[0]="省份";
		names[1]="案件类型";
		names[2]="法院";
		names[3]="案件名称";
		names[4]="上传日期";
		names[5]="判决日期";
		names[6]="各方当事人";
		names[7]="案件编号";
		names[8]="案件内容";
		/*
		 * 生成表头
		 */
		for(int j=0;j<CountColumnNum;j++){
			firstcell[j]=firstrow.createCell(j);
			firstcell[j].setCellValue(new HSSFRichTextString(names[j]));
		}
		
		//生成普通行
		for(int i=0;i<jocs.size();i++){
			//创建一行
			HSSFRow  row=sheet.createRow(i+1);
			Joc joc=jocs.get(i);
			//得到要插入的每一条记录
			for(int colu=0;colu<1;colu++){
				//在一行内循环
				HSSFCell joc_area=row.createCell(0);
				joc_area.setCellValue(joc.getJoc_area());
				HSSFCell joc_type=row.createCell(1);
				joc_type.setCellValue(joc.getJoc_type());	
				HSSFCell joc_court=row.createCell(2);
				joc_court.setCellValue(joc.getJoc_court());
				HSSFCell joc_title=row.createCell(3);
				joc_title.setCellValue(joc.getJoc_title());	
				HSSFCell joc_time=row.createCell(4);
				joc_time.setCellValue(joc.getJoc_time());	
				HSSFCell joc_timeori=row.createCell(5);
				joc_timeori.setCellValue(joc.getJoc_timeori());	
				HSSFCell joc_content_top=row.createCell(6);
				joc_content_top.setCellValue(joc.getJoc_content_top());	
				HSSFCell joc_num=row.createCell(7);
				joc_num.setCellValue(joc.getJoc_num());	
				HSSFCell joc_content_bottom=row.createCell(8);
				joc_content_bottom.setCellValue(joc.getJoc_content_bottom());	
			}
		}
		
		//创建文件输出流，准备输出电子表格
		OutputStream out=new FileOutputStream(filename+".xls");
		hwb.write(out);
		out.close();
		System.out.println("数据库导出成功");
	}
	public static void main(String[] args) throws IOException {
		System.out.println("test");
	}
}

/**
 * 
 */
package com.niubaisui.excel;

/**
 * @author 12169_000
 *
 */
public class Joc {

	/*
	 * joc_mark, joc_area,joc_type,joc_court,joc_title,joc_time,joc_timeori（转换成日期格式）,joc_num,joc_content_top,joc_content_bottom
	 */
	private String joc_mark;
	private String joc_area;
	private String joc_type;
	private String joc_court;
	private String joc_title;
	private String joc_time;
	private String joc_timeori;
	private String joc_num;
	private String joc_content_top;
	private String joc_content_bottom;
	public Joc(){
		
	}
	public Joc(String joc_mark,String joc_area,String joc_type,String joc_court,String joc_title,String joc_time,
			String joc_timeori,String joc_num,String joc_content_top,String joc_content_bottom){
		this.joc_mark=joc_mark;
		this.joc_area=joc_area;
		this.joc_type=joc_type;
		this.joc_court=joc_court;
		this.joc_title=joc_title;
		this.joc_time=joc_time;
		this.joc_timeori=joc_timeori;
		this.joc_num=joc_num;
		this.joc_content_top=joc_content_top;
		this.joc_content_bottom=joc_content_bottom;
	}
	public String getJoc_area() {
		return joc_area;
	}
	public void setJoc_area(String joc_area) {
		this.joc_area = joc_area;
	}
	public String getJoc_type() {
		return joc_type;
	}
	public void setJoc_type(String joc_type) {
		this.joc_type = joc_type;
	}
	public String getJoc_court() {
		return joc_court;
	}
	public void setJoc_court(String joc_court) {
		this.joc_court = joc_court;
	}
	public String getJoc_title() {
		return joc_title;
	}
	public void setJoc_title(String joc_title) {
		this.joc_title = joc_title;
	}
	public String getJoc_timeori() {
		return joc_timeori;
	}
	public void setJoc_timeori(String joc_timeori) {
		this.joc_timeori = joc_timeori;
	}
	public String getJoc_content_top() {
		return joc_content_top;
	}
	public void setJoc_content_top(String joc_content_top) {
		this.joc_content_top = joc_content_top;
	}
	public String getJoc_time() {
		return joc_time;
	}
	public void setJoc_time(String joc_time) {
		this.joc_time = joc_time;
	}
	public String getJoc_mark() {
		return joc_mark;
	}
	public void setJoc_mark(String joc_mark) {
		this.joc_mark = joc_mark;
	}
	public String getJoc_num() {
		return joc_num;
	}
	public void setJoc_num(String joc_num) {
		this.joc_num = joc_num;
	}
	public String getJoc_content_bottom() {
		return joc_content_bottom;
	}
	public void setJoc_content_bottom(String joc_content_bottom) {
		this.joc_content_bottom = joc_content_bottom;
	}
}

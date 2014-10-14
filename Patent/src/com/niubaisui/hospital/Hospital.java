/**
 * 
 */
package com.niubaisui.hospital;

import java.util.Comparator;

/**
 * @author niubaisui
 *
 */
public class Hospital implements Comparator<Hospital>{
	
	private String name;
	private String hclass;
	private String grade;
	private Long  computing;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHclass() {
		return hclass;
	}
	public void setHclass(String hclass) {
		this.hclass = hclass;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Long getComputing() {
		return computing;
	}
	public void setComputing(Long computing) {
		this.computing = computing;
	}
	@Override
	public int compare(Hospital o1, Hospital o2) {
		if(o1.getComputing()>o2.getComputing()){
			return -1;
		}
		if(o1.getComputing()<o2.getComputing()){
			return 1;
		}
		return 0;
	}
	
	
}

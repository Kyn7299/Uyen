package assign;

import java.io.Serializable;
import java.util.Comparator;

public class SinhVien implements Serializable, Comparable<SinhVien>{
	protected String name;
	protected String smt;
	protected String course;
	protected String masv;
	
	public SinhVien(String name, String smt, String course, String masv) {
		super();
		this.name = name;
		this.smt = smt;
		this.course = course;
		this.masv = masv;
	}
	public SinhVien() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSemester() {
		return smt;
	}
	public void setSemester(String smt) {
		this.smt = smt;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getMa() {
		return masv;
	}
	public void setMa(String masv) {
		this.masv = masv;
	}
	@Override
	public String toString() {
		return this.name + "\t\t" + this.smt + "\t\t" + this.course + "\t\t" + this.masv;
	}
	@Override
	public int compareTo(SinhVien arg0) {
		return 0;
	}
}

class NameCompare implements Comparator<SinhVien> {
	@Override
	public int compare(SinhVien o1, SinhVien o2) {
		
	return o1.getName().compareTo(o2.getName());
	}	
}

class Report {
	public String name;
	public String course;
	int tt;
	
	public Report(String name, String course, int tt) {
		this.name = name;
		this.course = course;
		this.tt = tt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getTotal() {
		return tt;
	}
	public void setTotal(int tt) {
		this.tt = tt;
	}
}


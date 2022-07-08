package school;

import java.util.ArrayList;
import utils.Define;

public class Subject {
	private String subjectName;
	private int subjectId;
	private int gradeType;
	
	private ArrayList<Student> studentList = new ArrayList<>();
	
	public Subject(String name, int id) {
		subjectName = name;
		subjectId = id;
		gradeType = Define.AF_TYPE;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void register(Student student) {
		studentList.add(student);
	}
}

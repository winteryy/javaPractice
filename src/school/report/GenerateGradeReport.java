package school.report;

import java.util.ArrayList;

import grade.*;
import school.*;
import utils.Define;

public class GenerateGradeReport {
	School school = School.getInstance();
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이름 | 학번 |필수과목| 점수 \n ";
	public static final String LINE = "-------------------------------\n";
	
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject sbj : subjectList) {
			makeHeader(sbj);
			makeBody(sbj);
			makeFooter();
		}
		
		return buffer.toString();
	}
	
	public void makeHeader(Subject sbj) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + sbj.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
	}
	
	public void makeBody(Subject sbj) {
		ArrayList<Student> studentList = school.getStudentList();
		
		for(int i=0; i<studentList.size(); i++) {
			Student std = studentList.get(i);
			buffer.append(std.getStudentName());
			buffer.append(" | ");
			buffer.append(std.getStudentId());
			buffer.append(" | ");
			buffer.append(std.getMajorSubject().getSubjectName() + "\t");
			buffer.append(" | ");
			
			getScoreGrade(std, sbj.getSubjectId());
			
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	
	public void getScoreGrade(Student std, int subjectId) {
		ArrayList<Score> scoreList = std.getScoreList();
		int majorId = std.getMajorSubject().getSubjectId();
		
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()};
		
		for(int i=0; i<scoreList.size(); i++) {
			Score score = scoreList.get(i);
			if(score.getSubject().getSubjectId() == subjectId) {
				String grade;
				if(score.getSubject().getSubjectId() == majorId) {
					grade = gradeEvaluation[Define.SF_TYPE].getGrade(score.getPoint());
				}else {
					grade = gradeEvaluation[Define.AF_TYPE].getGrade(score.getPoint());
				}		
			buffer.append(score.getPoint());
			buffer.append(":");
			buffer.append(grade);
			buffer.append(" | ");
			}
		}
	}
	
	public void makeFooter() {
		buffer.append("\n");
	}
}

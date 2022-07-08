package test;

import school.*;
import school.report.*;
import utils.Define;

public class TestMain {
	School goodSchool = School.getInstance();
	Subject korean;
	Subject math;
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
		TestMain test = new TestMain();
		
		test.createSubject();
		test.createStudent();
		
		String report = test.gradeReport.getReport();
		System.out.println(report);		
	}
	
	public void createSubject() {
		korean = new Subject("국어", Define.KOREAN);
		math = new Subject("수학", Define.MATH);
		
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
	}
	
	public void createStudent() {
		Student std1 = new Student(181213, "안성원", korean);
		Student std2 = new Student(181518, "오태훈", math);
		Student std3 = new Student(171230, "이동호", korean);
		Student std4 = new Student(171255, "조성욱", korean);
		Student std5 = new Student(171590, "최태평", math);
		
		goodSchool.addStudent(std1);
		goodSchool.addStudent(std2);
		goodSchool.addStudent(std3);
		goodSchool.addStudent(std4);
		goodSchool.addStudent(std5);
		
		korean.register(std1);
		korean.register(std2);
		korean.register(std3);
		korean.register(std4);
		korean.register(std5);
		
		math.register(std1);
		math.register(std2);
		math.register(std3);
		math.register(std4);
		math.register(std5);
		
		addScoreForStudent(std1, korean, 95);
		addScoreForStudent(std1, math, 56);
		
		addScoreForStudent(std2, korean, 95);
		addScoreForStudent(std2, math, 95);
		
		addScoreForStudent(std3, korean, 100);
		addScoreForStudent(std3, math, 88);
		
		addScoreForStudent(std4, korean, 89);
		addScoreForStudent(std4, math, 95);
		
		addScoreForStudent(std5, korean, 85);
		addScoreForStudent(std5, math, 56);
	}

	public void addScoreForStudent(Student std, Subject sbj, int point) {
		Score score = new Score(std.getStudentId(), sbj, point);
		std.addScore(score);
	}
}


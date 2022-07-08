package school;

public class Score {
	private int studentId;
	private Subject subject;
	private int point;

	public Score(int id, Subject sub, int point) {
		this.studentId = id;
		this.subject = sub;
		this.point = point;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "ÇÐ¹ø: " + studentId + ", " + subject.getSubjectName() + ": " + point;
	}
	
	
}

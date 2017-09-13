package jw.secondproject.shared.business.marks;

import java.math.BigDecimal;

import jw.secondproject.shared.business.role.Teacher;

public class FractionSchoolGrade {

	private Teacher teacher;
	
	private BigDecimal percent;

	private Grade grade;

	public FractionSchoolGrade(Teacher teacher, BigDecimal percent, Grade grade) {
		this.teacher = teacher;
		this.percent = percent;
		this.grade = grade;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public Grade getGrade() {
		return grade;
	}
	
	
	
}

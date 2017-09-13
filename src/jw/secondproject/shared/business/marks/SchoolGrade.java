package jw.secondproject.shared.business.marks;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import jw.secondproject.shared.business.role.Student;

public class SchoolGrade {

	private Set<FractionSchoolGrade> fractions = new HashSet<>();
	
	private Student student;
	
	public SchoolGrade(Set<FractionSchoolGrade> fractions, Student student) {
		this.fractions.addAll(fractions);
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}
	
	/**
	 * Rechnet die aktuelle Note in dem Fach aus.
	 * 
	 * @return
	 * @throws Exception wenn Teilnoten nicht 100%
	 */
	public Grade getGrade() throws Exception{
		if (!isComplete()){
			throw new Exception("Die Note kann nicht berechnet werden, da die Teilnoten nicht 100% ergeben");
		}
			
		BigDecimal exactGrade = fractions.stream().collect(Collectors.reducing(BigDecimal.ZERO, fGrade -> fGrade.getGrade().getExact().multiply(fGrade.getPercent()), BigDecimal::add));
		return new Grade(exactGrade);
	}
	
	/**
	 * Prueft ob alle Teilnoten 100% ergeben.
	 * 
	 * @return true = alle 100%
	 */
	public boolean isComplete(){
		BigDecimal percent = fractions.stream().collect(Collectors.reducing(BigDecimal.ZERO, fGrade -> fGrade.getPercent(), BigDecimal::add));
		if (percent.compareTo(BigDecimal.ONE) == 0){
			return true;
		}
		return false;
	}
	
}

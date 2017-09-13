package jw.secondproject.shared.business.marks;

import java.math.BigDecimal;

public class Grade {

	private int rounded;
	
	private BigDecimal exact;
	
	public Grade(BigDecimal exact) {
		this.exact = exact;
		rounded = exact.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
	}
	
	public BigDecimal getExact() {
		return exact;
	}
	
	public int getRounded() {
		return rounded;
	}
}

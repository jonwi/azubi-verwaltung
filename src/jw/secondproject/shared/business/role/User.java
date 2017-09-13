package jw.secondproject.shared.business.role;

public abstract class User {

	private int nr;
	
	public User(int nr) {
		this.nr = nr;
	}
	
	public int getNr() {
		return nr;
	}
	
}
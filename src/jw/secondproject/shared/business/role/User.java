package jw.secondproject.shared.business.role;

import java.io.Serializable;

public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int nr;

	public User() {
	}

	public User(int nr) {
		this.nr = nr;
	}

	public int getNr() {
		return nr;
	}

}
package jw.secondproject.shared.business.role;

public class Student extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String vorname;

	private String klasse;

	private String betrieb;

	private boolean vollzeit;

	public Student() {
		super();
	}

	public Student(int nr) {
		super(nr);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public String getKlasse() {
		return klasse;
	}

	public String getBetrieb() {
		return betrieb;
	}

	public boolean isVollzeit() {
		return vollzeit;
	}

	@Override
	public String toString() {
		return "Student [" + nr + " name=" + name + ", vorname=" + vorname + ", klasse=" + klasse + ", betrieb="
				+ betrieb + ", vollzeit=" + vollzeit + "]";
	}

}

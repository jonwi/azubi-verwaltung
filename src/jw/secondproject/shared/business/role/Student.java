package jw.secondproject.shared.business.role;

public class Student extends User {

	private String name;
	
	private String vorname;
	
	private String klasse;
	
	private String betrieb;
	
	private boolean vollzeit;
	
	public Student(int nr) {
		super(nr);
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
		return "Student [name=" + name + ", vorname=" + vorname + ", klasse=" + klasse + ", betrieb=" + betrieb
				+ ", vollzeit=" + vollzeit + "]";
	}

		
}

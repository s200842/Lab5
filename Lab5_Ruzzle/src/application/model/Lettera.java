package application.model;

public class Lettera {
	
	private String lettera;
	private Posizione p;
	private boolean utilizzata;
	
	public Lettera(String s){
		lettera = s;
		utilizzata = false;
	}

	public String getLettera() {
		return lettera;
	}

	public void setLettera(String lettera) {
		this.lettera = lettera;
	}

	public Posizione getP() {
		return p;
	}

	public void setP(Posizione p) {
		this.p = p;
	}

	public boolean isUtilizzata() {
		return utilizzata;
	}

	public void setUtilizzata(boolean utilizzata) {
		this.utilizzata = utilizzata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lettera == null) ? 0 : lettera.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettera other = (Lettera) obj;
		if (lettera == null) {
			if (other.lettera != null)
				return false;
		} else if (!lettera.equals(other.lettera))
			return false;
		return true;
	}
	
	

}

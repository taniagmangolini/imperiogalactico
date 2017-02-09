package model;

import java.util.Date;
import java.util.Set;

public class PlanoVoo implements Comparable<PlanoVoo> {

	private Date dataCadastro;
	private Nave nave;
	private Planeta planeta;
	private Set<Tripulante> tripulantes;
	private String tripulantesString;

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public Set<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(Set<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	public String getTripulantesString() {
		StringBuilder sb = new StringBuilder();
		if (tripulantes != null && tripulantes.size() > 0) {
			for (Tripulante tripulante : tripulantes) {
				sb.append(tripulante.getName() + ", ");
			}
			if (sb.lastIndexOf(",") != -1) {
				sb.replace(sb.lastIndexOf(","), sb.length(), "");
			}
			tripulantesString = sb.toString();
		}
		return tripulantesString;
	}

	public void setTripulantesString(String tripulantesString) {
		this.tripulantesString = tripulantesString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((nave == null) ? 0 : nave.hashCode());
		result = prime * result + ((planeta == null) ? 0 : planeta.hashCode());
		result = prime * result
				+ ((tripulantes == null) ? 0 : tripulantes.hashCode());
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
		PlanoVoo other = (PlanoVoo) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (nave == null) {
			if (other.nave != null)
				return false;
		} else if (!nave.equals(other.nave))
			return false;
		if (planeta == null) {
			if (other.planeta != null)
				return false;
		} else if (!planeta.equals(other.planeta))
			return false;
		if (tripulantes == null) {
			if (other.tripulantes != null)
				return false;
		} else if (!tripulantes.equals(other.tripulantes))
			return false;
		return true;
	}

	public int compareTo(PlanoVoo o) {
		if (getDataCadastro().compareTo(o.getDataCadastro()) == -1) {
			return 1;
		} else if (getDataCadastro().compareTo(o.getDataCadastro()) == 1) {
			return -1;
		} else {
			return 0;
		}
	}

}

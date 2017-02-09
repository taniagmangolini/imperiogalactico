package model;

import java.net.URL;
import java.util.List;

public class Planeta {
	String name ;
	String diameter ;
	String rotation_period;
	String orbital_period ;
	String gravity ;
	String population;
	String climate ;
	String terrain;
	String surface_water ;
	List<String> residents ;
	String url ;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getRotation_period() {
		return rotation_period;
	}
	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}
	public String getOrbital_period() {
		return orbital_period;
	}
	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}
	public String getGravity() {
		return gravity;
	}
	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getSurface_water() {
		return surface_water;
	}
	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}
	public List<String> getResidents() {
		return residents;
	}
	public void setResidents(List<String> residents) {
		this.residents = residents;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((climate == null) ? 0 : climate.hashCode());
		result = prime * result
				+ ((diameter == null) ? 0 : diameter.hashCode());
		result = prime * result + ((gravity == null) ? 0 : gravity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((orbital_period == null) ? 0 : orbital_period.hashCode());
		result = prime * result
				+ ((population == null) ? 0 : population.hashCode());
		result = prime * result
				+ ((rotation_period == null) ? 0 : rotation_period.hashCode());
		result = prime * result
				+ ((surface_water == null) ? 0 : surface_water.hashCode());
		result = prime * result + ((terrain == null) ? 0 : terrain.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Planeta other = (Planeta) obj;
		if (climate == null) {
			if (other.climate != null)
				return false;
		} else if (!climate.equals(other.climate))
			return false;
		if (diameter == null) {
			if (other.diameter != null)
				return false;
		} else if (!diameter.equals(other.diameter))
			return false;
		if (gravity == null) {
			if (other.gravity != null)
				return false;
		} else if (!gravity.equals(other.gravity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orbital_period == null) {
			if (other.orbital_period != null)
				return false;
		} else if (!orbital_period.equals(other.orbital_period))
			return false;
		if (population == null) {
			if (other.population != null)
				return false;
		} else if (!population.equals(other.population))
			return false;
		if (rotation_period == null) {
			if (other.rotation_period != null)
				return false;
		} else if (!rotation_period.equals(other.rotation_period))
			return false;
		if (surface_water == null) {
			if (other.surface_water != null)
				return false;
		} else if (!surface_water.equals(other.surface_water))
			return false;
		if (terrain == null) {
			if (other.terrain != null)
				return false;
		} else if (!terrain.equals(other.terrain))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	

}

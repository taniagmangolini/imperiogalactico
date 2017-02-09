package model;

import java.util.List;

public class Nave {

	private String name;
	private String model;
	private String starship_class;
	private String manufacturer;
	private String cost_in_credits;
	private String length;
	private String crew;
	private String passengers;
	private String max_atmosphering_speed;
	private String hyperdrive_rating;
	private String mglt;
	private String cargo_capacity;
	private String consumables;
	private List<Tripulante> tripulantes;
	private String url;
	
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStarship_class() {
		return starship_class;
	}

	public void setStarship_class(String starship_class) {
		this.starship_class = starship_class;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCost_in_credits() {
		return cost_in_credits;
	}

	public void setCost_in_credits(String cost_in_credits) {
		this.cost_in_credits = cost_in_credits;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getMax_atmosphering_speed() {
		return max_atmosphering_speed;
	}

	public void setMax_atmosphering_speed(String max_atmosphering_speed) {
		this.max_atmosphering_speed = max_atmosphering_speed;
	}

	public String getHyperdrive_rating() {
		return hyperdrive_rating;
	}

	public void setHyperdrive_rating(String hyperdrive_rating) {
		this.hyperdrive_rating = hyperdrive_rating;
	}

	public String getMglt() {
		return mglt;
	}

	public void setMglt(String mglt) {
		mglt = mglt;
	}

	public String getCargo_capacity() {
		return cargo_capacity;
	}

	public void setCargo_capacity(String cargo_capacity) {
		this.cargo_capacity = cargo_capacity;
	}

	public String getConsumables() {
		return consumables;
	}

	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}

	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cargo_capacity == null) ? 0 : cargo_capacity.hashCode());
		result = prime * result
				+ ((consumables == null) ? 0 : consumables.hashCode());
		result = prime * result
				+ ((cost_in_credits == null) ? 0 : cost_in_credits.hashCode());
		result = prime * result + ((crew == null) ? 0 : crew.hashCode());
		result = prime
				* result
				+ ((hyperdrive_rating == null) ? 0 : hyperdrive_rating
						.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime
				* result
				+ ((max_atmosphering_speed == null) ? 0
						: max_atmosphering_speed.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((starship_class == null) ? 0 : starship_class.hashCode());
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
		Nave other = (Nave) obj;
		if (cargo_capacity == null) {
			if (other.cargo_capacity != null)
				return false;
		} else if (!cargo_capacity.equals(other.cargo_capacity))
			return false;
		if (consumables == null) {
			if (other.consumables != null)
				return false;
		} else if (!consumables.equals(other.consumables))
			return false;
		if (cost_in_credits == null) {
			if (other.cost_in_credits != null)
				return false;
		} else if (!cost_in_credits.equals(other.cost_in_credits))
			return false;
		if (crew == null) {
			if (other.crew != null)
				return false;
		} else if (!crew.equals(other.crew))
			return false;
		if (hyperdrive_rating == null) {
			if (other.hyperdrive_rating != null)
				return false;
		} else if (!hyperdrive_rating.equals(other.hyperdrive_rating))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (max_atmosphering_speed == null) {
			if (other.max_atmosphering_speed != null)
				return false;
		} else if (!max_atmosphering_speed.equals(other.max_atmosphering_speed))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (starship_class == null) {
			if (other.starship_class != null)
				return false;
		} else if (!starship_class.equals(other.starship_class))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}



}

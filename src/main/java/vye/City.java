package vye;

import java.util.ArrayList;
import java.util.List;

public class City {
	
	private List<Mob> citizens;
	private String name;
	private int population;
	private char type;
	
	public City(String name,char type, int population) {
		
		this.name = name;
		this.type = type;
		this.population = population;
		
		this.citizens = new ArrayList<Mob>(population);
	}

	public List<Mob> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Mob> citizens) {
		this.citizens = citizens;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	
}

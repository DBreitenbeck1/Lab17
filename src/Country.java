import java.util.Comparator;

public class Country implements Comparable<Country>{
	private String name;
	private int population;
	private String capital;
	
	
	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Country(String n, int pop) {
		this.name=n;
		this.population=pop;
	}
	
	public Country(String n, int pop, String c) {
		this.name=n;
		this.population=pop;
		this.capital=c;
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
	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + "]";
	}

	@Override
	public int compareTo(Country o) {
		int compare = name.compareTo(o.name);
	return compare;
	}

	
	

	

}

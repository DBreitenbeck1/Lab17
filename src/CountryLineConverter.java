
public class CountryLineConverter implements LineConverter<Country> {

	@Override
	public String toLine(Country object) {
		return String.format("%s\t%d\t%s", object.getName(), object.getPopulation(), object.getCapital());
	}

	@Override
	public Country fromLine(String line) {
		String[] list = line.split("\t");
		String name = list[0];
		int pop = Integer.parseInt(list[1]);
		String capital = list[2];
		return new Country(name, pop, capital);
	}

}

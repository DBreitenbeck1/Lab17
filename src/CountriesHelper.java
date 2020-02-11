import java.util.*;

public class CountriesHelper {

	public static void showMenu() {
		
		System.out.println("Options:");
		System.out.println("-------");
		System.out.println("1. Display Saved Countries");
		System.out.println("2. Add a Country");
		System.out.println("3. Delete a Country");
		System.out.println("4. Edit Country Population");
		System.out.println("5. Sort Countries by Name");
		System.out.println("6. Sort Countries by Population");
		System.out.println("7. Quit");
		System.out.println();
	}

	public static Country makeCountry() {
		Scanner scanner = new Scanner(System.in);
		String name = Validator.getString(scanner, "Enter Country Name: ");
		int pop = Validator.getInt(scanner, "Enter Country Population in Millions: ");
		String capital = Validator.getString(scanner, "Enter Capital City: ");

		return new Country(name, pop, capital);
	}

	public static boolean yesNo(String prompt) {
		Scanner scanner = new Scanner(System.in);
		boolean yes = false;
		String y = Validator.getStringMatchingRegex(scanner, prompt + "[y/n]\n", "[y,n]").trim().toLowerCase();
		if (y.contentEquals("y")) {
			yes = true;
		}
		return yes;
	}

	public static void showCountries(List<Country> countries) {
		Scanner scanner =new Scanner(System.in);
		System.out.printf("%s\t\t%s\t%s\n", "Name:", "Population:", "Capital:");
		System.out.printf("%s\t\t%s\t%s\n","-----","----------","-------");
		for (Country c : countries) {
			System.out.print(c.getName() + "\t\t");
			System.out.print(c.getPopulation() + " million");
			System.out.println("\t"+c.getCapital());
		}
		System.out.println("Press enter to continue.");
		scanner.nextLine();
		
	}

	public static boolean quit() {
		boolean quit = yesNo("Do you really want to quit?");
		return quit;

	}

	public static List<Country> remove(List<Country> countries) {
		Scanner scanner = new Scanner(System.in);
		String n = Validator.getString(scanner, "Which country do you want to remove (0 to cancel)?\n").trim().toLowerCase();
		Country s =null;
		if (!n.equals("0")) {
		for (Country c : countries) {
			if (c.getName().trim().toLowerCase().equals(n)) {
				s=c;
			}	
		}
		if(countries.contains(s)) {
		countries.remove(s);
		} else {
			System.out.println("No such country listed");
			remove(countries);
		}
		}
		return countries;

	}

	public static void sortName(List<Country> countries){
		Scanner scanner = new Scanner(System.in);
		Collections.sort(countries);
		System.out.printf("%s\t\t%s\t%s\n", "Name", "Population", "Capital");
		System.out.printf("%s\t\t%s\t%s\n","-----","----------","-------");
		for (Country c: countries) {
			System.out.println(c.getName()+"\t\t" + c.getPopulation()+" million"+"\t"+c.getCapital());
		}
		System.out.println("Press enter to continue.");
		scanner.nextLine();
		
	}
	
	public static void sortPop(List<Country> countries) {
		Scanner scanner = new Scanner(System.in);
		Collections.sort(countries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return o2.getPopulation()-o1.getPopulation();
			}	
		});
		System.out.printf("%s\t\t%s\t%s\n", "Name", "Population", "Capital");
		System.out.printf("%s\t\t%s\t%s\n","-----","----------","-------");
		for (Country c: countries) {
			System.out.println(c.getName()+"\t\t" + c.getPopulation()+" million" +"\t"+c.getCapital());
		}
		System.out.println("Press enter to continue.");
		scanner.nextLine();
				
		
	}
	
	public static List<Country> editPop(List<Country> countries) {
		Scanner scanner = new Scanner(System.in);
		String country = Validator.getString(scanner, "Which country do you want to edit?(0 to cancel)\n").trim().toLowerCase();
		Country s =null;
		int t;
		if (!country.equals("0")) {
		for (Country c : countries) {
			if (c.getName().trim().toLowerCase().equals(country)) {
				t = countries.indexOf(c);
				s=c;
			}	
		}
		if(countries.contains(s)) {
			int p = Validator.getInt(scanner, "Enter new Population: ");
			s.setPopulation(p);
		}else {
			System.out.println("No such country listed");
			editPop(countries);
		}
		System.out.println("Press enter to continue.");
		scanner.nextLine();
		}
		return countries;
	}
	
}

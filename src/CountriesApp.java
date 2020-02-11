import java.util.*;

public class CountriesApp {
	private static FileHelper<Country> fileHelper = new FileHelper<>("src/countries.txt", new CountryLineConverter());

	private static CountriesHelper ch = new CountriesHelper();
	private static boolean end = false;

	public static void main(String[] args) {

		System.out.println("The Countries of the World");
		System.out.println("==========================");
		do {
			List<Country> countries = fileHelper.readAll();

			CountriesHelper.showMenu();

			menuSelect(countries);

		} while (!end);

		System.out.println("Goodbye");

	}

	public static void menuSelect(List<Country> countries) {
		Scanner scanner = new Scanner(System.in);
		int a = Validator.getInt(scanner, "Enter Selection: ");
		switch (a) {
		case 1: {
			ch.showCountries(countries);
			break;
		}
		case 2: {
			fileHelper.append(ch.makeCountry());
			break;
		}
		case 3: {
			fileHelper.rewrite(ch.remove(countries));
			System.out.println();
			break;
		}
		case 4: {
			fileHelper.rewrite(ch.editPop(countries));
			System.out.println();
			break;
		}
		case 5: {
			ch.sortName(countries);
			break;
		}
		case 6: {
			ch.sortPop(countries);
			break;
		}
		case 7: {
			end = ch.quit();
			break;
		}

		}

	}

}

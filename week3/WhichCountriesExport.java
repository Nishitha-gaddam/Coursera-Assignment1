package week3;

import org.apache.commons.csv.*;

import edu.duke.*;

public class WhichCountriesExport {

	public String countryInfo(CSVParser parser, String country) {
		for (CSVRecord record : parser) {
			String myCountry = record.get("Country");
			if (myCountry.contains(country)) {
				String exports = record.get("Exports");
				String value = record.get("Value (dollars)");
				String data = myCountry + ": " + exports + ": " + value;
				return data;
			}
		}
		return "NOT FOUND";
	}

	public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
		for (CSVRecord record : parser) {
			String exports = record.get("Exports");
			String country = record.get("Country");
			if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
				System.out.println(country);
			}
		}
	}

	public int numberOfExporters(CSVParser parser, String exportItem) {
		int numOfCountries = 0;
		for (CSVRecord record : parser) {
			String exports = record.get("Exports");
			if (exports.contains(exportItem)) {
				numOfCountries++;
			}
		}
		return numOfCountries;
	}

	public void bigExporters(CSVParser parser, String amount) {
		for (CSVRecord record : parser) {
			String value = record.get("Value (dollars)");
			String country = record.get("Country");

			if (value.length() > amount.length()) {
				System.out.println(country + ": " + value);
			}
		}
	}

	public void tester() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		int numOfCountries = numberOfExporters(parser, "cocoa");
		System.out.println(numOfCountries);

	}
	
	public static void main(String[] args) {
		WhichCountriesExport e=new WhichCountriesExport();
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
     	e.tester();
     	e.bigExporters(parser, "100");
     	e.numberOfExporters(parser, "cocoa");
		
		
		
	}

}
package week3;

/**
 * Find the highest (hottest) temperature in any number of files of CSV weather data chosen by the user.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMinimumTemperature {
	public CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord coldestTemperature = null;
		for (CSVRecord currRow : parser) {
			if (coldestTemperature == null) {
				coldestTemperature = currRow;
			} else {
				double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
				double lowestTemp = Double.parseDouble(coldestTemperature.get("TemperatureF"));
				if (currTemp < lowestTemp) {
					coldestTemperature = currRow;
				}
			}
		}
		return coldestTemperature;
	}

	public String fileWithColdestTemperature() {

		DirectoryResource dr = new DirectoryResource();
		File fileName = null;
		CSVRecord coldestTemperature = null;

		for (File file : dr.selectedFiles()) {
			FileResource fr = new FileResource(file);
			CSVRecord currRow = coldestHourInFile(fr.getCSVParser());

			if (coldestTemperature == null) {
				coldestTemperature = currRow;
				fileName = file;
			} else {
				double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
				double lowestTemp = Double.parseDouble(coldestTemperature.get("TemperatureF"));
				if (currTemp < lowestTemp && currTemp > -50) {
					coldestTemperature = currRow;
					fileName = file;
				}
			}
		}
		return fileName.getAbsolutePath();
	}

	public CSVRecord lowestHumidityInFile(CSVParser parser) {
		CSVRecord lowestHumdity = null;
		int currHumdity;
		int lowHumdudity;
		for (CSVRecord currRow : parser) {
			if (lowestHumdity == null) {
				lowestHumdity = currRow;
			}

			else {
				if (!currRow.get("Humidity").equals("N/A") && !lowestHumdity.get("Humidity").equals("N/A")) {
					currHumdity = Integer.parseInt(currRow.get("Humidity"));
					lowHumdudity = Integer.parseInt(lowestHumdity.get("Humidity"));

					if (currHumdity < lowHumdudity) {
						lowestHumdity = currRow;
					}
				}
			}
		}
		return lowestHumdity;
	}

	public CSVRecord lowestHumidityInManyFiles() {
		DirectoryResource dr = new DirectoryResource();
		CSVRecord lowestHumdity = null;
		int currHumdity;
		int lowHumdity;

		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser();
			CSVRecord currRow = lowestHumidityInFile(parser);

			if (lowestHumdity == null) {
				lowestHumdity = currRow;
			} else {
				int currTemp = Integer.parseInt(currRow.get("Humidity"));
				int lowestTemp = Integer.parseInt(lowestHumdity.get("Humidity"));
				if (currTemp < lowestTemp) {
					lowestHumdity = currRow;
				}

				else {
					if (currRow.get("Humidity") != "N/A" && lowestHumdity.get("Humidity") != "N/A") {
						currHumdity = Integer.parseInt(currRow.get("Humidity"));
						lowHumdity = Integer.parseInt(lowestHumdity.get("Humidity"));

						if (currHumdity < lowHumdity) {
							lowestHumdity = currRow;
						}
					}
				}
			}
		}
		return lowestHumdity;
	}

	public double averageTemperatureInFile(CSVParser parser) {
		double num = 0.0;
		double sum = 0.0;

		for (CSVRecord record : parser) {
			double temp = Double.parseDouble(record.get("TemperatureF"));
			sum += temp;
			num++;
		}

		double averageTemperature = sum / num;
		return averageTemperature;
	}

	public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
		double num = 0.0;
		double sum = 0.0;

		for (CSVRecord record : parser) {
			double temp = Double.parseDouble(record.get("TemperatureF"));
			int humidity = Integer.parseInt(record.get("Humidity"));
			if (humidity >= value) {
				sum += temp;
				num++;
			}
		}

		double averageTemperature = sum / num;
		return averageTemperature;
	}

	public void testColdestHourInFile() {
		FileResource fr = new FileResource();

		CSVRecord lowestTemp = coldestHourInFile(fr.getCSVParser());
		System.out.println(lowestTemp.get("TemperatureF") + ":: " + lowestTemp.get("DateUTC"));
	}

	public void testFileWithColdestTemperature() {
		String fileWithColdestTemp = fileWithColdestTemperature();
		File f = new File(fileWithColdestTemp);
		String fileName = f.getName();

		System.out.println("Coldest day = " + fileName);

		FileResource fr = new FileResource(f);
		CSVRecord lowestTemp = coldestHourInFile(fr.getCSVParser());

		System.out.println("Coldest Temperature is: " + lowestTemp.get("TemperatureF"));

	}

	public void testLowestHumidityInFile() {
		FileResource fr = new FileResource();
		CSVRecord lowestHumdity = lowestHumidityInFile(fr.getCSVParser());

		System.out.println(lowestHumdity.get("Humidity") + lowestHumdity.get("DateUTC"));
	}

	public void testLowestHumidityInManyFiles() {
		CSVRecord record = lowestHumidityInManyFiles();
		System.out.println(record.get("Humidity") + record.get("DateUTC"));
	}

	public void testAverageTemperatureInFile() {
		FileResource fr = new FileResource();

		double avg = averageTemperatureInFile(fr.getCSVParser());

		System.out.println("average temperature = " + avg);
	}

	public void testAverageTemperatureWithHighHumidityInFile() {
		FileResource fr = new FileResource();
		double avg = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);

		if (!Double.isNaN(avg)) {
			System.out.println("average temperature = " + avg);
		} else {
			System.out.println("No Temperature was found");
		}
	}
	
	public static void main(String[] args) { 
		CSVMinimumTemperature  c =new CSVMinimumTemperature();
		c.testAverageTemperatureInFile();
		c.testAverageTemperatureWithHighHumidityInFile();
		c.testColdestHourInFile();
		c.testFileWithColdestTemperature();
		c.testLowestHumidityInFile();
		c.testLowestHumidityInManyFiles();
		
		
	}
}

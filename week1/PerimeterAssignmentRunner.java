package week1;

import java.io.File;
import edu.duke.*;

public class PerimeterAssignmentRunner {
	public double getPerimeter(Shape s) {

		double totalPerim = 0.0;

		Point prevPt = s.getLastPoint();

		for (Point currPt : s.getPoints()) {

			double currDist = prevPt.distance(currPt);

			totalPerim = totalPerim + currDist;

			prevPt = currPt;
		}

		return totalPerim;
	}

	public int getNumPoints(Shape s) {
		int numPoints = 0;
		for (Point pt : s.getPoints()) {
			numPoints += 1;
		}
		return numPoints;
	}

	public double getAverageLength(Shape s) {
		double averageLength = getPerimeter(s) / (double) getNumPoints(s);

		return averageLength;
	}

	public double getLargestSide(Shape s) {
		Point lastPoint = s.getLastPoint();
		double largestSide = 0.0;
		for (Point pt : s.getPoints()) {
			double dist = lastPoint.distance(pt);
			if (dist > largestSide) {
				largestSide = dist;
			}
			lastPoint = pt;
		}
		return largestSide;
	}

	public double getLargestX(Shape s) {
		Point lastPoint = s.getLastPoint();
		int lastPointX = lastPoint.getX();
		double largestX = (double) lastPointX;

		for (Point pt : s.getPoints()) {
			int X = pt.getX();
			if (X > largestX) {
				largestX = (double) X;
			}
		}
		return largestX;
	}

	public double getLargestPerimeterMultipleFiles() {
		DirectoryResource dr = new DirectoryResource();
		double largestPerimeter = 0.0;

		for (File f : dr.selectedFiles()) {
			FileResource file = new FileResource(f);
			double perimeter = getPerimeter(new Shape(file));
			if (perimeter > largestPerimeter) {
				largestPerimeter = perimeter;
			}
		}
		return largestPerimeter;
	}

	public String getFileWithLargestPerimeter() {
		DirectoryResource dr = new DirectoryResource();
		double largestPerimeter = 0.0;
		File largestFile = null;

		for (File f : dr.selectedFiles()) {
			FileResource file = new FileResource(f);
			double perimeter = getPerimeter(new Shape(file));
			if (perimeter > largestPerimeter) {
				largestPerimeter = perimeter;
				largestFile = f;
			}
		}

		return largestFile.getName();
	}

	public void testPerimeter() {
		FileResource fr = new FileResource();
		Shape s = new Shape(fr);
		double length = getPerimeter(s);
		int numPoints = getNumPoints(s);
		double averageLength = getAverageLength(s);
		double largestSide = getLargestSide(s);
		double largestX = getLargestX(s);

		System.out.println("perimeter = " + length);
		System.out.println("Number of Points = " + numPoints);
		System.out.println("Average Length = " + averageLength);
		System.out.println("Largest Side = " + largestSide);
		System.out.println("Largest X is = " + largestX);
	}

	public void testPerimeterMultipleFiles() {
		Double largestPerimeter = getLargestPerimeterMultipleFiles();
		System.out.println("Largest perimeter is: " + largestPerimeter);
	}

	public void testFileWithLargestPerimeter() {
		String fileWithLargestPerimeter = getFileWithLargestPerimeter();
		System.out.println("Largest perimeter file is: " + fileWithLargestPerimeter);
	}

	// This method creates a triangle that you can use to test your other methods
	public void triangle() {
		Shape triangle = new Shape();
		triangle.addPoint(new Point(0, 0));
		triangle.addPoint(new Point(6, 0));
		triangle.addPoint(new Point(3, 6));
		for (Point p : triangle.getPoints()) {
			System.out.println(p);
		}
		double peri = getPerimeter(triangle);
		System.out.println("perimeter = " + peri);
	}

	// This method prints names of all files in a chosen folder that you can use to
	// test your other methods
	public void printFileNames() {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			System.out.println(f);
		}
	}

	public static void main(String[] args) {
		PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
		pr.testPerimeter();
	}
}
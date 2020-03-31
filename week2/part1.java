package week2;

public class part1 {
	public String findSimpleGene(String dna) {
		String result = "";
		int start = dna.indexOf("ATG");
		if (start == -1) {
			return result;
		}
		int stop = dna.indexOf("TAA", start);
		if (stop == -1) {
			return result;
		}

		if ((stop - start) % 3 == 0) {
			result = dna.substring(start, stop + 3);
			return result;
		} else {
			return result;
		}
	}

	public void testSimpleGene() {
		String test1 = "ACCATGCCCAAAGGTAA";
		String test2 = "CGGCAATGCAGCGATAC";

		System.out.println("The string is: " + test1 + ". The Gene is: " + findSimpleGene(test1));
		System.out.println("The string is: " + test2 + ". The Gene is: " + findSimpleGene(test2));

	}

	public static void main(String[] args) {
		part1 p1 = new part1();
		p1.testSimpleGene();
	}
}

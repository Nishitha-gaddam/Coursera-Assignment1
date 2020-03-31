package week2;

public class part2 {

	
	public String findSimpleGene(String dna) {
       String startCodon="ATG";
       String stopCodon="TAA";
		String result = "";
        if( Character.isUpperCase(dna.charAt(0)) ) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
       } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        
        int start = dna.indexOf(startCodon);
      if(start == -1) {
            return result;
        }
        
        int stop = dna.indexOf(stopCodon, start);
        if(stop == -1) {
            return result;
        }
        
        if((stop - start) % 3 == 0) {
        	result=dna.substring(start, stop+3);
           return result;
        }
        else {
            return result;
        }
	}
 

	public void testSimpleGene() {
		String test1 = "ATGAATAACATAAGA";
		String test2 = "CCAATGCAGCGATAC";
		String test3 = "atgaaccatataaatgtaa";

		System.out.println("The string is: " + test1 + ". The Gene is: " + findSimpleGene(test1));
		System.out.println("The string is: " + test2 + ". The Gene is: " + findSimpleGene(test2));
		System.out.println("The string is: " + test3 + ". The Gene is: " + findSimpleGene(test3));
	
	}
	public static void main(String[] args) {
		part2 p2=new part2();
		p2.testSimpleGene();
	}

}


package week2;

public class part3 {
	public boolean twoOccurrences(String stringa, String stringb) {
		int startindex = stringb.indexOf(stringa);
		if (startindex != -1) {
			int index = stringb.indexOf(stringa, startindex + 1);
			if (index != -1) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	public void testing() {
		System.out.println(twoOccurrences("e", "monkey on a tree"));
		System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("c", "banana"));
        System.out.println(lastPart("an", "banana"));
		System.out.println(twoOccurrences("s", "stress"));
	}

	public String lastPart(String stringa, String stringb) {
		if (stringb.indexOf(stringa) != -1) {
			int index = stringb.indexOf(stringa);
			return stringb.substring(index + stringa.length(), stringb.length());
		} else {
			return stringb;
		}
	}

	public static void main() {
		part3 p3 = new part3();
		p3.testing();
	}
}
package week2;
import edu.duke.*;
import java.util.*;

public class part4 {
    public void CheckUrl(String url) {
        URLResource u = new URLResource(url);
        for(String word : u.words()) {
            if(word.toLowerCase().indexOf("youtube.com") != -1) {
                int quoteIndex = word.indexOf("\"");
                int lastQouteIndex = word.indexOf("\"", quoteIndex+1);
                System.out.println(word.substring(quoteIndex+1, lastQouteIndex));
                
            }
        }
    }
    
    public void testUrl() {
        CheckUrl("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
    
    public static void main() {
        part4 p4 = new part4();
        p4.testUrl();
    }
}
import java.util.HashMap;
/**
 *
 * @author Akash
 */
public class SCSAlgorithm  extends TextSample   {

	public static void main(String... arrays) { 
		    String find = "dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5";
	        long start = System.currentTimeMillis();
	        System.out.println(startSCS(find, txtsample));
	        System.out.println(System.currentTimeMillis() - start+" Millis");
	}
	
	private static int startSCS(String toFind, String paragraph) {
		char[] charArray = toFind.toCharArray();
		HashMap<Character, Integer> charMap = new HashMap<>();
		int y = 0;
		for (Character character : charArray) {
			charMap.put(character, y++);
		}
		int findLength = toFind.length();
		int findCharLen = toFind.length()-1;
		int paragraphLength = paragraph.length();
		boolean pass=true;
		int j = 0;
		int count = 0;
		for (int i = 0; i < paragraphLength;) {
			Integer ln = 0;
			if ((ln = charMap.get(paragraph.charAt(i))) != null) {
				if (j == findCharLen) {
					count++;
					j = 0;
					++i;
					pass=true;
				} else if (i - ln > 0 && pass) {
					i = i - ln ;
					pass=false;
				}else {
					j++;
					++i;
				}
			} else {
				i = i + findLength;
				j = 0;
				pass=true;
			}
		}
		return count;
	}
}

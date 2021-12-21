package kosinov;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Helper {


	public static String[] SplitString(String text) {
		List<String> words = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for(char symbol : text.toCharArray()) {
			if((int)symbol == 32 | (int)symbol == 33 |(int)symbol == 58|(int)symbol == 44|(int)symbol == 46) {
				words.add(builder.toString());
				builder = new StringBuilder();
				continue;
			}
			builder.append(symbol);
		}
		if(builder.length() != 0) {
			words.add(builder.toString());
		}
		for (int i = 0; i < words.size(); i++) {
			if(words.get(i).length() == 0) {
				words.remove(i);
			}
		}
		String[] output = new String[words.size()];
		for (int i = 0; i < words.size(); i++) {
			output[i] = words.get(i);
		}
		return output;
	}

	public static void PrintResult (String[]words){

		System.out.println( "==========================");
		System.out.println( "A Word" + "\t\t\t" + "Count");
		System.out.println( "==========================");

		HashMap<String, Integer> wordToCount = new HashMap<>();
		for (String word : words) {
			if (!wordToCount.containsKey(word)) {
				wordToCount.put(word, 0);
			}
			wordToCount.put(word, wordToCount.get(word) + 1);
		}

		for (String word : wordToCount.keySet()) {
			System.out.println(word + "\t\t\t" + wordToCount.get(word));
		}
		System.out.println( "==========================");
	}
}

package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Start {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("dog");
		list.add("god");
		list.add("odg");
		list.add("fish");
		list.add("shif");
		list.add("ishf");
		list.add("matart");
		list.add("ttarma");
		list.add("mattar");
		
		System.out.println(findFirstAnagram(findAnagram(list)));
	}
	// dog, god, odg
	private static Map<String, List<String>> findAnagram(List<String> words){
		
		Map<String,List<String>> anagrams = null;
		
		if(words ==null || words.size() == 0) {
			return null;
		}
		
		//instinliz anagrams to the Interface implementation
		anagrams = new HashMap<String, List<String>>();
		
		//dog
		for(String word : words) {
			char[] charArray = word.trim().toCharArray();
			Arrays.sort(charArray);
			//dgo as a key
			String sortedWord = String.valueOf(charArray);
			
			//
			if(anagrams.containsKey(sortedWord)) {
				//as a Value
				List<String> newList = anagrams.get(sortedWord);
				//added the Value
				newList.add(word);
				anagrams.put(sortedWord, newList);
			}else {
				//create a list of keys
				List<String> list = new ArrayList<String>();
				list.add(word);
				anagrams.put(sortedWord, list);
			}
		}
		return anagrams;
		
	}
	
	private static List<String> findFirstAnagram(Map<String, List<String>> list) {
		
		List<String> firstAnagramWords = new ArrayList<String>();
		if(list !=null) {
			
		
		for(Map.Entry<String, List<String>> entry : list.entrySet()) {
		    //to get only the First new anagram word
		    String value = entry.getValue().get(0);
		    //added to the new anagram list words
		    firstAnagramWords.add(value);
		}
		}
		return firstAnagramWords;
	}

}

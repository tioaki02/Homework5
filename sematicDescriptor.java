package homework5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class contains method that get a list which has lists that represents the
 * sentences(created by another class) and return a HashMap d to for each word w
 * that appears in at least one sentence, and element d [w] is HashMap
 * representing the semantic vector of the word w.
 * 
 * @author Theofanis Ioakim,Klea Kleanthous
 * @version 1.0
 * @since 30/4/18
 */
public class sematicDescriptor {
	private HashMap<String, HashMap<String, Integer>> sematic;

	/**
	 * The constructor that creates the hashmap
	 * 
	 * @param a
	 * @param word
	 * @param choices
	 * @param c
	 */
	public sematicDescriptor(ArrayList<ArrayList<String>> a, String word, String[] choices, int c) {
		this.sematic = new HashMap<String, HashMap<String, Integer>>();
		if (c == 1)
			this.build_sematic_descriptors(a, word, choices);
		if (c == 2)
			this.build_sematic_descriptors_slow(a);
	}

	/**
	 * The getter of the Semantic
	 * 
	 * @return hashmap
	 */
	public HashMap<String, HashMap<String, Integer>> getSematic() {
		return sematic;
	}

	/**
	 * The setter of the HashMap
	 * 
	 * @param sematic
	 */
	public void setSematic(HashMap<String, HashMap<String, Integer>> sematic) {
		this.sematic = sematic;
	}

	/**
	 * The method that builds the semantic descriptors using Hashmaps and
	 * ArrayLists.
	 * 
	 * @param a
	 * @param word
	 * @param choices
	 */
	public void build_sematic_descriptors(ArrayList<ArrayList<String>> a, String word, String choices[]) {
		this.add_hashmap_of_word(a, word);
		for (String choiceWord : choices) {
			this.add_hashmap_of_word(a, choiceWord);
		}
	}

	/**
	 * The method that adds the HashMap of the word if the HashMap contains the
	 * selected word
	 * 
	 * @param a
	 * @param selectedWord
	 */
	public void add_hashmap_of_word(ArrayList<ArrayList<String>> a, String selectedWord) {
		HashMap<String, Integer> sematicArray = new HashMap<String, Integer>();
		if (!sematic.containsKey(selectedWord)) {
			for (ArrayList<String> temp : a) {
				if (temp.contains(selectedWord)) {
					for (String tempWord : temp) {
						if (sematicArray.containsKey(tempWord)) {
							sematicArray.put(tempWord, sematicArray.get(tempWord) + 1);
						} else {
							sematicArray.put(tempWord, 1);
						}
					}
				}
			}
			sematic.put(selectedWord, sematicArray);
		}
	}

	/**
	 * The method that creates all the semantic descriptors slowly.
	 * 
	 * @param a
	 */
	public void build_sematic_descriptors_slow(ArrayList<ArrayList<String>> a) {
		System.out.println("Building descriptors.Please wait this might take several minutes...");
		for (ArrayList<String> selected : a) {
			for (String selectedWord : selected) {
				if (!sematic.containsKey(selectedWord)) {
					HashMap<String, Integer> sematicArray = new HashMap<String, Integer>();
					for (ArrayList<String> temp : a) {
						if (temp.contains(selectedWord)) {
							for (String tempWord : temp) {
								if (!tempWord.equals(selectedWord)) {
									if (sematicArray.containsKey(tempWord)) {
										sematicArray.put(tempWord, sematicArray.get(tempWord) + 1);
									} else {
										sematicArray.put(tempWord, 1);
									}
								}
							}
						}
					}
					sematic.put(selectedWord, sematicArray);
				}
			}
		}
	}

	/**
	 * The toString method which prints the hashmap
	 */
	public String toString() {
		for (String key : this.sematic.keySet()) {
			System.out.print("{");
			System.out.print(key + " }" + sematic.get(key));
			System.out.println();
		}
		return null;

	}
}

package homework5;

import java.util.HashMap;

/**
 * In this class the are methods which function based on a word word, a list of
 * choices, and HashMap semantic_descriptors created in another class and should
 * find the word from the list choices that has the most semantic resemblance to
 * the word word. The semantic similarity is calculated using data in HashMap
 * semantic_descriptors
 * 
 * @author Theofanis Ioakim , Klea Kleanthous
 * @version 1.0
 * @since 30/4/18
 *
 */
public class similarWord {
	private String word;
	private String[] choices;
	private sematicDescriptor desc;
	private String ans;
	private boolean foundAns;

	/**
	 * Constructor
	 * 
	 * @param a
	 * @param word
	 * @param choices
	 */
	public similarWord(sematicDescriptor a, String word, String[] choices) {
		this.word = word;
		this.choices = choices;
		this.desc = a;
		int choice = this.most_similar_word();
		if (choice == -1)
			this.foundAns = false;
		else {
			this.foundAns = true;
			this.ans = choices[choice];
		}

	}

	/**
	 * Returns the position of the most Similar Word
	 * 
	 * @return integer
	 */
	public int most_similar_word() {
		HashMap<String, Integer> word = null;
		if (desc.getSematic().containsKey(this.word))
			word = desc.getSematic().get(this.word);
		else {
			this.foundAns = false;
			return -1;
		}
		double choicesSin[] = new double[choices.length];
		for (int i = 0; i < this.choices.length; i++) {
			if (desc.getSematic().containsKey(choices[i]))
				choicesSin[i] = cosine_similarity(word, desc.getSematic().get(choices[i]));
			else
				choicesSin[i] = 0;
		}
		double max = -1;
		int pos = -1;
		for (int i = 0; i < choicesSin.length; i++) {
			if (choicesSin[i] > max) {
				max = choicesSin[i];
				pos = i;
			}
		}
		return pos;

	}

	/**
	 * Getter of the word
	 * 
	 * @return String
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Setter of the String word
	 * 
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Getter of the Choices array
	 * 
	 * @return String[]
	 */
	public String[] getChoices() {
		return choices;
	}

	/**
	 * Setter of the array
	 * 
	 * @param choices
	 */
	public void setChoices(String[] choices) {
		this.choices = choices;
	}

	/**
	 * Getter of the semantic descriptor
	 * 
	 * @return sematicDescriptor
	 */
	public sematicDescriptor getDesc() {
		return desc;
	}

	/**
	 * Setter of the semantic descriptor
	 * 
	 * @param desc
	 */
	public void setDesc(sematicDescriptor desc) {
		this.desc = desc;
	}

	/**
	 * Getter of the answer
	 * 
	 * @return String
	 */
	public String getAns() {
		return ans;
	}

	/**
	 * Setter of the String ans
	 * 
	 * @param ans
	 */
	public void setAns(String ans) {
		this.ans = ans;
	}

	/**
	 * Returns the value of the foundAns
	 * 
	 * @return boolean
	 */
	public boolean isFoundAns() {
		return foundAns;
	}

	/**
	 * Sets the value of a boolean
	 * 
	 * @param foundAns
	 */
	public void setFoundAns(boolean foundAns) {
		this.foundAns = foundAns;
	}

	/**
	 * Static method which returns a square root of the sum of squares
	 * 
	 * @param vec
	 * @return double
	 */
	public static double norm(HashMap<String, Integer> vec) {
		double sum_of_squares = 0.0;
		for (String key : vec.keySet()) {
			sum_of_squares = sum_of_squares + vec.get(key) * vec.get(key);
		}
		return Math.sqrt(sum_of_squares);
	}

	/**
	 * A static method that returns the cosine
	 * 
	 * @param vec1
	 * @param vec2
	 * @return double
	 */
	public static double cosine_similarity(HashMap<String, Integer> vec1, HashMap<String, Integer> vec2) {
		double dot_product = 0.0;
		for (String key : vec1.keySet()) {
			if (vec2.containsKey(key)) {
				dot_product = dot_product + vec1.get(key) * vec2.get(key);
			}
		}
		return dot_product / (norm(vec1) * norm(vec2));
	}

}

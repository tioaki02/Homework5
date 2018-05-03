package homework5;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class contains methods which get a String and return an ArrrayList with
 * ArrayLists of Strings that include every sentence's words.
 * 
 * @author Theofanis Ioakim,Klea Kleanthous
 * @version 1.0
 * @since 30/4/18
 */
public class sentenceList {

	private ArrayList<String> list;

	/**
	 * The constructor which creates the ArrayList.
	 */
	public sentenceList() {
		this.setList(new ArrayList<String>());

	}

	/**
	 * The function that splits the sentences to words using StringTokenizer and
	 * turns them to lower case and returns false if the list has empty space
	 * otherwise it returns true.
	 * 
	 * @param sentence
	 * @return boolean
	 */
	public boolean getSentenceLists(String sentence) {
		StringTokenizer word = new StringTokenizer(sentence, ",'` -:;", false);
		while (word.hasMoreTokens()) {
			list.add(word.nextToken().toLowerCase());
		}
		if (this.list.isEmpty()) {
			return false;
		} else
			return true;
	}

	/**
	 * The getter of the List.
	 * 
	 * @return ArrayList
	 */
	public ArrayList<String> getList() {
		return list;
	}

	/**
	 * The setter of the ArrayList.
	 * 
	 * @param list
	 */
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
}

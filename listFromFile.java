
package homework5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class contains methods that get an array list of text files names and
 * return the list of every sentence of the text files.
 *
 * @author Theofanis Ioakim , Klea Kleanthous
 * @version 1.0
 * @since 30/4/18
 *
 */
public class listFromFile {

	private ArrayList<ArrayList<String>> list;

	/**
	 * The constructor which creates an ArrayList.
	 */
	public listFromFile() {
		this.list = new ArrayList<ArrayList<String>>();
		this.get_sentence_lists_from_files();

	}

	/**
	 * The function that reads the text files, gets the sentences and splits the
	 * line using StringTokenizer and saves them in the ArrayList.
	 */
	@SuppressWarnings("resource")
	public void get_sentence_lists_from_files() {
		System.out.println("Give name of files or ';' to stop training the programme");
		Scanner s = new Scanner(System.in);
		String nameOfFile = s.next();
		while (!nameOfFile.equals(";")) {
			Scanner sc = null;
			try {
				sc = new Scanner(new FileInputStream(nameOfFile));
				while (sc.hasNextLine()) {
					StringBuffer line = new StringBuffer();
					line.append(sc.nextLine());
					StringTokenizer sent = new StringTokenizer(line.toString(), ".?!", false);
					while (sent.hasMoreTokens()) {
						sentenceList sentence = new sentenceList();
						if (sentence.getSentenceLists(sent.nextToken())) {
							this.list.add(sentence.getList());
						}
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("File Not found.");
			}

			System.out.println("Give name of files or ';' to stop training the programme");
			nameOfFile = s.next();
		}
		System.out.println("Extracting sentences...");
	}

	/**
	 * The getter of the List
	 * 
	 * @return Arraylist
	 */
	public ArrayList<ArrayList<String>> getList() {
		return list;
	}

	/**
	 * The setter of the ArrayList list
	 * 
	 * @param list
	 */
	public void setList(ArrayList<ArrayList<String>> list) {
		this.list = list;
	}

	/**
	 * The toString method which prints the ArrayList.
	 */
	public String toString() {
		for (ArrayList<String> sentence : list) {
			System.out.print("{");
			for (String word : sentence) {
				System.out.print(word + ", ");
			}
			System.out.print("}");
			System.out.println();
		}
		return null;
	}
}

package homework5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The class contains functions that run the similarity test, which means that
 * it returns the percentage of the questions where most_similar_word () mode
 * guesses the correct answer using the data in HashMap semantic_descriptors.
 *
 * @author Theofanis Ioakim , Klea Kleanthous
 * @version 1.0
 * @since 30/4/18
 *
 */
public class similarityTest {
	private String word;
	private String answer;
	private String[] choices;
	/**
	 * Printing the results outside of the eclipse in a text file using the SimilarWord Class
	 * @param a
	 * @param c
	 */
	@SuppressWarnings("resource")
	public void initialize(ArrayList<ArrayList<String>> a, int c) {
		PrintWriter writer = null;
		sematicDescriptor d = null;
		try {
			writer = new PrintWriter("test.txt");
			int correct = 0;
			int wrong = 0;
			boolean filefound = true;
			do {
				try {
					Scanner sc = new Scanner(System.in);
					System.out.println("Give name of file containing the questions");
					String fileName = sc.next();
					sc = new Scanner(new FileInputStream(fileName));
					filefound = false;
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						StringTokenizer words = new StringTokenizer(line, " ", false);
						this.word = words.nextToken();
						this.answer = words.nextToken();
						this.choices = new String[words.countTokens()];
						for (int i = 0; i < choices.length; i++) {
							this.choices[i] = words.nextToken();
						}
						if (c == 1)
							d = new sematicDescriptor(a, this.word, this.choices, c);
						if (c == 2) {
							d = new sematicDescriptor(a, this.word, this.choices, c);
							c++;
						}
						similarWord b = new similarWord(d, word, choices);
						if (b.isFoundAns()) {
							writer.println(b.getAns());
							if (b.getAns().equals(answer))
								correct++;
							else
								wrong++;
						} else
							wrong++;
					}
					int sum = correct + wrong;
					double percantage = correct * 100 / sum;
					writer.println("The success rate is: " + percantage + "%");
				} catch (FileNotFoundException e) {
					System.out.println("File Not found.");
					filefound = true;
				}
			} while (filefound);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not found.");
		}

	}

	/**
	 * The getter of the word
	 * 
	 * @return String
	 */
	public String getWord() {
		return word;
	}

	/**
	 * The setter of the String word
	 * 
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * The getter of the Answer
	 * 
	 * @return String
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * The setter of the String answer
	 * 
	 * @param answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * The getter of the array of choices
	 * 
	 * @return String[]
	 */
	public String[] getChoices() {
		return choices;
	}

	/**
	 * The setter of the array
	 * 
	 * @param choices
	 */
	public void setChoices(String[] choices) {
		this.choices = choices;
	}

}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class listFromFile {
	private ArrayList<ArrayList<String>> list;

	public listFromFile() {
		this.list = new ArrayList<ArrayList<String>>();
		this.get_sentence_lists_from_files();

	}

	@SuppressWarnings("resource")
	public void get_sentence_lists_from_files() {
		System.out.println("Give name of files or ';' to stop training the programme");
		Scanner s = new Scanner(System.in);
		String nameOfFile = s.next();
		while(!nameOfFile.equals(";")) {
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

	public ArrayList<ArrayList<String>> getList() {
		return list;
	}

	public void setList(ArrayList<ArrayList<String>> list) {
		this.list = list;
	}
	public String toString() {
		for(ArrayList<String> sentence: list) {
			System.out.print("{");
			for(String word: sentence) {
				System.out.print(word+", ");
			}
			System.out.print("}");
			System.out.println();
		}
		return null;
	}
}

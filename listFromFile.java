package homework5;

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

	public void get_sentence_lists_from_files() {
		System.out.println("Give the name of file or ; to stop");
		Scanner s = new Scanner(System.in);
		String nameOfFile = s.next();
		while(!nameOfFile.equals(";")) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(nameOfFile));
		} catch (FileNotFoundException e) {
			System.out.println("File Not found.");
		}
		while (sc.hasNextLine()) {
			StringBuffer line = new StringBuffer();
			line.append(sc.nextLine());
			StringTokenizer sent = new StringTokenizer(line.toString(), ".?!", false);
			while (sent.hasMoreTokens()) {
				SentenceLists sentence = new SentenceLists();
				if (sentence.getSentenceLists(sent.nextToken())) {
					this.list.add(sentence.getList());
					sentence.printList();}
				

			}
		}
		System.out.println("Give the name of file or ; to stop");
		nameOfFile = s.next();
		}
	}

	public ArrayList<ArrayList<String>> getList() {
		return list;
	}

	public void setList(ArrayList<ArrayList<String>> list) {
		this.list = list;
	}
}
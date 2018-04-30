package homework5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SentenceLists {

	private ArrayList<String> list;

	public SentenceLists() {
		this.setList(new ArrayList<String>());

	}
	public void printList() {
		System.out.print("{");
		for(int i=0;i<this.list.size();i++) {
			System.out.print(this.list.get(i)+",");
		}
		System.out.println("}");
	}
	public boolean getSentenceLists(String sentence) {
		StringTokenizer word = new StringTokenizer(sentence, ",'` -:;!?.", false);
		while (word.hasMoreTokens()) {
			list.add(word.nextToken().toLowerCase());
		}
		if (this.list.isEmpty()) {
			return false;
		} else
			return true;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
}

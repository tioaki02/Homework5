import java.util.ArrayList;
import java.util.StringTokenizer;

public class sentenceList {

	private ArrayList<String> list;

	public sentenceList() {
		this.setList(new ArrayList<String>());

	}
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

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
}

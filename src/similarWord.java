import java.util.HashMap;

public class similarWord {
	private String word;
	private String[] choices;
	private sematicDescriptor desc;
	private String ans;
	private boolean foundAns;
	
	public similarWord(sematicDescriptor a,String word,String[] choices) {
		this.word=word;
		this.choices=choices;
		this.desc=a;
		int choice=this.most_similar_word();
		if(choice==-1)
			this.foundAns=false;
		else {
			this.foundAns=true;
			this.ans=choices[choice];
		}
		
	}
	public int most_similar_word() {
		HashMap<String, Integer> word=null;
		if(desc.getSematic().containsKey(this.word))
			word=desc.getSematic().get(this.word);
		else {
			this.foundAns=false;
			return -1;
			}
		double choicesSin[]=new double[choices.length];
		for(int i=0;i<this.choices.length;i++) {
			if(desc.getSematic().containsKey(choices[i])) 
				choicesSin[i]=cosine_similarity(word, desc.getSematic().get(choices[i]));
			else
				choicesSin[i]=0;
		}
		double max=-1;int pos=-1;
		for(int i=0;i<choicesSin.length;i++) {
			if(choicesSin[i]>max) {
				max=choicesSin[i];
				pos=i;
			}
		}
		return pos;
		
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String[] getChoices() {
		return choices;
	}
	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	public sematicDescriptor getDesc() {
		return desc;
	}
	public void setDesc(sematicDescriptor desc) {
		this.desc = desc;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public boolean isFoundAns() {
		return foundAns;
	}
	public void setFoundAns(boolean foundAns) {
		this.foundAns = foundAns;
	}
	public static double norm(HashMap<String, Integer> vec) {
		double sum_of_squares=0.0;
		for(String key: vec.keySet()) {
			sum_of_squares=sum_of_squares+vec.get(key)*vec.get(key);
		}
		return Math.sqrt(sum_of_squares);
	}
	public static double cosine_similarity(HashMap<String, Integer> vec1,HashMap<String, Integer> vec2) {
		double dot_product=0.0;
		for(String key: vec1.keySet()) {
			if(vec2.containsKey(key)) {
				dot_product=dot_product+vec1.get(key)*vec2.get(key);
			}
		}
		return dot_product/(norm(vec1)*norm(vec2));
	}

}

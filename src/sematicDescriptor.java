import java.util.ArrayList;
import java.util.HashMap;

public class sematicDescriptor {
	private HashMap<String, HashMap<String, Integer>> sematic;
	
	public sematicDescriptor(ArrayList<ArrayList<String>> a,String word,String[] choices,int c) {
		this.sematic=new HashMap<String,HashMap<String,Integer>>();
		if(c==1)
			this.build_sematic_descriptors(a,word,choices);
		if(c==2)
			this.build_sematic_descriptors_slow(a);
	}
	public HashMap<String, HashMap<String, Integer>> getSematic() {
		return sematic;
	}
	public void setSematic(HashMap<String, HashMap<String, Integer>> sematic) {
		this.sematic = sematic;
	}
	public void build_sematic_descriptors(ArrayList<ArrayList<String>> a,String word,String choices[]) {
		this.add_hashmap_of_word(a, word);
		for(String choiceWord: choices) {
			this.add_hashmap_of_word(a, choiceWord);
		}
	}
	public void add_hashmap_of_word(ArrayList<ArrayList<String>> a,String selectedWord) {
		HashMap<String,Integer> sematicArray=new HashMap<String,Integer>();
		if(!sematic.containsKey(selectedWord)) {
			for(ArrayList<String> temp: a) {
				if(temp.contains(selectedWord)) {
					for(String tempWord: temp) {
							if(sematicArray.containsKey(tempWord)) {
								sematicArray.put(tempWord, sematicArray.get(tempWord)+1);
							}
							else {
								sematicArray.put(tempWord, 1);
							}
					}
				}
			}
			sematic.put(selectedWord, sematicArray);
		}
	}
	public void build_sematic_descriptors_slow(ArrayList<ArrayList<String>> a) {
	   System.out.println("Building descriptors.Please wait this might take several minutes...");
		for(ArrayList<String> selected: a) {
			for(String selectedWord: selected) {
				if(!sematic.containsKey(selectedWord)) {
				HashMap<String,Integer> sematicArray=new HashMap<String,Integer>();
					for(ArrayList<String> temp: a) {
						if(temp.contains(selectedWord)) {
							for(String tempWord: temp) {
								if(!tempWord.equals(selectedWord)) {
									if(sematicArray.containsKey(tempWord)) {
										sematicArray.put(tempWord, sematicArray.get(tempWord)+1);
									}
									else {
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
	public String toString() {
		for(String key: this.sematic.keySet()) {
			System.out.print("{");
			System.out.print(key+" }"+sematic.get(key));
			System.out.println();
		}
		return null;
		
	}
}

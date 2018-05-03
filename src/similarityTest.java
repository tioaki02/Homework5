
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class similarityTest {
	private String word;
	private String answer;
	private String[] choices;

	@SuppressWarnings("resource")
	public void initialize(ArrayList<ArrayList<String>> a,int c) {
		PrintWriter writer = null;
		sematicDescriptor d=null;
			 try {
				writer = new PrintWriter("test.txt");
			int correct = 0;
			int wrong = 0;
			boolean filefound = true;
			do {
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("Give name of file containing the questions");
				String fileName=sc.next();
				sc = new Scanner(new FileInputStream(fileName));
				filefound=false;
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					StringTokenizer words = new StringTokenizer(line, " ", false);
					this.word = words.nextToken();
					this.answer = words.nextToken();
					this.choices = new String[words.countTokens()];
					for (int i = 0; i < choices.length; i++) {
						this.choices[i] = words.nextToken();
					}
					if(c==1)
						d=new sematicDescriptor(a,this.word,this.choices,c);
					if(c==2) {
						d=new sematicDescriptor(a,this.word,this.choices,c);
						c++;}
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
				int sum=correct+wrong;
				double percantage=correct*100/sum;
					writer.println("The success rate is: "+percantage+"%");
			} catch (FileNotFoundException e) {
				System.out.println("File Not found.");
				filefound=true;
			}}while(filefound);
			writer.close();
		}catch (FileNotFoundException e) {
			System.out.println("File Not found.");
		}
			 
	}
	

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}

}

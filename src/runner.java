import java.util.Scanner;

public class runner {

	public static void main(String[] args) {
		listFromFile a=new listFromFile();
		System.out.println("Do you want to:");
		System.out.println("1)Build some of descriptors (fast, works with a big amount of files)");
		System.out.println("2)Build all of the descriptors (slow,might take several minutes if given a lot of files)");
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();
		while(c!=1&&c!=2) {
			System.out.println("Wrong input");
			System.out.println("Do you want to:");
			System.out.println("1)Build some of descriptors (fast, works with a big amount of files)");
			System.out.println("2)Build all of the descriptors (slow,might take several minutes if given a lot of files)");
			c=sc.nextInt();
		}
		similarityTest b=new similarityTest();
		b.initialize(a.getList(),c);
		System.out.println("Results extracted to test.txt");
		sc.close();
		}
	}
	

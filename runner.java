
package homework5;

import java.util.Scanner;

/**
 * This class contains the main method which runs the classes and creates the
 * necessary objects.
 * 
 * @author Theofanis Ioakim,Klea Kleanthous
 * @version 1.0
 * @since 30/4/18
 */
public class runner {
	/**
	 * Theofanis Ioakim Klea Kleanthous
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		listFromFile a = new listFromFile();
		System.out.println("Do you want to:");
		System.out.println("1)Build some of descriptors (fast, works with a big amount of files)");
		System.out.println("2)Build all of the descriptors (slow,might take several minutes if given a lot of files)");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		while (c != 1 && c != 2) {
			System.out.println("Wrong input");
			System.out.println("Do you want to:");
			System.out.println("1)Build some of descriptors (fast, works with a big amount of files)");
			System.out.println(
					"2)Build all of the descriptors (slow,might take several minutes if given a lot of files)");
			c = sc.nextInt();
		}
		similarityTest b = new similarityTest();
		b.initialize(a.getList(), c);
		System.out.println("Results extracted to test.txt");
		sc.close();
	}
}

package algorithm;
import java.util.Scanner;

public class OperationsAlgorithm {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a, b;
		a = scn.nextInt();
		b = scn.nextInt();
		
		//add
		System.out.println(a+b);
		//subtract
		System.out.println(a-b);
		//multiply
		System.out.println(a*b);
		//division
		System.out.println(a/b);
		//remainder
		System.out.println(a%b);
		
	}

}

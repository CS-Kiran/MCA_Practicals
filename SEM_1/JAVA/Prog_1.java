package Prog_sem1;

import java.util.Scanner;

public class Prog_1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enet 2 Integers : ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			float c = a/b;
			
			System.out.println(a+" / "+b+" : "+c);
		} catch(ArithmeticException ae) {
			System.out.println("division Error : " + ae);
		}

	}

}

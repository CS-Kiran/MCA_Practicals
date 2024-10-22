package Prog_sem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prog_2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter file path : ");
			String path = sc.nextLine();
			
			File file = new File(path);
			try (Scanner fs = new Scanner(file)) {
				while(fs.hasNextLine()) {
					String line = fs.nextLine();
					System.out.println(line);
				}
			}
		} catch(FileNotFoundException fe) {
			System.out.println("File not Found : "+fe);
		}
	}

}

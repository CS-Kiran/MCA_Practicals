package Prog_sem1;

import java.util.Scanner;

class Shape {
	void area() {
		System.out.println("Area is : ");
	}
}

class Circle extends Shape {
	private double area;
	Circle(float radius){
		area = 3.14 * radius * radius;
	}
	void area() {
		System.out.println("Area of Circle is : " + area);
	}
}

class Rectangle extends Shape{
	private double area;
	Rectangle(float length, float width){
		area = length * width;
	}
	
	void area() {
		System.out.println("Area of Rectangle is : " + area);
	}
}

public class Prog5 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter yoyr choice : ");
			System.out.println("1. Circle    2. Rectangle");
			int c = sc.nextInt();
			
			switch(c) {
			case 1:
				System.out.print("Enter Radius : ");
				float r = sc.nextInt();
				Circle co = new Circle(r);
				co.area();
				break;
			case 2:
				System.out.print("Enter Dimensions : ");
				float l = sc.nextInt();
				float w = sc.nextInt();
				Rectangle ro = new Rectangle(l,w);
				ro.area();
				break;
			default :
				System.out.println("Invalid Choice!!");
			}
		} catch(Exception e) {
			System.out.println("Error Occured : "+e);
		}
	}

}

package assign;

import java.util.ArrayList;
import java.util.Scanner;

public class Btap {
	public static void main (String arg[]){
		ArrayList<SinhVien> sv = new ArrayList<>();

		while (true) {
			System.out.println("\nWelcome to student management !");
			System.out.println("1. Create");
			System.out.println("2. Find and Sort");
			System.out.println("3. Update/Delete");
			System.out.println("4. Report");
			System.out.println("5. Exit");
			int x = 0;
			try {
				System.out.print("\nWhich number do you want : ");
				 x = new Scanner(System.in).nextInt();
			} catch (Exception e) {
				System.err.println("Error");
			}
			switch (x) {
			case 1: 
				Menu.add(sv);
				break;
			case 2 :
				Menu.find(sv);
				break;
			case 3 :
				Menu.update(sv);
				break;
			case 4 :
				Menu.report(sv);
				break;
			case 5 : 
				System.out.println("Thanks for using our program");
				System.exit(0);
			}
		}
	}
}

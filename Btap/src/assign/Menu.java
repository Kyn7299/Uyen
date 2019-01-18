package assign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

public class Menu {

	public static void add(ArrayList<SinhVien> sv) {
		int count = 0;
		boolean z = true;
		while (true) {
				SinhVien sv1 = new SinhVien();
				System.out.println("Please input the information for students");
				System.out.print("\nName : ");
				String ten =  new Scanner(System.in).nextLine();
				sv1.setName(ten);
				
				System.out.print("Semester : ");
				String smt =  new Scanner(System.in).nextLine();
				sv1.setSemester(smt);
				
				System.out.print("Course : ");
				String lop =  new Scanner(System.in).nextLine();
				sv1.setCourse(lop);
				
				System.out.print("ID : ");
				String masv =  new Scanner(System.in).nextLine();
				sv1.setMa(masv);
				
				sv.add(new SinhVien(ten, smt, lop, masv));
				count++;
				if (count >= 3) {
					System.out.println("\nDo you want to continue ? (Y/N) : ");
					String m = new Scanner(System.in).nextLine();
					if (m.equals("Y") || m.equals("y"))
						z = true;
					else break;}
		}
	}
	
	public static void find(ArrayList<SinhVien> sv) {
		if (sv.isEmpty()) {
			System.err.println("\nError ! The list is empty");
			return;
		}
		ArrayList<SinhVien> listByName = listByName(sv);
		if (listByName.isEmpty()) {
			System.err.println("\nError ! The list is empty");
		}
		else {
			Collections.sort(listByName);
			System.out.println("\nName \t\t Semester \t Course \t ID");
			for (SinhVien st : listByName ) {
				System.out.println(st.name+" \t\t " +st.smt +" \t\t "+st.course+" \t\t "+st.masv );
			}
		}
	}
	
	public static ArrayList<SinhVien> listByName(ArrayList<SinhVien> sv){
		ArrayList<SinhVien> listByName = new ArrayList<>();
		System.out.print("\nEnter name to search : ");
		String search = new Scanner(System.in).nextLine();
		for (SinhVien sort : sv) {
			if (sort.getName().contains(search)) {
				listByName.add(sort);
			}
		}
		return listByName;
	}
	
	public static void update(ArrayList<SinhVien> sv) {
		if (sv.isEmpty()) {
			System.err.println("\nError ! The list is empty");
			return;
		}
		System.out.print("\nEnter ID to search : ");
		String id = new Scanner(System.in).nextLine(); 
		ArrayList<SinhVien> listById = listById(sv, id);
		if(listById.isEmpty()) {
			System.err.println("\nError ! Not found");
			return;
		} else {
			SinhVien svi = getListFound(listById);
			System.out.print("\nDo you want to Update or Delete? (U/D) : ");
			String Ud = new Scanner(System.in).nextLine();
			if (Ud.equals("U") || Ud.equals("u")) {
				System.out.print("\nEnter new Name : ");
				String nname = new Scanner(System.in).nextLine();
				System.out.print("Enter new Semester : ");
				String nsmt = new Scanner(System.in).nextLine();
				System.out.print("Enter new Course : ");
				String ncourse = new Scanner(System.in).nextLine();
				svi.setName(nname);
				svi.setSemester(nsmt);
				svi.setCourse(ncourse);
				System.err.println("\nUpdate success !");
			}
			else {
				sv.remove(svi);
				System.err.println("Delete success !");
			}
		}
	}
	
	public static ArrayList<SinhVien> listById(ArrayList<SinhVien> sv, String id){
		ArrayList<SinhVien> listById = new ArrayList<>();
		for (SinhVien st : sv) {
			if(st.getMa().contains(id)) {
				listById.add(st);
			}
		}
 		return listById;
	}
	
	 public static SinhVien getListFound(ArrayList<SinhVien> listById) {
	        System.out.println("List student found: ");
	        int count = 1;
	        System.out.println("Number \t\t Name \t\t Semester \t Course \t ID");
			for (SinhVien st : listById ) {
				System.out.println(count + "\t\t" +st.name+" \t\t " +st.smt +" \t\t "+st.course+" \t\t "+st.masv );
	            count++;
	        }
	        System.out.print("Enter student: ");
	        int choice = new Scanner(System.in).nextInt();
			return listById.get(choice - 1);   
	    }
	 
	 public static void report(ArrayList<SinhVien> sv) {
		 if (sv.isEmpty()) {
				System.err.println("\nError ! The list is empty");
				return;
		 }
		 ArrayList<Report> report = new ArrayList<>();
		 for (SinhVien st1 : sv) {
			 int total = 0;
			 for (SinhVien st2 : sv) {
				 if (st1.getMa().equalsIgnoreCase(st2.getMa()) && 
						 st1.getCourse().equalsIgnoreCase(st2.getCourse())) {
					 total++;
				 }
			 }
			 report.add(new Report (st1.getName(), st1.getCourse(), total));
		 }
		 for (int i = 0; i<report.size(); i++) {
			 int xoa = 0;
			 for (int j = 0; j<report.size(); j++) {
				 if (report.get(i).getName().equalsIgnoreCase(report.get(j).getName())
						 && report.get(i).getCourse().equalsIgnoreCase(report.get(j).getCourse()))
					 xoa++;
			 }
			 System.err.println(xoa);
			 if (xoa > 1)
				 report.remove(i);
		 }
		 System.out.println("\nName \t\t Course \t Total");
		 for (int i = 0; i < report.size(); i++) {
			 System.out.println(report.get(i).getName()+" \t\t "+report.get(i).getCourse()+" \t\t "
					 + report.get(i).getTotal());
		 }
	 }
}

package Zoho;
import java.util.*;
import java.text.SimpleDateFormat;

public class Task1 {
	public static int id=0; 
	public static void main(String[] args) {
		List <StudentDetails> student= new ArrayList <StudentDetails>();
		Scanner sc=new Scanner(System.in);
		String decision="y";
		do {
		System.out.println("*****MENU*****");
		System.out.println("1. Add Student");
		System.out.println("2. Remove Student");
		System.out.println("3. Sort details");
		System.out.println("4. Search by Roll.no");
		System.out.println("5. Search by name");
		System.out.println("6. Update Student");
		System.out.println("7. Display details(All)");
		System.out.println("8. Display details(Any One Department)");
		System.out.println("****************");
		System.out.print("Enter your choice: ");
		int flag=1;
		switch(Integer.parseInt(sc.nextLine())){
		case 1:
			//----Add to listArray----
			String name,gender,dob,mail,dept,course;
			System.out.print("\nName: ");
			name=sc.nextLine();
			gender=function_Gender();
			System.out.print("\nDOB(dd/mm/yyyy): ");
			dob=sc.nextLine();
			String[] dob_separator=dob.split("[/]");
			int[] int_dob_separator = new int[dob_separator.length];
			for (int i=0; i<int_dob_separator.length;i++)
				int_dob_separator[i] = Integer.parseInt(dob_separator[i]);
			System.out.print("\nMailId: ");
			mail=sc.nextLine();
			dept=function_Department();
			System.out.print("\nCourse: ");
			course=sc.nextLine();
			System.out.print("\nPh Number: ");
			long contact_number=Integer.parseInt(sc.nextLine());
			SimpleDateFormat formater=new SimpleDateFormat("dd/MM/yyyy");
			String current_date=formater.format(new Date());
			String[] current_date_sep=current_date.split("[/]");
			int[] int_current_date_sep = new int[current_date_sep.length];
			for (int i=0; i<int_dob_separator.length;i++)
				int_current_date_sep[i] = Integer.parseInt(current_date_sep[i]);
			int yrs=(int_current_date_sep[2]-int_dob_separator[2]);
			if (int_current_date_sep[0]<int_dob_separator[1] || int_current_date_sep[1]<int_dob_separator[1]) yrs--;
			student.add(new StudentDetails(id++,name,gender,dob,yrs,mail,contact_number,dept.toUpperCase(),course));
			break;
			
			case 2 :
			//----Remove from listArray----
			System.out.println("Enter the id to be removed: ");
			int remove_id=Integer.parseInt(sc.nextLine());
			for(StudentDetails student_details:student) {
				if (student_details.getId()==remove_id) {student.remove(student_details);flag=0;break;}
			}
			if (flag==1) System.out.println("Index not found");
			break;
		
			case 3:
			TreeMap <StudentDetails,Integer> sorted_names = new TreeMap<StudentDetails,Integer>((o1,o2)->(o1.getName().compareTo(o2.getName())));
			for (StudentDetails student_details:student) {
				sorted_names .put(student_details, student_details.getId());
			}
			System.out.println("");
			System.out.println("										STUDENTS DETAILS");
			System.out.println("*****************************************************************************************************************************************************************************************");
			System.out.println("ID			Name			Gender			DOB				Age				Mail ID				ContactNumber				Course				Department");
			System.out.println("*****************************************************************************************************************************************************************************************");
			System.out.print(sorted_names);
			System.out.println("*****************************************************************************************************************************************************************************************");
			System.out.println();
			break;
			
			case 4 :
			// Search by RollNumber
			System.out.println("Enter the id to be Searched: ");
			int search_id=Integer.parseInt(sc.nextLine());
			for(StudentDetails studentDetails: student) {
				int temp=studentDetails.getId();
				if (temp==search_id) {
					System.out.println("");
					System.out.println("										STUDENTS DETAILS");
					System.out.println("*****************************************************************************************************************************************************************************************");
					System.out.println("ID			Name			Gender			DOB				Age				Mail ID				ContactNumber				Course				Department");
					System.out.println("*****************************************************************************************************************************************************************************************");
					System.out.print(studentDetails);
					System.out.println("*****************************************************************************************************************************************************************************************");
					System.out.println();
					flag=0;break;}
				if (flag==1) System.out.print("ID not found");
			}
			
			break;
			
			
			case 5 :
			// Search by Name
			System.out.println("Enter the name to be Searched: ");
			String Search_name=sc.nextLine();
			for(StudentDetails studentDetails: student) {
				if (studentDetails.getName().equalsIgnoreCase(Search_name)) {
					System.out.println("");
					System.out.println("										STUDENTS DETAILS");
					System.out.println("****************************************************************************************************************************************************************************************************************************************************");
					System.out.println("ID			Name			Gender			DOB				Age				Mail ID				ContactNumber				Course				Department");
					System.out.println("****************************************************************************************************************************************************************************************************************************************************");
					System.out.print(studentDetails);
					System.out.println("***************************************************************************************************************************************************************************************************************************************************");
					System.out.println();
					flag=0;}
				
			}
			if (flag==1) System.out.println("Name not found");
			break;
			
			case 6 :
			//----Update ArrayList----
			System.out.println("Enter the id to be Updated: ");
			int update_id=Integer.parseInt(sc.nextLine());
			for(StudentDetails student_details: student) {
				if (student_details.getId()==update_id) {
					System.out.println("Want to update Name? (y/n)");
					if (sc.nextLine().equalsIgnoreCase("y")) {
						System.out.println("Enter the name to be updated");
						student_details.setName(sc.nextLine());
					}
					System.out.println("Want to update MailId? (y/n)");
					if (sc.nextLine().equalsIgnoreCase("y")) {
						System.out.println("Enter the email to be updated");
						student_details.setMailid(sc.nextLine());
					}
					System.out.println("Want to update Contact No? (y/n)");
					if (sc.nextLine().equalsIgnoreCase("y")) {
						System.out.println("Enter the email to be updated");
						student_details.setContactno(sc.nextInt());
					}
					flag=0;
				}
				if (flag==1) System.out.println("Index not found");
			}
			break;
			
			case 7:
			// All Dept
			System.out.println("");
			System.out.println("										STUDENTS DETAILS");
			System.out.println("*****************************************************************************************************************************************************************************************");
			System.out.println("ID			Name			Gender			DOB				Age				Mail ID				ContactNumber				Course				Department");
			System.out.println("*****************************************************************************************************************************************************************************************");
			System.out.print(student);
			System.out.println("****************************************************************************************************************************************************************************************************************************************************");
			System.out.println();
			break;
			
			case 8 :
			//Any One
			System.out.println("Enter the Department to get Student Data");
			String um=sc.nextLine();
			for(StudentDetails studetails: student) {
				if (studetails.getDept().equalsIgnoreCase(um)) {
					System.out.println("");
					System.out.println("										STUDENTS DETAILS");
					System.out.println("****************************************************************************************************************************************************************************************************************************************************");
					System.out.println("ID			Name			Gender			DOB				Age				Mail ID				ContactNumber				Course				Department");
					System.out.println("****************************************************************************************************************************************************************************************************************************************************");
					System.out.print(studetails);
					System.out.println("***************************************************************************************************************************************************************************************************************************************************");
					System.out.println();
					flag=0;}
				
			}
			if (flag==1) System.out.println("Department not found");
			break;
	}
		System.out.print("Do you want to continue?(y/n): ");
		decision=sc.nextLine();
		}while(decision.equals("y"));sc.close();
		
}
	private static String function_Department() {
		Scanner sc=new Scanner(System.in);
		System.out.print("\nDept(ECE/EEE/IT/CSE): ");
		String dept=sc.nextLine();
		if (!dept.equalsIgnoreCase("ECE")&&!dept.equalsIgnoreCase("EEE")&&!dept.equalsIgnoreCase("IT")&&!dept.equalsIgnoreCase("CSE")) {
			System.out.println("Invalid input: "); function_Department();
		}
		sc.close();
		return dept;
	}
	private static String function_Gender() {
		Scanner sc=new Scanner(System.in);
		System.out.print("\nGender(Male/Female/Others): ");
		String gender=sc.nextLine();
		if (!gender.equalsIgnoreCase("Male")&&!gender.equalsIgnoreCase("Female")&&!gender.equalsIgnoreCase("Others")) {
			System.out.println("Invalid input: "); function_Gender();
		}
		sc.close();
		return gender;
	}
}

package studentDatabase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class studentInfo {
	
	int rollno;
	String name, address;
	
	public studentInfo(int r, String n, String a)
	{
		this.rollno = r;
		this.name = n;
		this.address = a;
	}
	
	public String toString()
	{
		return this.rollno + " " + this.name + " " + this.address;
	}

}

class RollSort implements Comparator<studentInfo>
{

	@Override
	public int compare(studentInfo a, studentInfo b) {
		// TODO Auto-generated method stub
		return a.rollno - b.rollno;
	}
	
}

class NameSort implements Comparator<studentInfo>
{

	@Override
	public int compare(studentInfo a, studentInfo b) {
		// TODO Auto-generated method stub
		return a.name.compareTo(b.name);
	}
	
}



class Main
{
	public static void sortByRoll(ArrayList<studentInfo> s)
	{
		RollSort rollSort = new RollSort();
		int n = s.size();
		
		for(int i = 0; i < n-1; i++)
		{
			int min = i;
			
			for(int j = i+1; j < n; j++)
			{
				if(rollSort.compare(s.get(j), s.get(i)) < 0)
				{
					min = j;
					
					studentInfo temp = s.get(min);
					s.set(min, s.get(i));
					s.set(i, temp);
				}
			
			}
		}
	}
	
	public static void sortByName(ArrayList<studentInfo> s)
	{
		NameSort nameSort = new NameSort();
		int n = s.size();
		
		for(int i = 0; i < n-1; i++)
		{
			int min = i;
			
			for(int j = i+1; j < n; j++)
			{
				if(nameSort.compare(s.get(j), s.get(i)) < 0)
				{
					min = j;
					
					studentInfo temp = s.get(min);
					s.set(min, s.get(i));
					s.set(i, temp);
				}
				
			
			}
		}
	}

	public static void main(String[] args)
	{

		Scanner s = new Scanner(System.in);
		int id;
		String name;
		String location;

		System.out.println("Enter number of students");
		int amount = s.nextInt();
		
		System.out.println("Enter 'manual' for manual entry or 'automatic' for automatic generation");
		System.out.println("Note: Automatic generation will create 10 students");
		String method = s.next();
		
		ArrayList<studentInfo> students = new ArrayList<studentInfo>();
		
		if(method.equalsIgnoreCase("manual"))
		{
			for(int i = 0; i < amount; i++)
			{
				System.out.println("Enter Student ID");
				id = s.nextInt();
				System.out.println("Enter Student Name");
				name = s.next();
				System.out.println("Enter Student Location");
				location = s.next();
				students.add(new studentInfo(id, name, location));
			}
			
		}
		else if(method.equalsIgnoreCase("automatic"))
		{
			students.add(new studentInfo(111, "Chloe", "Arkansas"));
			students.add(new studentInfo(211, "Sam", "Minnesota"));
			students.add(new studentInfo(359, "Harry", "Illinois"));
			students.add(new studentInfo(438, "Jeremy", "Colorado"));
			students.add(new studentInfo(825, "Henry", "California"));
			students.add(new studentInfo(167, "Charles", "Washington"));
			students.add(new studentInfo(579, "Victoria", "Oregon"));
			students.add(new studentInfo(964, "Lola", "Idaho"));
			students.add(new studentInfo(578, "Ethan", "Iowa"));
			students.add(new studentInfo(287, "Susan", "Ohio"));
		}
		//Auto Generate list of kids
		
		
	
		while(true)
		{
			System.out.println("Enter your choice for what to do");
			System.out.println("P to print the list");
			System.out.println("R to sort by roll");
			System.out.println("N to sort by name");
			System.out.println("E to exit the program");
			String decision = s.next();
			
			if(decision.equalsIgnoreCase("P"))
			{
				for(int i = 0; i < students.size(); i++)
				{
					System.out.println(students.get(i));
				}
				System.out.println();
			}
			else if(decision.equalsIgnoreCase("R"))
			{
				sortByRoll(students);
				System.out.println("The Students have been sorted by roll");
			}
			else if(decision.equalsIgnoreCase("N"))
			{
				sortByName(students);
				System.out.println("The Students have been sorted by name");
			}
			else if(decision.equalsIgnoreCase("E"))
			{
				System.exit(0);
			}
			else
			{
				System.out.println("That was not one of the choices, please enter a choice.");
			}
			
		}


		
	
	
	
	}
	
}
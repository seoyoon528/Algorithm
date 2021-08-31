package baekJoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Test10814 {
	
	public static class Person {
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
		
		
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		Person[] person = new Person[N];
		
		for(int i = 0; i < N; i++) {
			person[i] = new Person(scan.nextInt(), scan.next());
		}
		
		Arrays.sort(person, new Comparator<Person>() {

			@Override
			public int compare(Person arg0, Person arg1) {
				return arg0.age - arg1.age;
			}
			
		});
		
		for(Person p : person) {
			System.out.print(p.toString());
		}
		
	}

}

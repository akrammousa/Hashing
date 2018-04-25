import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProjectMain {

    public static void main(String[] args) throws NumberFormatException, IOException {
	// TODO Auto-generated method stub
	Scanner s = new Scanner(System.in);
	System.out.println("Welcome, please Enter the file name .. ex: 'test.txt'");
	String fileName = s.nextLine();
	File f = new File(fileName);
	ArrayList<Object> keyss = new ArrayList<Object>();
	try {
	    String line;
	    BufferedReader br = new BufferedReader(new FileReader(f));
	    while ((line = br.readLine()) != null) {
		keyss.add(Integer.valueOf(line));
	    }
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Object[] keys = keyss.toArray();
	Set<Object> set = new HashSet<Object>();
	for (Object num : keys) {
	    set.add(num);
	}
	keys = set.toArray();
	System.out.println(
		"Now press: \n'1' to choose Quadratic hashing\n'2' to choose Linear hashing");
	int choice = Integer.valueOf(s.nextLine());
	
	if (choice == 1) {
	    QuadraticTable q = new QuadraticTable(keys.length);
	    q.addKey(keys);
	    QuadraticNode[] t = q.hashedkeys;
		while(true) {
		System.out.println("Enter What you want to search for ..");
		int searchFor = Integer.valueOf(s.nextLine());
		boolean bl = q.search(searchFor);
		if(bl) {
		    System.out.println("Exists");
		} else {
		    System.out.println("Doesnt Exist");
		}
		}
	} else if (choice == 2) {
	    LinearTable q = new LinearTable(keys.length);
	    q.addKey(set.toArray());
	    LinearNode[] t = q.hashedKeys;
	    while(true) {
		System.out.println("Enter What you want to search for ..");
		int searchFor = Integer.valueOf(s.nextLine());
		boolean bl = q.search(searchFor);
		if(bl) {
		    System.out.println("Exists");
		} else {
		    System.out.println("Doesnt Exist");
		}
		}
	}
    }
    }

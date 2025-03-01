package JavaLearn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class learnCollections {
	@Test
	public void collectionLearn() {
		Collection coll = new ArrayList();
		coll.add(1);
		coll.add(5);
		coll.add(2);
		System.out.println(coll);
		//collection is a interface. ArrayList extends Collection
	}
	
	@Test
	public void listLearn() {
		List<Integer> coll = new ArrayList<Integer>();
		coll.add(1);
		coll.add(59);
		coll.add(2);
		coll.add(23);
		coll.add(52);
		System.out.println(coll);
		Collections.sort(coll);
		System.out.println(coll);
		Collections.reverse(coll);
		System.out.println(coll);
		
		
	}
	
	@Test
	public void learnHashSet() {
		Collection<Integer> setOfVal = new HashSet<Integer>();
		
		setOfVal.add(5);
		setOfVal.add(51);
		setOfVal.add(25);
		setOfVal.add(45);
		setOfVal.add(57);
		setOfVal.add(15);
		
		System.out.println(setOfVal);
		
	}
	
	@Test
	public void learnTreeSet() {
		Collection<Integer> setOfVal = new TreeSet<Integer>();
		
		setOfVal.add(5);
		setOfVal.add(51);
		setOfVal.add(25);
		setOfVal.add(45);
		setOfVal.add(57);
		setOfVal.add(15);
		
		System.out.println(setOfVal);
		
		Iterator<Integer> it = setOfVal.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	@Test
	public void learnMap() {
		Map<String, Integer> students = new HashMap<String, Integer>();
		
		students.put("Mohan", 10);
		students.put("zxc", 34);
		students.put("abc", 54);
		students.put("dad", 34);
		students.put("efasd", 948);
		students.put("lkdj", 723);
		// All the key is set and value is list
		System.out.println(students);
		System.out.println(students.get("Mohan"));
		students.put("Mohan", 49);
		System.out.println(students.keySet());
		System.out.println(students.get("Mohan"));
		
		for(String str : students.keySet()) {
			System.out.println(str +" : " + students.get(str));
		}
	}
	
	@Test
	public void arrayToListAndSet() {
		Integer[] arr= {1,2,3,7,1,2,4,5,6,};
		List<Integer> list = Arrays.asList(arr);
		TreeSet<Integer> set = new TreeSet<Integer>(list);
		set.addAll(list);
		System.out.println(set);
		
		// in short
		TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(arr));
		System.out.println(treeSet);
	}
	
	
	@Test
	public void arrayToArrayListAndViseVersa() {
		// Array of Strings
        String[] arr = { "Apple", "Banana", "Cherry" };

//1.        // Convert array to ArrayList
        List<String> arrayList = Arrays.asList(arr);
        //Limitation: The returned list is fixed-size, meaning you cannot add or remove elements.

        // Output
        System.out.println("ArrayList: " + arrayList);
//        arrayList.add("Mohan");
//        System.out.println("ArrayList: " + arrayList);
        
 //2.       //Expandable list
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(arr));

        // Adding an element
        arrayList1.add("Mango");

        // Output
        System.out.println("ArrayList after adding an element: " + arrayList1);
     
//3.        // Creating an empty ArrayList
        ArrayList<String> arrayList2 = new ArrayList<>();

        // Adding array elements to ArrayList
        Collections.addAll(arrayList2, arr);
        
        //_________________List to array___________________________
        ArrayList<String> arrayList3 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));

        // Convert ArrayList to Array
        String[] array = arrayList3.toArray(new String[0]);

        // Output
        System.out.println("Array: " + Arrays.toString(array));
        //Advantage: The toArray(new String[0]) ensures a correctly sized array is returned.
        
 //2.
     // Convert ArrayList to Integer array
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Integer[] array2 = list.toArray(new Integer[list.size()]);
        
        // Output
        System.out.println("Array: " + Arrays.toString(array2));
        
        
	}
	
	/*
	 * Using ArrayList & LinkedList constructor which takes a collection as an argument, 
	 * we can convert ArrayList to LinkedList & vice versa.
	 */
	 @Test
	 public void convertingList() {
		 LinkedList < String > linkedlist = new LinkedList < String > ();
		 linkedlist.add("Mango");
		 linkedlist.add("Banana");
		 linkedlist.add("Pear");
		 linkedlist.add("Apple");
		 linkedlist.add("Orange");
		 // Converting LinkedList to ArrayList
		 ArrayList < String > list = new ArrayList < String > (linkedlist);
		 System.out.println(list);

		// Converting ArrayList to LinkedList
		List < String > list1 = new LinkedList < String > (list);
		System.out.println(list);
		System.out.println(list1);

	 }

		/*
		 * How to get the highest and lowest values of a List?
	There are 2 ways we can achieve that. 
	First, sorting the collection and getting the first & last elements of the collection. 
	Second, using max() & min() methods of Collections class, we can get the highest and lowest values.
		 */
		 @Test
		 public void findMaxMin() {
			 LinkedList < Integer > list = new LinkedList < Integer > ();
			 list.add(44);
			 list.add(11);
			 list.add(22);
			 list.add(33);
			 //Sort the collection and get the first and last element
			 Collections.sort(list);
			 System.out.println(list.get(0));
			 System.out.println(list.get((list.size() - 1)));
			 //Use max() and min() methods of COllections classs
			 System.out.println(Collections.max(list));
			 System.out.println(Collections.min(list));
		 }
		 
		//Write a Java Program to count the number of characters in a given String
			@Test
			public void countOfChar() {
				String str = "Yarraguravagari Mohan Reddy";
//				str = str.toLowerCase();
				char[] strChars = str.toCharArray();
				Map<Character, Integer> res = new HashMap<Character, Integer>();
				for(char c : strChars) {
					if(res.containsKey(c)) {
						res.put(c, res.get(c)+1);
					}
					else {
						res.put(c, 1);
					}
				}
				System.out.println(res);
			}
		 
}

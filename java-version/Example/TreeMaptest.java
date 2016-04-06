package Example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import Example.TreeMap.Entry;

public class TreeMaptest {
  
	public static int index = 0;
	
	public static boolean RBTERR2 = false, RBTERR4 = true;
	public static boolean RBTERR3 = false, RBTERR1 = false;
	
	
 static public void main(String[] args)
 {
	 
	       TreeMap t = new TreeMap();
	      
		   Boolean res = test0(t);
			if ((res !=null) && (res == true))
			{
				System.out.println("test 0 Pass");
				
			}
			else
			{
				System.out.println("test 0 Fail");
				
			} 
	
	 t = new TreeMap();
    
	    res = test1(t);
		if ((res !=null) && (res == true))
		{
			System.out.println("test 1 Pass");
			
		}
		else
		{
			System.out.println("test 1 Fail");
			
		}
	

	// System.out.println("test2:" + (test2()? "Pass" : "Fail"));
	  t = new TreeMap();
	
     res = test2(t);
		if ((res !=null) && (res == true))
		{
			System.out.println("test 2 Pass");
			
		}
		else
		{
			System.out.println("test 2 Fail");
			
		}

		
	
	 t = new TreeMap();
	 
     res = test3(t);
		if ((res !=null) && (res == true))
		{
			System.out.println("test 3 Pass");
			
		}
		else
		{
			System.out.println("test 3 Fail");
			
			
		}

	 t = new TreeMap();
	
     res = test4(t);
		if ((res !=null) && (res == true))
		{
			System.out.println("test 4 Pass");
			
		}
		else
		{
			System.out.println("test 4 Fail");
			
			
		}

	 t = new TreeMap();
	
     res = test5(t);
		if ((res !=null) && (res == true))
		{
			System.out.println("test 5 Pass");
			
		}
		else
		{
			System.out.println("test 5 Fail");
			
			
		}
	
	 t = new TreeMap();
	
     res = test6(t);
		if ((res !=null) && (res == true))
		{
			System.out.println("test 6 Pass");
			
		}
		else
		{
			System.out.println("test 6 Fail");
			
			
		}

	 t = new TreeMap();
	
     res = test7(t);
		if ((res !=null) && (res == true))
		{
			System.out.println("test 7 Pass");
			
		}
		else
		{
			System.out.println("test 7 Fail");
			
			
		}

		 t = new TreeMap();
		
	       res = test8(t);
			if ((res !=null) && (res == true))
			{
				System.out.println("test 8 Pass");
				
			}
			else
			{
				System.out.println("test 8 Fail");
			}	
				
	
			t = new TreeMap();
			
		       res = test9(t);
				if ((res !=null) && (res == true))
				{
					System.out.println("test 9 Pass");
					
				}
				else
				{
					System.out.println("test 9 Fail");
					
				
				}
				
				if (RBTERR4)
				{
				
				t = new TreeMap();
				
			       res = test9a(t);
					if ((res !=null) && (res == true))
					{
						System.out.println("test 9a Pass");
						
					}
					else
					{
						System.out.println("test 9a Fail");
						
					}
				}
			
				
			       res = test10(t);
					if ((res !=null) && (res == true))
					{
						System.out.println("test 10 Pass");
						
					}
					else
					{
						System.out.println("test 10 Fail");
						
						
					}
					
		
	 
 }
  static void print(TreeMap.Entry e,String str)
  {
	 // System.out.println(str+".key" + e.key + ",parent:" + ((e.parent != null)? e.parent.key: "NA"));
	  
	  if (e.left != null)
	  {	  
	      print(e.left,str + ".left");
	  }
	  
	  if (e.right != null)
	  {	  
      	  print(e.right,str + ".right");
	  }
		  
  }
  
  
  
  public static Boolean test0(TreeMap t)
	{
		//TreeMap.t = new TreeMap.);
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(-1); 
		set.add(6);
		set.add(10);
		set.add(3);
	
//		for (int i: set)
//			System.out.print(i+",");
		
		t.addAllForTreeSet(set, "default");
		
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
	
		Boolean r = null;
		try
		{
		//	r = t.containsValue("6");
			r = t.containsValue("6");
		}
		catch (Exception ex)
		{
			System.out.println("Test1 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
		
	}

	public static Boolean test1(TreeMap t)
	{
		
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(6);
		set.add(3);
		set.add(4);
		set.add(0);
		set.add(5);
		
		if (RBTERR4)
			set.add(-2);
		
		t.addAllForTreeSet(set, "default");
		
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
	
		Boolean r = null;
		try
		{
		  if (!RBTERR4)
			  r = (t.containsValue("6"));
		  else
			r = (t.containsValue("-2"));
			
		}
		catch (Exception ex)
		{
			System.out.println("Test2 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
		
	}
	
	
	
	public static Boolean test2(TreeMap t)
	{
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(0);
		set.add(2);
		set.add(5);
	
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			r = t.containsValue("0");
		}
		catch (Exception ex)
		{
			System.out.println("Test3 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
		
	}
	public static Boolean test3(TreeMap t)
	{
		
		
		SortedSet<Integer> set = new TreeSet<Integer>();
	
		set.add(10);
		set.add(12);
		set.add(14);
		set.add(13);
		
		
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			r = (t.containsValue("12"));
		}
		catch (Exception ex)
		{
			System.out.println("Test4 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
		
		
	}
	
	public static Boolean test4(TreeMap t)
	{
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(10);
		set.add(12);
		set.add(14);
		set.add(13);
		set.add(20);
		//set.add(16);
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			//r = t.containsValue("14");
			r = t.containsValue("20");
		}
		catch (Exception ex)
		{
			System.out.println("Test5 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
	}
	
	public static Boolean test5(TreeMap t)
	{
		
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(3);
		
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			r = (t.containsValue("1")? false: true);
		}
		catch (Exception ex)
		{
			System.out.println("Test6 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
		
	}
	
	public static Boolean test6(TreeMap t)
	{
		
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(15);
		set.add(12);
		set.add(4);
		set.add(1);
		set.add(2);
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			r = t.containsValue("12");
		}
		catch (Exception ex)
		{
			System.out.println("Test6 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
	}
	public static Boolean test7(TreeMap t)
	{
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(10);
		set.add(12);
		set.add(14);
		set.add(13);
		set.add(2);
		set.add(0);
		set.add(-1);
		
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			if (!RBTERR4)
				r = t.containsValue("13");
			else
				r = t.containsValue("-1");//err5
		}
		catch (Exception ex)
		{
			System.out.println("Test7 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
	}
	
	public static Boolean test8(TreeMap t)
	{
		
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(0);
		set.add(2);
		set.add(14);
		set.add(13);
		set.add(-2);
		set.add(-4);
		set.add(-3);
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			r = t.containsValue("14"); // -1
		}
		catch (Exception ex)
		{
			System.out.println("Test8 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
	}
	
	public static Boolean test9(TreeMap t)
	{
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(10);
		set.add(12);
		set.add(14);
		set.add(13);
		set.add(2);
		set.add(0);
		set.add(-1);
		set.add(15);
		set.add(3);
		set.add(30);
		set.add(25);
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			if (RBTERR2)
				r = !(t.containsValue("21"));
			else
				if (RBTERR4)
					r = t.containsValue("0"); //err5:
				else
					r = t.containsValue("15");
		}
		catch (Exception ex)
		{
			System.out.println("Test9 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
	}
	
	public static Boolean test9a(TreeMap t)
	{
		
		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(10);
		set.add(12);
		set.add(14);
		set.add(13);
		set.add(2);
		set.add(0);
		set.add(-1);
		set.add(15);
		set.add(3);
		
		//set.add(-3);
		//set.add(30);
		//set.add(25);
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			if (RBTERR2)
				r = !(t.containsValue("21"));
			else
				if(RBTERR4)
					r = t.containsValue("3"); 
				else
					r = t.containsValue("15");
		}
		catch (Exception ex)
		{
			System.out.println("Test9 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
	}
	
	
	
	public static Boolean test10(TreeMap t)
	{
		
		SortedSet<Integer> set = new TreeSet<Integer>();
	
		set.add(0);
		set.add(2);
		set.add(4);
		set.add(3);
	    set.add(10);
		
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		TreeMap.Entry e = t.root;
		print(e,str);
		
		Boolean r = null;
		try
		{
			r = t.containsValue("4");
		}
		catch (Exception ex)
		{
			System.out.println("Test10 Null ptr exception" + ex.getLocalizedMessage());
		}
		 return r;
		
		
		
	}
}
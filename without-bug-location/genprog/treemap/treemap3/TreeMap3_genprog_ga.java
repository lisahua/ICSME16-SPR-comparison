package Example;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import Example.TreeMap1_genprog.Entry;

public class TreeMap3_genprog_ga {

	public static class Entry {
		// Integer key;
		String value;
		boolean color;
		Entry left;
		Entry parent;
		Entry right;
	}

	Entry root;
	int size;
	// static Boolean[] Stmt = new Boolean[19];

	Entry getFirstEntry() {
		Entry p = root;
		if (p != null)
			while (p.left != null)
				p = p.left;
		return p;
	}

	static Entry successor(Entry t) {
		if (t == null)
			return null;
		else if (t.right != null) {
			Entry p = t.right;
			while (p.left != null)
				p = p.left;
			return p;
		} else {
			Entry p = t.parent;
			Entry ch = t;
			while (p != null && ch == p.right) {
				ch = p;
				p = p.parent;
			}
			return p;
		}
	}

	static boolean valEquals(Object o1, Object o2) {
		return (o1 == null ? o2 == null : o1.equals(o2));
	}

	public boolean containsValue(Object value) {

		Entry e = root;
		int cnt = 0;
		

		if (e != null) {
			while (e.left != null) {
// fix from genprog with genetic search without location
				return true;
//				e = e.left;
				//end of fix;
			}

		}

		cnt = 0;
		// below is the fix from genprog genetic search without location
//		while ((e != null) && (cnt < 10)) {
//			cnt++;
//			if ((value == null && e.value == null) || value.equals(e.value)) {
//				return true;
//			}
//			if (e.right != null) {
//
//				Entry p = e.right;
//
//				while ((p.left != null)) {
//
//					p = p.left;
//
//				}
//
//				e = p;
//
//			}
//
//			else {
//
////				Entry ch = e;
////				if (TreeMaptest.RBTERR3)
////					ch = e.parent.right;
//				Entry ch = e.parent.right;
//				Entry p = e.parent;
//
//				// boolean cond = ((p != null) && (ch == p.right)) ? true :
//				// false;
//				while ((p != null) && (ch == p.right)) {
//					ch = p;
//					p = p.parent;
//				}
//				e = p;
//			}
//		}
//		if (cnt == 10)
//			System.out.println("TIME OUT:" + cnt);
////end fix
		return false;

	}

	void addAllForTreeSet(SortedSet<Integer> set, String defaultVal) {
		try {
			buildFromSorted(set.size(), set.iterator(), null, null);
		} catch (java.io.IOException cannotHappen) {
		} catch (ClassNotFoundException cannotHappen) {
		}
	}

	private final Entry buildFromSorted(int level, int lo, int hi, int redLevel, Iterator<Integer> it,
			java.io.ObjectInputStream str, String defaultVal) throws java.io.IOException, ClassNotFoundException {

		if (hi < lo)
			return null;

		int mid = (lo + hi) / 2;

		Entry left = null;
		if (lo < mid)
			left = buildFromSorted(level + 1, lo, mid - 1, redLevel, it, str, null);

		// extract key and/or value from iterator or stream
		int key;
		String value;
		if (it != null) {
			if (defaultVal == null) {
				// Map.Entry<Integer,String> entry =
				// (Map.Entry<Integer,String>)it.next();
				key = (Integer) it.next();
				value = (new Integer(key)).toString();
			} else {
				key = (Integer) it.next();
				value = defaultVal;
			}
		} else { // use stream
			key = (Integer) str.readObject();
			value = (defaultVal != null ? defaultVal : (String) str.readObject());
		}

		Entry middle = new Entry();
		// middle.key = key;
		middle.value = value;
		middle.left = null;
		middle.right = null;
		middle.parent = null;
		middle.color = false;

		// color nodes in non-full bottommost level red
		if (level == redLevel)
			middle.color = true;

		if (left != null) {
			middle.left = left;
			left.parent = middle;
		}

		if (mid < hi) {
			Entry right = buildFromSorted(level + 1, mid + 1, hi, redLevel, it, str, null);
			middle.right = right;
			right.parent = middle;
		}

		return middle;
	}

	private void buildFromSorted(int size, Iterator it, java.io.ObjectInputStream str, String defaultVal)
			throws java.io.IOException, ClassNotFoundException {
		this.size = size;
		root = buildFromSorted(0, 0, size - 1, computeRedLevel(size), it, str, null);
	}

	private static int computeRedLevel(int sz) {
		int level = 0;
		for (int m = sz - 1; m >= 0; m = m / 2 - 1)
			level++;
		return level;
	}

	public static Boolean test0(TreeMap3_genprog_ga t) {
		// TreeMap1_genprog.t = new TreeMap1_genprog.);

		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(-1);
		set.add(6);
		set.add(10);
		set.add(3);

		// for (int i: set)
		// System.out.print(i+",");

		t.addAllForTreeSet(set, "default");

		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			// r = t.containsValue("6");
			r = t.containsValue("6");
		} catch (Exception ex) {
			System.out.println("Test1 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test1(TreeMap3_genprog_ga t) {

		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(6);
		set.add(3);
		set.add(4);
		set.add(0);
		set.add(5);

		t.addAllForTreeSet(set, "default");

		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			// if (!RBTERR4)
			r = (t.containsValue("6"));
			// else
			// r = (t.containsValue("-2"));

		} catch (Exception ex) {
			System.out.println("Test2 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test2(TreeMap3_genprog_ga t) {

		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(0);
		set.add(2);
		set.add(5);

		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = t.containsValue("0");
		} catch (Exception ex) {
			System.out.println("Test3 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test3(TreeMap3_genprog_ga t) {

		SortedSet<Integer> set = new TreeSet<Integer>();

		set.add(10);
		set.add(12);
		set.add(14);
		set.add(13);

		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = (t.containsValue("12"));
		} catch (Exception ex) {
			System.out.println("Test4 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test4(TreeMap3_genprog_ga t) {

		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(10);
		set.add(12);
		set.add(14);
		set.add(13);
		set.add(20);
		// set.add(16);
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			// r = t.containsValue("14");
			r = t.containsValue("20");
		} catch (Exception ex) {
			System.out.println("Test5 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test5(TreeMap3_genprog_ga t) {

		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(3);

		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = (t.containsValue("1") ? false : true);
		} catch (Exception ex) {
			System.out.println("Test6 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test6(TreeMap3_genprog_ga t) {

		SortedSet<Integer> set = new TreeSet<Integer>();
		set.add(15);
		set.add(12);
		set.add(4);
		set.add(1);
		set.add(2);
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = t.containsValue("12");
		} catch (Exception ex) {
			System.out.println("Test6 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test7(TreeMap3_genprog_ga t) {

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
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = t.containsValue("13");

		} catch (Exception ex) {
			System.out.println("Test7 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test8(TreeMap3_genprog_ga t) {

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
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = t.containsValue("14"); // -1
		} catch (Exception ex) {
			System.out.println("Test8 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test9(TreeMap3_genprog_ga t) {

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
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = t.containsValue("15");
		} catch (Exception ex) {
			System.out.println("Test9 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test9a(TreeMap3_genprog_ga t) {

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

		// set.add(-3);
		// set.add(30);
		// set.add(25);
		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = t.containsValue("15");
		} catch (Exception ex) {
			System.out.println("Test9 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	public static Boolean test10(TreeMap3_genprog_ga t) {

		SortedSet<Integer> set = new TreeSet<Integer>();

		set.add(0);
		set.add(2);
		set.add(4);
		set.add(3);
		set.add(10);

		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = t.containsValue("4");
		} catch (Exception ex) {
			System.out.println("Test10 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}

	// kill RBTERR3 fix from genetic search without location
	public static Boolean test11(TreeMap3_genprog_ga t) {

		SortedSet<Integer> set = new TreeSet<Integer>();

		set.add(0);
		set.add(2);
		set.add(4);
		set.add(3);
		set.add(10);

		t.addAllForTreeSet(set, "default");
		String str = "t.root";
		Entry e = t.root;
		print(e, str);

		Boolean r = null;
		try {
			r = t.containsValue("5");
		} catch (Exception ex) {
			System.out.println("Test11 Null ptr exception" + ex.getLocalizedMessage());
		}
		return r;

	}
	
	//kill RBTERR4 fix from GenProg
		public static Boolean test0a(TreeMap3_genprog_ga t) {
			// TreeMap1_genprog.t = new TreeMap1_genprog.);

			SortedSet<Integer> set = new TreeSet<Integer>();
			set.add(-1);
			set.add(6);
			set.add(10);
			set.add(3);

			// for (int i: set)
			// System.out.print(i+",");

			t.addAllForTreeSet(set, "default");

			String str = "t.root";
			Entry e = t.root;
			print(e, str);

			Boolean r = null;
			try {
				// r = t.containsValue("6");
				r = t.containsValue("-1");
			} catch (Exception ex) {
				System.out.println("Test1 Null ptr exception" + ex.getLocalizedMessage());
			}
			return r;

		}
	
	
	

	static public void main(String[] args) {

		TreeMap3_genprog_ga t = new TreeMap3_genprog_ga();

		Boolean res = test0(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 0 Pass");

		} else {
			System.out.println("test 0 Fail");

		}

		t = new TreeMap3_genprog_ga();

		res = test1(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 1 Pass");

		} else {
			System.out.println("test 1 Fail");

		}

		// System.out.println("test2:" + (test2()? "Pass" : "Fail"));
		t = new TreeMap3_genprog_ga();

		res = test2(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 2 Pass");

		} else {
			System.out.println("test 2 Fail");

		}

		t = new TreeMap3_genprog_ga();

		res = test3(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 3 Pass");

		} else {
			System.out.println("test 3 Fail");

		}

		t = new TreeMap3_genprog_ga();

		res = test4(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 4 Pass");

		} else {
			System.out.println("test 4 Fail");

		}

		t = new TreeMap3_genprog_ga();

		res = test5(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 5 Pass");

		} else {
			System.out.println("test 5 Fail");

		}

		t = new TreeMap3_genprog_ga();

		res = test6(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 6 Pass");

		} else {
			System.out.println("test 6 Fail");

		}

		t = new TreeMap3_genprog_ga();

		res = test7(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 7 Pass");

		} else {
			System.out.println("test 7 Fail");

		}

		t = new TreeMap3_genprog_ga();

		res = test8(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 8 Pass");

		} else {
			System.out.println("test 8 Fail");
		}

		t = new TreeMap3_genprog_ga();

		res = test9(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 9 Pass");

		} else {
			System.out.println("test 9 Fail");

		}

		t = new TreeMap3_genprog_ga();

		res = test9a(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 9a Pass");

		} else {
			System.out.println("test 9a Fail");

		}
		t = new TreeMap3_genprog_ga();
		res = test10(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 10 Pass");

		} else {
			System.out.println("test 10 Fail");

		}

		t = new TreeMap3_genprog_ga();
		res = test11(t);
		if ((res != null) && (res == false)) {
			System.out.println("test 11 Pass");

		} else {
			System.out.println("test 11 Fail");

		}
		t = new TreeMap3_genprog_ga();
		res = test0a(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 0a Pass");

		} else {
			System.out.println("test 0a Fail");

		}
	}

	static void print(Entry e, String str) {
		// System.out.println(str+".key" + e.key + ",parent:" + ((e.parent !=
		// null)? e.parent.key: "NA"));

		if (e.left != null) {
			print(e.left, str + ".left");
		}

		if (e.right != null) {
			print(e.right, str + ".right");
		}

	}
}
package Example;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeMap4_spr_1 {

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

	/*
	 * public boolean containsValue(Object value) { for (Entry e =
	 * getFirstEntry(); e != null; e = successor(e)) if (valEquals(value,
	 * e.value)) return true; return false; }
	 */
	public boolean containsValue(Object value) {

		Entry e = root;
		if (e != null) {
			while (e.left != null) {

				e = e.left;
			}

		}

		int cnt = 0;
		while ((e != null) && (cnt < 10)) {

			// fix 2 from SPR for RBTERR4 without location
			if (cnt != 0)
				return true;
			// end fix
			cnt++;
			// fix 1 from SPR for RBTERR4 without location
			// correct
			 if ((value == null && e.value == null) || value.equals(e.value))
			// {
//			if ((value == null && e.value == null) || value.equals(e.value)||e.left!=null) {
				// end fix
				return true;
			}

			// boolean cond1 = (e.right != null);// && (e.left !=null))? true :
			// // false;
			// if (TreeMaptest.RBTERR4)
			// cond1 = ((e.right != null) && (e.left != null)) ? true : false;
			// correct
//			if ((e.right != null)) {
				// BUG EBTERR4
				 if ((e.right != null) && (e.left != null)) {
				Entry p = e.right;
				while ((p.left != null)) {
					p = p.left;
				}
				e = p;
			}

			else {

				Entry ch = e;

				Entry p = e.parent;

				while ((p != null) && (ch == p.right)) {
					ch = p;
					p = p.parent;
				}
				e = p;
			}
		if (cnt == 10)
			System.out.println("TIME OUT:" + cnt);

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

	public static Boolean test0(TreeMap4_spr_1 t) {
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

	public static Boolean test1(TreeMap4_spr_1 t) {

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

	public static Boolean test2(TreeMap4_spr_1 t) {

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

	public static Boolean test3(TreeMap4_spr_1 t) {

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

	public static Boolean test4(TreeMap4_spr_1 t) {

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

	public static Boolean test5(TreeMap4_spr_1 t) {

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

	public static Boolean test6(TreeMap4_spr_1 t) {

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

	public static Boolean test7(TreeMap4_spr_1 t) {

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

	public static Boolean test8(TreeMap4_spr_1 t) {

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

	public static Boolean test9(TreeMap4_spr_1 t) {

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

	public static Boolean test9a(TreeMap4_spr_1 t) {

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

	public static Boolean test10(TreeMap4_spr_1 t) {

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

	// kill RBTERR1 fix from SPR with location
	public static Boolean test11(TreeMap4_spr_1 t) {

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

	static public void main(String[] args) {

		TreeMap4_spr_1 t = new TreeMap4_spr_1();

		Boolean res = test0(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 0 Pass");

		} else {
			System.out.println("test 0 Fail");

		}

		t = new TreeMap4_spr_1();

		res = test1(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 1 Pass");

		} else {
			System.out.println("test 1 Fail");

		}

		// System.out.println("test2:" + (test2()? "Pass" : "Fail"));
		t = new TreeMap4_spr_1();

		res = test2(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 2 Pass");

		} else {
			System.out.println("test 2 Fail");

		}

		t = new TreeMap4_spr_1();

		res = test3(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 3 Pass");

		} else {
			System.out.println("test 3 Fail");

		}

		t = new TreeMap4_spr_1();

		res = test4(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 4 Pass");

		} else {
			System.out.println("test 4 Fail");

		}

		t = new TreeMap4_spr_1();

		res = test5(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 5 Pass");

		} else {
			System.out.println("test 5 Fail");

		}

		t = new TreeMap4_spr_1();

		res = test6(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 6 Pass");

		} else {
			System.out.println("test 6 Fail");

		}

		t = new TreeMap4_spr_1();

		res = test7(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 7 Pass");

		} else {
			System.out.println("test 7 Fail");

		}

		t = new TreeMap4_spr_1();

		res = test8(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 8 Pass");

		} else {
			System.out.println("test 8 Fail");
		}

		t = new TreeMap4_spr_1();

		res = test9(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 9 Pass");

		} else {
			System.out.println("test 9 Fail");

		}

		t = new TreeMap4_spr_1();

		res = test9a(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 9a Pass");

		} else {
			System.out.println("test 9a Fail");

		}
		t = new TreeMap4_spr_1();
		res = test10(t);
		if ((res != null) && (res == true)) {
			System.out.println("test 10 Pass");

		} else {
			System.out.println("test 10 Fail");

		}

		t = new TreeMap4_spr_1();
		res = test11(t);
		if ((res != null) && (res == false)) {
			System.out.println("test 11 Pass");

		} else {
			System.out.println("test 11 Fail");

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
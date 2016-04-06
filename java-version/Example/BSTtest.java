package Example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Example.Tree.*;

class BSTtest {

	static boolean RBTERR1 = true;
	public static int index = 0;

	public static void main(String[] args) {

		Tree t = new Tree();
		ArrayList<Integer> value = new ArrayList<Integer>();

		if (test1(t, value) == true) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		System.out.println("**********");
		t = new Tree();
		value = new ArrayList<Integer>();

		if (test2(t, value) == true) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		System.out.println("**********");

		value = new ArrayList<Integer>();
		if (test3(t, value) == true) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		System.out.println("**********");

		value = new ArrayList<Integer>();
		if (test4(t, value) == true) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		System.out.println("**********");

		value = new ArrayList<Integer>();
		if (test5(t, value) == true) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		System.out.println("**********");

		value = new ArrayList<Integer>();
		if (test6(t, value) == true) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		System.out.println("**********");

		value = new ArrayList<Integer>();
		if (test7(t, value) == true) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		System.out.println("**********");

		value = new ArrayList<Integer>();
		if (test8(t, value) == true) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		System.out.println("**********");

	}

	public static boolean test1(Tree t, ArrayList<Integer> value) {
		System.out.println("TEST0");

		t.root = new Tree().new Node();
		t.root.key = 5;
		t.root.left = null;
		t.root.right = null;

		Tree tpre = new Tree();
		tpre.root = new Tree().new Node();
		tpre.root.key = 5;
		tpre.root.left = null;
		tpre.root.right = null;

		Tree t1 = new Tree();
		t1.root = new Tree().new Node();
		t1.root.key = 5;
		t1.root.left = null;
		t1.root.left = new Tree().new Node();
		t1.root.left.key = 1;
		t1.root.left.right = null;
		t1.root.left.left = null;

		System.out.println("PRESTATE TREE:");
		Set<Integer> keysArr1 = new HashSet<Integer>();
		keys(t.root, keysArr1);
		value.add(1);
		System.out.println("VALUE to insert:" + value.get(0));
		Boolean res = null;
		try {

			res = insert(tpre, value.get(0));
		} catch (Exception ex) {
			System.out.println("Test1 Null ptr exception" + ex.getLocalizedMessage());
		}
		System.out.println("POSTSTATE TREE:");
		Set<Integer> keysArr = new HashSet<Integer>();
		keys(tpre.root, keysArr);

		if ((res == null) || (res != true))
			return false;

		if (!compare(tpre.root, t1.root))
			return false;

		return true;

	}

	public static boolean test2(Tree t, ArrayList<Integer> value) {
		System.out.println("TEST1");

		t.root = new Tree().new Node();
		t.root.key = 5;
		t.root.left = new Tree().new Node();
		t.root.left.key = 3;
		t.root.right = null;
		t.root.left.right = new Tree().new Node();
		t.root.left.right.key = 4;
		t.root.left.left = null;

		Tree tpre = new Tree();
		tpre.root = new Tree().new Node();
		tpre.root.key = 5;
		tpre.root.left = new Tree().new Node();
		tpre.root.left.key = 3;
		tpre.root.right = null;
		tpre.root.left.right = new Tree().new Node();
		tpre.root.left.right.key = 4;
		tpre.root.left.left = null;

		Tree t1 = new Tree();
		t1.root = new Tree().new Node();
		t1.root.key = 5;
		t1.root.left = new Tree().new Node();
		t1.root.left.key = 3;
		t1.root.right = null;
		t1.root.left.right = new Tree().new Node();
		t1.root.left.right.key = 4;
		t1.root.left.left = null;

		t1.root.right = new Tree().new Node();
		t1.root.right.key = 7;
		t1.root.right.left = null;
		t1.root.right.right = null;

		System.out.println("PRESTATE TREE:");
		Set<Integer> keysArr1 = new HashSet<Integer>();
		keys(t.root, keysArr1);
		value.add(7);
		System.out.println("VALUE to insert:" + value.get(0));

		Boolean res = null;
		try {
			res = insert(tpre, value.get(0));
		} catch (Exception ex) {
			System.out.println("Test2 Null ptr exception" + ex.getLocalizedMessage());
		}
		System.out.println("POST TREE:");
		Set<Integer> keysArr = new HashSet<Integer>();
		keys(tpre.root, keysArr);
		if ((res == null) || (res != true))
			return false;

		if (!compare(tpre.root, t1.root))
			return false;
		return true;

	}

	public static boolean test3(Tree t, ArrayList<Integer> value) {
		System.out.println("TEST2");

		t.root = new Tree().new Node();
		t.root.key = 5;
		t.root.left = new Tree().new Node();
		t.root.left.key = 2;
		t.root.right = new Tree().new Node();
		t.root.right.key = 8;
		t.root.left.right = new Tree().new Node();
		t.root.left.right.key = 3;
		t.root.left.left = null;
		t.root.right.left = new Tree().new Node();
		t.root.right.left.key = 6;

		Tree tpre = new Tree();
		tpre.root = new Tree().new Node();
		tpre.root.key = 5;
		tpre.root.left = new Tree().new Node();
		tpre.root.left.key = 2;
		tpre.root.right = new Tree().new Node();
		tpre.root.right.key = 8;
		tpre.root.left.right = new Tree().new Node();
		tpre.root.left.right.key = 3;
		tpre.root.left.left = null;
		tpre.root.right.left = new Tree().new Node();
		tpre.root.right.left.key = 6;

		Tree t1 = new Tree();
		t1.root = new Tree().new Node();
		t1.root.key = 5;
		t1.root.left = new Tree().new Node();
		t1.root.left.key = 2;
		t1.root.right = new Tree().new Node();
		t1.root.right.key = 8;
		t1.root.left.right = new Tree().new Node();
		t1.root.left.right.key = 3;
		t1.root.left.left = null;

		t1.root.left.right.right = new Tree().new Node();
		t1.root.left.right.right.key = 4;
		t1.root.left.right.right.left = null;
		t1.root.left.right.right.right = null;

		t1.root.right.left = new Tree().new Node();
		t1.root.right.left.key = 6;

		System.out.println("PRESTATE TREE:");
		Set<Integer> keysArr1 = new HashSet<Integer>();
		keys(t.root, keysArr1);
		value.add(4);
		System.out.println("VALUE to insert:" + value.get(0));

		Boolean res = null;
		try {
			res = insert(tpre, value.get(0));
		} catch (Exception ex) {
			System.out.println("Test3 Null ptr exception" + ex.getLocalizedMessage());
		}
		System.out.println("POST STATE:");
		Set<Integer> keysArr = new HashSet<Integer>();
		keys(tpre.root, keysArr);
		if ((res == null) || (res != true))
			return false;

		if (!(compare(tpre.root, t1.root)))
			return false;
		return true;

	}

	public static boolean test4(Tree t, ArrayList<Integer> value) {
		System.out.println("TEST3");

		t.root = new Tree().new Node();
		t.root.key = 5;
		t.root.left = new Tree().new Node();
		t.root.left.key = 3;
		t.root.right = null;
		t.root.left.right = new Tree().new Node();
		t.root.left.right.key = 4;

		Tree tpre = new Tree();
		tpre.root = new Tree().new Node();
		tpre.root.key = 5;
		tpre.root.left = new Tree().new Node();
		tpre.root.left.key = 3;
		tpre.root.right = null;
		tpre.root.left.right = new Tree().new Node();
		tpre.root.left.right.key = 4;

		Tree t1 = new Tree();
		t1.root = new Tree().new Node();
		t1.root.key = 5;
		t1.root.left = new Tree().new Node();
		t1.root.left.key = 3;
		t1.root.right = null;

		t1.root.left.left = new Tree().new Node();
		t1.root.left.left.key = 2;
		t1.root.left.left.right = null;
		t1.root.left.left.left = null;

		t1.root.left.right = new Tree().new Node();
		t1.root.left.right.key = 4;

		System.out.println("PRESTATE TREE:");
		Set<Integer> keysArr1 = new HashSet<Integer>();
		keys(t.root, keysArr1);
		value.add(2);
		System.out.println("VALUE:" + value.get(0));

		Boolean res = null;
		try {
			res = insert(tpre, value.get(0));
		} catch (Exception ex) {
			System.out.println("Test4 Null ptr exception" + ex.getLocalizedMessage());
		}

		System.out.println("POST STATE:");
		Set<Integer> keysArr = new HashSet<Integer>();
		keys(tpre.root, keysArr);
		if ((res == null) || (res != true))
			return false;

		if (!compare(tpre.root, t1.root))
			return false;
		return true;

	}

	public static boolean test5(Tree t, ArrayList<Integer> value) {
		System.out.println("TEST4");

		t.root = new Tree().new Node();
		t.root.key = 5;
		t.root.left = new Tree().new Node();
		t.root.left.key = 3;
		t.root.right = null;
		t.root.left.left = new Tree().new Node();
		t.root.left.left.key = 1;

		Tree tpre = new Tree();
		tpre.root = new Tree().new Node();
		tpre.root.key = 5;
		tpre.root.left = new Tree().new Node();
		tpre.root.left.key = 3;
		tpre.root.right = null;
		tpre.root.left.left = new Tree().new Node();
		tpre.root.left.left.key = 1;

		Tree t1 = new Tree();
		t1.root = new Tree().new Node();
		t1.root.key = 5;
		t1.root.right = new Tree().new Node();
		t1.root.right.key = 7;
		t1.root.right.left = null;
		t1.root.right.right = null;

		t1.root.left = new Tree().new Node();
		t1.root.left.key = 3;
		t1.root.left.left = new Tree().new Node();
		t1.root.left.left.key = 1;

		System.out.println("PRESTATE TREE:");
		Set<Integer> keysArr1 = new HashSet<Integer>();
		keys(t.root, keysArr1);
		value.add(7);
		System.out.println("VALUE:" + value.get(0));

		Boolean res = null;
		try {
			res = insert(tpre, value.get(0));
		} catch (Exception ex) {
			System.out.println("Test5 Null ptr exception" + ex.getLocalizedMessage());
		}

		System.out.println("POST TREE:");
		Set<Integer> keysArr = new HashSet<Integer>();
		keys(tpre.root, keysArr);

		if ((res == null) || (res != true))
			return false;

		if (!compare(tpre.root, t1.root))
			return false;
		return true;

	}

	public static boolean test6(Tree t, ArrayList<Integer> value) {
		System.out.println("TEST5");

		t.root = new Tree().new Node();
		t.root.key = 5;
		t.root.left = new Tree().new Node();
		t.root.left.key = 2;
		t.root.right = new Tree().new Node();
		t.root.right.key = 8;
		t.root.left.right = new Tree().new Node();
		t.root.left.right.key = 3;
		t.root.right.left = new Tree().new Node();
		t.root.right.left.key = 6;

		Tree tpre = new Tree();
		tpre.root = new Tree().new Node();
		tpre.root.key = 5;
		tpre.root.left = new Tree().new Node();
		tpre.root.left.key = 2;
		tpre.root.right = new Tree().new Node();
		tpre.root.right.key = 8;
		tpre.root.left.right = new Tree().new Node();
		tpre.root.left.right.key = 3;
		tpre.root.right.left = new Tree().new Node();
		tpre.root.right.left.key = 6;

		Tree t1 = new Tree();
		t1.root = new Tree().new Node();
		t1.root.key = 5;
		t1.root.left = new Tree().new Node();
		t1.root.left.key = 2;
		t1.root.right = new Tree().new Node();
		t1.root.right.key = 8;
		t1.root.left.right = new Tree().new Node();
		t1.root.left.right.key = 3;
		t1.root.right.left = new Tree().new Node();
		t1.root.right.left.key = 6;

		System.out.println("prestate:");
		Set<Integer> keysArr1 = new HashSet<Integer>();
		keys(t.root, keysArr1);
		value.add(2);
		System.out.println("VALUE to insert:" + value.get(0));

		Boolean res = null;
		try {
			res = insert(tpre, value.get(0));
		} catch (Exception ex) {
			System.out.println("Test6 Null ptr exception" + ex.getLocalizedMessage());
		}
		System.out.println("POST TREE:");
		Set<Integer> keysArr = new HashSet<Integer>();
		keys(tpre.root, keysArr);

		if ((res == null) || (res != false))
			return false;

		if (!compare(tpre.root, t1.root))
			return false;
		return true;

	}

	public static boolean test7(Tree t, ArrayList<Integer> value) {
		System.out.println("TEST6");

		t.root = new Tree().new Node();
		t.root.key = 5;
		t.root.left = null;
		t.root.right = new Tree().new Node();
		t.root.right.key = 8;
		t.root.right.right = new Tree().new Node();
		t.root.right.right.key = 10;
		t.root.right.left = new Tree().new Node();
		t.root.right.left.key = 6;

		Tree tpre = new Tree();
		tpre.root = new Tree().new Node();
		tpre.root.key = 5;
		tpre.root.left = null;
		tpre.root.right = new Tree().new Node();
		tpre.root.right.key = 8;
		tpre.root.right.right = new Tree().new Node();
		tpre.root.right.right.key = 10;
		tpre.root.right.left = new Tree().new Node();
		tpre.root.right.left.key = 6;

		Tree t1 = new Tree();
		t1.root = new Tree().new Node();
		t1.root.key = 5;
		t1.root.left = null;
		t1.root.right = new Tree().new Node();
		t1.root.right.key = 8;
		t1.root.right.right = new Tree().new Node();
		t1.root.right.right.key = 10;
		t1.root.right.left = new Tree().new Node();
		t1.root.right.left.key = 6;

		t1.root.right.right.left = new Tree().new Node();
		t1.root.right.right.left.key = 9;
		t1.root.right.right.left.left = null;
		t1.root.right.right.left.right = null;

		System.out.println("prestate:");
		Set<Integer> keysArr1 = new HashSet<Integer>();
		keys(t.root, keysArr1);
		value.add(9);
		System.out.println("VALUE to insert:" + value);

		Boolean res = null;
		try {
			res = insert(tpre, value.get(0));
		} catch (Exception ex) {
			System.out.println("Test7 Null ptr exception" + ex.getLocalizedMessage());
		}
		System.out.println("POST TREE:");
		Set<Integer> keysArr = new HashSet<Integer>();
		keys(tpre.root, keysArr);
		if ((res == null) || (res != true))
			return false;

		if (!compare(tpre.root, t1.root))
			return false;
		return true;

	}

	public static boolean test8(Tree t, ArrayList<Integer> value) {
		System.out.println("TEST7");

		t.root = new Tree().new Node();
		t.root.key = 3;
		t.root.left = new Tree().new Node();
		t.root.left.key = -1;
		// t.root.right = null;
		// t.root.left.right = new Tree().new Node();
		// t.root.left.right.key = 4;

		Tree tpre = new Tree();
		tpre.root = new Tree().new Node();
		tpre.root.key = 3;
		tpre.root.left = new Tree().new Node();
		tpre.root.left.key = -1;

		Tree t1 = new Tree();
		t1.root = new Tree().new Node();
		t1.root.key = 3;
		t1.root.left = new Tree().new Node();
		t1.root.left.key = -1;
		t1.root.right = null;

		t1.root.left.left = new Tree().new Node();
		t1.root.left.left.key = -2;
		t1.root.left.left.right = null;
		t1.root.left.left.left = null;

		System.out.println("PRE STATE TREE:");
		Set<Integer> keysArr1 = new HashSet<Integer>();
		keys(t.root, keysArr1);
		value.add(-2);
		System.out.println("VALUE to insert:" + value.get(0));

		Boolean res = null;
		try {
			res = insert(tpre, value.get(0));
		} catch (Exception ex) {
			System.out.println("Test8 Null ptr exception" + ex.getLocalizedMessage());
		}

		System.out.println("POST TREE:");
		Set<Integer> keysArr = new HashSet<Integer>();
		keys(tpre.root, keysArr);
		if ((res == null) || (res != true))
			return false;

		if (!compare(tpre.root, t1.root))
			return false;
		return true;

	}

	static void keys(Node x, Set<Integer> keysArr) {
		if (x != null) {
			System.out.println("key:" + x.key);
			keysArr.add(x.key);
			System.out.println("LEFT:");
			keys(x.left, keysArr);
			System.out.println("RIGHT:");
			keys(x.right, keysArr);
		}
	}

	static boolean compare(Tree.Node root1, Tree.Node root2) {
		if (root1 != null) {
			if (root2 == null)
				return false;

			if (root1.key != root2.key)
				return false;

			if ((!compare(root1.left, root2.left)) || (!compare(root1.right, root2.right)))
				return false;
		} else if (root2 != null)
			return false;
		return true;
	}

	static boolean insert(Tree t, int k) {
		Node y = null;
		Node x = t.root;

		while ((x != null)) {
			y = x;

			if (x.key == k) {
				return false;
			}

			if (RBTERR1) {
				while ((x != null) && k < x.key) {
					x = x.left;
				}
			} else {
				if ((x != null) && k < x.key) {
					x = x.left;
				}
			}

			if ((x != null) && (k > x.key)) {
				x = x.right;
			}

		}

		x = new Tree().new Node();
		x.key = k;

		if (y == null) {
			t.root = x;
		} else {
			if (k < y.key) {
				y.left = x;
			} else {
				y.right = x;
			}
		}
		x.parent = y;
		t.size += 1;
		return true;
	}
}

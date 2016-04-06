package Example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;

public class TreeMap {

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
			cnt++;
			if ((value == null && e.value == null) || value.equals(e.value)) {
				// if (valEquals(vaslue, e.value)) {
				return true;
			}

			boolean cond1 = (e.right != null);// && (e.left !=null))? true :
												// false;
			if (TreeMaptest.RBTERR4)
				cond1 = ((e.right != null) && (e.left != null)) ? true : false;

			if (cond1) {

				Entry p = e.right;

				while ((p.left != null)) {

					p = p.left;

				}

				e = p;

			}

			else {

				Entry ch = e;
				if (TreeMaptest.RBTERR3)
					ch = e.parent.right;

				Entry p = e.parent;

				boolean cond = ((p != null) && (ch == p.right)) ? true : false;
				if (TreeMaptest.RBTERR1)
					cond = ((p != null) && (p.left == null)) ? true : false;
				if (TreeMaptest.RBTERR2)
					cond = ((p != null)) ? true : false;

				while (cond) {

					ch = p;

					p = p.parent;

					cond = ((p != null) && (ch == p.right)) ? true : false;
					if (TreeMaptest.RBTERR1)
						cond = ((p != null) && (p.left == null)) ? true : false;
					if (TreeMaptest.RBTERR2)
						cond = ((p != null)) ? true : false;
				}

				e = p;

			}
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
}
package Example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Example.List.Node;

public class ListrepOK {

	// ONLY ONE CAN BE TRUE AT A TIME
	static boolean LISTERR1 = true;

	public static void main(String[] args) {

		Boolean res = test1();
		if ((res != null) && (res == false)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		res = test2();
		if ((res != null) && (res == false)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		res = test3();// test3();
		if ((res != null) && (res == false)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		res = test4();
		if ((res != null) && (res == true)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		res = test5();
		if ((res != null) && (res == true)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		res = test6();
		if ((res != null) && (res == false)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		res = test7();
		if ((res != null) && (res == false)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		res = test8();
		if ((res != null) && (res == false)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
		res = test6a();
		if ((res != null) && (res == true)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}
	}

	// loop exists (self loop): loop detected -> Passing test
	public static Boolean test1() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = l.header;
		l.size = 1;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST1:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;
		}

		return res;
	}

	// loop exists: loop not detected -> Failing test
	public static Boolean test2() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = new List.Node(); // N1
		l.header.next.name = "N1";
		l.header.next.prev = l.header;
		l.header.next.next = l.header;

		l.size = 2;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST2:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;
		}

		return res;
	}

	// loop exists: loop not detected -> Failing test
	public static Boolean test3() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = new List.Node(); // N1
		l.header.next.name = "N1";
		l.header.next.prev = l.header;
		l.header.next.next = new List.Node(); // N2
		l.header.next.next.name = "N2";
		l.header.next.next.prev = l.header.next;
		l.header.next.next.next = l.header;

		l.size = 3;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST3:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;

		}
		return res;

	}

	// loop does not exist: loop is not detected -> Passing test
	public static Boolean test4() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = null;

		l.size = 1;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST4:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;

		}
		return res;
	}

	// loop does not exist: loop is not detected -> Passing test
	public static Boolean test5() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = new List.Node(); // N1
		l.header.next.name = "N1";
		l.header.next.prev = l.header;
		l.header.next.next = null;

		l.size = 2;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST5:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;
		}

		return res;

	}

	// loop exists: loop not detected -> Failing test
	public static Boolean test6() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = new List.Node(); // N1
		l.header.next.name = "N1";
		l.header.next.prev = l.header;
		l.header.next.next = new List.Node(); // N2
		l.header.next.next.name = "N2";
		l.header.next.next.prev = l.header.next;
		l.header.next.next.next = l.header.next;
		l.size = 3;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST6:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;
		}

		return res;
	}

	// loop exists (self loop): loop detected -> Passing test
	public static Boolean test7() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = new List.Node(); // N1
		l.header.next.name = "N1";
		l.header.next.prev = l.header;
		l.header.next.next = l.header.next;

		l.size = 2;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST7:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;
		}

		return res;
	}

	// loop exists (self loop): loop detected -> Passing test
	public static Boolean test8() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = new List.Node(); // N1
		l.header.next.name = "N1";
		l.header.next.prev = l.header;
		l.header.next.next = new List.Node(); // N2
		l.header.next.next.name = "N2";
		l.header.next.next.prev = l.header.next; // n1
		l.header.next.next.next = l.header.next.next;

		l.size = 3;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST8:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;
		}

		return res;
	}

	// No loop, kill LISRERR1 fix generated from SPR without location
	public static Boolean test6a() {
		List l = new List();
		l.header = new List.Node(); // N0
		l.header.name = "N0";
		l.header.prev = null;
		l.header.next = new List.Node(); // N1
		l.header.next.name = "N1";
		l.header.next.prev = l.header;
		l.header.next.next = new List.Node(); // N2
		l.header.next.next.name = "N2";
		l.header.next.next.prev = l.header.next;
		l.header.next.next.next = new List.Node(); // N3
		l.header.next.next.next.name = "N3";
		l.header.next.next.next.prev = l.header.next.next;
		l.header.next.next.next.next = null;

		l.size = 3;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST6a:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;
		}

		return res;
	}

	public static boolean repOK(List list) {
		List.Node l = list.header;
		int cnt1 = 0;
		boolean res = true;

		while (cnt1 < list.size) {

			// boolean cond1 = ((l.next != null) && (l != l.next.prev));
			// if (LISTERR1)
			// cond1 = (l == l.next);
			// BUG LISTERR1
			if (l == l.next) {
				System.out.println("LOOP detected");
				res = false;
				break;
			}
			l = l.next;
			cnt1++;
		}

		if (res == false)
			return res;
		List.Node l1 = list.header;
		int sz = 0;
		while (l1 != null) {
			// SPR gen patch
			if (sz == 2)
				return false;
			//end SPR gen patch
			sz++;
			l1 = l1.next;
			if (sz > list.size) {
				System.out.println("LOOP NOT DETECTED CORRECTLY");
				System.out.println("infinite loop in the size check");
				return true;
			}

		}

		if (sz != list.size) {
			System.out.println("SIZE not correct");
			res = false;
		}

		return res;
	}
}
package Example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Example.List.Node;

public class ListrepOKmod_list3_fix_spr_without2 {

	// ONLY ONE CAN BE TRUE AT A TIME
	static boolean LISTERR2 = false;
	static boolean LISTERR3 = true;

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

		res = test9();
		if ((res != null) && (res == true)) {
			System.out.println("Pass");

		} else {
			System.out.println("Fail");

		}

		res = test6a();
		if ((res != null) && (res == false)) {
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

	// kill LISTERR2 SPR fix 1 without location
	// loop does not exist: loop not detected -> Passing test
	public static Boolean test9() {
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
		l.header.next.next.next = null;

		l.size = 3;
		Boolean res = null;
		try {
			res = repOK(l);
			System.out.println("TEST9:" + res);
		} catch (Exception e) {
			System.out.println("Exception:" + e.getLocalizedMessage());
			res = null;
		}

		return res;
	}

	// loop exists: loop not detected -> Failing test
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
		l.header.next.next.prev = l.header;
		l.header.next.next.next = l.header.next.next;

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
		List.Node p = null;
		while (cnt1 < list.size) {

			p = l.next;
			int cnt2 = cnt1 + 1;

			boolean cond = ((cnt2 <= list.size) && (p != null)) ? true : false;
			if (LISTERR2)
				cond = (cnt2 < list.size) ? true : false;

			while (cond) {
				// LISTERR3 fix 1 from SPR without location
				if ((l == p) || (cnt1 != 0))
				// end of fix
				// correct
//				if ( (l == p))
				{

					res = false;
					return res;
				}

				cnt2++;
				if (LISTERR3)
					p = l.next;
				else
					p = p.next;

				cond = ((cnt2 <= list.size) && (p != null)) ? true : false;
				if (LISTERR2)
					cond = (cnt2 < list.size) ? true : false;

			}
			l = l.next;
			cnt1++;
		}

		if (res == false)
			return res;

		// checks if size = # of unique nodes reachable from header, res set to
		// false otherwise
		List.Node l1 = list.header;

		//LISTERR3 SPR fix 2 without location
//		  if ((l != null))
//		        return false;
		//end of fix 
		  
		int sz = 0;
		while (l1 != null) {
			// LISTERR2 fix 2 from SPR without location
			// if ((l != null))
			// return false;
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
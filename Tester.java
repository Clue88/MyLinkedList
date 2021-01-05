/******************************************************************************
 *  Compilation:  javac Tester.java
 *  Execution:    java Tester [DEBUG]
 *
 *  DEBUG: Whether to add extra outputs (seed, error output). Defaults true.
 ******************************************************************************/

public class Tester {
    public static int ERR = 0;
    public static boolean DEBUG = true;
    public static void main(String[] args) {
        if (args.length > 0 && Boolean.parseBoolean(args[0]) == false) DEBUG = false;
        String test = "";

        test = "Node(String value)";
        try {
            Node n = new Node("hello");
            nothing(n);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "Node.getValue()";
        try {
            Node n = new Node("hello");
            check(test, n.getValue(), "hello");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "Node.setValue()";
        try {
            Node n = new Node("hello");
            n.setValue("world");
            check(test, n.getValue(), "world");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "Node.getNext()";
        try {
            Node n = new Node("hello");
            check(test, n.getNext(), null);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "Node.setNext()";
        try {
            Node n1 = new Node("hello");
            Node n2 = new Node("world");
            n1.setNext(n2);
            check(test, n1.getNext(), n2);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "Node.getPrev()";
        try {
            Node n = new Node("hello");
            check(test, n.getPrev(), null);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "Node.setPrev()";
        try {
            Node n1 = new Node("hello");
            Node n2 = new Node("world");
            n1.setPrev(n2);
            check(test, n1.getPrev(), n2);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "MyLinkedList()";
        try {
            MyLinkedList m = new MyLinkedList();
            nothing(m);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "MyLinkedList.size()";
        try {
            MyLinkedList m = new MyLinkedList();
            check(test, m.size(), 0);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "MyLinkedList.toString()";
        try {
            MyLinkedList m = new MyLinkedList();
            check(test, m.toString(), "[]");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "MyLinkedList.add(String value)";
        try {
            MyLinkedList m = new MyLinkedList();
            m.add("hello");
            m.add("world");
            m.add("foo");
            m.add("bar");
            check(test, m.toString(), "[hello, world, foo, bar]");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "MyLinkedList.add(int index, String value)";
        try {
            MyLinkedList m = new MyLinkedList();
            m.add(0, "hello");
            m.add(0, "world");
            m.add(2, "foo");
            m.add(1, "bar");
            check(test, m.toString(), "[world, bar, hello, foo]");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "MyLinkedList.get(int index)";
        try {
            MyLinkedList m = new MyLinkedList();
            m.add("hello");
            m.add("world");
            m.add("foo");
            m.add("bar");
            check(test, m.get(3), "bar");
            m.get(4);
            noException(test, "IndexOutOfBoundsException");
        } catch(IndexOutOfBoundsException e) {
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "MyLinkedList.set(int index, String value)";
        try {
            MyLinkedList m = new MyLinkedList();
            m.add("hello");
            m.add("world");
            m.add("foo");
            m.add("bar");
            check(test, m.set(1, "huzzah"), "world");
            check(test, m.toString(), "[hello, huzzah, foo, bar]");
        } catch(IndexOutOfBoundsException e) {
        } catch(RuntimeException e) {
            except(test, e);
        }

        if (ERR == 0) System.out.println("All good!");
        else if (ERR == 1) System.out.println("Uh oh... 1 error found.");
        else System.out.println("Uh oh... " + ERR + " errors found.");
    }

    public static void check(String test, Object actual, Object expected) {
        if (actual == null || expected == null) {
            if (actual != null) {
                System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
                ERR++;
            }
            return;
        }

        if (!actual.equals(expected)) {
            System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            ERR++;
        }
    }

    public static void check(String test, Object actual, Object expected, int seed) {
        if (actual == null || expected == null) {
            if (actual != null) {
                System.out.print("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
                if (DEBUG) System.out.println(" Seed: " + seed);
                else System.out.println();
                ERR++;
            }
            return;
        }
        
        if (!actual.equals(expected)) {
            System.out.print("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            if (DEBUG) System.out.println(" Seed: " + seed);
            else System.out.println();
            ERR++;
        }
    }

    public static void except(String test, RuntimeException e) {
        System.out.println("Failure on " + test + ": RuntimeException");
        if (DEBUG) System.out.println(e.toString());
        ERR++;
    }

    public static void noException(String test, String expected) {
        System.out.println("Failure on " + test + ": Expected " + expected);
        ERR++;
    }

    public static void nothing(Object... nothings) {
        return;
    }
}

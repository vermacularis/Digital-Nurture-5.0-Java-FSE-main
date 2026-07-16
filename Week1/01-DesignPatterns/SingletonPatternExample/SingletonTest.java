/**
 * Test/demo that verifies only ONE Logger instance exists.
 * Run inside this folder:  javac *.java  &&  java SingletonTest
 */
public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message from logger1");
        logger2.log("Second message from logger2");

        System.out.println("logger1 hashCode: " + System.identityHashCode(logger1));
        System.out.println("logger2 hashCode: " + System.identityHashCode(logger2));

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both references point to the SAME Logger instance.");
        } else {
            System.out.println("FAIL: Different instances were created.");
        }
    }
}

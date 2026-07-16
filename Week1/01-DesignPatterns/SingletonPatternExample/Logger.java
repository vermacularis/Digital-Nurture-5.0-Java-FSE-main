/**
 * Exercise 1: Singleton Pattern.
 *
 * A logging utility that must have exactly ONE instance for the whole
 * application lifecycle. Achieved by:
 *   - a private static reference to the single instance
 *   - a private constructor (nobody outside can call `new Logger()`)
 *   - a public static accessor getInstance()
 *
 * This uses lazy initialization made thread-safe with double-checked locking.
 */
public class Logger {

    // The single, shared instance. `volatile` guarantees visibility across threads.
    private static volatile Logger instance;

    // Private constructor prevents external instantiation.
    private Logger() {
        System.out.println("Logger instance created.");
    }

    /** Global access point that always returns the same instance. */
    public static Logger getInstance() {
        if (instance == null) {                 // first check (no locking)
            synchronized (Logger.class) {
                if (instance == null) {         // second check (with lock)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

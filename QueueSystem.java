public class QueueSystem {
    // Volatile ensures visibility of changes across threads
    private static volatile QueueSystem instance;
    private int currentNumber;

    // Private constructor prevents instantiation from outside
    private QueueSystem() {
        currentNumber = 0;
    }

    // Double-Checked Locking Singleton pattern
    public static QueueSystem getInstance() {
        if (instance == null) {  // First check (no locking)
            synchronized (QueueSystem.class) {  // Lock only if instance might be null
                if (instance == null) {  // Second check (with lock)
                    instance = new QueueSystem();
                }
            }
        }
        return instance;
    }

    // Get next queue number
    public synchronized int getNextNumber() {
        currentNumber++;
        return currentNumber;
    }

    // Display current queue number
    public synchronized int getCurrentNumber() {
        return currentNumber;
    }

    // Reset queue number
    public synchronized void resetQueue(int newNumber) {
        if (newNumber < 0) {
            System.out.println("[Error] Cannot reset to a negative number!");
            return;
        }
        System.out.println("[System] Queue reset to start from number: " + newNumber);
        currentNumber = newNumber;
    }
}
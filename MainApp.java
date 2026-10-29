public class MainApp {
    public static void main(String[] args) {
        QueueSystem queue = QueueSystem.getInstance();

        System.out.println("=== Pag-ibig Centralized Queuing System ===");

        System.out.println("Help Desk 1 serving queue number: " + queue.getNextNumber());
        System.out.println("Help Desk 2 serving queue number: " + queue.getNextNumber());
        System.out.println("Help Desk 3 serving queue number: " + queue.getNextNumber());

        System.out.println("\n[Online Monitor] Current queue number: " + queue.getCurrentNumber());

        queue.resetQueue(0);

        System.out.println("\nHelp Desk 1 serving queue number: " + queue.getNextNumber());
        System.out.println("[Online Monitor] Current queue number: " + queue.getCurrentNumber());
    }
}
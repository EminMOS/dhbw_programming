import java.util.Scanner;

public class RobotNavigationSystem {

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Is there an obstacle ahead? (true/false): ");
            boolean obstacleSensor = scanner.nextBoolean();

            System.out.print("Enter battery level (0-100): ");
            int batteryLevel = scanner.nextInt();

            System.out.print("Has the destination been reached? (true/false): ");
            boolean destinationReached = scanner.nextBoolean();

            navigate(obstacleSensor, batteryLevel, destinationReached);
        }
    }

    public static void navigate(boolean obstacleSensor, int batteryLevel, boolean destinationReached) {
        if (destinationReached) {
            System.out.println("Destination reached. Stopping.");
        } else if (obstacleSensor) {
            if (batteryLevel > 50) {
                System.out.println("Obstacle detected. Turning right.");
            } else {
                System.out.println("Obstacle detected. Stopping due to low battery.");
            }
        } else {
            if (batteryLevel > 20) {
                System.out.println("Path clear. Moving forward.");
            } else {
                System.out.println("Low battery. Stopping to recharge.");
            }
        }
    }
}

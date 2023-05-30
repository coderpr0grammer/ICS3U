public class Time {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            // Convert elapsed time to seconds
            long seconds = elapsedTime / 1000;

            // Calculate minutes and seconds
            long minutes = seconds / 60;
            seconds %= 60;

            // Calculate hours and minutes
            long hours = minutes / 60;
            minutes %= 60;

            // Format the time
            String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

            // Clear the terminal/console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Display the elapsed time in the terminal
            System.out.println("Elapsed Time: " + time);

            try {
                // Delay the loop for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

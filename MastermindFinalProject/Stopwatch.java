package MastermindFinalProject;

public class Stopwatch {
    private long startTime;
    private long elapsedTime;
    private boolean isRunning;
    public int timerLimit;

    public Stopwatch() {
        startTime = 0;
        elapsedTime = 0;
        isRunning = false;

    }

    public void start(int limit) {
        
        timerLimit = limit;
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    public void pause() {
        if (isRunning) {
            elapsedTime += System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }

    public long getElapsedTime() {
        long totalTime = elapsedTime;
        if (isRunning) {
            totalTime += System.currentTimeMillis() - startTime;
        }
        return totalTime;
    }

    public String getTimeString() {
        long totalTime = getElapsedTime();

        // Convert elapsed time to seconds
        long tenths = totalTime / 10;
        tenths %= 10;
        long seconds = totalTime / 1000;

        // Calculate minutes and seconds
        long minutes = seconds / 60;
        seconds %= 60;

        // Calculate hours and minutes
        long hours = minutes / 60;
        minutes %= 60;

        // Format the time
        String time = String.format("%02d:%02d", seconds, tenths);

        return time;
    }

    public void displayTimer() {
        while (isRunning) {

            if (getElapsedTime() / 1000 < timerLimit) {

                System.out.print("\r");

                // Display the elapsed time in the terminal
                String time = getTimeString();
                System.out.print("| ⏲ \s Clock's ticking: " + time + " |");

                try {
                    // Delay the loop for 1 second
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                pause();
            }

        }
    }
}
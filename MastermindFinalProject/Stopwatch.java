package MastermindFinalProject;

public class Stopwatch {
    private long startTime;
    private long elapsedTime;
    public boolean isRunning;
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

    public void reset() {
        elapsedTime = 0;
        startTime = System.currentTimeMillis();
        isRunning = true;
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
        String time = String.format("%02d:%02d", timerLimit - seconds, 9 - tenths);

        return time;
    }

}
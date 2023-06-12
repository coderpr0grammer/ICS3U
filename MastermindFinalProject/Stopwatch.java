/* 
 * Daniel Martinez
 * June 12th, 2023
 * ICS3U
 * 
 * Custom Stopwatch class to instantiate new stopwatches that can pause, reset or get the elapsed time 
*/

package MastermindFinalProject;

public class Stopwatch {

    //initialize global variables
    private long startTime;
    private long elapsedTime;
    public boolean isRunning;
    public int timerLimit;

    //constructor sets the defaults of these
    public Stopwatch() {
        startTime = 0;
        elapsedTime = 0;
        isRunning = false;
    }

    //start the stopwatch
    public void start(int limit) {
        timerLimit = limit;
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    //pause the stopwatch
    public void pause() {
        if (isRunning) {
            //set the elapsed time to current time minus start time
            elapsedTime += System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }

    //reset the stopwatch
    public void reset() {
        elapsedTime = 0;
        startTime = System.currentTimeMillis();
        isRunning = true;
    }

    //get the elapsed time
    public long getElapsedTime() {
        long totalTime = elapsedTime;
        if (isRunning) {
            totalTime += System.currentTimeMillis() - startTime;
        }
        return totalTime;
    }

    //create a formatted time string using String.format()
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
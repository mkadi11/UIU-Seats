//done
package com.example.group42_real_final;
import java.util.LinkedList;
import java.util.Queue;
import java.time.LocalTime;

public class Place {
    private String name;
    private double avg;
    private int inputs; // number of inputs in the queue -->maxed out at 25
    private Queue<Integer> inputQueue; // Use Queue<Integer> to store inputs
    final private int capacity = 25;
    private LocalTime resetTime;

    // Constructor
    public Place(String name) {
        this.name = name;
        this.avg = 0;
        this.inputs = 0;
        this.inputQueue = new LinkedList<>();
        this.resetTime = LocalTime.of(4,0,0);
    }

    // Add function
    public void add(int rating) {
        // add the new user input
        // call average
        // update inputs queue
        // update front end --> do we do that here?

        // Ensure the input is within bounds (1, 2, or 3)

        inputQueue.add(rating);
        inputs++;
        if (inputs >= capacity) {
            inputQueue.remove();
            inputs--; // Remove the oldest input
        }
        average();

        // Update the front end here
    }

//    // Remove function --> come back when have buttons, for user to remove their input
//    public void remove() {
//        // Deletes the oldest input from the queue
//        // Calls average to update the average of that
//        // Update front end
//
//        if (!inputQueue.isEmpty()) {
//            int removedInput = inputQueue.poll();
//            inputs--;
//            avg();
//            // Update the front end here
//        }
//    }

    // Average (private) function
    private void average() {
        // Called on a specific location object in add
        // Averages the values in the inputQueue (divide by the size of inputs)
        // If inputs is larger than the size of the queue, set inputs to queue.size()
        // Update average variable

        double sum = 0;
        for (int input : inputQueue) {
            sum += input;
        }

        if (inputs > 0) {
            avg = sum / inputs;
        } else {
            avg = 0;
        }
    }

    public String getAvg() {
        String ret = "";
        String val = Double.toString(avg * 10);
        if(val.length() >= 2 && !(val.equals("100.0"))) {
            val = val.substring(0, 2);
        } else if(val.equals("100.0")) {
            val = val.substring(0, 3);
        }
        if(avg  > 6.7) {
            ret += "BUSY: " + (val) + "%";
        } else if (avg < 3.3) {
            ret += "EMPTY: " + (val) + "%";
        } else {
            ret += "NEUTRAL: " + (val) + "%";
        }
        return ret;
    }

    // Reset function
    public void reset() {
        // Sets private variables to zero at a given time
        // Empties the input queue
        inputs = 0;
        avg = 0;
        inputQueue.clear();
    }
    //resets queue at 4am for the given location
    public void timeBasedReset() {
        LocalTime time = LocalTime.now();

        if(time.equals(resetTime)) {
            reset();
        }
    }

}
// come back to this when doing frontend to config for user input + buttons
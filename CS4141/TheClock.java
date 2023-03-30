// Name : Mykola Vaskevych

// ID : 2232199

public class TheClock {

    public static void main(String[] args) {

        // Declaring some NAMED CONSTANTS

        final long MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;

        final long SECONDS_IN_AN_HOUR = 60 * 60;


        // Declaring some VARIABLES AND ASSIGNING INITIAL VALUES TO THEM

        long millisSinceMidnight = 0, secondsSinceMidnight = 0;

        long hour = 0, minute = 0, second = 0;


        // ALTER THE STATES OF THE VARIABLES IN THE CORRECT SEQUENCE

        // TO FIND OUT WHAT TIME IT IS

        // Take the current time and remove all the time up to midnight last night

        millisSinceMidnight = System.currentTimeMillis() % MILLISECONDS_IN_A_DAY;

        // Convert the millis to seconds

        secondsSinceMidnight = millisSinceMidnight / 1000;

        // Calculate how many hours are in secondsSinceMidnight

        hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;

        // Calculate how many minutes are in time NOT INCLUDED in the hours

        minute = (secondsSinceMidnight % SECONDS_IN_AN_HOUR) / 60;

        // Calculate how many seconds are in time NOT INCLUDED in the hours and minutes

        second = secondsSinceMidnight % 60;

        // Output the results. NOTE: The outputs may be single digits.

        System.out.println(hour + ":" + minute + ":" + second);

    }

}
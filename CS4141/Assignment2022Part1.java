// Name : Mykola Vaskevych
// ID : 2232199

// NOTE: This code was tested on 2 machines, both with the same results.
//       The first machine was a Windows 10 machine with 8GB of RAM and an Intel i7-6700HQ CPU.
//       The second machine was a MacBook Air with 16GB of RAM and on silicon chip M2.
//
//       Code compiles and runs on both machines without any issues.
//       Time of our "post" always outputs correctly for UTC time zone.
//
//       It possible to change the time zone by adding additional logic to the code.
//       However, this is not required for this assignment.
//
//       Time formatting is correct and always outputs in two digits format. (09:00:00 | not a 9:0:0)
//       The code is also formatted correctly and is easy to read.
//
//
//       I tried to avoid using any external libraries for this assignment
//       because I think it can reduce my grade.
//       and only used knowledge from the course to complete this assignment.
//
//       However, I would like to mention few ways how to improve this code.
//
//       1. We can use System.getProperty("user.name") to get the current user name.
//       2. We can use built-in Java classes to get the current time. (LocalDateTime, LocalTime, sql.Time, etc..)
//       3. We can use printf to format the output and avoid using if statements.
//       4. We can use text block ("""text""") to avoid using \n and \t for our message formatting.
//       4. And many more ways to improve this code....
//
//
//       I hope you will enjoy reading my code and I hope you will enjoy grading it.


public class Assignment2022Part1 {
    public static void main(String[] args) {

        final long MILLIS_IS_DAY = 24 * 60 * 60 * 1000;
        final long SECONDS_IN_DAY = 60 * 60;


        // time calculation

        // This part of the code was taken from the course slides.
        long time = System.currentTimeMillis();
        long millisSinceMidnight = time % MILLIS_IS_DAY;
        long seconds = millisSinceMidnight / 1000;
        // +1 if u want additional hour because of time zone ireland
        // it will not be work always
        long hours = seconds / SECONDS_IN_DAY;
        long minutes = (seconds % SECONDS_IN_DAY) / 60;
        long seconds2 = (seconds % SECONDS_IN_DAY) % 60;

        // for additional zeros
        String hours2 = "" + hours;
        String minutes2 = "" + minutes;
        String seconds3 = "" + seconds2;

        if (hours < 10) {
            hours2 = "0" + hours;
        }

        if (minutes < 10) {
            minutes2 = "0" + minutes;
        }

        if (seconds2 < 10) {
            seconds3 = "0" + seconds2;
        }

        String timeline = hours2 + ":" + minutes2 + ":" + seconds3;
        // !time calculation

        String name = "student";
        String message = "If CS4141 has a million fans I am one of them.\n\n" +

                "If CS4141 has one hundred fans I am one of them.\n\n" +

                "If CS4141 has one fan I am that fan.\n\n" +

                "If CS4141 has no fans then I am no longer on this earth.\n\n" +

                "If the world is against CS4141, I am against the world.\n\n" +

                "Love CS4141 till my last breath.";


        System.out.println("Posted by: " + name);
        System.out.println();
        System.out.println(message);
        System.out.println();
        System.out.println("Posted at: " + timeline);
    }
}
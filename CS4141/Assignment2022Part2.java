import static java.lang.System.getProperty;

public class Assignment2022Part2 {
    final static long MILLIS_IS_DAY = 24 * 60 * 60 * 1000;
    final static long SECONDS_IN_DAY = 60 * 60;

    final static String text1 = "If CS4141 has a million fans I am one of them.\n\n" +
            "If CS4141 has one hundred fans I am one of them.\n\n" +
            "If CS4141 has one fan I am that fan.\n\n" +
            "If CS4141 has no fans then I am no longer on this earth.\n\n" +
            "If the world is against CS4141, I am against the world.\n\n" +
            "Love CS4141 till my last breath. (text1)";
    final static String text2 = "A best friend is like a four leaf clover: hard to find and lucky to have. (text2)";
    final static String text3 = "One apple a day keeps the doctor away. (text3)";
    final static String text4 = "You are not reading this book because a teacher assigned it to you,\n" +
            "you are reading it because you have a desire to learn, and wanting to learn\n" +
            "is the biggest advantage you can have. (text4)";
    final static String text5 = "The best way to predict the future is to invent it. (text5)";

    final static String[] texts = {text1, text2, text3, text4, text5};
    final static String[] names = {"student", "student2", "student3",
            "student4", "student5", getProperty("user.name")};

    public static void main(String[] args) {


        String senderMessage = texts[(int) (Math.random() * texts.length)];
        String senderName = names[(int) (Math.random() * names.length)];

        if (senderName.equals(getProperty("user.name"))) {
            senderName = senderName.toLowerCase();
        } else {
            senderName = senderName.toUpperCase();
        }

        // current time calculation
        // This part of the code was taken from the course slides.
        long time = System.currentTimeMillis();
        long millisSinceMidnight = time % MILLIS_IS_DAY;
        long seconds = millisSinceMidnight / 1000;
        long hours = seconds / SECONDS_IN_DAY;
        long minutes = (seconds % SECONDS_IN_DAY) / 60;
        long seconds2 = (seconds % SECONDS_IN_DAY) % 60;
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

        String currentTime = hours2 + ":" + minutes2 + ":" + seconds3;
        // ! current time calculation

        // random time calculation
        long randomTime = (long) (Math.random() * 1000000000000L);
        long randomMillisSinceMidnight = randomTime % MILLIS_IS_DAY;
        long randomSeconds = randomMillisSinceMidnight / 1000;
        long randomHours = randomSeconds / SECONDS_IN_DAY;
        long randomMinutes = (randomSeconds % SECONDS_IN_DAY) / 60;
        long randomSeconds2 = (randomSeconds % SECONDS_IN_DAY) % 60;
        String randomHours2 = "" + randomHours;
        String randomMinutes2 = "" + randomMinutes;
        String randomSeconds3 = "" + randomSeconds2;
        // for additional zeros
        if (randomHours < 10) {
            randomHours2 = "0" + randomHours;
        }
        if (randomMinutes < 10) {
            randomMinutes2 = "0" + randomMinutes;
        }
        if (randomSeconds2 < 10) {
            randomSeconds3 = "0" + randomSeconds2;
        }
        String randomTime2 = randomHours2 + ":" + randomMinutes2 + ":" + randomSeconds3;
        // ! random time calculation

        // random day calculation
        long howManyDaysAgo = (int) (Math.random() * 10);
        String day = "";
        if (howManyDaysAgo == 0) {
            day = "no day output";
        } else if (howManyDaysAgo == 1) {
            day = "Yesterday";
        } else if (howManyDaysAgo == 2) {
            day = "Monday";
        } else if (howManyDaysAgo == 3) {
            day = "Tuesday";
        } else if (howManyDaysAgo == 4) {
            day = "Wednesday";
        } else if (howManyDaysAgo == 5) {
            day = "Thursday";
        } else if (howManyDaysAgo == 6) {
            day = "Friday";
        } else if (howManyDaysAgo == 7) {
            day = "Saturday";
        } else if (howManyDaysAgo == 8) {
            day = "Sunday";
        } else if (howManyDaysAgo > 8) {
            day = "Some time ago...";
        }


        System.out.println("Posted By " + senderName);
        System.out.println(senderMessage);
        System.out.println("Posted At " + randomTime2);
        if (!day.equals("no day output")) {
            System.out.printf("%40s", day);
        } else {
            System.out.println(day);
        }

    }
}
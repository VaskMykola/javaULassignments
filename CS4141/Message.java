/*
 * Name : Mykola Vaskevych
 * ID : 22372199
 *
 */

class MessageToolBox {
    public static String timeOfDayFormatted(long timeInMillis) {
        final long MILLISECONDS_IN_A_DAY = 86400000;
        final long SECONDS_IN_AN_HOUR = 3600;
        final long secondsSinceMidnight = (timeInMillis % MILLISECONDS_IN_A_DAY) / 1000;

        long hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;
        long minute = (secondsSinceMidnight % SECONDS_IN_AN_HOUR) / 60;
        long second = secondsSinceMidnight % 60;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public static String dayName(long timeInMillis) {

        // Get the number of days since January 1, 1970
        long daysSince1970 = timeInMillis / 86400000;

        // calculate the day of the week
        int dayOfWeek = (int) (daysSince1970 + 4) % 7;


        // Get the day name
        return switch (dayOfWeek) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "ERROR can't find day of the week";
        };
    }

    public static int ageOfPost(long timeInMillis) {
        long age = System.currentTimeMillis() - timeInMillis;
        if (age < 0) {
            return -1;
        }
        return (int) (age / (1000 * 60 * 60 * 24)); // convert to days
    }

    public static String centre(String messageText, int width) {

        StringBuilder newMessageText = new StringBuilder();

        if (width <= 0) {
            return newMessageText.toString();

        } else if (width < messageText.length()) {
            return newMessageText.toString();

        } else if (messageText.length() == 0) {
            newMessageText.append(" ".repeat(width));

        } else {

            String spaces = " ".repeat((width - messageText.length()) / 2);

            if (width % 2 == 0) {
                newMessageText.append(spaces);
                newMessageText.append(messageText);
                newMessageText.append(spaces);

            } else {
                newMessageText.append(spaces);
                newMessageText.append(messageText);
                newMessageText.append(" ".repeat((width - messageText.length()) / 2 + 1));
            }
        }

        return newMessageText.toString();
    }

    public static void display(String messageText, int width) {

        if (messageText.length() == 0) {
            return;
        }

        if (width < 10) {
            width = 10;

        } else if (width > 80) {
            width = 80;
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < messageText.length(); i++) {

            char ch = messageText.charAt(i);
            out.append(ch);

            if (i % width == 0 && i != 0) {
                System.out.println(out);
                out = new StringBuilder();
            }

            if (i == messageText.length() - 1) {
                System.out.println(out);
            }
        }
    }
}

public class Message extends MessageToolBox {
    private static final int DISPLAY_WIDTH = 30;
    private String postedBy;
    private String messageText;
    private long postedAt;


    public Message(String text) {
        this.messageText = text;
        this.postedBy = System.getProperty("user.name");
        this.postedAt = System.currentTimeMillis();
    }

    public Message(String text, String postedBy) {
        this(text);
        this.postedBy = postedBy;
    }


    public void display() {
        display(messageText, DISPLAY_WIDTH);
    }

    public String getPostedBy() {
        return postedBy;
    }

    public String getMessageText() {
        return messageText;
    }

    public long getPostedAt() {
        return postedAt;
    }

    public String postedAtTime() {
        return timeOfDayFormatted(postedAt);
    }

    public String postedAtDayName() {
        return dayName(postedAt);
    }

    public int ageOfPost() {
        return ageOfPost(postedAt);
    }

}
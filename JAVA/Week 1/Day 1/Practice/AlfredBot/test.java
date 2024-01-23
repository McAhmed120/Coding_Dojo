public class test {

    public static void main(String[] args) {
        AlfredBot alfred = new AlfredBot();

        // Example usage:
        System.out.println(alfred.basicGreeting());

        String guestName = "John";
        String dayPeriod = "morning";
        System.out.println(alfred.guestGreeting(guestName, dayPeriod));

        System.out.println(alfred.dateAnnouncement());

        String userPhrase = "Hello Alfred!";
        System.out.println(alfred.answeringBeforeAlexis(userPhrase));
    }
}

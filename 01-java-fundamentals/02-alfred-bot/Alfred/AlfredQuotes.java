import java.util.Date;


public class AlfredQuotes {

    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
   
    public String guestGreeting(String name, String dayPeriod) {
        String string1 = "Good " + dayPeriod + ", " + name + ". ";
        String string2 = "Lovely to see you.";
        String string3 = string1.concat(string2);
        return string3;
    }


    public String dateAnnouncement() {
                Date date = new Date();
                return "The Current date is: " + date;
            }
    
    public String conversation(String discussion) {
            int alfred = discussion.indexOf("Alfred");
            int alexis = discussion.indexOf("Alexis");
            if(alexis > -1) {
                return "Right away, sir.  She certainly isn't sophisticated for that.";
            }
            else if(alfred > -1) {
                return "At your service.  As you wish, naturally.";
            }
            else {
                return "Right. And with that I shall retire.";
            }
    }

    public String respondBeforeAlexis(String conversation) {
        int alfred = conversation.indexOf("Alfred");
        int alexis = conversation.indexOf("Alexis");
        String none = "Is there something I can help you with, sir?";
        if(alexis > -1) {
            return "Right away, sir.  She certainly isn't sophisticated for that.";
        }
        else if(alfred > -1) {
            return "At your service.  As you wish, naturally.";
        }
        else {
            return none.toUpperCase();
        }
        
    }
    
}


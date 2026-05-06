package CreationalDesginPattern.FactorDesginPattern;
 interface Notification {
    void send();
}
class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Email Notification");
    }
}
class SMSNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending SMS Notification");
    }
}

class PushNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }
}

class NotificationFactory {

    public static Notification createNotification(String type) {

        if(type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }

        else if(type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }

        else if(type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }

        throw new IllegalArgumentException("Invalid type");
    }
}
public class FactoryDesgin {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.createNotification("EMAIL");
        notification1.send(); // Output: Sending Email Notification

        Notification notification2 = NotificationFactory.createNotification("SMS");
        notification2.send(); // Output: Sending SMS Notification

        Notification notification3 = NotificationFactory.createNotification("PUSH");
        notification3.send(); // Output: Sending Push Notification
    }
    
}

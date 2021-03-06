package org.forum.entities.user.email;

public class EmailMessage {

    private String recipient;
    private String subject;
    private String content;


    public EmailMessage(String recipient, String subject, String content) {
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}

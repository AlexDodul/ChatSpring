package org.example.dto;

public class ChatForm {

    private String userName;
    private String messageText;

    public ChatForm() {}

    public ChatForm(String userName, String messageText) {
        this.userName = userName;
        this.messageText = messageText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "ChatForm{" +
                "userName='" + userName + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}

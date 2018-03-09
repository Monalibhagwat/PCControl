package com.example.rahul.lbs;
import java.io.Serializable;

public class Message implements Serializable{

    private static final long serialVersionUID = 1L;
    public String type, sender,  recipient;
    public Object content;

    public Message(String type, String sender, String content, String recipient){
        this.type = type; this.sender = sender; this.content = content; this.recipient = recipient;
    }
    public Message(String type, String sender, Object content, String recipient){
        this.type = type; this.sender = sender; this.content = content; this.recipient = recipient;
    }
    @Override
    public String toString(){
        return "{type='"+type+"', sender='"+sender+"', content='"+content+"', recipient='"+recipient+"'}";
    }
}

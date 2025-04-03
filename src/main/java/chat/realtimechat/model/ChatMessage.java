package chat.realtimechat.model;



//korisne anotacije da preskocim pisanje gettera, settera i konstruktora


public class ChatMessage {
    private String sender;
    private String content;

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package Models;

public class Messages {

    private int id;
    private String name;
    private String lastMsg;
    private String date;
    private int image;

    public Messages(int id, String name, String lastMsg, String date, int image) {
        this.id = id;
        this.name = name;
        this.lastMsg = lastMsg;
        this.date = date;
        this.image = image;
    }

    public Messages() {
    }

    public Messages(String name, String lastMsg, String date, int image) {
        this.name = name;
        this.lastMsg = lastMsg;
        this.date = date;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

package algonquin.cst2335.pate1088;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatMessage {
    @ColumnInfo(name = "message")
    String message;

    @ColumnInfo(name = "TimeSent")
    String timeSent;

    @ColumnInfo(name = "SendOrReceive")
    boolean isSentButton;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    // Empty constructor for Room
    public ChatMessage() {
    }

    // Constructor with parameters that match the fields
    public ChatMessage(String message, String timeSent, boolean isSentButton) {
        this.message = message;
        this.timeSent = timeSent;
        this.isSentButton = isSentButton;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public boolean isSentButton() {
        return isSentButton;
    }

    public int getId() {
        return id;
    }
}
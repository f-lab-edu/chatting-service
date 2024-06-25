package flab.chattingservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String id;
    private String roomId;
    private String sender;
    private String message;
}

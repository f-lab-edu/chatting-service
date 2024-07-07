package flab.chattingservice.data.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ChatMessageDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String messageId;
    private String roomId;
    private String sender;
    private String message;
    private LocalDateTime timestamp;
}
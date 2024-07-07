package flab.chattingservice.data.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class ChatRoomDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomId;
    private String roomName;

}

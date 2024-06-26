package flab.chattingservice.data.repository;

import flab.chattingservice.data.dto.ChatRoomDto;
import flab.chattingservice.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoomDto, String> {
    default ChatRoomDto saveChatRoom(ChatRoom chatRoom) {
        ChatRoomDto dto = new ChatRoomDto();
        dto.setRoomId(chatRoom.getRoomId());
        dto.setRoomName(chatRoom.getRoomName());
        return this.save(dto);
    }
    Optional<ChatRoomDto> findByRoomId(String roomId);
}

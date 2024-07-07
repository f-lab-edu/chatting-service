package flab.chattingservice.integration;

import flab.chattingservice.data.dto.ChatRoomDto;
import flab.chattingservice.data.repository.ChatRoomRepository;
import flab.chattingservice.model.ChatRoom;
import flab.chattingservice.service.ChatRoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class ChatRoomServiceImplIntegrationTest {

    @Autowired
    private ChatRoomService chatRoomService;

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Test
    public void createChatRoom_ShouldSaveChatRoom() {
        // Given
        ChatRoom chatRoom = new ChatRoom();
        String expectedRoomId = UUID.randomUUID().toString();
        String expectedRoomName = UUID.randomUUID().toString();
        chatRoom.setRoomId(expectedRoomId);
        chatRoom.setRoomName(expectedRoomName);

        // When
        ChatRoom createdChatRoom = chatRoomService.createChatRoom(chatRoom);

        // Then
        assertNotNull(createdChatRoom);
        assertNotNull(createdChatRoom.getRoomId());
        assertEquals(expectedRoomId, createdChatRoom.getRoomId());
        assertEquals(expectedRoomName, createdChatRoom.getRoomName());

        Optional<ChatRoomDto> foundChatRoom = chatRoomRepository.findByRoomId(createdChatRoom.getRoomId());
        assertNotNull(foundChatRoom);
        assertEquals(expectedRoomId, foundChatRoom.get().getRoomId());
        assertEquals(expectedRoomName, foundChatRoom.get().getRoomName());
    }
}

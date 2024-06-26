package flab.chattingservice.service;

import flab.chattingservice.data.repository.ChatRoomRepository;
import flab.chattingservice.model.ChatRoom;
import flab.chattingservice.service.ChatRoomService;
import flab.chattingservice.service.impl.ChatRoomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class ChatRoomServiceImplTest {

    @Mock
    private ChatRoomRepository chatRoomRepository;

    @InjectMocks
    private ChatRoomServiceImpl chatRoomService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

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
        verify(chatRoomRepository, times(1)).saveChatRoom(any(ChatRoom.class));
        assertEquals(expectedRoomId, createdChatRoom.getRoomId());
        assertEquals(expectedRoomName, createdChatRoom.getRoomName());
    }
}

package flab.chattingservice.service.impl;

import flab.chattingservice.data.repository.ChatRoomRepository;
import flab.chattingservice.model.ChatRoom;
import flab.chattingservice.service.ChatRoomService;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        chatRoomRepository.saveChatRoom(chatRoom);
        return chatRoom;
    }

}
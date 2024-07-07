package flab.chattingservice.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomCreation {
    @GetMapping("/createChatRoom")
    public String showCreateChatRoomPage() {
        return "createChatRoom";
    }
}
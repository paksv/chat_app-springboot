package in.tusharprabhu.chatapp.controller;

import in.tusharprabhu.chatapp.model.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChatControllerTest {

    @InjectMocks
    private ChatController chatController;

    @Mock
    private SimpMessageHeaderAccessor headerAccessor;

    @Test
    public void testSendMessage() {
        // Create a test message
        ChatMessage chatMessage = ChatMessage.builder()
                .content("Hello, World!")
                .sender("TestUser")
                .type(ChatMessage.MessageType.CHAT)
                .build();

        // Call the controller method
        ChatMessage result = chatController.sendMessage(chatMessage);

        // Verify the result
        assertEquals(chatMessage.getContent(), result.getContent());
        assertEquals(chatMessage.getSender(), result.getSender());
        assertEquals(chatMessage.getType(), result.getType());
    }

    @Test
    public void testRegister() {
        // Create a test message
        ChatMessage chatMessage = ChatMessage.builder()
                .content("User joined")
                .sender("NewUser")
                .type(ChatMessage.MessageType.JOIN)
                .build();

        // Mock the session attributes
        Map<String, Object> sessionAttributes = new HashMap<>();
        when(headerAccessor.getSessionAttributes()).thenReturn(sessionAttributes);

        // Call the controller method
        ChatMessage result = chatController.register(chatMessage, headerAccessor);

        // Verify the username was added to session attributes
        assertEquals("NewUser", sessionAttributes.get("username"));
        
        // Verify the returned message
        assertEquals(chatMessage.getContent(), result.getContent());
        assertEquals(chatMessage.getSender(), result.getSender());
        assertEquals(chatMessage.getType(), result.getType());
    }
}
package in.tusharprabhu.chatapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChatMessageTest {

    @Test
    public void testChatMessageBuilder() {
        // Test the builder pattern
        ChatMessage message = ChatMessage.builder()
                .content("Hello, world!")
                .sender("TestUser")
                .type(ChatMessage.MessageType.CHAT)
                .build();
        
        assertEquals("Hello, world!", message.getContent());
        assertEquals("TestUser", message.getSender());
        assertEquals(ChatMessage.MessageType.CHAT, message.getType());
    }
    
    @Test
    public void testChatMessageGettersAndSetters() {
        // Test getters and setters
        ChatMessage message = new ChatMessage();
        message.setContent("Test content");
        message.setSender("John");
        message.setType(ChatMessage.MessageType.JOIN);
        
        assertEquals("Test content", message.getContent());
        assertEquals("John", message.getSender());
        assertEquals(ChatMessage.MessageType.JOIN, message.getType());
    }
    
    @Test
    public void testMessageTypeEnum() {
        // Test the MessageType enum values
        assertEquals(3, ChatMessage.MessageType.values().length);
        assertEquals(ChatMessage.MessageType.CHAT, ChatMessage.MessageType.valueOf("CHAT"));
        assertEquals(ChatMessage.MessageType.JOIN, ChatMessage.MessageType.valueOf("JOIN"));
        assertEquals(ChatMessage.MessageType.LEAVE, ChatMessage.MessageType.valueOf("LEAVE"));
    }
}
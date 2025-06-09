package in.tusharprabhu.chatapp.config;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

public class WebSocketConfigTest {

    @Test
    public void testRegisterStompEndpoints() {
        // Create an instance of the class to test
        WebSocketConfig webSocketConfig = new WebSocketConfig();
        
        // Mock the StompEndpointRegistry
        StompEndpointRegistry registry = Mockito.mock(StompEndpointRegistry.class);
        
        // Mock the registry.addEndpoint() call
        Mockito.when(registry.addEndpoint("/websocket")).thenReturn(Mockito.mock(org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration.class));
        
        // Call the method to test
        webSocketConfig.registerStompEndpoints(registry);
        
        // Verify that addEndpoint was called with the correct argument
        Mockito.verify(registry).addEndpoint("/websocket");
    }
    
    @Test
    public void testConfigureMessageBroker() {
        // Create an instance of the class to test
        WebSocketConfig webSocketConfig = new WebSocketConfig();
        
        // Mock the MessageBrokerRegistry
        MessageBrokerRegistry registry = Mockito.mock(MessageBrokerRegistry.class);
        
        // Call the method to test
        webSocketConfig.configureMessageBroker(registry);
        
        // Verify that the methods were called with the correct arguments
        Mockito.verify(registry).enableSimpleBroker("/topic");
        Mockito.verify(registry).setApplicationDestinationPrefixes("/app");
    }
}
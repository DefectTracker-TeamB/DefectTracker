package com.spring.gradle.defect.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.entity.Notification;
@Service
public class NotificationService {

	
	private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    
 
    public void sendGlobalNotification() {
    	Notification response = new Notification(" Notification Sent to all");

        messagingTemplate.convertAndSend("/topic/global-notifications", response);
    }

//    public void sendPrivateNotification(final String userId) {
//        Notification message = new Notification("Private Notification");
//
//       messagingTemplate.convertAndSendToUser(userId,"/topic/private-notifications", message);   
//}


}

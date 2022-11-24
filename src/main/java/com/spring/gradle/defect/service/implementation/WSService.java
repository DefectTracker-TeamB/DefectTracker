package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.service.implementation.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.entity.Notification;

@Service 
public class WSService {
	private final SimpMessagingTemplate messagingTemplate;
	private final NotificationService notificationService;
	
	@Autowired
	    public WSService(SimpMessagingTemplate messagingTemplate, NotificationService notificationService) {
	        this.messagingTemplate = messagingTemplate;
	        this.notificationService = notificationService;
	    }
	    
	public void notifyFrontend(final String message) {
        Notification response = new  Notification( message);
        notificationService.sendGlobalNotification();
        messagingTemplate.convertAndSend("/topic/messages", response);
    }

	public static void saveNotification(Notification notification) {
		// TODO Auto-generated method stub
		
	}
}
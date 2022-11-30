package com.spring.gradle.defect.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.entity.Notification;
import com.spring.gradle.defect.repository.NotificationRepository;
import com.spring.gradle.defect.service.MNotificationService;

@Service
public class NotificationImplementation implements MNotificationService {
	@Autowired NotificationRepository notificationRepository;

	public void saveNotific(Notification notific) {
		notificationRepository.save(notific);
		
	}
	
	
	
}

package com.example.service;

import java.util.Date;
import java.util.List;

import com.example.entity.Activity;


public interface ActivityService {

	public List<Activity> listByAuthor(String author);
	
	public List<Activity> listByDatePeriod(Date startDate  ,Date endDate);
	
	public List<Activity> listByKeyword(String keyword);
	
	public Activity getActivityById(Long id);

	public Activity createActivity(Activity activity);
	
	public void deleteActivity(Long id);
	
	public Activity updateActivity(Activity activity,Long id);
	
}

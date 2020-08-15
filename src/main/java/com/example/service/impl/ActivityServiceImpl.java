package com.example.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ActivityDao;
import com.example.entity.Activity;
import com.example.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	private List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<>();
		activityDao.findAll().forEach(activities::add);
		return activities;
	}

	@Override
	public List<Activity> listByAuthor(String author) {
		return findAllActivities().stream().filter(a -> a.getAuthor().equalsIgnoreCase(author))
				.collect(Collectors.toList());
	}

	@Override
	public List<Activity> listByDatePeriod(Date startDate, Date endDate) {
		return findAllActivities().stream()
				.filter(a -> startDate.before(a.getDateOfCreation()) && endDate.after(a.getDateOfCreation()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Activity> listByKeyword(String keyword) {
		return findAllActivities().stream()
				.filter(a -> a.concateableFields().contains(keyword))
				.collect(Collectors.toList());
	}

	@Override
	public Activity getActivityById(Long id) {
		return activityDao.findById(id).orElse(null);
	}

	@Override
	public Activity createActivity(Activity activity) {
		return activityDao.save(activity);
	}

	@Override
	public void deleteActivity(Long id) {
		activityDao.deleteById(id);

	}

	@Override
	public Activity updateActivity(Activity activity, Long id) {
		if (!id.equals(activity.getId())) {
			throw new IllegalArgumentException("activity Id does not match given id");
		}
		activityDao.findById(id).get(); // if activity not found throws no such element exception
		return activityDao.save(activity);
	}

}

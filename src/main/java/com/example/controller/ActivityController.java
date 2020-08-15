package com.example.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Activity;
import com.example.enums.DatePeriods;
import com.example.service.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	ActivityService  activityService;
	
	@RequestMapping(value="/create" ,method = RequestMethod.POST, produces = "application/json" )
	public Activity create(@RequestBody Activity activity) {
		return activityService.createActivity(activity);
	}
	
	@GetMapping("/{id}")
	public Activity getActivityById(@PathVariable Long id) {
		return activityService.getActivityById(id);
	}
	
	@PutMapping("/{id}")
	public Activity updateActivity(@PathVariable Long id, @RequestBody Activity activity ) {
		return activityService.updateActivity(activity,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteActivity(@PathVariable Long id) {
		activityService.deleteActivity(id);
	}
	
	@GetMapping("/listByAuthor")
	public List<Activity> getActivitiesByAuthor(@RequestParam  String author) {
		return activityService.listByAuthor(author);
	}
	
	@GetMapping("/listByDatePeriod")
	public List<Activity> listByDatePeriod(@RequestParam DatePeriods period) {
		LocalDate now = LocalDate.now();
		Date startDate= null;
		if(period.equals(DatePeriods.LAST_DAY)) {
			startDate = Date.from(now.minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		}else if(period.equals(DatePeriods.LAST_WEEK)) {
			startDate = Date.from(now.minusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant());
		}else if(period.equals(DatePeriods.LAST_30_DAYS)) {
			startDate = Date.from(now.minusDays(30).atStartOfDay(ZoneId.systemDefault()).toInstant());
		}
		return activityService.listByDatePeriod(startDate, new Date());
	}

	@GetMapping("/listByKeyword")
	public List<Activity> listByKeyword(@RequestParam String keyword) {
		return activityService.listByKeyword(keyword);
	}

}

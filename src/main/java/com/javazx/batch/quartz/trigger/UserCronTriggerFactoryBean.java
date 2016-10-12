package com.javazx.batch.quartz.trigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author itmrchen
 * @date 2016/10/12
 * @time 13:19
 */
public class UserCronTriggerFactoryBean implements FactoryBean<Trigger>{

	private final String jobName;
	
	private final String cronExpression;
	
	public UserCronTriggerFactoryBean(String jobName, String cronExpression){
		this.jobName = jobName;
		this.cronExpression = cronExpression;
	}
	
	public Trigger getObject() throws Exception {

		return TriggerBuilder
				.newTrigger()
				.forJob(jobName, "DEFAULT")
				.withIdentity(jobName+"Trigger", "DEFAULT")
				.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
				.build();
	}

	public Class<?> getObjectType() {
		return Trigger.class;
	}

	public boolean isSingleton() {
		return false;
	}

}

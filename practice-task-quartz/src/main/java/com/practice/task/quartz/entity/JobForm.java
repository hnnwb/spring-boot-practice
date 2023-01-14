package com.practice.task.quartz.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wb
 */
@Data
@Accessors(chain = true)
public class JobForm {
    /**
     * 定时任务全类名
     */
    private String jobClassName;
    /**
     * 任务组名
     */
    private String jobGroupName;
    /**
     * 定时任务cron表达式
     */
    private String cronExpression;
}

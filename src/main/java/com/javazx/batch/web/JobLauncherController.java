package com.javazx.batch.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author itmrchen
 * @date 2016/10/13
 * @time 12:25
 */
@Controller
public class JobLauncherController {

    private static final String JOB_NAME = "jobName";

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobRegistry jobRegistry;

    @RequestMapping(value = "/executeJob", method = RequestMethod.GET)
    public String launch(@RequestParam String jobName,
                         HttpServletRequest request) throws Exception {
        JobParameters jobParameters = bulidParameters(request);
        JobExecution result = jobLauncher.run(jobRegistry.getJob(jobName),
                jobParameters);
        ExitStatus es = result.getExitStatus();
        if (es.getExitCode().equals(ExitStatus.COMPLETED.getExitCode())) {
            return "ok";
        } else if (es.getExitCode().equals(ExitStatus.EXECUTING.getExitCode())) {
            return "process";
        } else if (es.getExitCode().equals(ExitStatus.UNKNOWN.getExitCode())) {
            return "process";
        } else {
            System.out.println("任务失败，exitCode=" + es.getExitCode());
            return "err";
        }

    }

    private JobParameters bulidParameters(HttpServletRequest request) {
        JobParametersBuilder builder = new JobParametersBuilder();

        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            if (!JOB_NAME.equals(paramName)) {
                builder.addString(paramName, request.getParameter(paramName));
            }
        }
        builder.addLong("time", System.currentTimeMillis());
        return builder.toJobParameters();
    }
}

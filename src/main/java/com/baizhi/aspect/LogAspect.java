package com.baizhi.aspect;

import com.baizhi.entity.Admin;
import com.baizhi.entity.mess;
import com.baizhi.service.MessService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Autowired
    HttpServletRequest request;
    @Autowired
    MessService messService;

    @Pointcut("@annotation(com.baizhi.aspect.Log)")
    public void pt() {

    }

    @Around("pt()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) {
        mess mess = new mess();
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        String s = admin.getName();
        Date date = new Date();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        String name = annotation.name();
        String flag = "flase";
        Object proceed = null;
        mess.setName(s).setTime(date).setMatter(name);
        try {
            proceed = proceedingJoinPoint.proceed();
            flag = "true";
            mess.setResult(flag);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        log.info("who:{} === what:{} === when{}===result{}", s, name, new SimpleDateFormat("yyyy-MM-dd").format(date), flag);
        messService.save(mess);
        return proceed;
    }


}

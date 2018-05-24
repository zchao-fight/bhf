package cn.ccf.module.aop;

import cn.ccf.module.pojo.CheckException;
import cn.ccf.module.pojo.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerAop {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = System.currentTimeMillis();

        //临时 @colin
        Object result;
        result = pjp.proceed();
        logger.info("@author colin:"+pjp.getSignature() + " 用时: " + (System.currentTimeMillis() - startTime) + "ms");
        return result;


        //规范写法 返回统一ResultBean
/*
        ResultBean<?> result;

        try

        {
            result = (ResultBean<?>) pjp.proceed();
            logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));

        } catch (Throwable e)

        {
            result = handlerException(pjp, e);

        }

        return result;*/

    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {

        ResultBean<?> result = new ResultBean();

        // 已知异常

        if (e instanceof CheckException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);

        } else {
            logger.error(pjp.getSignature() + " error ", e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.FAIL);

            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。

        }

        return result;

    }
}
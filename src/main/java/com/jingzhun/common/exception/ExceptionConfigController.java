package com.jingzhun.common.exception;

import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by Administrator on 2019/2/28 0028.
 */

    @ControllerAdvice
    public class ExceptionConfigController {
        // 专门用来捕获和处理Controller层的空指针异常
        @ExceptionHandler(NullPointerException.class)
        public ModelAndView nullPointerExceptionHandler(NullPointerException e){
            ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
            mv.addObject("success",false);
            mv.addObject("mesg","请求发生了空指针异常，请稍后再试");
            return mv;
        }

        // 专门用来捕获和处理Controller层的运行时异常
        @ExceptionHandler(RuntimeException.class)
        public ModelAndView runtimeExceptionHandler(RuntimeException e){
            ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
            mv.addObject("success",false);
            mv.addObject("mesg","请求发生了运行时异常，请稍后再试");
            return mv;
        }

        // 专门用来捕获和处理Controller层的异常
        @ExceptionHandler(Exception.class)
        public ModelAndView exceptionHandler(Exception e){
            ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
            mv.addObject("success",false);
            mv.addObject("mesg","请求发生了异常，请稍后再试");
            return mv;
        }
    }


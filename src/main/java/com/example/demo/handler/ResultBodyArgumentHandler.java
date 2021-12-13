package com.example.demo.handler;

import com.example.demo.pojo.annotations.Ip;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义HandlerMethodArgumentResolver
 * 用于处理被@ResultBody标记的变量
 */
public class ResultBodyArgumentHandler implements HandlerMethodArgumentResolver {

    /**
     * 处理@ResultBody注解
     *
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(Ip.class);
    }

    /**
     * 这个方法的返回值作为反射处理的参数
     *
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //获取HttpServletRequest类
        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        int length = request.getContentLength();


        return  request.getRemoteAddr();
//        if (length == 0) return null;
//
//        //从inputStream中获取字节流
//        ServletInputStream inputStream = request.getInputStream();
//        byte[] bytes = new byte[length];
//        //通过工具类读取
//        IOUtils.readFully(inputStream, bytes);
//
//        //将byte[]转为javabean
//        Result o = JSON.parseObject(bytes, Result.class);
//        JSONObject jsonObject = (JSONObject) o.getData();
//        //将jsonObject转换为实际的javaBean
//        //methodParameter.getParameterType() 获取参数class
//        return jsonObject.toJavaObject(methodParameter.getParameterType());
    }
}
package com.cloud.user.controller;

import com.cloud.user.service.impl.MessageService;
import com.cloud.user.vo.BaseVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * -@description: Feign远程服务调用
 * <p>
 * -@author: xiang
 * -@create: 2019-02-17 15:11
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    private MessageService messageService;

    /**
     * 调用信息服务的手机验证码接口
     *
     * @param mobile
     * @param message
     * @return
     */
    @RequestMapping(value = "/mobile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object mobile(@RequestParam String mobile, @RequestParam String message) {
        boolean mobileMessage = messageService.mobileMessage(mobile, message);
        return new BaseVO(mobileMessage);
    }

    /**
     * 调用信息服务的邮箱验证码接口
     *
     * @param email
     * @param message
     * @return
     */
    @RequestMapping(value = "/mail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object mail(@RequestParam String email, @RequestParam String message) {
        boolean mailMessage = messageService.mailMessage(email, message);
        return new BaseVO(mailMessage);
    }
}

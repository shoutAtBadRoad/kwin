package com.kwin.db.controller;

import cc.heyjobs.ycl.sop.sdk.client.OpenClient;
import cc.heyjobs.ycl.sop.sdk.request.CommonRequest;
import cc.heyjobs.ycl.sop.sdk.response.CommonResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kwin.db.config.response.ResultStatusEnum;
import com.kwin.db.entity.Camera;
import com.kwin.db.service.CamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.kwin.db.config.response.ResultStatusEnum.BADREQUEST;

@RestController
@RequestMapping("/cam")
public class CamController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CamService camService;

    String url = "http://api.yunchuanglive.com";
    String appId = "20200921757640174552219648";
    /**
     * 开发者私钥
     */
    String privateKeyIsv = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCktb0TPj0ys6APtCnDnb5MD56FJ7eUIdTj0sgdHHYmD7xQnZVfStC1kCN6iovkaxM6BNEe8RGbSHvQw89M3WKfQHkcoeEOS+mDcH+sjaWLagSIvBZ9IY5jPvraUJIV1KS2ZpNUdA+B+Q7HzjghEGYcKi02kgUD+xiPq+mY2UmqVDRvrCytIkCacRxMnJ22QVosz/7ICXdlwyFZm1hVrUoRKl33BRXqGsVejUh26Xmfy3hCuQZDt/hdz7MvIO2FwsPRRHkhJE58zcbN+2p7VYrjcN76GRQlkytH67dZGZ/nvAO2Zw1s438X7I7QbTzm3bQw+jvqd5ym8U1mObTrnNfhAgMBAAECggEARPxdgcbKqQa03n7uEyFph7/u/ARDjoaQ/Q7Wg+Lc1Vo33Gf0HSJfwfvp8DRBHV1/gwhrchMz9Z7pROoOVDpRSTQexdBDS9KdrlCbGPGGyZqQ5ZgpryUz1vuU44VlekFC76aMxI2LxTtEZolH1wlgSyGbKEUGVsF/awVs5Hj1sqG8YSHoMFc4jcjJGBp0Ywk918jsnolRYYnScDFRhYNqNXAEm1iCivBEPTDKWWUQ3bibXJIlg2ljd64vJCqPFqDfNA1TnjENAvCcb8OB6KDQEDNT9VXEXtk56HoW6P1u+SocNKQIz3nzTkS0hxVqv03HkLn52oyWRfE4sKExA/rMwQKBgQD8LX1aR7FPNjzKkLNs/5faA8MFn1G/qHbKI11iYZMNdYN4w995poYchMkhfsp8udQt14Bta2ZpNKNQesKYdQbcTF/vj0Q2bL5M+gHbioRkuXy+4iHWrAQehiuejBEYfHKXhLMFtOZMblp9LKObilZXDNKiTwW1yuKLEAejdDsyOQKBgQCnNNpSYUS6PpQcmkZbN/dzooBFibGqadM83V0kO41yvV/A0tBGZq18GS9047OjhCV7yCA1L/WmGAG6dAmxZRUMLCp127vvBtcVxWOOSV1DJA5BpM5dhh2pcWKKT8bX9MjyvSr0vnuB12QZ3h2INfWQzgB2CnGHyA6o86BIDVUy6QKBgQDXSsLdI53l4Yku6zCz2tY6o8GI+EajmOCpnF2qk2EnOW9f1+HfiuKuUFMijIu0xjW2WWhkgi+xm+Xd3KBr5mVQCMhSzn5O9LHXKA4T74MuNwmgMZDwJHVz1dpBhpVF0WFHqFvqgFGpaQFKIqUfMpCZyvG87jgSxz53uNy8mIu9SQKBgQCV/2v7ixbEnW7xWdTT8BkkuxqnRycC4XyGlW8BGguCazCDIpuFDIeFVHKmQb7daabWrGl4TVXpco/aXE51vWBsUxKkOEMX4uMAvNrawiXQHYBMkzQt4iqp3vWvbnHLOeUrHVhzxo21pSw/qGqFzyJEjQkM28GNNYMxPZ0EBjHwQQKBgQDgwMwJTL4gT12Ly8TiTraYXEGLr4sQp9I80e7J5Iu5iRvdVqA0l0Hue9TMn3Xdj00rIXXh9a75jQteiqB7zXs+oVcxFXHXIod//9FV3sfwivPlB/2YssIRCvVjInf9KIyklVItuetu3KH+BzZZXsIy5vn95GnhP1B6hKQP96Jx9w==";
    /* 开放平台提供的公钥
     * 前往SOP-ADMIN，ISV管理--秘钥管理，生成平台提供的公私钥，然后把【平台公钥】放到这里
     */
    String publicKeyPlatform = "";

    // 声明一个就行
    OpenClient client = new OpenClient(url, appId, privateKeyIsv, publicKeyPlatform);

    /**
     *
     * @param id
     * @return com.kwin.db.config.response.ResponseResult<com.kwin.db.entity.Camera>
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 20:52
     * 根据id查询摄像头视频流地址
     */
    @GetMapping("/geturl/{id}")
    public Camera getUrl(@PathVariable("id")Integer id){
        return camService.getCam(id);
    }

    /**
     *
     * @param uid
	 * @param move
     * @return com.kwin.db.config.response.ResponseResult<java.lang.Object>
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 20:52
     * 根据设备uid与move控制摄像头转动
     */
    @GetMapping("/control/{uid}/{move}")
    public Object exeControl(@PathVariable("uid")String uid, @PathVariable("move")Integer move) {
        if(uid==null || move<0 || move >5){
            return BADREQUEST; //检测请求不正确的情况
        }
        // 创建请求对象
        CommonRequest request = new CommonRequest("camera.control.ptz");
        // 请求参数
        Map<String, Object> bizModel = new HashMap<>();
        bizModel.put("uid", uid); //测试使用的mac：SSAA-337220-ABDCB
        bizModel.put("act", move);
        bizModel.put("speed", 1);
        request.setBizModel(bizModel);
        // 发送请求
        CommonResponse response = client.execute(request);
        if (response.isSuccess()) {  //根据操作是否成功返回不同结果
            // 返回结果
            return ResultStatusEnum.OK;
        } else {
            return ResultStatusEnum.ERROR;
        }
    }

    @PostMapping("/control/{uid}/{move}")
    public void postexeControl(@PathVariable("uid")String uid,@PathVariable("move")Integer move) {
        // 创建请求对象
        CommonRequest request = new CommonRequest("camera.control.ptz");
        // 请求参数
        Map<String, Object> bizModel = new HashMap<>();
        bizModel.put("uid", uid); //SSAA-337220-ABDCB
        bizModel.put("act", move);
        bizModel.put("speed", 1);
        request.setBizModel(bizModel);
        // 发送请求
        CommonResponse response = client.execute(request);
        if (response.isSuccess()) {
            // 返回结果
            String body = response.getBody();
            JSONObject jsonObject = JSON.parseObject(body);
            System.out.println(jsonObject);
        } else {
            System.out.println("错误，subCode:" + response.getSubCode() + ", subMsg:" + response.getSubMsg());
        }
    }
}

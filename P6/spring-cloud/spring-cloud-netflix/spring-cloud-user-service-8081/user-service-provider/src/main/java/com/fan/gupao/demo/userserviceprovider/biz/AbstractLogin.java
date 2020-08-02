package com.fan.gupao.demo.userserviceprovider.biz;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.exception.BizException;
import com.fan.gupao.demo.userserviceprovider.controller.dto.AuthLoginDto;
import com.fan.gupao.demo.userserviceprovider.mapper.entitys.TbMember;
import com.fan.gupao.demo.userserviceprovider.utils.JwtGeneratorUtil;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
@Slf4j
public abstract class AbstractLogin implements Login {

    public static ConcurrentHashMap<Integer, AbstractLogin> loginMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        loginMap.put(getLoginType(), this);
    }


    @Override
    public R doLogin(AuthLoginDto authLoginDto) throws BizException {
        log.info("begin AbstractLogin.doLogin:" + authLoginDto);
        // 第一步完成验证
        validate(authLoginDto);
        TbMember tbMember = doProcessor(authLoginDto);
        Map<String, Object> payLoad = new HashMap<>();
        payLoad.put("uid", tbMember.getId());
        payLoad.put("exp", DateTime.now().plusHours(1).toDate().getTime() / 1000);
        String token = JwtGeneratorUtil.generatorToken(payLoad);
        return new R.Builder<>().setData(token).buildOk();
    }

    /**
     * 功能描述: 在子类中去声明自己的登录类型
     *
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/2 10:34
     */
    public abstract int getLoginType();

    /**
     * 功能描述: 通过子类去完成验证
     *
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/2 10:35
     */
    public abstract void validate(AuthLoginDto authLoginDto);


    /**
     * 功能描述: 登录校验
     *
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/2 10:35
     */
    public abstract TbMember doProcessor(AuthLoginDto authLoginDto);
}

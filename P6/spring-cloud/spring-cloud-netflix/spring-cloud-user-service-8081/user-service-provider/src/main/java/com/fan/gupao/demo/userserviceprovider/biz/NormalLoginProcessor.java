package com.fan.gupao.demo.userserviceprovider.biz;

import com.fan.gupao.demo.exception.BizException;
import com.fan.gupao.demo.exception.ValidException;
import com.fan.gupao.demo.userserviceprovider.controller.dto.AuthLoginDto;
import com.fan.gupao.demo.userserviceprovider.controller.enums.LoginEnum;
import com.fan.gupao.demo.userserviceprovider.mapper.entitys.TbMember;
import com.fan.gupao.demo.userserviceprovider.mapper.entitys.TbMemberExample;
import com.fan.gupao.demo.userserviceprovider.mapper.persistence.TbMemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
@Slf4j
@Service
public class NormalLoginProcessor extends AbstractLogin {

    @Autowired
    TbMemberMapper tbMemberMapper;

    @Override
    public int getLoginType() {
        return LoginEnum.NORMAL.getCode();
    }

    @Override
    public void validate(AuthLoginDto authLoginDto) {
        if (StringUtils.isBlank(authLoginDto.getUsername()) || StringUtils.isBlank(authLoginDto.getPassword())) {
            throw new ValidException("帐号或者密码不能为空");
        }
    }

    @Override
    public TbMember doProcessor(AuthLoginDto authLoginDto) {
        log.info("begin NormalLoginProcessor.doProcessor:" + authLoginDto);
        TbMemberExample example = new TbMemberExample();
        example.createCriteria().andStateEqualTo("1")
                .andUsernameEqualTo(authLoginDto.getUsername());
        List<TbMember> members = tbMemberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(members)) {
            throw new BizException("用户名或者密码错误");
        }
        if (!members.get(0).getPassword().equals(authLoginDto.getPassword())) {
            throw new BizException("用户名或者密码错误");

        }
        return members.get(0);
    }
}

package com.fan.gupao.demo.userserviceprovider.feign;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.clients.IUserAuthFeignClient;
import com.fan.gupao.demo.exception.ValidException;
import com.fan.gupao.demo.userserviceprovider.utils.JwtGeneratorUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
@RestController
public class UserAuthFeignClient implements IUserAuthFeignClient {

    @Override
    public R<String> validToken(String token) {
        if (StringUtils.isBlank(token)) {
            throw new ValidException("token为空");
        }
        try {


            Claims claims = JwtGeneratorUtil.parseToken(token);
            return new R.Builder<>().setData(claims.get("uid").toString()).buildOk();
        } catch (ExpiredJwtException e) {
            return new R.Builder<>().buildCustomize("token已过期");
        } catch (SignatureException e) {
            return new R.Builder<>().buildCustomize("签名校验失败");
        }
    }
}

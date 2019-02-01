package com.oauth.service;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

/**
 * @author ：zhangqiang
 * @create ：2019-01-30 11:20
 **/
public interface OauthTokenService {

	OAuth2Authentication readAccessToken(String Authorization);
}

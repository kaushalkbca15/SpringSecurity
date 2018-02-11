package com.fcb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fcb.security.FCBSpringSecurityConfig;

@Configuration
@Import(value=FCBSpringSecurityConfig.class)
public class RootConfig {

}

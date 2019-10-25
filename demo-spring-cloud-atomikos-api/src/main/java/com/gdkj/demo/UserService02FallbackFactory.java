package com.gdkj.demo;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserService02FallbackFactory  implements FallbackFactory<UserService02> {
    public UserService02 create(Throwable throwable) {
        return new UserService02() {
            public int insert(String name, Integer age) {
                return -1001;
            }
        };
    }
}

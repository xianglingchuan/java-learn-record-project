package com.ioc.beanannotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) //list列表排序
@Component
public class BeanTwo implements BeanInterface {

}

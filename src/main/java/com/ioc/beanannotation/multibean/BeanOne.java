package com.ioc.beanannotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2) //list列表排序
@Component
public class BeanOne implements BeanInterface {

}

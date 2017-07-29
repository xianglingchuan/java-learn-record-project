package com.aop.api.introduction;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class LockMixinAdvisor extends DefaultIntroductionAdvisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LockMixinAdvisor(Advice advice) {
		super(new LockMixin(),LockInterface.class);
	}

}

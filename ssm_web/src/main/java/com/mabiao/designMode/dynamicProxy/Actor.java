package com.mabiao.designMode.dynamicProxy;

/**
 * @author created by mabiao on 2018/8/3
 */
public class Actor implements IActor {
	@Override
	public void basicActor(int money) {
		System.out.println("表演挣了" + money);
	}

	@Override
	public void dangerActor(int money) {
		System.out.println("危险表演挣了" + money);
	}
}

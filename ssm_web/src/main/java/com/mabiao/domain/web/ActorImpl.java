package com.mabiao.domain.web;

/**
 * @author created by mabiao on 2018/6/13
 */
public class ActorImpl implements Actor {

	@Override
	public void act(String name) {
		System.out.println("act:" + name);
	}
}

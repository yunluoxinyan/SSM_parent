package com.mabiao.designMode.observerMode;

import java.util.Observable;
import java.util.Observer;

/**
 * @author created by mabiao on 2018/8/3
 */
public class JDObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		String newProduct = (String) arg;
		System.out.println("新产品" + newProduct +"同步至京东商城");
	}
}

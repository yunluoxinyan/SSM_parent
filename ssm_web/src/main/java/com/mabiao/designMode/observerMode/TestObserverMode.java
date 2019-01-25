package com.mabiao.designMode.observerMode;

/**
 * @author created by mabiao on 2018/8/3
 */
public class TestObserverMode {

	public static void main(String[] args) {
		ProductList productList = ProductList.getInstance();
		JDObserver jdObserver = new JDObserver();
		TBObserver tbObserver = new TBObserver();
		productList.addProductListObserver(jdObserver);
		productList.addProductListObserver(tbObserver);
		productList.addProduct("智能音箱");
	}
}

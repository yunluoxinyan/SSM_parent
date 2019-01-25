package com.mabiao.designMode.observerMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author created by mabiao on 2018/8/3
 */
public class ProductList extends Observable {

	/**
	 * 	产品列表
	 */
	private List<String> productList = null;

	/**
	 * 	产品类唯一实例
	 */
	private static ProductList instance;

	private ProductList(){}

	/**
	 * 获取产品列表唯一实例
	 */
	public static ProductList getInstance() {
		if(instance == null) {
			instance = new ProductList();
			instance.productList = new ArrayList<>();
		}
		return instance;
	}

	/**
	 * 增加观察者
	 * @param observer
	 */
	public void addProductListObserver(Observer observer) {
		this.addObserver(observer);
	}

	public void addProduct(String newProduct) {
		productList.add(newProduct);
		System.out.println("产品列表新增商品：" + newProduct);
		this.setChanged();
		this.notifyObservers(newProduct);
	}
}

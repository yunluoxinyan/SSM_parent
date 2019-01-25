package com.mabiao.dispatch;

/**
 * @author created by mabiao on 2018/7/27
 */
public class StaticDispatch {
	static abstract class human{
	}

	static class man extends human{
	}

	static class woman extends human{
	}

	public void sayhello(human guy){
		System.out.println("hello guy");
	}
	public void sayhello(man guy){
		System.out.println("hello gentleMan");
	}
	public void sayhello(woman guy){
		System.out.println("hello lady");
	}

	public static void main(String[] args) {
		human man = new man();
		human woman = new woman();
		StaticDispatch sd = new StaticDispatch();
		sd.sayhello(man);
		sd.sayhello(woman);
	}

	/**
	 * 静态分派  典型应用：方法重载    根据变量的静态类型决定重载的方法
	 * 此案例中  静态类型为human  动态类型为man  woman
	 */
}

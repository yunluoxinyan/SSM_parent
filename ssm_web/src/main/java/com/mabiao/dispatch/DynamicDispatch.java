package com.mabiao.dispatch;

/**
 * @author created by mabiao on 2018/7/30
 */
public class DynamicDispatch {

	static abstract class Human{
		protected abstract void sayHello();
	}

	static class Man extends Human {

		@Override
		protected void sayHello() {
			System.out.println("man sayHello");
		}
	}

	static class Woman extends Human {

		@Override
		protected void sayHello() {
			System.out.println("woman sayHello");
		}
	}

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		man.sayHello();
		woman.sayHello();
		man = new Woman();
		man.sayHello();
	}

	/**
	 * javap 输出代码的字节码
	 *动态分派  典型应用：方法重写 在运行期根据实际类型确定方法执行版本
	 * 						在执行invokevirtual指令把常量池中的类方法符号引用解析到不同的直接应用上
	 */
}

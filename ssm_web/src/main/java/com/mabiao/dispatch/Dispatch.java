package com.mabiao.dispatch;

/**
 * @author created by mabiao on 2018/7/30
 */
public class Dispatch {
	static class QQ{}
	static class _360{}

	public static class father{
		public void choice(QQ arg) {
			System.out.println("father choice qq");
		}

		public void choice(_360 arg){
			System.out.println("father choice 360");
		}
	}

	public static class son extends father{
		@Override
		public void choice(QQ arg) {
			System.out.println("son choice qq");
		}

		@Override
		public void choice(_360 arg){
			System.out.println("son choice 360");
		}
	}

	public static void main(String[] args) {
		father f = new father();
		father s = new son();
		f.choice(new QQ());
		s.choice(new _360());
	}

	/**
	 * 父亲选择qq 儿子选择360
	 * 编译期 静态多分派  根据静态类型是father还是son  方法参数是qq还是360  这两个宗量进行    确定
	 * 运行期 动态单分派  已经确定了使 用choice(QQ) 根据实际类型是father还是son 这一个宗量作为选择依据
	 */
}

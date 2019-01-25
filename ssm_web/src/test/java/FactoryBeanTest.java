import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mabiao.controller.DateFoo;
import com.mabiao.controller.NextDayDateFactoryBean;
import com.mabiao.domain.web.Actor;
import com.mabiao.domain.web.ActorImpl;
import com.mabiao.domain.web.PageQuery;
import com.mabiao.util.URLEncodeUtil;
import com.mabiao.validate.FormValidate;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author created by mabiao on 2018/6/6
 */
public class FactoryBeanTest {

	@Test
	public void test1() throws Exception{
		ApplicationContext container = new ClassPathXmlApplicationContext("spring/springmvc.xml");
		Object nextDayDate =  container.getBean("nextDayDate");
		assertTrue(nextDayDate instanceof DateTime);
		Object factoryBean = container.getBean("&nextDayDate");
		assertTrue(factoryBean instanceof FactoryBean);
		assertTrue(factoryBean instanceof NextDayDateFactoryBean);
		Object factoryValue = ((FactoryBean)factoryBean).getObject();
		assertTrue(factoryValue instanceof DateTime);
		//测试两次返回的时间是否一致
		assertNotSame(nextDayDate, factoryValue);
		assertEquals(((DateTime)nextDayDate).getDayOfYear(),((DateTime)factoryValue).getDayOfYear());
	}

	@Test
	public void test2(){
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy/MM/dd");
		Date date = dateTimeFormatter.parseDateTime("2019/04/09").toDate();
		System.out.println(date);
	}

	@Test
	public void test3(){
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time);
		java.time.format.DateTimeFormatter df = java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String str = df.format(time);
		System.out.println(str);
	}

	@Test
	public void test4(){
		ApplicationContext container = new ClassPathXmlApplicationContext("spring/springmvc.xml");
		DateFoo dateTest = (DateFoo) container.getBean("dateFoo");
		System.out.println(dateTest.getDate());
	}

	@Test
	public void test5(){
		try {
			String url = "http://www.jd.com/index.html?username=tom&password=123";
			URL url1 = new URL(url);
			System.out.println(url1.getPath().toLowerCase());
			System.out.println(url1.getQuery());
			System.out.println(url1.getHost());
			byte[] bytes = url1.getQuery().getBytes("utf-8");
			for (byte b : bytes) {
				System.out.println(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test6(){
		ActorImpl ai = new ActorImpl();
		Actor a = (Actor)Proxy.newProxyInstance(ai.getClass().getClassLoader(), new Class[]{Actor.class}, new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					String name = (String) args[0];
					name += "&jerry";
					return method.invoke(ai,name);
				}
			});
		a.act("tom");
	}

	@Test
	public void test7(){
		String a = null;
		Assert.assertNotNull("不能为null",a);
	}

	@Test
	public void test(){
		String keyWords = "ids,,805619;;ShopCategoryIDS,,9069125";
		keyWords = URLEncodeUtil.encode(keyWords, "GBK");
		System.out.println(keyWords);
	}

	@Test
	public void test8(){
		int i = Integer.parseInt(null);
		System.out.println(i);
	}

	@Test
	public void test9() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
		String tsStr;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		tsStr = sdf.format(ts);
		System.out.println(tsStr);
	}

	@Test
	public void test10() {
		LocalDate today1 = LocalDate.now();
		LocalDate today2 = LocalDate.now();
		System.out.println(today1.isBefore(today2));
	}

	@Test
	public void test11() {
		PageQuery p = new PageQuery();
		p.setPagesize(1);
		p.setNum("123");
		System.out.println(p);
	}

	@Test
	public void test12() {
		String str = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]";
		// 首先把字符串转成 JSONArray  对象
		JSONArray json = JSONArray.parseArray(str);
		if(json.size()>0){
			for(int i=0;i<json.size();i++){
				// 遍历 jsonarray 数组，把每一个对象转成 json 对象
				JSONObject job = json.getJSONObject(i);
// 得到 每个对象中的属性值
				System.out.println(job.get("name")+"=") ;
			}
		}
	}

	@Test
	public void test13(){
		Object[] old = {};
		int oldLength = old.length;
		int newCapacity = oldLength + (oldLength >> 1);
		System.out.println(newCapacity);
	}

	@Test
	public void test14(){
		try {
			File file = ResourceUtils.getFile("classpath:classify-mapping.xml");
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
			Element foo;
			for (Iterator i = root.elementIterator("VALUE"); i.hasNext();) {
				foo = (Element) i.next();
				System.out.print("车牌号码:" + foo.elementText("NO"));
				System.out.println("车主地址:" + foo.elementText("ADDR"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void intern(){

		String b = new String("abc") + new String("1");
		b.intern();
		String a= "abc1";
		System.out.println(a==b);

		String b1 = new String("abc");
		b1.intern();
		String a1= "abc";
		System.out.println(a1==b1);
	}

	@Test
	public void intern1(){

		String str = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str.intern()==str);

		String str1 = new StringBuilder("pang").append("ge").toString();
		System.out.println(str1.intern()==str1);

		String str2 = new StringBuilder("22").append("11").toString();
		System.out.println(str2.intern()==str2);

		String str3 = new StringBuilder("11").append("22").toString();
		System.out.println(str3.intern()==str3);
	}

	@Test
	public void intern2(){

//		String str = new String("pang") + new String("ge");
//		//System.out.println(str.intern()==str);
//		str.intern();
//		System.out.println(str == "pangge");
//
//		String str1 = new String("tr") + new String("ue");
//		//System.out.println(str1.intern()==str1);
//		str1.intern();
//		System.out.println(str1 == "true");

		byte[] trues = new String("true").getBytes();
		for (byte b : trues) {
			System.out.println(b);
		}
	}

	@Test
	public void cglib(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(FactoryBeanTest.class);
		enhancer.setUseCache(false);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				return methodProxy.invokeSuper(o,objects);
			}
		});
		enhancer.create();
	}

	@Test
	public void classGetName(){
		String str1 = FormValidate.class.getName();
		String str2 = FormValidate.class.getSimpleName();
		System.out.println(str1 + "---" + str2);
	}

	@Test
	public void test23(){
		Date date = new Date(1534780800000L);
		System.out.println(date);
	}
}

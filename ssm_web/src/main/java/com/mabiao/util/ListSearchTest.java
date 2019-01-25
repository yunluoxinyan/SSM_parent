package com.mabiao.util;

import com.alibaba.fastjson.JSONArray;

import java.util.Map;

/**
 * @author created by mabiao on 2018/10/9
 */
public class ListSearchTest {
	public static void main(String[] args) {
		String str = "{\"items\":null,\"attrs\":null,\"total_count\":82,\"summary\":{\"page\":{\"PageCount\":9,\"" +
				"PageIndex\":1,\"PageSize\":10},\"real_count\":82,\"filt_type\":[]},\"topic\":{\"id\":46628,\"name\":" +
				"\"DL-全部上衣\",\"type\":1,\"cat1\":1672,\"cat2\":2615,\"cat3\":9188,\"status\":1,\"adv_id\":0,\"" +
				"top_image\":\"\",\"cat1_name\":\"礼品箱包\",\"cat2_name\":\"奢侈品\",\"cat3_name\":\"服饰\",\"topic_type" +
				"\":11,\"aggregation\":0,\"page_temiplate\":\"gSquare\",\"sort_mode\":1,\"source\":\"\",\"mobile_image\"" +
				":\"//img30.360buyimg.com/phoenix/jfs/t27454/122/322256403/97828/b3950bec/5b8e3091Nc12306b9.jpg\",\"" +
				"mobile_color\":\"#ffffff\",\"related_topics\":\"\",\"pc_relation\":[],\"mobile_relation\":[],\"" +
				"mobile_label\":\"\",\"share_title\":\"DEREK LAM京东自营专区\",\"share_desc\":\"来自纽约的时尚品牌，" +
				"DEREK LAM为奢侈品注入时髦现代感，恰到好处的简约风格及贴心入微的细节设计，迅速成为纽约时尚圈的焦点。\"," +
				"\"share_pic\":\"//img30.360buyimg.com/phoenix/jfs/t25093/48/1213110287/4553/a908cdb2/5b8e308dN219a2b4c.png" +
				"\",\"show_comment\":0,\"show_style\":1,\"topic_nav\":null},\"brands\":null,\"brandsLen\":0,\"price\":null}";

		Map resObj = JsonUtil.toObject(str, Map.class);

		JSONArray items = (JSONArray) resObj.get("items");

		System.out.println(items == null);
		System.out.println("null".equals(items));
	}
}

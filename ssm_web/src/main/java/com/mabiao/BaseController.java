package com.mabiao;

import java.util.*;

/**
 * @program: SSM_parent
 * @description: 抽象类
 * @author: mabiao
 * @create: 2019-01-15 10:47
 **/
public abstract class BaseController {
    Set<String> list = new HashSet<>(Arrays.asList("mabiao8", "wangguanwen1", "guowei43", "houlei8", "bjwf", "majun12", "shenli8", "zhangenke",
            "bjnijianyou", "wangyue102", "caozhifei", "bjlihongbo","jiangshijie5","zhouwenxuan1","wangtian122","duweijia","mabowen2"));

    public void print() {
        System.out.println(list);
    }
}

/**
 * Project Name:umale
 * File Name:ListSplitUtil
 * Package Name:com.citycloud.umale.esi.service.impl.commons
 * Date: 2019/5/17 13:30
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.service.impl.commons;/**
 * @author zq
 * @date 2019/5/17
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author bridge
 * @className ListSplitUtil
 * @description
 * @date 2019/5/17 13:30
 * @since JDK 1.8
 */
public class ListSplitUtil {
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remaider = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remaider > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        List<List<Integer>> lists=averageAssign(integers, 6);
        System.out.println(lists);
    }

}

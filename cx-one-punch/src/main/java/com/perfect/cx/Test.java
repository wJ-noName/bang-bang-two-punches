package com.perfect.cx;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.hash.Hash;
import cn.hutool.core.util.ObjectUtil;
import com.perfect.cx.utils.DateUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(7);
        ArrayList<Integer> objectss = new ArrayList<>();



        Collection<Integer> intersection = CollectionUtil.intersection(objects, objectss);
        Set<Integer> integers = CollectionUtil.intersectionDistinct(objects, objectss);
        Collection<Integer> subtract = CollectionUtil.subtract(objectss, objects);
        Set<Integer> integers1 = new HashSet<>(subtract);
        System.out.println(intersection);
        System.out.println(integers);
        System.out.println(subtract);
        System.out.println(integers1);
    }

}

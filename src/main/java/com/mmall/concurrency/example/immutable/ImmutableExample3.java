package com.mmall.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.mmall.concurrency.annotation.ThreadSafe;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {
    //ImmutableList
    private final static List<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap<Integer,Integer> map2 = ImmutableMap.<Integer,Integer>builder().put(1,2).put(2,3)
            .put(3,4).build();
    public static void main(String[] args) {
        //list.add(4);
        map2.get(3);
    }
}

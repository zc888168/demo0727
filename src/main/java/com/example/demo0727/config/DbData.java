package com.example.demo0727.config;

import com.example.demo0727.vo.StudentVo;
import com.google.common.collect.Maps;

import java.util.Map;

public class DbData {
    public final static  Map<String, StudentVo> studentMap = Maps.newHashMapWithExpectedSize(50);
}

package com.example.demo0727.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo0727.config.DbData;
import com.example.demo0727.vo.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/student")
@Api(value = "student")
public class DemoController {

    @PostMapping("/addition")
    @ApiOperation(value = "添加一个学生")
    public JSONObject add(@Valid @RequestBody StudentVo studentVo){
        JSONObject object = new JSONObject();
        if(DbData.studentMap.containsKey(studentVo.getName())){
            object.put("code", "0011");
            object.put("message", "用户已经存在，请勿重复添加");
        } else {
            DbData.studentMap.put(studentVo.getName(), studentVo);
            object.put("code", "000");
            object.put("message", "用户添加成功");
        }
        return object;
    }
    @PostMapping("/removement")
    @ApiOperation(value = "删除一个学生")
    public JSONObject del(@RequestParam(value = "name",required = true)String name){
        JSONObject object = new JSONObject();
      if(!DbData.studentMap.containsKey(name)){
          object.put("code", "0012001");
          object.put("message", "用户不存在");
          return object;
      } else {
          StudentVo studentVo =  DbData.studentMap.remove(name);
          if(studentVo == null){
              object.put("code", "0012002");
              object.put("message", "删除用户异常");
              return object;
          }else {
              object.put("code", "0010");
              object.put("message", "成功删除用户");
              return object;
          }
      }

    }
    @PostMapping("/modification")
    @ApiOperation("修改用户")
    public JSONObject update(@Valid @RequestBody StudentVo studentVo){
        JSONObject object = new JSONObject();
        if(!DbData.studentMap.containsKey(studentVo.getName())){
            //不存在就添加
            DbData.studentMap.put(studentVo.getName(), studentVo);
        } else {
            //存在就覆盖
            DbData.studentMap.put(studentVo.getName(), studentVo);
        }
        object.put("code", "000");
        object.put("message", "成功修改用户");
        return object;
    }
    @GetMapping("/query")
    @ApiOperation("查询用户")
    public JSONObject query(@Valid @RequestParam(name = "name",required = true)String name){
        JSONObject object = new JSONObject();
        if(!DbData.studentMap.containsKey(name)){
            object.put("code", "0014001");
            object.put("message", "用户不存在");
            return object;
        } else {
            StudentVo vo = DbData.studentMap.get(name);
            object.put("code", "000");
            object.put("vo", vo);
            return object;
        }

    }
}

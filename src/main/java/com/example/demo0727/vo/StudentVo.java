package com.example.demo0727.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {
    @NotNull(message = "年龄不能为空")
    @Min(value = 1,message = "最小年龄不能小于1")
    @Max(value = 200,message = "最大年龄不能大于200")
    private int age;
    @NotEmpty(message = "姓名不能为空")
    private String name;


}

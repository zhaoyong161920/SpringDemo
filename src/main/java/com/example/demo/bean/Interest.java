package com.example.demo.bean;

import lombok.*;

@Data
@ToString
@AllArgsConstructor // 全参构造器
@NoArgsConstructor  // 无参构造器
@EqualsAndHashCode
public class Interest {
    int id;
    String iName;
}

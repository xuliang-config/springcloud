package com.atguigu.springcloudalibab.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    public int id;
    public int buyId;
    public int countNum;
    public int status;
}

package com.hushunjian.plan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    private String id;

    private String name;

    private String parentId;

    private String outLine;

    private int orderNum;

}

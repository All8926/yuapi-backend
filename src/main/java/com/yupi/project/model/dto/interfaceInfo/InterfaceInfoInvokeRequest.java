package com.yupi.project.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 测试接口请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    /**
     * id
     */
    private long id;


    /**
     * 请求参数
     */
    private String requestParams;


    private static final long serialVersionUID = 1L;
}
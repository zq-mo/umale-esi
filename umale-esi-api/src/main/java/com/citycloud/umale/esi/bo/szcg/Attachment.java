/**
 * Project Name:umale
 * File Name:Attachment
 * Package Name:com.citycloud.umale.esi.bo.szcg
 * Date: 2019/6/18 10:04
 * Copyright (c) 2018, CCI All Rights Reserved.
 */
package com.citycloud.umale.esi.bo.szcg;/**
 * @author zq
 * @date 2019/6/18
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author bridge
 * @version
 * @className Attachment
 * @description
 * @date 2019/6/18 10:04
 * @since JDK 1.8
 */
@Data
public class Attachment implements Serializable {

    private static final long serialVersionUID = -7342287712282036194L;

    private String name;
    private String url;
}

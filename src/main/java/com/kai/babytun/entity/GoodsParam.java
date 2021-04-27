package com.kai.babytun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_goods_param")
public class GoodsParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gp_id", type = IdType.AUTO)
    private Integer gpId;

    private String gpParamName;

    private String gpParamValue;

    private Integer goodsId;

    private Integer gpOrder;


}

package com.kai.babytun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

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
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Long goodsId;

    /**
     * 商品名称
     */
    private String title;

    /**
     * 子标题
     */
    private String subTitle;

    /**
     * 原价
     */
    private Float originalCost;

    /**
     * 折后价
     */
    private Float currentPrice;

    /**
     * 折扣(0~1)
     */
    private Float discount;

    /**
     * 是否包邮
     */
    private Integer isFreeDelivery;

    private Integer categoryId;

    private Date lastUpdateTime;


}

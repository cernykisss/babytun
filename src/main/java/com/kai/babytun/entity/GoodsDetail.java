package com.kai.babytun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_goods_detail")
public class GoodsDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gd_id", type = IdType.AUTO)
    private Integer gdId;

    private Integer goodsId;

    private String gdPicUrl;

    private Integer gdOrder;


}

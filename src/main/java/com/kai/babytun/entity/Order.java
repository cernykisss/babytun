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
 * @since 2021-05-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单业务编号
     */
    private String orderNo;

    /**
     * 0已创建 1已支付 2已发货 3已收货 4已评价 
     */
    private Integer orderStatus;

    private String userId;

    private String recvName;

    private String recvAddress;

    private String recvMobile;

    /**
     * 邮费

     */
    private Float postage;

    private Float amount;

    private Date createTime;


}

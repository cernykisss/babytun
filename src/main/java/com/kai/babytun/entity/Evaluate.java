package com.kai.babytun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("t_evaluate")
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "evaluate_id", type = IdType.AUTO)
    private Long evaluateId;

    private String content;

    /**
     * 5
     */
    private Integer stars;

    private Date createTime;

    /**
     * 0
     */
    private Long goodsId;


}

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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("t_goods_cover")
public class GoodsCover implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gc_id", type = IdType.AUTO)
    private Integer gcId;

    private Integer goodsId;

    private String gcPicUrl;

    private String gcThumbUrl;

    private Integer gcOrder;


}

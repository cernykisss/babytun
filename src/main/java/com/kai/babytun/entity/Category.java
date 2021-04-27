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
@TableName("t_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品分类
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 上级分类
     */
    private String parentId;

    /**
     * 级别
     */
    private Integer categoryLevel;

    /**
     * 排序
     */
    private Integer categoryOrder;


}

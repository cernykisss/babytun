package com.kai.babytun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.babytun.entity.Category;
import com.kai.babytun.mapper.CategoryMapper;
import com.kai.babytun.service.ICategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}

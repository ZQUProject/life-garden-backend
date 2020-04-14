package com.garden.life.provider.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garden.life.commons.domain.Book;
import com.garden.life.commons.mapper.BookMapper;
import com.garden.life.commons.service.BookService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图书信息表 服务实现类
 * </p>
 *
 * @author RunningSnail
 * @since 2020-04-12
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}

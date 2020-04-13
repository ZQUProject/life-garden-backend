package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文件收集详情表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("collection_file_detail")
public class CollectionFileDetail implements Serializable {
    private Long fileId;
    private Long userId;
    private String nickname;
    private Date createTime;
}

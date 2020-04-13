package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 权限信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("permission")
public class Permission implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer parentId;
    private String alias;
    private Date createDate;
}

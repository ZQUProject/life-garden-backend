package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 抢票信息表
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("ticket_record")
public class TicketRecord implements Serializable {
    private Long ticketId;
    private Long userId;
    private Date createTime;
}

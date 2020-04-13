package com.garden.life.commons.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 * @author RunningSnail
 * @date  2020-04-12
 */
@Data
@TableName("faculty_class")
public class FacultyClass implements Serializable {
    private Integer classId;
    private Integer facultyId;
}

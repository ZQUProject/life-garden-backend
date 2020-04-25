package com.garden.life.commons.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.garden.life.commons.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MenuDTO {
    private Integer id;
    private String name;
    private Integer sort;
    private String component;
    private Integer parentId;
    private String path;
    private Date createTime;
    private List<MenuDTO> children;
    @JsonIgnore
    public static MenuDTO toDTO(Menu menu, List<MenuDTO> children) {
        return new MenuDTO(menu.getId(), menu.getName(), menu.getSort(), menu.getComponent(),
                menu.getParentId(), menu.getPath(), menu.getCreateTime(), children);
    }
}

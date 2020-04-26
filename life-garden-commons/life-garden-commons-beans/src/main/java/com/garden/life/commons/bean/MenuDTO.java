package com.garden.life.commons.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.garden.life.commons.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MenuDTO {
    private Integer id;
    @NotEmpty(message="菜单名不能为空")
    private String name;
    @NotNull(message = "菜单序号不能为空")
    private Integer sort;
    @NotEmpty(message="菜单组件不允许空")
    private String component;
    @NotNull(message="菜单父组件不能为空")
    private Integer parentId;
    @NotEmpty(message="菜单路径不能为空")
    private String path;
    private Date createTime;
    private List<MenuDTO> children;
    @JsonIgnore
    public static MenuDTO toDTO(Menu menu, List<MenuDTO> children) {
        return new MenuDTO(menu.getId(), menu.getName(), menu.getSort(), menu.getComponent(),
                menu.getParentId(), menu.getPath(), menu.getCreateTime(), children);
    }
}

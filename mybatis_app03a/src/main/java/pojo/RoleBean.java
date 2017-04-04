package pojo;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by 范培忠 on 2017/3/19.
 */
@Alias(value = "role")
public class RoleBean {
    private Integer id;
    private String roleName;
    private Date createDate;
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

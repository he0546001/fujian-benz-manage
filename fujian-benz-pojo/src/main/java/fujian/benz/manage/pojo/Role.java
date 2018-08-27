package fujian.benz.manage.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Role {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select replace(newid(), '-', '')")    
	private String id;
    private String name;
    private String code;
    private Date createTime;

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", code=" + code  + ", createTime="
                + createTime +  "]";
    }
    
    
}

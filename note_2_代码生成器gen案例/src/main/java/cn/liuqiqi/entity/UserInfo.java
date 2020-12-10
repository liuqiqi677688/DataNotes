package cn.liuqiqi.entity;

import java.util.Date;

/**
 * 用户信息表
 */
public class UserInfo {
	/** 自增主键 */
	private Integer id;
	/** t_user外键 */
	private Integer userId;
	/** 城市 */
	private String city;
	/** 街道 */
	private String address;
	/** 类型 */
	private String status;
	/** 添加时间 */
	private Date createTime;
	private Date updateTime;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        UserInfo that = (UserInfo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "UserInfo{" +
				"id=" + id +
						",userId='" + userId + "'" + 
						",city='" + city + "'" + 
						",address='" + address + "'" + 
						",status='" + status + "'" + 
						",createTime='" + createTime + "'" + 
						",updateTime='" + updateTime + "'" + 
		                '}';
    }
	
}
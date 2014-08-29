package et.common.demo;

import java.util.List;

import javax.ws.rs.FormParam;

import et.common.vo.base.SuperVO;

public class UserVO extends SuperVO{

	private static final long serialVersionUID = 3723922619500169848L;

	@FormParam("userid")
	private String userid;
	
	@FormParam("usercode")
	private String usercode;
	
	@FormParam("username")
	private String username;
	
	@FormParam("sex")
	private Integer sex;
	
	@FormParam("flag")
	private Integer flag;

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer status) {
		this.flag = status;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public List<String> getForeignRelation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPKFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParentPKFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package et.common.demo;

import java.util.List;

import et.common.vo.base.SuperVO;

public class UserVO extends SuperVO{

	private static final long serialVersionUID = 3723922619500169848L;
	
	private String userid;	
	
	private String usercode;	
	
	private String username;	
	
	private Integer sex;	
	
	/**是否离职：0为在职，1为离职*/
	private Integer flag=0;

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
		return "userid";
	}

	@Override
	public String getParentPKFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {		
		return "demo_user";
	}	
}
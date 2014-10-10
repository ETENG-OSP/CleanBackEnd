package et.common.demo;

import java.util.concurrent.ConcurrentHashMap;


/** 内存模拟数据库操作
 * @author huangjx
 *
 */
public class UserDMO {
	
	//MAP内存
	public static ConcurrentHashMap<String,UserVO> MAP=new ConcurrentHashMap<String,UserVO>();
	
	public UserDMO(){
		
	}
	
	/**插入新用户
	 * @param vo
	 */
	public void insert(UserVO vo){
		UserDMO.MAP.put(vo.getPrimaryKey(), vo);
	}
	
	/**离职用户
	 * @param userid
	 */
	public void resign(String userid){
		UserVO vo=UserDMO.MAP.get(userid);
		if(vo!=null && vo.getFlag()==0){
			vo.setFlag(1);			
		}
		
	}
	
	/** 查询所有用户
	 * @return
	 */
	public UserVO[] queryAll(){
		UserVO[] vos=new UserVO[UserDMO.MAP.values().size()];
		UserDMO.MAP.values().toArray(vos);
		return vos;		
	}
}
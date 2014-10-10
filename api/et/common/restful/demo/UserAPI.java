package et.common.restful.demo;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jboss.resteasy.annotations.cache.NoCache;

import et.common.demo.UserDMO;
import et.common.demo.UserVO;
import et.common.restful.ARestModule;
import et.common.restful.ResponseBuilder;
import et.common.util.JSONUtility;

@Path(value = "api/user")
@Produces("application/json;charset=UTF-8")
@NoCache
public class UserAPI extends ARestModule {	

	public UserAPI() {
		super();
	}

	@POST
	@Path(value = "")
	public Response onAdd(String json) {
		try {
			JSONObject jobj = JSONObject.fromObject(json);
			UserVO uvo = (UserVO) JSONUtility.getBeanFromJSONObject(jobj,
					UserVO.class.getName());
			
			log.info("插入一个新用户：" + uvo.getUsername());
			uvo.setUserid(UUID.randomUUID().toString());
			new UserDMO().insert(uvo);
			//insertUser();
			
			JSONObject jo = new JSONObject();
			jo.put("message", "保存成功");
			jo.put("id", uvo.getUserid());			
			log.info(jo.toString());
			//throw new BusinessException("hello");
			return ResponseBuilder.success(jo.toString());
		} catch (Exception e) {
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("message", e.getMessage());
			return ResponseBuilder.error(jo.toString());
		}
	}

	@POST
	@Path(value = "/resign")
	public Response onResign(String json) {
		try {
			JSONObject jobj = JSONObject.fromObject(json);
			
			String userid=jobj.getString("id");
			log.info("用户离职，id：" +userid );
			new UserDMO().resign(userid);			
			
			JSONObject jo = new JSONObject();
			jo.put("message", "离职成功");
			return ResponseBuilder.success(jo.toString());
		} catch (Exception e) {
			JSONObject jo = new JSONObject();
			jo.put("message", e.getMessage());
			return ResponseBuilder.error(jo.toString());
		}
	}
	
	@GET
	@Path(value = "")
	public Response onQuery() {
		try {
			UserVO[] vos=new UserDMO().queryAll();
			JSONArray jobj = JSONArray.fromObject(vos,JSONUtility.configJson());		
						
			log.info(jobj.toString());		
			return ResponseBuilder.success(jobj.toString());
		} catch (Exception e) {
			JSONObject jo = new JSONObject();
			jo.put("message", e.getMessage());
			return ResponseBuilder.error(jo.toString());
		}		
	}
	
	/*private void insertUser() throws Exception{
		UserVO vo = new UserVO();
		vo.setUsername("qlb");
		vo.setFlag(1);
		
		//new SuperDMO("etframework").insert(vo);
		new SuperDMO().insert(vo);
		
	}*/ 
}
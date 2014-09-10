package et.common.restful.demo;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;
import et.common.bs.industry.SuperDMO;
import et.common.demo.UserVO;
import et.common.restful.ARestModule;
import et.common.restful.ResponseBuilder;
import et.common.util.JSONUtility;

@Path(value = "api/user")
@Produces("application/json;charset=UTF-8")
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

			// 模拟数据库操作
			uvo.setUserid("newuserid");

			log.info("插入一个新用户：" + uvo.getUsername());
			JSONObject jo = new JSONObject();
			jo.put("message", "保存成功");
			jo.put("id", uvo.getUserid());
			insertUser();
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
			// 模拟数据库操作
			log.info("用户离职，id：" + jobj.getString("id"));
			JSONObject jo = new JSONObject();
			jo.put("message", "离职成功");
			return ResponseBuilder.success(jo.toString());
		} catch (Exception e) {
			JSONObject jo = new JSONObject();
			jo.put("message", e.getMessage());
			return ResponseBuilder.error(jo.toString());
		}
	}
	
	private void insertUser() throws Exception{
		UserVO vo = new UserVO();
		vo.setUsername("qlb");
		vo.setFlag(1);
		
		new SuperDMO("etframework").insert(vo);
		
	}
}
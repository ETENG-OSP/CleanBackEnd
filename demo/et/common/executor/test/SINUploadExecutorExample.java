package et.common.executor.test;

import java.io.File;
import java.util.HashMap;

import et.common.executor.UploadExecutor;
import et.common.vo.itf.InterfaceDefVO;

/**
 * 上传接口处理器范例
 * FTP处理范例
 * 
 * @author hjx
 * @since 2010-11-10
 */
public class SINUploadExecutorExample extends UploadExecutor {

	public SINUploadExecutorExample(InterfaceDefVO defVO) {
		super(defVO);
	}

	public String run(File file,HashMap<String,String> map) throws Exception {		
		System.out.println(map.toString());
		//ArrayList<String> dowfiles=downloadFile(null,"xml", true);
		//ArrayList<String> upfiles=uploadFile(null,"properties", true);
		log.error("处理文件："+file.getName());
		System.out.println(file.getName());
		//throw new BusinessException("处理文件："+file.getName()+"出错");
		return file.getPath();
	}

	@Override
	protected void afterRun() throws Exception {
		// TODO 自动生成方法存根
	}

	@Override
	protected void beforeRun() throws Exception {
		// TODO 自动生成方法存根
	}
}
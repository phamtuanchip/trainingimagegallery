package training.imagegallery.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class BytesResult  implements Result{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(ActionInvocation inovacation) throws Exception {
		// TODO Auto-generated method stub
		String contentType = "image/jpeg,image/png,image/gif,image/pjpeg";
		ImageAction imageAction = (ImageAction) inovacation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(contentType);
		response.getOutputStream().write(imageAction.getMyImageInBytes());
		response.getOutputStream().flush();
		
	}
	
}

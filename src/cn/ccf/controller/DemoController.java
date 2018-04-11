package cn.ccf.controller;//package cn.ccf.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.ccf.constants.FileConst;
import cn.ccf.mapper.WorkMapper;
import cn.ccf.pojo.ResponseDto;
import cn.ccf.pojo.Work;
//import cn.ccf.service.AttachFileService;

@Controller
public class DemoController {

//	@Autowired
//	private AttachFileService attachFileService;

	@Autowired
	private WorkMapper workMapper;

	@RequestMapping("/demo")
	public String demo() {
		return "demo/editPage";
	}

	@RequestMapping("/demo/ckeditor")
	public void ckeditor(HttpServletRequest request, HttpServletResponse response) throws IOException {

		MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
		String num = request.getParameter("CKEditorFuncNum");
		Map<String, MultipartFile> files = Murequest.getFileMap();// 得到文件map对象
		MultipartFile multipartFile = files.values().iterator().next();

		String uuid = UUID.randomUUID().toString();
		String originalFilename = multipartFile.getOriginalFilename();
		String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
		String uploadFile = FileConst.ATTACH_FILE_DIR + uuid + extName;
		multipartFile.transferTo(new File(uploadFile));



		// 设置headers参数
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/temp/file/" + uuid + extName;
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()  + "/upload/temp/file/" + uuid + extName;
//		out.println("<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(\"" + num + "\", \"" + url + "\");</script>");
		out.println("<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction("+num+", url, '上传成功');</script> ");
	}

	@RequestMapping("/demo/uploadAttach")
	@ResponseBody
	public ResponseDto filesUpload(HttpServletRequest request) throws IllegalStateException, IOException {
		MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = Murequest.getFileMap();// 得到文件map对象
		if (files.isEmpty()) {
			return ResponseDto.error("请选择附件上传");
		}

		MultipartFile multipartFile = files.values().iterator().next();
//		Integer attachFileId = attachFileService.save(multipartFile);
//		return ResponseDto.succ(attachFileId);
		return null;
	}

	@RequestMapping("/demo/saveWork")
	public ResponseDto saveWork(HttpServletRequest request) throws IllegalStateException, IOException {
		MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = Murequest.getFileMap();// 得到文件map对象
		// 封皮
		MultipartFile multipartFile = files.get("coverPage");
		// 内容
		String content = request.getParameter("content");
		// 標題
		String title = request.getParameter("title");
		// 附件id
		String attachfiles = request.getParameter("attachfiles");
		System.out.println(content);
		System.out.println(attachfiles);
		System.out.println(title);

		Work work = new Work();
		work.setAttachfiles(attachfiles);
		work.setContent(content);
//		work.setCoverpage(coverpage);


		return ResponseDto.succ("");
	}
}

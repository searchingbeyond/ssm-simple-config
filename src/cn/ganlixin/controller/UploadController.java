package cn.ganlixin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {

	@RequestMapping("upload")
	public String upload(MultipartFile file, HttpServletRequest req) {
		
		String fileName = file.getOriginalFilename();
		String uploadDir = req.getServletContext().getRealPath("upload");
		File target = new File(uploadDir, fileName);
		try {
			file.transferTo(target);
			System.out.println("成功保存上传的文件，保存路径为" + uploadDir + "/" + fileName);
		} catch (IllegalStateException | IOException e) {
			req.setAttribute("msg", "上传文件失败");
			e.printStackTrace();
		}
		req.setAttribute("msg", "上传文件成功");
		return "success";
	}
}

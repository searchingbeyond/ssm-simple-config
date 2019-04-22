package cn.ganlixin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {

	@RequestMapping("/download/{fileName:.+}")
	public String download(@PathVariable String fileName, HttpServletRequest req, HttpServletResponse resp) {
		String downloadDir = "/var/work/download";
		File targetFile = new File(downloadDir, fileName);

		if (! targetFile.exists()) {
			req.setAttribute("msg", "文件不存在，路径：" + targetFile.getAbsolutePath());
			return "error";
		}

		// 设置响应header
		resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		ServletOutputStream outputStream = null;
		try {
			outputStream = resp.getOutputStream();
			outputStream.flush();
			
			byte[] bytes = FileUtils.readFileToByteArray(targetFile);
			outputStream.write(bytes);
			outputStream.flush();
			req.setAttribute("msg", "下载文件成功");
			return null;  // 这里不要返回视图，不然会出现下面这个错误：
			// java.lang.IllegalStateException: getOutputStream() has already been called for this response
		} catch (IOException e) {
			req.setAttribute("msg", "下载过程出现差错");
			return "error";
			//e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

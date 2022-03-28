package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageboardDTO;

@Controller
public class ImageboardController {
	
	@RequestMapping(value="imageboard/imageboardWriteForm", method = RequestMethod.GET)
	public String imageboardWriteForm() {
		return "imageboard/imageboardWriteForm.jsp";
	}
	
	// MultipartFile image1 : <input type="file" name="image1">
	// 변수명과 <input>태그의 name 속성은 일치되어야함
	@RequestMapping(value="imageboard/imageboardWrite")
	public ModelAndView imageboardWrite(HttpServletRequest request, MultipartFile image1) {
		// 1. 데이터 처리
		// filePath = C:\Users\hyung_jin\Desktop\java_hyung jin\spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\step19\storage
		//			  fileName = lion.jpg
		String filePath = request.getSession().getServletContext().getRealPath("/storage");
		String fileName = image1.getOriginalFilename();
		
		System.out.println("filePath = " + filePath);
		System.out.println("fileName = " + fileName);
		
		// 이클립스가 관리하는 폴더에 저장된 파일을 현재 프로젝트의 storage에 파일 복사하기
		File file = new File(filePath, fileName);
		try {
			FileCopyUtils.copy(image1.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 데이터 추출
		ImageboardDTO dto = new ImageboardDTO();
		dto.setImageId(request.getParameter("imageId"));
		dto.setImageName(request.getParameter("imageName"));
		dto.setImagePrice(Integer.parseInt(request.getParameter("imagePrice")));
		dto.setImageQty(Integer.parseInt(request.getParameter("imageQty")));
		dto.setImageContent(request.getParameter("imageContent"));
		dto.setImage1(request.getParameter("image1"));
		dto.setImage1(fileName);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("/imageboard/imageboardWrite.jsp");
		return modelAndView;
	}
}

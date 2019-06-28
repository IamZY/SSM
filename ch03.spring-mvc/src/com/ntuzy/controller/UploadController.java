package com.ntuzy.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ntuzy.domain.User;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/test1")
	public String test1(User user, MultipartFile headIcon, HttpServletRequest request) throws IllegalStateException, IOException {

		System.out.println(user.getUserName());
		System.out.println(user.getUserPass());

		// ±£´æÎÄ¼þ
		String uploadPath = request.getServletContext().getRealPath("/upload");
		headIcon.transferTo(new File(uploadPath + "/" + headIcon.getOriginalFilename()));

		return "success";
	}

}

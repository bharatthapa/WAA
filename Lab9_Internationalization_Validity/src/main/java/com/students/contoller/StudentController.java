package com.students.contoller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students.domain.Student;

@Controller
@RequestMapping(value = "/registration")
public class StudentController {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(@ModelAttribute("student") Student student,
			Model model) {
		System.out.println("hello student");
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute Student student,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		
		String root = request.getSession().getServletContext()
				.getRealPath("/");
		System.out.println("root directory: " + root);
		if (student.getFile() != null && !student.getFile().isEmpty()) {
			try {
				student.getFile().transferTo(
						new File(root + "\\resources\\images\\"
								+ student.getEmail() + ".jpeg"));
			} catch (Exception e) {
				throw new RuntimeException("Image upload failed", e);
			}
		}
		if (bindingResult.hasErrors()) {
			return "registration";
		}

		else
			return "success";

	}

}

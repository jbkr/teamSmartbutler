package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.User;
import com.fms.smartbutler.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {
	
	private final UserService userService;
	
	// 회원 정보
	@GetMapping
	public String getUserList(Model model) {
		List<User> user = userService.findAllUser();
		
		model.addAttribute("user", user);
		
		return "admin/user/user-list";
	}
	
	// 회원 정보 상세
	@GetMapping("/{userId}")
	public String getUserInfo(@PathVariable Long userId, Model model) {
		User user = userService.findByUserId(userId).orElseGet(User::new);
		
		model.addAttribute("user", user);
		
		return "admin/user/user-info";
	}
	
	// 회원 탈퇴
	@PostMapping("/{userId}/delete")
	public String postUserDelete(@PathVariable Long userId) {
		userService.deleteUser(userId);
		
		return "redirect:/admin/user/list";
	}
}

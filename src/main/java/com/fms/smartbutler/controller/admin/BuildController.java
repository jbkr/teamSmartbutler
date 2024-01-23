package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fms.smartbutler.dto.Build;
import com.fms.smartbutler.service.BuildService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BuildController {
	
	private final BuildService buildService;
	
	@GetMapping("/admin/build/list")
	public String getBuildList(Model model) {
		List<Build> build = buildService.findAll();
		
		model.addAttribute("build", build);
		return "admin/build/build-list";
	}
	
	@GetMapping("/admin/build/list/{buildId}")
	public String getBuildInfo(@PathVariable Long buildId, Model model) {
		return "admin/build/build-info";
	}
	
	@GetMapping("/admin/build/add")
	public String getBuildAdd(Model model) {
		return "admin/build/build-info";
	}
	
	@PostMapping("/admin/build/add")
	public String postBuildAdd(@ModelAttribute Build build, Model model) {
		buildService.insert(build);
		
		return "redirect:/admin/build/list";
	}
}

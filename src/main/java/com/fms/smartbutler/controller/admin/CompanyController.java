package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Company.CompanyKind;
import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.CompanyDTO;
import com.fms.smartbutler.repository.CompanyKindRepository;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/buildings")
public class CompanyController {
	
	private final CompanyKindRepository companyKindRepository;
	private final BuildService buildService;
	private final CompanyService companyService;

	// 계약 업체 목록
	@GetMapping("/companies")
	public String getCompanyList(Model model) {
		List<CompanyDTO> companiesDTO = companyService.findAll();
		model.addAttribute("companies", companiesDTO);
		return "admin/company/company-list";
	}

	// 계약 업체 상세
	@GetMapping("/{buildId}/companies/{companyId}")
	public String getCompanyInfo(@PathVariable Long companyId, Model model) {
		CompanyDTO companyDTO = companyService.findById(companyId);
		model.addAttribute("company", companyDTO);
		return "admin/company/company-info";
	}

	// 계약 업체 수정 폼
	@GetMapping("/{buildId}/companies/{companyId}/update")
	public String getCompanyInfoUpdateForm(@PathVariable Long companyId, Model model) {
		List<CompanyKind> companyKinds = companyKindRepository.findAll();
		model.addAttribute("companyKinds", companyKinds);
		
		List<BuildDTO> buildDTOs = buildService.findAll();
		model.addAttribute("buildDTOs", buildDTOs);
		
		CompanyDTO companyDTO = companyService.findById(companyId);
		System.out.println("companyDTO");
		System.out.println(companyDTO);
		model.addAttribute("companyDTO", companyDTO);
		System.out.println("addAttribute");
		return "admin/company/update-company-info";
	}

	// 계약 업체 수정
	@PostMapping("/{buildId}/companies/{companyId}/update")
	public String updateCompanyInfo(@PathVariable Long companyId, @ModelAttribute CompanyDTO companyDTO) {
		System.out.println(companyId);
		System.out.println(companyDTO);
		System.out.println(companyDTO.getKindName());
		System.out.println(companyDTO.getKindType());
		System.out.println(companyDTO.getBuildId());
		System.out.println(companyDTO.getBuildName());
		System.out.println(companyDTO.getCompanyName());
		System.out.println(companyDTO.getManager());
		System.out.println(companyDTO.getRole());
		CompanyDTO savedCompanyDTO = companyService.save(companyDTO);
		System.out.println(companyDTO.getKindName());
		System.out.println(companyDTO.getKindType());
		System.out.println(companyDTO.getBuildId());
		System.out.println(companyDTO.getBuildName());
		System.out.println(companyDTO.getCompanyName());
		System.out.println(companyDTO.getManager());
		System.out.println(companyDTO.getRole());
		
		System.out.println(savedCompanyDTO.getKindName());
		System.out.println(savedCompanyDTO.getKindType());
		System.out.println(savedCompanyDTO.getBuildId());
		System.out.println(savedCompanyDTO.getBuildName());
		System.out.println(savedCompanyDTO.getCompanyName());
		System.out.println(savedCompanyDTO.getManager());
		System.out.println(savedCompanyDTO.getRole());
		return "redirect:/admin/buildings/companies";
	}

	// 계약 업체 삭제
	@PostMapping("/{buildId}/companies/{companyId}/delete")
	public String deleteCompanyInfo(@PathVariable Long companyId) {
		companyService.deleteById(companyId);
		return "redirect:/admin/buildings/companies";
	}

	// 계약 업체 등록 폼
	@GetMapping("/companies/add")
	public String getCompanyInfoForm(Model model) {
		List<CompanyKind> companyKinds = companyKindRepository.findAll();
		model.addAttribute("companyKinds", companyKinds);
		
		List<BuildDTO> buildDTOs = buildService.findAll();
		model.addAttribute("buildDTOs", buildDTOs);
		return "admin/company/add-company-info";
	}

	// 계약 업체 등록
	@PostMapping("/companies/add")
	public String addCompanyInfo(@ModelAttribute CompanyDTO companyDTO) {

		companyService.save(companyDTO);

		return "redirect:/admin/buildings/companies";
	}

}

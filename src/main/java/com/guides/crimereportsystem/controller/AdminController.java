package com.guides.crimereportsystem.controller;

import com.guides.crimereportsystem.entity.Admin;
import com.guides.crimereportsystem.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }

    @GetMapping("")
    public String listAdmins(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "admins";
    }

    @GetMapping("/new")
    public String createAdminForm(Model model) {
        var admin = new Admin();
        model.addAttribute("admin", admin);
        return "create_admin";
    }

    @PostMapping("")
    public String saveAdmin(@ModelAttribute("admin") Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/admins";
    }

    @GetMapping("/edit/{id}")
    public String editAdminForm(@PathVariable Long id, Model model) {
        model.addAttribute("admin", adminService.getAdminById(id));
        return "edit_admin";
    }

    @PostMapping("/{id}")
    public String updateAdmin(
            @PathVariable Long id,
            @ModelAttribute("admin") Admin admin
    ) {
        var existing = this.adminService.getAdminById(id);

        existing.setId(id);
        existing.setName(admin.getName());
        existing.setPhoneNumber(admin.getPhoneNumber());
        existing.setAddress(admin.getAddress());
        existing.setLogin(admin.getLogin());
        existing.setPassword(admin.getPassword());

        adminService.saveAdmin(existing);
        return "redirect:/admins";
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        this.adminService.deleteAdminById(id);
        return "redirect:/admins";
    }

}

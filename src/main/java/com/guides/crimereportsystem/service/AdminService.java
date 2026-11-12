package com.guides.crimereportsystem.service;

import com.guides.crimereportsystem.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmins();
    Admin saveAdmin(Admin admin);
    Admin getAdminById(Long id);
    Admin updateAdmin(Admin admin);
    void deleteAdminById(Long id);
}

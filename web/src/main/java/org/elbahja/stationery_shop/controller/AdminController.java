package org.elbahja.stationery_shop.controller;

import org.elbahja.stationery_shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/control-panel")
    public String getControlPanel(Model model) {
        model.addAttribute("carts", adminService.getAllCartsGroupedByUserId());
        //model.addAttribute("orders", adminService.getAllOrders());
        model.addAttribute("accounts", adminService.getAllAccounts());
        return "admin/control-panel";
    }

    @PostMapping("/delete-cart/{id}")
    public String deleteCart(@PathVariable Long id) {
        adminService.deleteCart(id);
        return "redirect:/admin/control-panel";
    }

//    @PostMapping("/delete-order/{id}")
//    public String deleteOrder(@PathVariable Long id) {
//        adminService.deleteOrder(id);
//        return "redirect:/admin/control-panel";
//    }

    @PostMapping("/delete-account/{id}")
    public String deleteAccount(@PathVariable Long id) {
        adminService.deleteAccount(id);
        return "redirect:/admin/control-panel";
    }
}
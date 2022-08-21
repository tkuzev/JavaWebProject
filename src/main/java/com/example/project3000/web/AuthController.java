package com.example.project3000.web;

import com.example.project3000.model.User;
import com.example.project3000.model.dto.UserRegistrationDTO;
import com.example.project3000.model.views.UsersProfileView;
import com.example.project3000.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initForm() {
        return new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDTO userRegistrationDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        System.out.println(userRegistrationDTO.toString());

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);

            return "redirect:/users/register";
        }

        this.authService.register(userRegistrationDTO);

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model){
        String username=principal.getName();

        User user=authService.getByUsername(username);

        UsersProfileView usersProfileView=new UsersProfileView(
                username,user.getFullName(),user.getAge(),
                user.getLevel());

        model.addAttribute("user",usersProfileView);

        return "profile";
    }

    @GetMapping("/profile/edit")
    public String edit(Principal principal, Model model){
        String username=principal.getName();

        User user=authService.getByUsername(username);

        UsersProfileView usersProfileView=new UsersProfileView(
                username,user.getFullName(),user.getAge(),
                user.getLevel());

        model.addAttribute("user",usersProfileView);

        return "edit";
    }

    @PostMapping("/profile/edit")
    public String doEdit(Principal principal, Model model) {

        return "index";
    }
}

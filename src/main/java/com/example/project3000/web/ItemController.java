package com.example.project3000.web;

import com.example.project3000.model.User;
import com.example.project3000.model.dto.ItemAddDTO;
import com.example.project3000.repository.UsersRepository;
import com.example.project3000.service.ItemService;
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
import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;
    private UsersRepository usersRepository;

    @Autowired
    public ItemController(ItemService itemService, UsersRepository usersRepository) {
        this.itemService = itemService;
        this.usersRepository = usersRepository;
    }

    @ModelAttribute("itemAddDTO")
    public ItemAddDTO initForm() {
        return new ItemAddDTO();
    }

    @GetMapping("/add")
    public String add(){
        return "item-add";
    }

    @PostMapping("/add")
    public String doAdd(@Valid ItemAddDTO itemAddDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes, Principal principal, Model model) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddDTO", itemAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddDTO", bindingResult);

            return "redirect:/items/add";
        }

        String username=principal.getName();

        this.itemService.add(itemAddDTO);

        return "redirect:/";
    }
}

package web.PP_3_1_2_spring_Boot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.PP_3_1_2_spring_Boot.Service.UserService;
import web.PP_3_1_2_spring_Boot.models.User;

@Controller
public class UsersController {
	private final UserService userService;
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping(value = "/")
	public String showAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	@GetMapping("/{id}")
	public String showOneUser(@PathVariable("id") int id1, ModelMap model) {
		model.addAttribute("user", userService.getUser(id1));
		return "user";
	}

	@GetMapping("/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping("/")
	public String create(@Valid @ModelAttribute("user")  User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/new";

			userService.addUser(user);
			return "redirect:/";
	}

	@GetMapping("/{id}/edit")
	public String edit(ModelMap model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUser(id));
		return "edit";
	}

	@PatchMapping("/{id}")
	public String update(@Valid @ModelAttribute("user")  User user, BindingResult bindingResult, @PathVariable("id") int id) {
		if (bindingResult.hasErrors())
			return "/edit";

		userService.updateUser(id, user);
		return "redirect:/";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		userService.removeUserById(id);
		return "redirect:/";
	}
}
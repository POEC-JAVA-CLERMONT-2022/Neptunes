package io.ipme.neptunes.Controller.mvc;

import io.ipme.neptunes.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/user-list")
    public ModelAndView itemList() {
        ModelAndView mAV = new ModelAndView("users/user-list");

        mAV.addObject("users", userService.findAll());

        return mAV;
    }

}

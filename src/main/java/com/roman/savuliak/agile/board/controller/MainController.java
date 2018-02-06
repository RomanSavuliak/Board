package com.roman.savuliak.agile.board.controller;

import com.roman.savuliak.agile.board.domain.Ticket;
import com.roman.savuliak.agile.board.services.TicketService;
import com.roman.savuliak.agile.board.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Roman on 06.02.2018.
 */
@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    TicketService ticketService;

    @RequestMapping("/")
    public String getMainPage() {
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Ticket> get() {
        return ticketService.findByUserId(userService.getCurrentUser().getId());
    }
}
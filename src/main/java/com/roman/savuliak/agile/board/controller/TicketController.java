package com.roman.savuliak.agile.board.controller;

import com.roman.savuliak.agile.board.domain.Ticket;
import com.roman.savuliak.agile.board.services.TicketService;
import com.roman.savuliak.agile.board.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Roman on 06.02.2018.
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Ticket> getAll() {
        return ticketService.findByUserId(userService.getCurrentUser().getId());
    }

    @RequestMapping(value = "/remove/id/{id}", method = RequestMethod.GET)
    public void remove(@PathVariable Long id) {
        ticketService.remove(id);
    }

    @RequestMapping(value = "/set/state/todo/id/{id}", method = RequestMethod.GET)
    public void setToDoState(@PathVariable Long id) {
        ticketService.setToDoState(id);
    }

    @RequestMapping(value = "/set/state/progress/id/{id}", method = RequestMethod.GET)
    public void setInProgressState(@PathVariable Long id) {
        ticketService.setInProgressState(id);
    }

    @RequestMapping(value = "/set/state/done/id/{id}", method = RequestMethod.GET)
    public void setDoneState(@PathVariable Long id) {
        ticketService.setDoneState(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> addTicket(@RequestBody Map<String, String> params){
        String name = params.get("name");
        String description = params.get("description");
        Ticket ticket = ticketService.createTicket(name, description, "todo");
        Long id = ticketService.add(ticket);
        HashMap<String, Long> result = new HashMap<>();
        result.put("id", id);
        return result;
    }
}
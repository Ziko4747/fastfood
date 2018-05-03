package kz.kaznitu.fastfood.controllers;

import kz.kaznitu.fastfood.models.Server;
import kz.kaznitu.fastfood.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ServerController {

    @Autowired
    ServerRepository serverRepository;

    @RequestMapping(value = "/servers", method = RequestMethod.GET)
    public String serverList(Model model) {
        model.addAttribute("servers", serverRepository.findAll());
        model.addAttribute("server", new Server());
        return "servers";
    }

    @RequestMapping(value =" /saveserver", method = RequestMethod.POST)
    public String saveServer(@ModelAttribute Server server) {
        serverRepository.save(server);
        return "redirect:/servers";
    }
}

package kz.kaznitu.fastfood.controllers;

import kz.kaznitu.fastfood.models.Server;
import kz.kaznitu.fastfood.models.Klient;
import kz.kaznitu.fastfood.repositories.ServerRepository;
import kz.kaznitu.fastfood.repositories.KlientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KlientController {
    @Autowired
    private KlientRepository klientRepository;

    @Autowired
    private ServerRepository serverRepository;

    @RequestMapping(value = "/klients", method = RequestMethod.GET)
    public String klientsList(Model model){
        model.addAttribute("klients", klientRepository.findAll());
        model.addAttribute("servers", serverRepository.findAll());
        return "klients";
    }

    @RequestMapping(value = "/klients",method = RequestMethod.POST)
    public String addKlient(@RequestParam Long serverIId,
                            Model model) {
        Server server = serverRepository.findById(serverIId).get();
        Klient newKlient = new Klient();
        newKlient.setServer(server);
        klientRepository.save(newKlient);

        return "redirect:/klients";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") Long id){
        klientRepository.deleteById(id);
        return "redirect:/klients";
    }

}

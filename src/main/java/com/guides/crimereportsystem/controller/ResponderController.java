package com.guides.crimereportsystem.controller;

import com.guides.crimereportsystem.entity.Responder;
import com.guides.crimereportsystem.service.ResponderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/responders")
public class ResponderController {
    private final ResponderService responderService;

    public ResponderController(ResponderService responderService) {
        super();
        this.responderService = responderService;
    }

    @GetMapping("")
    public String getAllResponders(Model model) {
        model.addAttribute("responders", this.responderService.getAllResponders());
        return "responders";
    }

    @GetMapping("/new")
    public String createResponderForm(Model model) {
        var responder = new Responder();
        model.addAttribute("responder", responder);
        return "create_responder";
    }

    @PostMapping("")
    public String saveResponder(@ModelAttribute("responder") Responder responder) {
        this.responderService.saveResponder(responder);
        return "redirect:/responders";
    }

    @GetMapping("/edit/{id}")
    public String editResponderTeamForm(@PathVariable Long id, Model model) {
        var existing = this.responderService.getResponderById(id);
        model.addAttribute("responder", existing);
        return "edit_responder";
    }

    @PostMapping("/edit/{id}")
    public String updateResponderTeam(
            @PathVariable Long id,
            @ModelAttribute("responder") Responder responder
    ) {
        var existing = this.responderService.getResponderById(id);

        existing.setId(id);
        existing.setStation(responder.getStation());
        existing.setCurrentPlace(responder.getCurrentPlace());
        existing.setCurrentJob(responder.getCurrentJob());

        this.responderService.updateResponder(existing);
        return "redirect:/responders";
    }

    @DeleteMapping("/{id}")
    public String deleteResponder(@PathVariable Long id) {
        this.responderService.deleteResponderById(id);
        return "redirect:/responders";
    }
}

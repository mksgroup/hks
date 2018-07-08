/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.hks.entry.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller processes request /
 * @author ThachLN
 */
@Controller
public class ItemsController {

    /**
     * Goto the index page.
     * @return
     */
    @GetMapping({"/items/typing", "/typing"})
    public String login() {
        return "items/typing";
    }
}

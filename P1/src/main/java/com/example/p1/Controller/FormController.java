package com.example.p1.Controller;

import com.example.p1.Entity.FormEntry;
import com.example.p1.Service.FormEntryService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/myapp")
public class FormController {

    @Autowired
    private FormEntryService formEntryService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formEntry", new FormEntry());
        return "form";
    }


    @PostMapping("/register")
    public String submitForm(@ModelAttribute FormEntry formEntry) throws MessagingException {
        formEntryService.saveFormEntry(formEntry);
        return "result";
    }


    @GetMapping("/getall")
    public String getAllForm(Model model) {
        List<FormEntry> entries= formEntryService.getAll();
        model.addAttribute("entries", entries);
        return "entries";
    }

    @GetMapping("/id/{myid}")
    public String getFormById(@PathVariable int myid, Model model) {
        Optional<FormEntry> entry=formEntryService.getById(myid);
        if(entry.isEmpty()){
            return "nullentry";
        }else{
            model.addAttribute("entries", Collections.singletonList(entry.get()));
            return "entries";
        }
    }

    @GetMapping("/deleteId/{myid}")
    public String deleteForm(@PathVariable int myid, Model model){
        Optional<FormEntry> entry=formEntryService.getById(myid);
        if(entry.isEmpty()){
            return "nullentry";
        }else{
            formEntryService.deleteById(myid);
            return "done";
        }
    }

    @GetMapping("/update/{myid}")
    public String updateId(@PathVariable int myid, Model themodel){
        Optional<FormEntry> existingEntry = formEntryService.getById(myid);
        if (existingEntry.isPresent()) {
            themodel.addAttribute("formEntry", existingEntry.get());
            return "form";
        } else {
            return "nullentry";
        }
    }

}


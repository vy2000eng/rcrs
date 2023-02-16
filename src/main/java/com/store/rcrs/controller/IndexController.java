package com.store.rcrs.controller;


import com.store.rcrs.model.Records;
import com.store.rcrs.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private final RecordService recordService;


    public IndexController(RecordService recordService) {

        this.recordService = recordService;
        // developer managed instance
        //recordService = new RecordServiceImpl();

        // spring managed instance
    }

    @GetMapping("/")
    public String index(Model model){
        List<Records> records = recordService.getRecord();

        model.addAttribute("records", records);
        return "index";
    }

    @GetMapping("/success")
    public String success(Model model){
        List<Records> records = recordService.getRecord();

        model.addAttribute("records", records);
        model.addAttribute("successMessage", "Data was saved successfully!");

        return "index";
    }


    @GetMapping("/search")
    public String searchGames(@RequestParam String term, Model model){
        List<Records> records = recordService.searchRecords(term);
        model.addAttribute("records", records);
        return "index";
    }

}
















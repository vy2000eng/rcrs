package com.store.rcrs.controller;

import com.store.rcrs.model.Records;
import com.store.rcrs.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }


    //
    //add a game

    @GetMapping("/record/add")
    public String addRecordView(Model model)
    {
        return "addRecord";
    }




    @PostMapping("/record/add")
    public String addRecordSubmit(Model model, @RequestParam String recordName, @RequestParam String recordArtist, @RequestParam Double recordPrice,@RequestParam  String recordReleaseDate, @RequestParam String recordGenre, @RequestParam Integer numberOfTracks ){



        try {
            this.recordService.addRecord(  recordName,  recordArtist,recordPrice,recordReleaseDate, recordGenre,  numberOfTracks);

        }catch (Exception ex){
            model.addAttribute("errorMessage", ex.getMessage());
            //System.err.println(ex.getMessage());
            return "addRecord";
        }
        model.addAttribute("successMessage", "The game was succesfully saved" );
        return "addRecord";


    }


    //
    //edit a page
    @GetMapping("/record/edit/{recordId}")
    public String editRecordView(@PathVariable Long recordId, Model model){
        Records records = recordService.getRecordById(recordId);
        model.addAttribute("recordName", records.getRecordName());
        model.addAttribute("recordPrice", records.getRecordPrice());
        model.addAttribute("recordArtist", records.getRecordArtist());
        model.addAttribute("recordGenre", records.getRecordGenre());
        model.addAttribute("recordReleaseDate", records.getRecordReleaseDate());
        model.addAttribute("numberOfTracks", records.getNumberOfTracks());





        return "editRecord";

    }

    @PostMapping("/record/edit")
    public String editRecordSubmit(Model model,@RequestParam Long recordId, @RequestParam String recordName, @RequestParam String recordArtist, @RequestParam Double recordPrice, @RequestParam String recordReleaseDate, @RequestParam String recordGenre, @RequestParam Integer numberOfTracks){


        //
        //submit the form
        try{
            this.recordService.editRecord(recordId,  recordName,  recordArtist, recordPrice, recordReleaseDate, recordGenre,  numberOfTracks);
        }catch (Exception ex){
            model.addAttribute("error", ex.getMessage());

        }
        //return "index";
        return "redirect:/success";

    }

    //delete a game
    @GetMapping("/record/delete/{recordId}")
    public String deleteRecord(@PathVariable Long recordId, Model model){
        //
        //submit the form
        try{
            this.recordService.deleteRecord(recordId);
        }catch (Exception ex){
            model.addAttribute("error", ex.getMessage());

        }
        //return "index";
        return "redirect:/success";





        //return "editRecord";

    }





}

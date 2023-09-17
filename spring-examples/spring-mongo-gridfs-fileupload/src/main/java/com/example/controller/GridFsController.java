package com.example.controller;

import com.example.service.GridFsService;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/gridfs")
public class GridFsController {
    private final GridFsService gridFsService;

    public GridFsController(GridFsService gridFsService) {
        this.gridFsService = gridFsService;
    }

    @PostMapping
    public String fileUpload(@RequestParam MultipartFile file) throws Exception {
        return gridFsService.uploadFile(file);
    }

    @GetMapping("/{fileId}")
    public GridFSFile fileUpload(@PathVariable String fileId){
        return gridFsService.findOne(fileId);
    }
}

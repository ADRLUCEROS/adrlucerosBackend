package com.adrLuceros.transporte.ProgramacionPreeliminar.Infrastructura.Input.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adrLuceros.transporte.ProgramacionPreeliminar.Application.Service.PPService;
import com.adrLuceros.transporte.ProgramacionPreeliminar.Domain.Models.ModelExcel;

@RestController
@RequestMapping("/api/v1/programacion-preeliminar")
public class PPController {

    private final PPService ppService;

    public PPController(PPService ppService) {
        this.ppService = ppService;
    }

    @PostMapping
    public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            List<ModelExcel> modelExcelList = ppService.getAll(file);
            return ResponseEntity.ok(modelExcelList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

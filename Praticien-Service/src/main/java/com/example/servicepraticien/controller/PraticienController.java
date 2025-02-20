package com.example.servicepraticien.controller;

import com.example.servicepraticien.model.Praticien;
import com.example.servicepraticien.service.PraticienService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/praticiens")
@Tag(name = "Gestion des Praticiens", description = "CRUD des praticiens")
public class PraticienController {

    private final PraticienService praticienService;

    public PraticienController(PraticienService praticienService) {
        this.praticienService = praticienService;
    }

    @GetMapping
    @Operation(summary = "Lister tous les praticiens", description = "Retourne la liste complète des praticiens")
    public ResponseEntity<List<Praticien>> getAllPraticiens() {
        return ResponseEntity.ok(praticienService.getAllPraticiens());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un praticien par ID", description = "Retourne les détails d'un praticien spécifique")
    public ResponseEntity<Praticien> getPraticienById(@PathVariable int id) {
        Praticien praticien = praticienService.getPraticienById(id);
        return praticien != null ? ResponseEntity.ok(praticien) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Ajouter un praticien", description = "Ajoute un nouveau praticien")
    public ResponseEntity<Praticien> addPraticien(@RequestBody Praticien praticien) {
        return ResponseEntity.ok(praticienService.addPraticien(praticien));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un praticien", description = "Modifie les informations d'un praticien")
    public ResponseEntity<Praticien> updatePraticien(@PathVariable int id, @RequestBody Praticien updatedPraticien) {
        Praticien updated = praticienService.updatePraticien(id, updatedPraticien);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un praticien", description = "Supprime un praticien")
    public ResponseEntity<Void> deletePraticien(@PathVariable int id) {
        return praticienService.deletePraticien(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

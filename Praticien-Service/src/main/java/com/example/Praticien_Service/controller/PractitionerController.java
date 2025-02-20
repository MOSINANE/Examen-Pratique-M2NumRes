package com.example.Praticien_Service.controller;

import com.example.Praticien_Service.model.Practitioner;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/practitioners")
@Tag(name="Practitioner", description = "Practitioner Controller")
public class PractitionerController {

    private final List<Practitioner> practitioners = new ArrayList<>();

    // Initialisation des praticiens statiques
    public PractitionerController() {
        practitioners.add(new Practitioner(1L, "Dr. Alice Dubois", "Cardiologue"));
        practitioners.add(new Practitioner(2L, "Dr. Bob Martin", "Dentiste"));
        practitioners.add(new Practitioner(3L, "Dr. Charlie Durand", "Généraliste"));
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les praticiens")
    public List<Practitioner> getAllPractitioners() {
        return practitioners;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un praticien par ID")
    public Practitioner getPractitionerById(@PathVariable Long id) {
        return practitioners.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    @Operation(summary = "Ajouter un praticien")
    public Practitioner addPractitioner(@RequestBody Practitioner practitioner) {
        practitioner.setId((long) (practitioners.size() + 1));
        practitioners.add(practitioner);
        return practitioner;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un praticien")
    public Practitioner updatePractitioner(@PathVariable Long id, @RequestBody Practitioner updatedPractitioner) {
        for (Practitioner practitioner : practitioners) {
            if (practitioner.getId().equals(id)) {
                practitioner.setNom(updatedPractitioner.getNom());
                practitioner.setSpecialite(updatedPractitioner.getSpecialite());
                return practitioner;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un praticien")
    public String deletePractitioner(@PathVariable Long id) {
        return practitioners.removeIf(p -> p.getId().equals(id)) ? "Praticien supprimé" : "Praticien non trouvé";
    }
}

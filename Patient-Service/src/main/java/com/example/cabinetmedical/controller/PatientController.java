package com.example.cabinetmedical.controller;

import com.example.cabinetmedical.model.Patient;
import com.example.cabinetmedical.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@Tag(name = "Gestion des Patients", description = "CRUD sur les patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Obtenir tous les patients", description = "Retourne la liste de tous les patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un patient par son ID", description = "Retourne un patient en fonction de son ID")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) { // ✅ Correction du type de l'ID (int)
        Patient patient = patientService.getPatientById(id);
        return patient != null ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    @Operation(summary = "Ajouter un nouveau patient", description = "Ajoute un patient à la liste")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un patient", description = "Modifie les informations d'un patient existant")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient updatedPatient) {
        Patient updated = patientService.updatePatient(id, updatedPatient);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Supprimer un patient", description = "Supprime un patient de la liste")
    public ResponseEntity<Void> deletePatient(@PathVariable int id) {
        return patientService.deletePatient(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

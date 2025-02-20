package com.example.cabinetmedical.service;

import com.example.cabinetmedical.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PatientService {
    private final List<Patient> patients = new ArrayList<>();
    {
        patients.add(new Patient(1, "Doe", "John", "123456789", "1 rue de Paris", new Date(), "M"));
        patients.add(new Patient(2, "Doe", "Jane", "987654321", "2 rue de Paris", new Date(), "F"));
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatientById(int id) {
        return patients.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Patient addPatient(Patient patient) {
        patients.add(patient);
        return patient;
    }

    public Patient updatePatient(int id, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.set(i, updatedPatient);
                return updatedPatient;
            }
        }
        return null;
    }

    public boolean deletePatient(int id) {
        return patients.removeIf(p -> p.getId() == id);
    }

}

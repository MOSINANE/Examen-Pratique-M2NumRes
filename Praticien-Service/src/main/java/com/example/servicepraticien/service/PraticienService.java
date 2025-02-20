package com.example.servicepraticien.service;

import com.example.servicepraticien.model.Praticien;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PraticienService {
    private final List<Praticien> praticiens = new ArrayList<>();

    // Initialisation avec quelques praticiens
    {
        praticiens.add(new Praticien(1, "Dr. Lefevre", "Neurologue", "0622334455", "30 boulevard Saint-Germain"));
        praticiens.add(new Praticien(2, "Dr. Petit", "Ophtalmologue", "0633445566", "40 rue de Rivoli"));
    }

    public List<Praticien> getAllPraticiens() {
        return praticiens;
    }

    public Praticien getPraticienById(int id) {
        return praticiens.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Praticien addPraticien(Praticien praticien) {
        praticiens.add(praticien);
        return praticien;
    }

    public Praticien updatePraticien(int id, Praticien updatedPraticien) {
        for (int i = 0; i < praticiens.size(); i++) {
            if (praticiens.get(i).getId() == id) {
                praticiens.set(i, updatedPraticien);
                return updatedPraticien;
            }
        }
        return null;
    }

    public boolean deletePraticien(int id) {
        return praticiens.removeIf(p -> p.getId() == id);
    }
}

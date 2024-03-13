package com.PatientAppointment.repositories;

import com.PatientAppointment.models.Provider;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProviderRepoInterface2 {
    void save(String providerId , LocalDateTime localDateTime);
    Optional<List<LocalDateTime>> findById(String providerId);
   List<String> findAll();
    void delete(String providerId, LocalDateTime localDateTime);


}

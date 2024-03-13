package com.PatientAppointment.repositories;

import com.PatientAppointment.models.ProviderAppointment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class ProviderRepo implements ProviderAppointmentRepo {
    HashMap<String,ProviderAppointment> providerAppointmentHashMap = new HashMap<>();

    @Override
    public ProviderAppointment save(String  providerId , ProviderAppointment providerAppointment) {
        providerAppointmentHashMap.put(providerId,providerAppointment);
        return providerAppointment;
    }

    @Override
    public Optional<ProviderAppointment> findById(String provideId) {
        if(providerAppointmentHashMap.containsKey(provideId)){
            return Optional.of(providerAppointmentHashMap.get(provideId));
        }
        return Optional.empty();
    }
}

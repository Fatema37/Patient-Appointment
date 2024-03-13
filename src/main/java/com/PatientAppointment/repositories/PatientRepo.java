package com.PatientAppointment.repositories;

import com.PatientAppointment.models.PatientAppointment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;
@Repository
public class PatientRepo implements PatientRepoInterface {

    private HashMap<String, PatientAppointment> patientAppointmentHashMap = new HashMap<>();

    @Override
    public PatientAppointment save( String patientId,PatientAppointment patientAppointment) {
        patientAppointmentHashMap.put(patientId, patientAppointment);
        return patientAppointment;
    }

    @Override
    public Optional<PatientAppointment> findById(String patientId) {
        if(patientAppointmentHashMap.containsKey(patientId)){
            return Optional.of(patientAppointmentHashMap.get(patientId));
        }
        return Optional.empty();
    }

    @Override
    public void delete(String  patientId) {
        if(patientAppointmentHashMap.containsKey(patientId)){
            patientAppointmentHashMap.remove(patientId);
        }

    }
}

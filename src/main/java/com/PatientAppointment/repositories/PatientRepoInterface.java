package com.PatientAppointment.repositories;

import com.PatientAppointment.models.PatientAppointment;

import java.util.Optional;

public interface PatientRepoInterface {
    PatientAppointment save(String patientId,PatientAppointment patientAppointment);
    Optional<PatientAppointment> findById(String patientId);

    void delete(String patientId);

}

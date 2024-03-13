package com.PatientAppointment.repositories;

import com.PatientAppointment.models.PatientAppointment;
import com.PatientAppointment.models.ProviderAppointment;

import java.util.Optional;

public interface ProviderAppointmentRepo {


    ProviderAppointment save(String providerId, ProviderAppointment providerAppointment);

    Optional<ProviderAppointment> findById(String patientId);




}

package com.PatientAppointment.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ProviderAppointment extends BaseModel{
    public LocalDateTime appointmentTime;
    public String patientID;
}

package com.PatientAppointment.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Provider {
    private String providerId;
    private List<LocalDateTime> localDateTimeList;

}

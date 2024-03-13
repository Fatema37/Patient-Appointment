package com.PatientAppointment.services;

import com.PatientAppointment.models.PatientAppointment;
import com.PatientAppointment.models.Provider;
import com.PatientAppointment.models.ProviderAppointment;
import com.PatientAppointment.repositories.PatientRepo;
import com.PatientAppointment.repositories.ProviderRepo;
import com.PatientAppointment.repositories.ProviderRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class VaccineScheduler {
    @Autowired
  private PatientRepo patientRepo;

    @Autowired
  private ProviderRepo providerRepo;
    @Autowired
  private ProviderRepo2 providerRepo2;


    public void scheduleAppointment(String patientID, String providerID, LocalDateTime appointmentTime)
    {
        Optional<PatientAppointment> optionalPatientRepo = patientRepo.findById(patientID);
        if(optionalPatientRepo.isPresent()){
            throw new RuntimeException("Appointment is already present for this patient");
        }
        AbstractMap<LocalDateTime, AbstractCollection<String>>  ans = getAvailableAppointments(appointmentTime.toLocalDate());
        if(!ans.containsKey(appointmentTime)){
         throw  new RuntimeException("Appointmrnt not available");
        }

      PatientAppointment patientAppointment1 = new PatientAppointment();
        patientAppointment1.setProviderID(providerID);
        patientAppointment1.setAppointmentTime(appointmentTime);
        patientRepo.save(patientID,patientAppointment1);
        removeAppointment(providerID, appointmentTime);
    }

    public void cancelAppointment(String patientID)
    {
        Optional<PatientAppointment> optionalPatientRepo = patientRepo.findById(patientID);
        if(optionalPatientRepo.isEmpty()){
            throw new RuntimeException("Appointtnnt not available");
        }
        patientRepo.delete(patientID);
        PatientAppointment patientAppointment = optionalPatientRepo.get();
        addAppointment(patientAppointment.getProviderID(), patientAppointment.getAppointmentTime());

    }

    public PatientAppointment getPatientAppointment(String patientID)
    {
        Optional<PatientAppointment> optionalPatientRepo = patientRepo.findById(patientID);
        return optionalPatientRepo.orElse(null);
    }

    public AbstractMap<LocalDateTime, AbstractCollection<String>> getAvailableAppointments(LocalDate day)
    {
        AbstractMap<LocalDateTime, AbstractCollection<String>> ans = new HashMap<>();
        List<String> providers = providerRepo2.findAll();
        for(String providerId : providers){
            Optional<List<LocalDateTime>> optional = providerRepo2.findById(providerId);
            if(optional.isPresent()){
                List<LocalDateTime> localDateTimeList = optional.get();
               for(LocalDateTime localDateTime : localDateTimeList){
                   LocalDate date = localDateTime.toLocalDate();

                   if(date.equals(day)){
                       if(ans.containsKey(localDateTime)){
                           List<String> providerIds = (List<String>) ans.get(localDateTime);
                           providerIds.add(providerId);
                       }
                       else{
                           List<String > providerIds = new ArrayList<>();
                           providerIds.add(providerId);
                           ans.put(localDateTime, (AbstractCollection<String>) providerIds);
                       }
                   }

               }

            }
        }

        return ans;
    }
    public void addAppointment(String providerID, LocalDateTime appointmentTime)
    {
       providerRepo2.save(providerID,appointmentTime);
    }

    public void removeAppointment(String providerID, LocalDateTime appointmentTime)
    {
        providerRepo2.delete(providerID,appointmentTime);

    }

    public AbstractCollection<ProviderAppointment> getProviderSchedule(String providerID, LocalDate day)
    {
        AbstractCollection<ProviderAppointment> providerAppointmentList = new ArrayList<>();
        return null;
    }


}

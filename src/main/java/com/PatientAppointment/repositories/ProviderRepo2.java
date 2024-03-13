package com.PatientAppointment.repositories;

import com.PatientAppointment.models.Provider;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class ProviderRepo2 implements ProviderRepoInterface2 {
    HashMap<String, List<LocalDateTime>> providerHashMap = new HashMap<>();

    @Override
    public void save(String providerId, LocalDateTime localDateTime) {
        if (providerHashMap.containsKey(providerId)) {
            List<LocalDateTime> localDateTimeList = providerHashMap.get(providerId);
            localDateTimeList.add(localDateTime);
        } else {
            List<LocalDateTime> localDateTimeList = new ArrayList<>();
            localDateTimeList.add(localDateTime);
            providerHashMap.put(providerId, localDateTimeList);
        }
    }

    @Override
    public Optional<List<LocalDateTime>> findById(String providerId) {
        if (providerHashMap.containsKey(providerId)) {
            return Optional.of(providerHashMap.get(providerId));
        }
        return Optional.empty();
    }

    @Override
    public List<String> findAll() {
        return providerHashMap.keySet().stream().toList();
    }


    @Override
    public void delete(String providerId, LocalDateTime localDateTime) {
        if (providerHashMap.containsKey(providerId)) {
            List<LocalDateTime> localDateTimeList = providerHashMap.get(providerId);
            for (int i = 0; i < localDateTimeList.size(); i++) {
                if (localDateTimeList.contains(localDateTime)) {
                    localDateTimeList.remove(localDateTime);}
            }
        }
    }
}

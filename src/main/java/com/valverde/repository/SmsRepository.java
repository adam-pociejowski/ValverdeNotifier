package com.valverde.repository;

import com.valverde.entity.Sms;
import com.valverde.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SmsRepository extends JpaRepository<Sms, Long> {
    List<Sms> findByState(State state);
    List<Sms> findByOrderByIdDesc();
}
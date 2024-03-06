package com.example.block16SpringCloudTicket.repository;

import com.example.block16SpringCloudTicket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiketRepository extends JpaRepository<Ticket, Integer> {
}

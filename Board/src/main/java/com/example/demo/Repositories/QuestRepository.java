package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Quest;

@Repository
public interface QuestRepository extends JpaRepository<Quest,Integer>{
}

package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Models.Quest;
import com.example.demo.Repositories.QuestRepository;

@Service
public class QuestService {
	
	private final QuestRepository questRepository;
	
	QuestService(QuestRepository questRepository){
		this.questRepository = questRepository;
	}
	
	public List<Quest> getQuests() {
		
		System.out.println(questRepository.getClass());
		return questRepository.findAll();
	}
	
	public Quest getQuest(int id) {
		return questRepository.findById(id).get();
	}
	
	public void insertQuest(Quest quest) {
		questRepository.save(quest);
	}
	
	public void deleteQuest(int id) {
		questRepository.deleteById(id);
	}
	
	
}

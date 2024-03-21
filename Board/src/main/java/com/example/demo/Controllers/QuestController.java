package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.Quest;
import com.example.demo.Services.QuestService;

@RestController
public class QuestController {
	
	private final QuestService questsService;
	
	@Autowired
	QuestController(QuestService questsService){
		this.questsService = questsService;
	}
	
	@GetMapping(path = "api/v1/quests")
	public List<Quest> getStuff() {
		return questsService.getQuests();
	}
	
	@GetMapping(path = "api/v1/quests/{id}")
	public Quest getQuest(@PathVariable int id) throws Exception {
		Quest quest = questsService.getQuest(id);
		if(quest!=null)
			return quest;
		throw new Exception("Not found");
	}
	
	@PostMapping("api/v1/quests")
	public String postStuff(@RequestBody Quest quest) {
		questsService.insertQuest(quest);
		return "Success";
	}
	
	@DeleteMapping("api/v1/quests/{id}")
	public String deleteStuff(@PathVariable int id) {
		questsService.deleteQuest(id);
		return "Success";
	}
	
}

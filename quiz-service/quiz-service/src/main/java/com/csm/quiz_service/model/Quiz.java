package com.csm.quiz_service.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;



@Entity
@Data
public class Quiz {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	//@ManyToMany
	@ElementCollection
//@CollectionTable(name = "quiz_question_ids", joinColumns = @JoinColumn(name = "quiz_id"))
    //@Column(name = "question_id")
	private List<Integer> questionIds;
	
	
}

package com.csm.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csm.quiz_service.dao.QuizDao;
import com.csm.quiz_service.feign.QuizInterface;
import com.csm.quiz_service.model.QuestionWrapper;
import com.csm.quiz_service.model.Quiz;
import com.csm.quiz_service.model.Response;


@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
//	@Autowired
//	QuestionDao questionDao;
	
	@Autowired
	QuizInterface quizInterface;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		
		List<Integer> questions=quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		
//		List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
//		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
    	quiz.setQuestionIds(questions);
//		
		quizDao.save(quiz);
//		
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Quiz quiz=quizDao.findById(id).orElseThrow(()->new RuntimeException("Quiz not found with id: " + id));
//		// use of get here is If a value is present, returns the value, 
//		//otherwise throws NoSuchElementException.
//		List<Question> questionsFromDB=quiz.get().getQuestions();
		List<Integer> questionIds=quiz.getQuestionIds();
		//List<QuestionWrapper> questionsForUser=new ArrayList<>();
		ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionFromId(questionIds);
//		
//		for(Question q:questionsFromDB)
//		{
//			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//			questionsForUser.add(qw);
//		}
//		
		//return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
		return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		//Quiz quiz= quizDao.findById(id).get();// get is optional here
		
ResponseEntity<Integer> score=quizInterface.getScore(responses);
//		List<Question> questions=quiz.getQuestions();
		//int right=0;
//		int i=0;
//		for(Response response:responses)
//		{
//			if(response.getResponse().trim().equals(questions.get(i).getRightAnswer().trim()))
//				right++;
//			i++;
//		}
		return score;
	}
	
	
	

}

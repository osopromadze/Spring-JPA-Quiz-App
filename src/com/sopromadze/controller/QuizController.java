package com.sopromadze.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopromadze.entities.Answer;
import com.sopromadze.entities.Question;
import com.sopromadze.entities.Quiz;
import com.sopromadze.service.QuestionService;
import com.sopromadze.service.QuizService;
import com.sopromadze.utilities.UserToLogin;

@Controller
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping(path = "add-quiz")
	public String addQuiz(HttpServletRequest request, @Valid @ModelAttribute Quiz quiz, BindingResult result, Model model) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("loggedInUser", userToLogin);
		
		if (result.hasErrors()) {
			return null;
		}
		
		quizService.saveQuiz(quiz);
		
		return "redirect:/add-quiz";
	}
	
	@PostMapping(path = "/show-add-question")
	public String showAddQuestion(HttpServletRequest request, Model model, @RequestParam int quizId) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("loggedInUser", userToLogin);
		
		Question question = new Question();
		Quiz quiz = quizService.getQuiz(quizId);
		
		if (question != null) {
			question.setQuiz(quiz);
		}
		
		List<Answer> answers = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			answers.add(new Answer());
		}
		
		question.setAnswers(answers);
		
		model.addAttribute("quiz", quiz);
		model.addAttribute("question", question);
		return "add-question";
	}
	
	@PostMapping(path = "/add-question")
	public String addQuestion(HttpServletRequest request, Model model, @Valid @ModelAttribute Question question) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		question.setApproved((byte) 1);
		int count = 0;
		
		for(Answer answer : question.getAnswers()) {
			if (count == 0) {
				answer.setIsCorrect((byte) 1);
			}
			
			answer.setQuestion(question);
			
			count++;
		}
		
		questionService.saveQuestion(question);
		
		
		
		return "redirect:/add-quiz";
	}
	
	@GetMapping(path = "/edit-quiz/{id}")
	public String showEditQuiz(HttpServletRequest request, Model model, @PathVariable(name = "id") int id) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("loggedInUser", userToLogin);
		
		Quiz quiz = quizService.getQuiz(id);
		model.addAttribute("quiz", quiz);
		
		return "edit-quiz";
	}
	
	@GetMapping(path = "/add-quiz")
	public String showAddQuiz(HttpServletRequest request, Model model) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("loggedInUser", userToLogin);
		
		Quiz quiz = new Quiz();
		model.addAttribute("quiz", quiz);
		
		List<Quiz> allQuizzes = quizService.getAllQuizzes();
		model.addAttribute("allQuizzes", allQuizzes);
		
		return "add-quiz";
		
	}
	
	@PostMapping(path = "/edit-quiz")
	public String editQuiz(@Valid @ModelAttribute Quiz quiz, HttpServletRequest request, Model model) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		Quiz updatedQuiz =  quizService.updateQuiz(quiz);
		model.addAttribute("quiz", updatedQuiz);
		
		return "redirect:/edit-quiz/" + updatedQuiz.getId();
	}
	
	@PostMapping(path = "/delete-quiz")
	public String deleteQuiz(@RequestParam int quizId, HttpServletRequest request) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		quizService.deleteQuiz(quizId);
		
		return "redirect:/add-quiz";
	}
	
	@GetMapping(path = "/edit-question/{id}")
	public String showEditQuestion(HttpServletRequest request, Model model, @PathVariable int id) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		Question question = questionService.getQuestion(id);
		if (question != null) {
			model.addAttribute("loggedInUser", userToLogin);
			model.addAttribute("question", question);
			return "edit-question";
		}
		
		return "redirect:/add-quiz";
	}
	
	@PostMapping(path = "/edit-question")
	public String editQuestion(HttpServletRequest request, Model model, @Valid @ModelAttribute Question question) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		question.setApproved((byte) 1);
		
		int count = 0;
		for(Answer answer : question.getAnswers()) {
			if (count == 0) {
				answer.setIsCorrect((byte) 1);
			}
			answer.setQuestion(question);
			
			count++;
		}
		
		Question updatedQuestion = questionService.updateQuestion(question);
		
		return "redirect:/edit-quiz/" + updatedQuestion.getQuiz().getId();
	}
	
	@PostMapping(path = "/delete-question")
	public String deleteQuestion(HttpServletRequest request, Model model, @RequestParam int id, @RequestParam int quizId) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() > 2) {
			return "redirect:/dashboard";
		}
		
		questionService.deleteQuestion(id);
		
		return "redirect:/edit-quiz/" + quizId;
	}
	
	
	private UserToLogin getLoggedInUser(HttpServletRequest request) {
		if (request.getSession().getAttribute("userToLogin") != null) {
			UserToLogin userToLogin = (UserToLogin) request.getSession().getAttribute("userToLogin");
			
			return userToLogin;
		}
		
		return null;
	}
}

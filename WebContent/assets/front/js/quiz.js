$(document).ready((function() {
	let questionsJson = $("#questionsJson").text();
	$("#questionsJson").remove();
	let questions = JSON.parse(questionsJson);
	
	let quizId = $("#quizId").text();
	$("#quizId").remove();
	
	let username = $("#username").text();
	$("#username").remove();
	
	let path = $("#path").text();
	$("#path").remove();

	let questionCounter = 0;
	let selections = [];
	let quiz = $('#quiz');
	
	let timeNow = Date.now();
	
	let results = {
		"username" : username,
		"quizId" : quizId
	};
	
	
	displayNext();

	// Click handler for the 'next' button
	$('#next').on('click', function(e) {
		e.preventDefault();

		// Suspend click listener during fade animation
		if (quiz.is(':animated')) {
			return false;
		}
		choose();

		// If no user selection, progress is stopped
		if (isNaN(selections[questionCounter])) {
			alert('Please make a selection!');
		} else {
			questionCounter++;
			displayNext();
		}
	});

	// Click handler for the 'Start Over' button
	$('#start').on('click', function(e) {
		e.preventDefault();

		if (quiz.is(':animated')) {
			return false;
		}
		
		timeNow = Date.now();
		questionCounter = 0;
		selections = [];
		displayNext();
		$('#start').hide();
	});

	function createQuestionElement(index) {
		var qElement = $('<div>', {
			id : 'question'
		});

		var header = $('<h2>Question ' + (index + 1) + '/' + questions.length + '</h2>');
		qElement.append(header);

		var question = $('<p>').append(questions[index].question);
		qElement.append(question);

		var radioButtons = createRadios(index);
		qElement.append(radioButtons);

		return qElement;
	}
	
	function createRadios(index) {
	    var radioList = $('<ul>');
	    var item;
	    var input = '';
	    for (var i = 0; i < questions[index].options.length; i++) {
	      item = $('<li>');
	      input = '<input type="radio" id="answer' + i + '" name="answer" value=' + i + ' />';
	      input += '<label for="answer' + i + '">';
	      input += questions[index].options[i];
	      input += '</label>';
	      item.append(input);
	      radioList.append(item);
	    }
	    return radioList;
	  }
	
	function choose() {
	    selections[questionCounter] = +$('input[name="answer"]:checked').val();
	  }
	
	function displayNext() {
	    quiz.fadeOut(function() {
	      $('#question').remove();
	      
	      if(questionCounter < questions.length){
	        var nextQuestion = createQuestionElement(questionCounter);
	        quiz.append(nextQuestion).fadeIn();
	        if (!(isNaN(selections[questionCounter]))) {
	          $('input[value='+selections[questionCounter]+']').prop('checked', true);
	        }
	        
	      }else {
	        var scoreElem = displayScore();
	        quiz.append(scoreElem).fadeIn();
	        $('#next').hide();
	        $('#start').show();
	      }
	    });
	  }
	
	function displayScore() {
	    var score = $('<p>',{id: 'question'});
	    
	    var numCorrect = 0;
	    for (var i = 0; i < selections.length; i++) {
	      if (selections[i] === questions[i].correctIndex) {
	        numCorrect++;
	      }
	    }
	    
	    results["correctAnswers"] = numCorrect;
	    results["incorrectAnswers"] = questions.length - numCorrect;
	    results["timeNow"] = timeNow;
	    
	    $.ajax({
	    	type: "POST",  
	        url: path + "/results",
	        dataType: 'json',
	        contentType: 'application/json',
	        data:  JSON.stringify(results),
	        success : function(result){
	        	if(result.error !== undefined){
	        		window.location.href = path + "/" + result.error;
	        	}
	        }
	    });
	    
	    score.append('You got ' + numCorrect + ' questions out of ' +
                questions.length + ' right!!!');
	    return score;
	}
}));
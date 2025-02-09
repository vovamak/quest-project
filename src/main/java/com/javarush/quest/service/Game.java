package com.javarush.quest.service;

import com.javarush.quest.entity.Question;
import com.javarush.quest.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private String playerName;

    public Game(String playerName) {
        this.playerName = playerName;
        this.questions = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.score = 0;
        initializeQuestions();
    }

    private void initializeQuestions() {
        this.questions= new QuestionRepository().getAllQuestions();
    }


    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public boolean answerQuestion(int answerIndex) {
        if (currentQuestionIndex >= questions.size()) {
            return false; // Вопросы закончились
        }
        // Проверяем ответ
        if (answerIndex == getCurrentQuestion().getCorrectAnswerIndex()) {
            score++;
        }
        // Переходим к следующему вопросу
        currentQuestionIndex++;

        // Возвращаем true, если есть еще вопросы, иначе false
        return currentQuestionIndex < questions.size();
    }

    public int getScore() {
        return score;
    }
    public int getQuestionsSize(){
        return questions.size();
    }

    public String getPlayerName() {
        return playerName;
    }

}

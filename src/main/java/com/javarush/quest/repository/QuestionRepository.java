package com.javarush.quest.repository;

import com.javarush.quest.entity.Question;

import java.util.Arrays;
import java.util.List;

public class QuestionRepository {

    private List<Question> questions= Arrays.asList(
            new Question("Какая столица Франции?", new String[]{"Париж", "Лондон", "Берлин"}, 0),
            new Question("Сколько планет в Солнечной системе?", new String[]{"8", "9", "10"}, 0),
            new Question("Кто написал 'Войну и мир'?", new String[]{"Толстой", "Достоевский", "Чехов"}, 0),
            new Question("Какой язык программирования самый популярный?", new String[]{"Python", "Java", "JavaScript"}, 1),
            new Question("Какой год был основан Google?", new String[]{"2000", "1998", "1995"}, 1)
            );
    public List<Question> getAllQuestions(){
        return questions;
    }

}

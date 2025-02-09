package com.javarush.quest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game("TestPlayer");
    }

    @Test
    void testInitialScore() {
        assertEquals(0, game.getScore(), "Начальный счет должен быть 0");
    }

    @Test
    void testCorrectAnswer() {
        game.answerQuestion(0); // Правильный ответ на первый вопрос
        assertEquals(1, game.getScore(), "Счет должен увеличиться на 1 после правильного ответа");
    }

    @Test
    void testIncorrectAnswer() {
        game.answerQuestion(1); // Неправильный ответ на первый вопрос
        assertEquals(0, game.getScore(), "Счет не должен измениться после неправильного ответа");
    }

    @Test
    void testGameCompletion() {
        for (int i = 0; i < game.getQuestionsSize()-1; i++) {
            assertTrue(game.answerQuestion(0), "Игра должна пока есть вопросы"); // Отвечаем на все вопросы
        }
        // Пытаемся ответить на 6-й вопрос
        assertFalse(game.answerQuestion(0), "Игра должна завершиться после всех вопросов");
    }

    @Test
    void testPlayerName() {
        assertEquals("TestPlayer", game.getPlayerName(), "Имя игрока должно быть 'TestPlayer'");
    }
}


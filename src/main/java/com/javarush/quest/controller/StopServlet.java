package com.javarush.quest.controller;

import com.javarush.quest.service.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "stopServlet", value = "/stop")
public class StopServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println(">>> stopServlet interrupts the game");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");

        // Увеличиваем счетчик игр
        Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");
        session.setAttribute("gamesPlayed", gamesPlayed + 1);

        // Перенаправляем на страницу результата
        resp.sendRedirect(req.getContextPath() +"/result");
    }
}

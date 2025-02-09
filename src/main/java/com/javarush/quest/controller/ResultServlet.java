package com.javarush.quest.controller;

import com.javarush.quest.service.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "resultServlet", value = "/result")
public class ResultServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println(">>> resultServlet starting");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");

        // Получаем данные из сессии
        String ipAddress = (String) session.getAttribute("ipAddress");
        Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");

        // Передаем данные на JSP
        req.setAttribute("score", game.getScore());
        req.setAttribute("playerName", game.getPlayerName());
        req.setAttribute("ipAddress", ipAddress);
        req.setAttribute("gamesPlayed", gamesPlayed);

        req.getRequestDispatcher("/result.jsp").forward(req, resp);

        // Очищаем игру из сессии
        session.removeAttribute("game");


    }
}

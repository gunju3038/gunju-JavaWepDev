package com.gunju.w1.todo;

import com.gunju.w1.todo.dto.TodoDTO;
import com.gunju.w1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "totoListController",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/list");
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        req.setAttribute("dtoList", dtoList);
        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req,resp);
    }
}

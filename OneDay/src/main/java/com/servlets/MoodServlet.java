package com.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.User;
import com.persistence.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MoodServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            updateMood(req,resp);




    }

    private void updateMood(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

        BufferedReader br = req.getReader();
        String line = br.readLine();

        StringBuilder sb = new StringBuilder();

        //here we are going to read through each line of our req.getReader
        //it is possible for their to only be 1 line in our br
        //a while loop is the safest way

        while(line != null){
            sb.append(line);
            line = br.readLine();
        }

        System.out.println(sb);

        String body = sb.toString();

        String[] sepByComma = body.split(",");

        ArrayList<String> values = new ArrayList<>();

        for(String value: sepByComma){
            // System.out.println(value);

            //here we want to trim all the excess symbols as well as the
            //keys and keep the values
            //note we can add multiple replaceAll functions
            value = value.replaceAll("\\{", "").replaceAll("}","").replaceAll("\"","");

            System.out.println(value);

            String target = value.substring(value.indexOf(":") + 1);

            System.out.println(target);
            values.add(target);


        }
        String mood = values.get(0);
        Integer username = Integer.valueOf(values.get(1));


        User user = new User(mood, username);

        //here we are doing the logic to actually log in

        userDAO.update(user);

        if(user != null){
            System.out.println("user is not null");
            resp.setStatus(200);


            //get a HTTP Session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");

            ObjectMapper om = new ObjectMapper();

            //convert the object with the mapper

            out.println(om.writeValueAsString(user));

            System.out.println("The user with :" + username + " has logged in");
        }else{
            System.out.println("user is null");
            resp.setStatus(204);
        }

    }



}

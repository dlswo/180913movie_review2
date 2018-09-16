package org.injae;

import org.injae.dao.MovieDAO;

public class Main {


    public static void main(String[] args) {
        MovieDAO dao = new MovieDAO();
        System.out.println(dao.getList());
    }


}

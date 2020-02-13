package sait.mms.application;

/**
 * AppDriver
 */

 import java.io.*;
import sait.mms.managers.MovieManagementSystem;

public class AppDriver {

    public static void main(String[] args) throws IOException {

    	MovieManagementSystem movieManagement = new MovieManagementSystem();

        movieManagement.loadMovie();

        movieManagement.displayMenu();
        

    }
}
package com.Muzafar.project;

import java.sql.*;
import java.util.Scanner;

public class Books {
    String BookName;
    String AuthorName;
    int Edition;
    double price;
    Scanner sc = new Scanner(System.in);

    Books(String BookName, String AuthorName, int Edition, double price) {
        this.BookName = BookName;
        this.AuthorName = AuthorName;
        this.Edition = Edition;
        this.price = price;
    }

    public Books() {

    }

    public void viewBooks() {
        String dbURL = "jdbc:mysql://localhost:3306/Java";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            if (conn != null) {

            }
            String sql = "SELECT * FROM books";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            System.out.println("            |BookName|      |AuthorName|        |Price|         |Edition|");
            while (result.next()) {
                String bookname = result.getString("BookName");
                String authorname = result.getString("AuthorName");
                double price = result.getDouble("Price");
                int edition = result.getInt("Edition");
                System.out.println("            |"+bookname+"|      |"+authorname+"|        |"+price+"|         |"+edition+"|");

//                String output = "Book #%d: %s - %s - %s - %s";
//                System.out.println(String.format(output, ++count, bookname ,authorname,  price,  edition));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void deleteBook() {
        viewBooks();
        System.out.println("Select any of book to delete");
        System.out.println("............");
        System.out.println("Enter Book Name to Delete");
        String book = sc.nextLine();
        String dbURL = "jdbc:mysql://localhost:3306/Java";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            if (conn != null) {

            }
            String sql = "DELETE FROM books WHERE BookName=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, book);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" book was deleted successfully!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void updateBook() {
        viewBooks();
        System.out.println("chose any of one book to update");
        String dbURL = "jdbc:mysql://localhost:3306/Java";
        String username = "root";
        String password = "";

        viewBooks();
        System.out.println("ENTER BOOK NAME THAT YOU WANT TO UPDATE");
        String naam= sc.nextLine();
        System.out.println("enter BookName To update");
        String book = sc.nextLine();
        System.out.println("enter Book Author To Update");
        String author = sc.nextLine();
        System.out.println("enter book edition to update");
        int edition = sc.nextInt();
        System.out.println("enter book price to update");
        double price = sc.nextDouble();


            try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {



                String query2 = "UPDATE books SET BookName= '" + book + "', AuthorName= '" + author + "', Edition ='" + edition + "',Price='" + price +"' WHERE BookName = '"+naam+"'";

                PreparedStatement prestatement = conn.prepareStatement(query2);
                prestatement.execute();
                System.out.println("An existing book was updated successfully!");


            }
            catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }



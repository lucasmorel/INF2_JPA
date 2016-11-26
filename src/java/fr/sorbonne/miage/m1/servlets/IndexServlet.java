package fr.sorbonne.miage.m1.servlets;

import fr.sorbonne.miage.m1.beans.Author;
import fr.sorbonne.miage.m1.beans.Book;
import fr.sorbonne.miage.m1.dao.AuthorDAO;
import fr.sorbonne.miage.m1.dao.BookDAO;
import fr.sorbonne.miage.m1.dao.DAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eddebbima
 */
public class IndexServlet extends HttpServlet {
    
    private DAO<Book> bookDao;
    private DAO<Author> authorDao;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Processing request in IndexServlet");
        authorDao = new AuthorDAO();
        
        Author a1 = new Author("Lucas","Morel" );
        authorDao.create(a1);
        
        Author a2 = new Author("A","Supprimer" );
        authorDao.create(a2);
        
        bookDao = new BookDAO();
        Book b = bookDao.findById(123456);
        if (b != null){
            bookDao.delete(b);
        }
        else{
            b = new Book(123456,"Le Livre crée", 45.0f);
            bookDao.create(b);
        }
        List<Book> books = bookDao.findAll();
        List<Author> authors = authorDao.findAll();
         authorDao.delete(a2);
        System.out.println("NB Books : " + books.size());
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("books", books);   
        System.out.println("NB Authors : " + authors.size());
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "IndexServlet";
    }// </editor-fold>

}

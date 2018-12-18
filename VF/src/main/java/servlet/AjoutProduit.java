package servlet;

import model.DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DataSourceFactory;

@WebServlet(name = "AjoutProduit", urlPatterns = {"/AjoutProduit"})
public class AjoutProduit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        Properties resultat = new Properties();
        
	int Product_ID = Integer.parseInt(request.getParameter("Product_ID"));
        int id = Integer.parseInt(request.getParameter("id"));
        dao.insertOrder(dao.maxOrderNum()+1, id, Product_ID, 1, (float) dao.ProductPrice(Product_ID), "2018-11-29","2018-12-01",dao.ManbyProduct(Product_ID));
        showView("Ajout_ok.jsp",request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
     private void exitSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        showView("ajoutDiscount.jsp", request, response);
    }
      private void showView(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/" + jsp).forward(request, response);
    }

}

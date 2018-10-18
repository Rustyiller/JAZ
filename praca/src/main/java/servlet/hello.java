package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class hello extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String kredyt = request.getParameter("kredyt");
        String raty = request.getParameter("raty");
        String oprocentowanie = request.getParameter("oprocentowanie");
        String oplata = request.getParameter("oplata");
        String rodzaj = request.getParameter("rodzaj");

        Double kredytD = Double.parseDouble(kredyt);
        Double ratyD = Double.parseDouble(raty);
        Double oprocentowanieD = Double.parseDouble(oprocentowanie);
        Double oplataD = Double.parseDouble(oplata);

        String tabela = "<table style='width:100%'>"+
                "<tr>"+
                "<th>Nr raty</th>"+
                "<th>Kwota kapitalu</th>"+
                "<th>Kwota odsetek</th>"+
                "<th>Oplaty stale</th>"+
                "<th>Calkowita kwota raty</th>"+
                "</tr>";


        if(rodzaj=="Malejaca") {
            Double kapital = kredytD/ratyD;
            for (int i = 1; i <= ratyD; i++) {
                Double reszta = kredytD-kapital;
                Double odsetki = reszta*(oprocentowanieD/100)/12;
                Double rata = kapital + odsetki;
                response.setContentType("text/html");
                tabela += "<tr>"+
                        "<td>" + i + "</td>" +
                        "<td>" + kapital + "</td>" +
                        "<td>" + odsetki + "</td>" +
                        "<td>" + oplataD + "</td>" +
                        "<td>" + rata + "</td>" +
                        "</tr>";
            }
            tabela += "</table>";
            response.getWriter().println(tabela);
        }
        else
        {
            Double diff = kredytD;
            for (int i = 1; i <= ratyD; i++) {
                Double q = (1 + ((oprocentowanieD / 100) / 12));
                Double potenga = Math.pow(q, ratyD);
                Double stala = kredytD * (potenga) * ((q-1)/(potenga)-1);
                diff-=stala;
                Double odsetkowa = diff*((oprocentowanieD/100)/12);
                Double kapitalowa = stala - odsetkowa;
                tabela += "<tr>"+
                        "<td>" + i + "</td>" +
                        "<td>" + kapitalowa + "</td>" +
                        "<td>" + odsetkowa + "</td>" +
                        "<td>" + oplataD + "</td>" +
                        "<td>" + stala + "</td>" +
                        "</tr>";
            }
            tabela += "</table>";
            response.getWriter().println(tabela);
        }


    }
}

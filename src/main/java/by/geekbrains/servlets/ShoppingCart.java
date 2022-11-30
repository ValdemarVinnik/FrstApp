package by.geekbrains.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import by.geekbrains.servlets.models.Product;

@Slf4j
@WebServlet(name = "ShoppingCart", urlPatterns = "/shopping_cart")
public class ShoppingCart extends HttpServlet {
    private List<Product> list;

    @Override
    public void init() throws ServletException {
        log.info("init products");
        list = new ArrayList<>();
        list.add(new Product(1, "milk", 60));
        list.add(new Product(2, "кефир", 65));
        list.add(new Product(3, "хлебушек", 45));
        list.add(new Product(4, "пивасик", 89));
        list.add(new Product(5, "батон", 55));
        list.add(new Product(6, "кофе", 120));
        list.add(new Product(7, "сосиски", 234));
        list.add(new Product(8, "селёдка", 220));
        list.add(new Product(9, "торт", 456));
        list.add(new Product(10, "сметана", 99));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setHeader("Content-Type", "text/html; charset=UTF-8 w/o BOM");

        writer.printf("<html>\n" +
                "<body>\n" +
                "<h1>%s</h1>\n", this.getClass().getSimpleName());
        for (Product each : list) {

            log.info(String.format("display %s", each.getTitle()));
            writer.printf("<h2>%d: %s - %d rub. </h2>\n",
                    each.getId(), each.getTitle(), each.getCost());
        }
        writer.print("</body>\n" +
                "</html>");

        writer.close();
    }
}

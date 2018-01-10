package am.sfl.cafeShushan.controller;

import am.sfl.cafeShushan.entity.*;
import am.sfl.cafeShushan.model.TableStatus;
import am.sfl.cafeShushan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shushi on 1/9/2018.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;


    @Autowired
    private ProductInOrderService productInOrderService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(String status) {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        Table table = tableService.findByUser(user);
        if (status != null) {
            table.setTableStatus(TableStatus.valueOf(status));
        }
        if (table == null) {
            modelAndView.setViewName("home");
        } else if (table.getTableStatus().tableStatus().equals("AVAILABLE")) {
            modelAndView.addObject("table", table);
            modelAndView.setViewName("home-available");
        } else if (table.getTableStatus().tableStatus().equals("BUSY")) {
            List<Product> products = productService.findAll();
            modelAndView.addObject("products", products);
            modelAndView.addObject("table", table);
//            modelAndView.setViewName("home-busy");
            modelAndView.setViewName("redirect:/home/busy");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/home/busy", method = RequestMethod.GET)
    public ModelAndView homeBusy() {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        Table table = tableService.findByUser(user);
        table.setTableStatus(TableStatus.BUSY);
        tableService.save(table);
     Order order = tableService.getOpenOrder(table);
      if (order ==null){
          order.setStatus("open");
          order.setTable(table);
          order.setProductInOrder(new ProductInOrder());
          orderService.save(order);
      }

        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);

        modelAndView.addObject("table", table);
        modelAndView.setViewName("home-busy");

        return modelAndView;
    }

    //@RequestMapping(value = "/home/busy", method = RequestMethod.POST)
//    public ModelAndView addToOrder(@Valid Product product, BindingResult bindingResult) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByUsername(auth.getName());
//        Table table = tableService.findByUser(user);
//
//        ProductInOrder productInOrder = orderService.findByTableAndStatus(table).getProductInOrder();
//        Product product1 = productService.findByName(product.getName());
//        productInOrder.getProducts().add(product1);
//
//        productInOrderService.save(productInOrder);
//        List<Product> products = productService.findAll();
//        modelAndView.addObject("products", products);
//
//        modelAndView.addObject("table", table);
//        modelAndView.addObject("productsInOrder", productInOrder.getProducts());
//        modelAndView.setViewName("home-busy");
//        if (bindingResult.hasErrors()) {
//            return modelAndView;
//        }
//        return modelAndView;
//    }
    @RequestMapping(value = "/home/add-to-order/{id}", method = RequestMethod.GET)
    public ModelAndView addToOrder(@PathVariable("id") String id) {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        Table table = tableService.findByUser(user);

        Order order = tableService.getOpenOrder(table);
       if (order != null) {
           ProductInOrder productInOrder = order.getProductInOrder();
           Product product1 = productService.findById(Long.valueOf(id));
           productInOrder.getProducts().add(product1);
           System.out.println(productInOrder.getProducts().get(0));
           productInOrderService.save(productInOrder);
           modelAndView.addObject("productsInOrder", productInOrder.getProducts());
       }

        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);

        modelAndView.addObject("table", table);

        modelAndView.setViewName("home-busy");

        modelAndView.setViewName("redirect:/home/busy");
        return modelAndView;
    }


    @RequestMapping(value = "/home/order", method = RequestMethod.GET)
    public ModelAndView homeShowOrder() {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        Table table = tableService.findByUser(user);
        List<Product> products = new ArrayList<>();
        if (table != null) {
            Order order = orderService.findByTableAndStatus(table);
            if (order != null) {
                products = order.getProductInOrder().getProducts();
            }

        }

        modelAndView.addObject("productsInOrder", products);

        modelAndView.setViewName("home-orders");

        return modelAndView;
    }

    @RequestMapping(value = "/home/bill", method = RequestMethod.POST)
    public ModelAndView biiling() {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        Table table = tableService.findByUser(user);
        Order order =  tableService.getOpenOrder(table);
        if (order != null) {
            order.setStatus("close");
            orderService.save(order);
        }
        table.setTableStatus(TableStatus.AVAILABLE);
tableService.save(table);
        modelAndView.addObject("message", "All food is for free today:))");

        modelAndView.setViewName("home-bill");

        return modelAndView;
    }


}

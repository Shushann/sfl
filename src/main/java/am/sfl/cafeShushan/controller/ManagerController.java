package am.sfl.cafeShushan.controller;

import am.sfl.cafeShushan.entity.*;
import am.sfl.cafeShushan.model.TableStatus;
import am.sfl.cafeShushan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Shushi on 1/9/2018.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
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

    @RequestMapping(value = {"/lists"}, method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manager-home");
        return modelAndView;
    }

    @RequestMapping(value = "/new-order", method = RequestMethod.GET)
    public ModelAndView newOrderGet() {
        ModelAndView modelAndView = new ModelAndView();
        Order order = new Order();
        modelAndView.addObject("order", order);
        modelAndView.setViewName("new-order-reg");
        return modelAndView;
    }

    @RequestMapping(value = "/new-order", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Order order, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();


        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("new-order-reg");
        } else {
            order.setStatus("open");
            ProductInOrder productInOrder = new ProductInOrder();
            order.setProductInOrder(productInOrder);
            orderService.save(order);
            modelAndView.addObject("successMessage", "Order has been registered successfully");
            modelAndView.addObject("order", new Order());
            modelAndView.setViewName("new-order-reg");

        }
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }


    @RequestMapping(value = "/product-reg", method = RequestMethod.GET)
    public ModelAndView registrationProduct() {
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("manager-product-reg");
        return modelAndView;
    }

    @RequestMapping(value = "/product-reg", method = RequestMethod.POST)
    public ModelAndView createNewProduct(@Valid Product product, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("manager-product-reg");
        } else {
            productService.save(product);
            modelAndView.addObject("successMessage", "Product has been registered successfully");
            modelAndView.addObject("product", new Product());
            modelAndView.setViewName("manager-product-reg");

        }
        return modelAndView;
    }

    @RequestMapping(value = "/table-to-user", method = RequestMethod.GET)
    public ModelAndView registrationTable() {
        ModelAndView modelAndView = new ModelAndView();
        Table table = new Table();

        modelAndView.addObject("table", table);
        modelAndView.setViewName("manager-table-reg");
        return modelAndView;
    }

    @RequestMapping(value = "/table-to-user", method = RequestMethod.POST)
    public ModelAndView createNewTable(@Valid Table table, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("manager-table-reg");
        } else {
            table.setTableStatus(TableStatus.AVAILABLE);
            tableService.save(table);
            modelAndView.addObject("successMessage", "Table has been registered successfully");
            modelAndView.addObject("table", new Table());
            modelAndView.setViewName("manager-table-reg");

        }
        return modelAndView;
    }

}

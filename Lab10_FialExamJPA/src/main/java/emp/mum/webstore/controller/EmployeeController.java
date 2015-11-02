package emp.mum.webstore.controller;

import emp.mum.webstore.domain.Employee;
import emp.mum.webstore.service.EmployeeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bharat
 */
@Controller
@RequestMapping({"/employees"})
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees", service.listEmployees());

        return "employees";
    }

    @RequestMapping("/employee")
    public String getEmployeeByNumber(Model model,
            @RequestParam("id") int employeeId) {

        model.addAttribute("employee", service.locateOneEmployeeByHisNumber(employeeId));
        return "employees";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewEmployee(@ModelAttribute("newEmployee") Employee newEmployee) {
        return "addEmployee";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewEmployee(@Valid @ModelAttribute("newEmployee") Employee employeeToBeAdded, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }
        try {
            service.add(employeeToBeAdded);
            attributes.addFlashAttribute("message", "Employee added successfully.");
        } catch (IllegalArgumentException ex) {
            attributes.addFlashAttribute("error", ex.getMessage());
            return "addEmployee";
        }
        return "redirect:/employees";
    }
}

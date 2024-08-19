package com.example.SpringWebsite;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    //whatever is returned by the below  function should be a view technoloy
    //but every url should match with the method first
    //by deafult springboot does not support the jsp page we have to convert it into a servlet----addd tomcat jasper in dependency
    //the request aping method below maps the home apage to  the method
    @RequestMapping("/")
    public String home(){
        System.out.println("home method called");
        //now the view resolver will resolve this to the view file
        return "index";
    }

    //the data is beeing sent as a query param so we need to accept the servlet
//    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session){
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result= num1+num2;
//        // we have to send the added data to the result page we need to send it
//        //to maintain the data between multiple pages is thorgh session
//        session.setAttribute("result",result);
//        System.out.println(num1+num2);
//        return "result.jsp";
//    }



//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int num, int num2, HttpSession session){
//        // it will not work with the diffrent name that of the variable actually given
//        int result= num+num2+10;
//        // we have to send the added data to the result page we need to send it
//        //to maintain the data between multiple pages is thorgh session
//        session.setAttribute("result",result);
//        System.out.println(num+num2);
//        return "result.jsp";
//    }


    //if we just need to pass the object between the pagges we need to use the model object
//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int num, int num2, Model model){
//        // it will not work with the diffrent name that of the variable actually given
//        int result= num+num2+10;
//        // we have to send the added data to the result page we need to send it
//        //to maintain the data between multiple pages is thorgh session
//        model.addAttribute("result",result);
//        System.out.println(num+num2);
//        return "result";
//    }



    //what if we ca put the model and view inside the model object it self
    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView mv){
        // it will not work with the diffrent name that of the variable actually given
        int result= num+num2+10;
        // we have to send the added data to the result page we need to send it
        //to maintain the data between multiple pages is thorgh session
        mv.addObject("result",result);
        mv.setViewName("result");
        System.out.println(num+num2);
        return mv;
    }



//    @RequestMapping("addAlien")
//    public ModelAndView addAlien(@RequestParam("aid") int aid, String aname, ModelAndView mv){
//        Alien a = new Alien();
//        a.setAid(aid);
//        a.setName(aname);
//        mv.addObject("alien",a);
//        mv.setViewName("result");
//        return mv;
//    }

    //i want the spring to create the object and asign the values to this alien object
    //for the we need to use a annotatio called model atribute
    //we can specify the name
//    @RequestMapping("addAlien")
//    public String  addAlien(@ModelAttribute("alien1") Alien alien){
//        return "result";
//    }

//even wityhout the model attribute annotation it works
    //if we dont want to have a diffrent name we can commpletely skip model atributte
    @RequestMapping("addAlien")
    public String  addAlien(Alien alien){
        return "result";
    }


    @ModelAttribute("cource")
    public String courceName(){
        return "Java";
    }
}

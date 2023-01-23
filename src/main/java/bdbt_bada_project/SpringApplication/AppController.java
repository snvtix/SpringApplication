package bdbt_bada_project.SpringApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class AppController implements WebMvcConfigurer {

    private KlienciDAO daoK;
    private OfertyDAO daoO;
    private PracownicyDAO daoP;
    private WynagrodzeniaDAO daoW;
    private StudiaDAO daoSt;
    private SprzetyDAO daoS;
    private FirmyDAO daoF;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/pracownik_zarzad").setViewName("admin/pracownik_zarzad");
        registry.addViewController("/edit_pracownicy").setViewName("admin/edit_pracownicy");
        registry.addViewController("/wynagrodzenia_zarzad").setViewName("admin/wynagrodzenia_zarzad");
        registry.addViewController("/studia_zarzad").setViewName("admin/studia_zarzad");
        registry.addViewController("/new_studia").setViewName("admin/new_studia");
        registry.addViewController("/edit_studia").setViewName("admin/edit_studia");
        registry.addViewController("/sprzety_zarzad").setViewName("admin/sprzety_zarzad");
        registry.addViewController("/new_sprzety").setViewName("admin/new_sprzety");
        registry.addViewController("/edit_sprzety").setViewName("admin/edit_sprzety");
        registry.addViewController("/firmy_zarzad").setViewName("admin/firmy_zarzad");
        registry.addViewController("/new_firmy").setViewName("admin/new_firmy");
        registry.addViewController("/edit_firmy").setViewName("admin/edit_firmy");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/klienci_zarzad").setViewName("user/klienci_zarzad");
        registry.addViewController("/edit_klienci").setViewName("user/edit_klienci");
        registry.addViewController("/oferty_zarzad").setViewName("user/oferty_zarzad");
        registry.addViewController("/new_oferty").setViewName("user/new_oferty");
        registry.addViewController("/edit_oferty").setViewName("user/edit_oferty");
    }

    @Controller
    public class DashboardController
    {
        @RequestMapping("/main")
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

    //user---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //klienci
    @RequestMapping("user/klienci_zarzad")
    public String klienciView(Model model){
        List<Klienci> listKlienci = daoK.list();
        model.addAttribute("listKlienci", listKlienci);
        return "user/klienci_zarzad";
    }
    @RequestMapping("user/edit_klienci/{nr_klienta}")
    public ModelAndView showEditFormKlienci(@PathVariable(name = "nr_klienta") int nr_klienta){
        ModelAndView mav = new ModelAndView("user/edit_klienci");
        Klienci klienci = daoK.get(nr_klienta);
        mav.addObject("klienci", klienci);

        return mav;
    }
    @RequestMapping(value="/updateKlienci", method=RequestMethod.POST)
    public String updateKlienciUser(@ModelAttribute("klienci") Klienci klienci){
        daoK.update(klienci);

        return "redirect:/klienci_zarzad";
    }

    //oferty
    @RequestMapping("user/oferty_zarzad")
    public String ofertyView(Model model){
        List<Oferty> listOferty = daoO.list();
        model.addAttribute("listOferty", listOferty);
        return "user/oferty_zarzad";
    }
    @RequestMapping("user/new_oferty")
    public String addNewOferty(Model model) {
        Oferty oferty = new Oferty();
        model.addAttribute("oferty", oferty);
        return "user/new_oferty";
    }
    @RequestMapping(value="/saveOferty", method=RequestMethod.POST)
    public String saveOferty(@ModelAttribute("oferty") Oferty oferty){
        daoO.save(oferty);
        return "redirect:/oferty_zarzad";
    }
    @RequestMapping("user/edit_oferty/{nr_oferty}")
    public ModelAndView showEditFormOferty(@PathVariable(name = "nr_oferty") int nr_oferty){
        ModelAndView mav = new ModelAndView("user/edit_oferty");
        Oferty oferty = daoO.get(nr_oferty);
        mav.addObject("oferty", oferty);

        return mav;
    }
    @RequestMapping(value="/updateOferty", method=RequestMethod.POST)
    public String updateOferty(@ModelAttribute("oferty") Oferty oferty){
        daoO.update(oferty);

        return "redirect:/oferty_zarzad";
    }

    //amdin-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //pracownicy
    @RequestMapping("/pracownicy_zarzad")
    public String pracownicyView(Model model){
        List<Pracownicy> listPracownicy = daoP.list();
        model.addAttribute("listPracownicy", listPracownicy);
        return "admin/pracownicy_zarzad";
    }
    @RequestMapping("/edit_pracownicy/{nr_pracownika}")
    public ModelAndView showEditFormPracownicy(@PathVariable(name = "nr_pracownika") int nr_pracownika){
        ModelAndView mav = new ModelAndView("admin/edit_pracownicy");
        Pracownicy pracownicy = daoP.get(nr_pracownika);
        mav.addObject("pracownicy", pracownicy);

        return mav;
    }
    @RequestMapping(value="/updatePracownicy", method=RequestMethod.POST)
    public String updatePracownicy(@ModelAttribute("pracownicy") Pracownicy pracownicy){
        daoP.update(pracownicy);

        return "redirect:/pracownicy_zarzad";
    }

    //Wynagrodzenia
    @RequestMapping("/wynagrodzenia_zarzad")
    public String wynagrodzeniaView(Model model){
        List<Wynagrodzenia> listWynagrodzenia = daoW.list();
        model.addAttribute("listWynagrodzenia", listWynagrodzenia);
        return "admin/wynagrodzenia_zarzad";
    }

    //Studia
    @RequestMapping("/studia_zarzad")
    public String studiaView(Model model){
        List<Studia> listStudia = daoSt.list();
        model.addAttribute("listStudia", listStudia);
        return "admin/studia_zarzad";
    }
    @RequestMapping("/edit_studia/{nr_studia}")
    public ModelAndView showEditFormStudia(@PathVariable(name = "nr_studia") int nr_studia){
        ModelAndView mav = new ModelAndView("admin/edit_studia");
        Studia studia = daoSt.get(nr_studia);
        mav.addObject("studia", studia);

        return mav;
    }
    @RequestMapping(value="/updateStudia", method=RequestMethod.POST)
    public String updateStudia(@ModelAttribute("studia") Studia studia){
        daoSt.update(studia);

        return "redirect:/studia_zarzad";
    }

    //sprzety
    @RequestMapping("/sprzety_zarzad")
    public String sprzetyView(Model model){
        List<Sprzety> listSprzety = daoS.list();
        model.addAttribute("listSprzety", listSprzety);
        return "admin/sprzety_zarzad";
    }
    @RequestMapping("/new_sprzety")
    public String showNewFormSprzety(Model model) {
        Sprzety sprzety = new Sprzety();
        model.addAttribute("sprzety", sprzety);
        return "admin/new_sprzety";
    }
    @RequestMapping(value="/saveSprzety", method=RequestMethod.POST)
    public String saveSprzety(@ModelAttribute("sprzety") Sprzety sprzety){
        daoS.save(sprzety);
        return "redirect:/sprzety_zarzad";
    }
    @RequestMapping("/edit_sprzety/{nr_sprzetu}")
    public ModelAndView showEditFormSprzety(@PathVariable(name = "nr_sprzetu") int nr_sprzetu){
        ModelAndView mav = new ModelAndView("admin/edit_sprzety");
        Sprzety sprzety = daoS.get(nr_sprzetu);
        mav.addObject("sprzety", sprzety);

        return mav;
    }
    @RequestMapping(value="/updateSprzety", method=RequestMethod.POST)
    public String updateSprzety(@ModelAttribute("sprzety") Sprzety sprzety){
        daoS.update(sprzety);

        return "redirect:/sprzety_zarzad";
    }
    @RequestMapping("/delete/{nr_sprzetu}")
    public String deleteSprzety(@PathVariable(name = "nr_sprzetu") int nr_sprzetu){
        daoS.delete(nr_sprzetu);

        return "redirect:/sprzety_zarzad";
    }

    //firmy
    @RequestMapping("/firmy_zarzad")
    public String firmyView(Model model){
        List<Firmy> listFirmy = daoF.list();
        model.addAttribute("listFirmy", listFirmy);
        return "admin/firmy_zarzad";
    }
    @RequestMapping("/new_firmy")
    public String showNewFormFirmy(Model model) {
        Firmy firmy = new Firmy();
        model.addAttribute("firmy", firmy);
        return "admin/new_firmy";
    }
    @RequestMapping(value="/saveFirmy", method=RequestMethod.POST)
    public String saveFirmy(@ModelAttribute("firmy") Firmy firmy){
        daoF.save(firmy);
        return "redirect:/firmy_zarzad";
    }
    @RequestMapping("/edit_firmy/{nr_firmy}")
    public ModelAndView showEditFormFirmy(@PathVariable(name = "nr_firmy") int nr_firmy){
        ModelAndView mav = new ModelAndView("admin/edit_firmy");
        Firmy firmy = daoF.get(nr_firmy);
        mav.addObject("firmy", firmy);

        return mav;
    }
    @RequestMapping(value="/updateFirmy", method=RequestMethod.POST)
    public String updateFirmy(@ModelAttribute("firmy") Firmy firmy){
        daoF.update(firmy);

        return "redirect:/firmy_zarzad";
    }
    @RequestMapping("/delete/{nr_firmy}")
    public String deleteFirmy(@PathVariable(name = "nr_firmy") int nr_firmy){
        daoF.delete(nr_firmy);

        return "redirect:/firmy_zarzad";
    }


}


package pl.gromadzki.human;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/generate")
public class HumanController {


    @RequestMapping(method = RequestMethod.GET)
    public String getGenerate(Model model){
        HumanService humanService = new HumanService(new Human());
        model.addAttribute("human", humanService.getHuman());
        return "generate";
    }
}

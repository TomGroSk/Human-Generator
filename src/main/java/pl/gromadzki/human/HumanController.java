package pl.gromadzki.human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/generate")
public class HumanController {
    private final HumanService humanService;

    @Autowired
    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String getGenerate(Model model){
        Human human = humanService.getHuman();
        model.addAttribute("human", human);
        return "generate";
    }
}

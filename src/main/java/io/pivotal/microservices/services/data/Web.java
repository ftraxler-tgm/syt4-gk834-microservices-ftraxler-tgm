package io.pivotal.microservices.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Fabian Traxler {@literal <ftraxler@student.tgm.ac.at>}
 * @version 2019-05-04
 * @project microservices-demo
 */
@Controller
public class Web {

    @Autowired
    WindengineRepository r;

    protected Logger logger = Logger.getLogger(Web.class.getName());


    @GetMapping("/abfrage")
    public String greeting(String output, Model model) {

        logger.info("Abfrage called");

        output = "Error";
        List<Windengine> windengines;

        try {
            windengines =r.findWindengineByTimestampAfterAndWindspeedGreaterThanAndPowerLessThan(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2019-03-25 11:00"),50.0,100.0);
            model.addAttribute("windengines",windengines);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        model.addAttribute("output", output);
        return "abfrage";
    }



}

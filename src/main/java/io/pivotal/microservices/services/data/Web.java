package io.pivotal.microservices.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PreDestroy;
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

    public boolean login=false;


    @GetMapping("/{user}/{password}/request")
    public String greeting(@PathVariable("user") String partialName, @PathVariable("password")String password, Model model) {
        login=false;
        logger.info("Abfrage called");


        logger.info("data-service byName() invoked: for "+ partialName+ "and" + password);
        RestTemplate restTemplate = new RestTemplate();
        List<Windengine> windengines;

        logger.info("Request to user Service send");
        String loginS;
        loginS = restTemplate.getForObject("http://127.0.0.1:2222/users/"+partialName+"/"+password,String.class);


        logger.info(loginS);
        logger.info(""+loginS.contains("true"));
        if(loginS.contains("true")){
            login=true;
        }

        logger.info(""+login);


        if (login) {
            try {
                windengines =r.findWindengineByTimestampAfterAndWindspeedGreaterThanAndPowerLessThan(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2019-03-25 11:00"),50.0,100.0);
                model.addAttribute("windengines",windengines);
                logger.info("");
                login=false;
                return "abfrage";
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        login=false;
        model.addAttribute("exception","Wrong Password Input");
        return "error";
    }

    @PreDestroy
    public void end(){
        login=false;
    }



}

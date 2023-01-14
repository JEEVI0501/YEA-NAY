package com.poll.votingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poll.votingsystem.entity.Candidate;
import com.poll.votingsystem.entity.Voter;
import com.poll.votingsystem.repo.CandidateRepo;
import com.poll.votingsystem.repo.VoterRepo;
import com.poll.votingsystem.repo.*;
@Controller
public class VoterController {

    public final Logger logger = Logger.getLogger(VoterController.class);

    @Autowired
    VoterRepo voteRepo;

    @Autowired
    CandidateRepo candidateRepo;

    @RequestMapping("/getResult")
    public String DisplayResult(Model m){
        List<Candidate> candidates = candidateRepo.findAll();
        m.addAttribute("candidates",candidates);
        return "result";
    }
    @RequestMapping("/")
    public String goToVote() {
        logger.info("Returning vote.html file");
        return "vHome";
    }
    @RequestMapping("/doUser")
    public String goTOUser(){
            return "userLog";
        }
    @RequestMapping("/doVoter")
    public String goToVoter(){
        return "voter";
    }
    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("fname") String firstname,@RequestParam("lname") String lastname,@RequestParam("rollno") String rollno,Model model, HttpSession session) {
        System.out.println("HELLOOOOO");
        logger.info("getting citizen from database");
        Voter citizen = voteRepo.findByRollno(rollno);
        System.out.println(citizen.getFirstname());
        System.out.println("Helo");
        logger.info("putting citizen into session");
        session.setAttribute("citizen", citizen);

        if (!citizen.getHasVoted()) {
            logger.info("putting candidates into model");
            List<Candidate> candidates = candidateRepo.findAll();
            model.addAttribute("candidates", candidates);
            model.addAttribute("citizens",citizen);
            return "/performVoted";
        } else {
            return "/ThankYou";
        }

    }

    @RequestMapping("/voteFor")
    public String voteFor(@RequestParam Long id, Model m,HttpSession session) {
        Voter vot = (Voter) session.getAttribute("citizen");

        if (!vot.getHasVoted()) {

            vot.setHasVoted(true);

            Candidate c = candidateRepo.findById((long) id);
            logger.info("voting for candidate "+c.getName());
            c.setNumberOfVotes(c.getNumberOfVotes() + 1);
            System.out.println(c);
            candidateRepo.save(c);
            voteRepo.save(vot);
            m.addAttribute("voting",c);
            return "voted";
        }
        return "alreadyVoted";

    }

}

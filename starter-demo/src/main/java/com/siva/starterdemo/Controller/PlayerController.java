package com.siva.starterdemo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.starterdemo.Model.Player;

@RestController
public class PlayerController {

    @Autowired
    Player defaultPlayer;
    List<Player> players = new ArrayList<>();

    @RequestMapping("/players")
    public List<Player> getAllPlayers() {
        System.out.println("IN Player controller");
        return players;
    }
}

/*
 * Daniel Martinez
 * June 12th, 2023
 * ICS3U
 * 
 * Main file to execute to run the Psychadelics on Steroids Game
*/

package MastermindFinalProject;

import MastermindFinalProject.GUI;

public class Main {
    public static void main(String[] args) {
        //create new instance of my GUI and a game
        GUI myGame = new GUI();
        myGame.newGameInstance();
    }
}
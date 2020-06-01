# README #

**Name:**	Jeffrey Ke

**Period:**	4

**Game Title:** Puck Man

## Game Proposal ##

I want to make a pac man like game. The little yellow puck-like character will be controlled with the 4 arrow keys
to navigate away from the ghosts and towards powerups as you gain points from eating the little pieces of fruit on
the map and from eating the ghosts after eating a power pellet.

Game Controls:

Arrow keys dictate movement (left arrow, move left; right arrow, move right etc)

Game Elements:

Enemies (the ghosts) will roam the map and follow you in an attempt to take you out. There will be little power pellets
scattered around the map that you can 'eat' and gain the ability to eat the enemies (much like in actual pac-man). There will
be fruits around the map that give a bonus amount of points.

How to Win:

Eat all the fruit on the map.

## Link Examples ##
Do a google search of 'pacman' and a playable form of pacman will show up.

## Teacher Response ##

**Approved**

A Pacman clone is a good choice but make sure you want to work hard because it will take hard work up front and get easier as you go.
Two things to consider when planning this game:

 - Pacman remembers your keypresses. Unless he's stuck in a corner on purpose, Pcman is always moving and he remembers both his current direction and the next direction you give him. For example, if Pacman is travelling EAST in a horizontal "hall" and the UP key is pressed, he ignores it and keeps moving EAST until NORTH opens up. Then he automatically goes NORTH because he remembers that the player most recently pressed UP. This is an important feature to implement so your Pacman doesn't get stuck on the corner of wall intersections. Effectively, while Pacman looks like he can move continuously, he is really going from grid point to gridpoint and he changes directions only when he's at an exact gridpoint location. If you allow Pacman to turn/move whenever the player pushes a new direction your gameplay will feel terrible because you'll get stuck on walls all the time.
 - Programming ghosts takes time and there are lots of kinds of ghost movement you can create. The easiest ghosts to play against are ones that move randomly and have no idea who Pacman is. The hardest ghosts to play against are ones that hunt down and chase Pacman.



## Development Journal ##

**May 26th**

Goal:  Set up Pac-Man's povement
Work accomplished:  Pac-Man moves only when the arrow keys are pressed. He stops moving once he hits a wall.

**May 27th**

Goal:  Adjust Pac-Man's movement to emulate the original game

Work accomplished:  I got Pac-Man to move only once he's at a certain position on the game-board, very similar to in the real pac-man, how he can't just turn
when he wants to. 

**May 28th**
Goal: make pac-man not bump into walls when moving

Work accomplished: Fixed up the Pacman class. Instead of having an overarching boundary check of whether pacman can move/turn based on his coordinates, I determine whether he can move based on the user input. If the user wants pacman to turn downwards, I make a check to see whether 1. He's at an 'x' coordinate where that's feasible, and 2. there isn't a wall right in front of him. If there is a wall, I tell pacman he can't move and has to wait until he can. Pacman can 'remember' what move he has to make next when the chance comes. If he can't move yet, he continues in the direction he was in. When he finally turns, his direction changes.	*forgot to make include a message about the new Ghost class in previous commit* The ghost class is very similar to the Pacman class when it comes to movement. It generates a random number, and that number is its movement. Before it can move the ghost has to check whether it can move. if it can't, it has to keep going in the same direction until it can finally turn. Added the wall class. Doesn't do anything, it's mostly used so Pacman and the ghosts don't phase through the game obstacles.	Added some demo game obstacles, and changed the game board from grid format to what the actual pac-man game board looks like. Also deleted some obselete code.	

**May 30th**
Goal: figure out why pac-man gets stuck on certain walls

Work accomplished: figured out why pac-man gets stuck: its because his height and width aren't the same. When he tries to turn a certain direction, his sprite potentially gets caught in the walls around him as he changes directions.Added all the in-game obstacles and walls. Cropped some sprites whose dimensions were too large. Also tried to make the ghosts move randomly throughout the map. Doesn't quiet work yet (they go out of bounds). Added what happens when pacman dies. When pacman dies without eating a fruit, therefore making the ghosts vulnerable, the words 'game over' display on the screen and the animation timer stops. I added the 'Gameover' class to display the 'Game Over' words. I also added the 'Fruit' class, which are the power pellets in my version of pac-man. I added some instance variables to keep track of whether the ghosts are alive and some boundary checks for their movement. I cleaned up some clutter comments in the Pacman class. I added some fruit sprites. - Implemented further the Fruit class and how it adds to the game. - When pacman eats a fruit, the ghosts become vulnerable and able to be eaten. - I also added some try-catch blocks to take care of the null pointers to the eaten fruits (the getWorld().remove(Actor a) method does not remove an actor it seems, only points it to null). - When a fruit gets eaten, it loops through all the ghosts in the game and turns them blue. - The game ends when all fruit are eaten, or pacman touches a non-blue ghost.

**May 31st**
Goal: Give the ghosts limited movement

Work accomplished: ghosts now move in random directions every animation frame and can phase through game walls but must stay in bounds. Release 1.0 Pac-Man Lite. The goal is to eat all the fruits and avoid all the ghosts. Ghosts can be defeated by eating fruits. Accounted for all exceptions when ghosts are removed from the world (but the Game still calls 'act()' on them somehow). Release 1.1 Pac-Man Lite. The ghosts can now move in random directions in each animation frame. The 'invulnerability' mode that pac-man has once he's eaten a fruit only lasts 1200 animation frames. Each time a fruit is eaten the timer resets. I also added the javadoc comments.


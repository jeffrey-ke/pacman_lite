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

## Class Design and Brainstorm ##

Put all your brainstorm ideas, strategy approaches, and class outlines here

## Development Journal ##

Every day you work, keep track of it here.

**Date (time spent)**

Goal:  What are you trying to accomplish today?

Work accomplished:  Describe what you did today and how it went.

**Date (time spent)**

Goal:  What are you trying to accomplish today?

Work accomplished:  Describe what you did today and how it went.

***
***


# Example (Delete after you've read) #

**Name:**	Happy Sparky

**Period:**	1

**Game Title:** Bomb Squad

## Game Proposal ##

I want to make an Angry Birds clone where the player shoots different powerup items at targets.  However,
I don't think handling all the physics is possible for me right now so I'll make the physics simpler and
instead have game elements such as trampolines, lava, fog, fans, etc, that modify the shot path.  I'll also
have different enemies and friendly characters you can't hit.

Game controls:

+ Mouse and buttons control your shot speed and direction
+ Arrow keys control which powerup you will launch

Game elements:

+ Simple falling physics in a gravity world
+ Stuff you hit doesn't tumble like in Angry Birds but is replaced with simpler mechanics
+ Friendly characters you must avoid hitting
	+ Some stay put where they are
	+ Others walk back and forth so you must time your shot
+ Armored enemies take two shots to kill (they drop their armor when hit first time)
+ 3 Levels followed by a Boss level
+ Trampolines - Your shot bounces off and continues farther
+ Lava - kills your shot instantly
+ Fog - your shot drops faster due to dense air
+ Fans - adds wind and modifies the direction of your shot
+ You must clear levels using a limited amount of shots

How to win:

+ Clear all levels using your limited bomb supply
+ I might have a star scoring system so player can try for a perfect score

## Link Examples ##
Provide links to examples of your game idea.  This can be a playable online game, screenshots, YouTube videos of gameplay, etc.

+ [Angry Birds](https://www.youtube.com/watch?v=aiiQ8btusrs) My original inspiration
+ [Tiny Empire](http://www.freewebarcade.com/game/tiny-empire/) I love this!  I want to make something like this version!

## Teacher Response ##

**Approved!**

Love your game plan!  Unless your boss level is truly awesome, it would be better to focus on having more
levels that add progressive game play twists, just like the real Angry Birds game has.  Maybe introduce a
new game element with each level and then have a few levels that take some thinking and replaying to beat.

Also, you haven't addressed how you'll hit multiple enemies.  Is it one shot per enemy or can a single shot
hit multiple enemies?  If so, how would that work?

## Class Design and Brainstorm ##

Put all your brainstorm ideas, strategy approaches, and class outlines here

## Development Journal ##

**Monday May 18 (4 hours)**

Goal:  Make a raw demo of my cannon firing mechanics.  When I click the mouse, I want a cannonball to be
       launched with its initial speed and angle determined by how far away the mouse is from the cannon.

Work accomplished:  My strategy of having the game controller listen for mouse clicks worked.  When the
         	        mouse is clicked, I find the distance from the mouse to the cannon and based on that
					I create a new cannonball object with the right initial speed and direction.  It flies
					through the air and is removed from the world once it goes out of view.

**Tuesday May 19 (1 hour)**

Goal:  I want the cannon to rotate so it points toward (follows) the mouse.

Work accomplished:  I got this working pretty quickly so I also tried to add a parabolic path showing where
the cannonball would travel when fired.  I honestly have no idea how to do this so I'm going to have to think
of a strategy that will actually work.  I spent all my time looking through APIs and looking at how to draw
parabolas on the Internet but nothing helped.  Maybe I should switch to displaying a "power meter" and show
the current angle as text on the screen.
Dragon - Test lets see what some of these options do.

Does anyone have an idea for the theme for the enemies? (monsters/militia/alien/fantasy/horror..Chuck Norris...ect)
We have a wall, if they break the wall is it instant lose?
Or do they still need to reach an objective on the other side?

We should plan for the screen size to be atleast 1024x768, We can do larger if you guys want. I couldn't get the picture.scale function working right on my drone.png. So I scaled it down in GIMP and added a copy here.

Recommmended: Edit this file to see it wrapped/formatted correctly (-.-)

Also, the file history that github keeps is sweet... look back on this readme now lol...

Michael: yeah this is pretty neat. 

---Started Looking At A couple different options for classes, copied source code thus far into the google doc.---
---

Dragon: Checked it out. Nice work, its looking good. I am under the weather today, got up and felt like crap soo I slept half the day away. There are a few more classes I was thinking about as ways to break the program down, but I will check it out tonight. 

Like having a dedicated window class that is in-charge of creating the canvas/world/window and sorting draw of the background, ui, and foreground. To layer things correctly. 

Then have it use  toySoldier.getPic() with a for-each loop to pull images into the window class. (And Tower.getPic()).
Otherwise we may have issues with layering. :) (We could probably put them into an arrayList for ease of use. Allowing for an easier time making the for-each loop in window)(Another thought: Could we make the arrayList into a list of turtle that would be able to include all of these foreground objects? since they all extend turtle... it maybe possible?)

I was thinking about a damagecalc class but I think the damages are basic enough to handle them in the units. 

Had some other ideas that I was trying to express through psuedo-code but, I can't express them correctly at the moment. Will be back on tonight to check it out, going to see black panther tonight. hype! hype! 

# MarsRover  
To start the program, go to the Start Program class and run the main method.  
The program accepts as input the size of the plateau (integer) X * Y. Coordinate reference point 0 0.  
The size of the board is set once, the dimensions cannot be less than or equal to 0.  
The next line specifies the initial coordinates of the rover (integer) and the primary direction of movement (N - north, E - east, S - south, W - West).  
The values are separated by a space, must contain two numbers and a letter ("1 1 S" is correct). The next line is the path that the rover should take.  
Commands to execute:  
L - turn left without movement (N -> W; W-> S; S -> E; E->N),  
R - turn right without movement (N -> E; E-> S; S->W; W->N),  
M - step to the next cell without changing the direction of movement (1 1 N -> M -> 1 2 N; 1 1 S -> M -> 1 0 S; 1 1 E -> M -> 2 1 E; 1 1 W -> M -> 0 1 W).  
The route command is accepted as a single line without spaces (correct LLMRRML; correct - " "; incorrect - L L MRR)  
If the route line is empty, the rover does not change its position.  
To move to the next rover, repeat the operations that set the starting point and route.  
  
Commands are set by entering values through the terminal, reading occurs using a loop.hasNext(). To start calculations, after the last line, press ctrl + D (windows) or EOF in UNIX.  
  
The output values are displayed in the console, representing the coordinates of the rover and the direction of its movement (for example: 3 6 S).  

If the rover at the end point is outside the plateau, a corresponding message will be displayed and the coordinates of the finish point will not be displayed. (It is allowed for the rover to go beyond the plateau during the calculation, if the endpoint is inside).  
  
Examples of correct input of initial values for one rover:  
4 7  
2 4 S  
LLRMMRSR  
  
Examples of correct input of initial values for several rovers:  
23 43  
12 32 E  
MMLRRLMLMRM  
2 11 S  
RMLL  
3 15 W  
  
19 4 N  
LL  
  
After entering the route, it is mandatory to switch to a new line "\n"  


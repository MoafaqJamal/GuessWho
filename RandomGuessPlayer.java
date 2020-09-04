import java.io.*;
import java.util.*;

/**
 * Random guessing player.
 * This player is for task B.
 *
 * You may implement/extend other interfaces or classes, but ensure ultimately
 * that this class implements the Player interface (directly or indirectly).
 */
public class RandomGuessPlayer implements Player
{

    /**
     * Loads the game configuration from gameFilename, and also store the chosen
     * person.
     *
     * @param gameFilename Filename of game configuration.
     * @param chosenName Name of the chosen person for this player.
     * @throws IOException If there are IO issues with loading of gameFilename.
     *    Note you can handle IOException within the constructor and remove
     *    the "throws IOException" method specification, but make sure your
     *    implementation exits gracefully if an IOException is thrown.
     */

    // storage for the selection choice, choice data is store in the String value (format of Attribute,Value).
    protected HashMap<Integer, String> choiceMap;
    // storage for opponent player guess
    protected HashMap<Integer, Player> playerOpponent;
    // storage on hand player info 
    protected Player playerHold; 

    public RandomGuessPlayer(String gameFilename, String chosenName)
        throws IOException
    {
        // initialize of the storage
        choiceMap = new HashMap<Integer, String>();
        playerOpponent = new HashMap<Integer, Player>();

        Player player = null;

        try {
            // loading info from the game1.config file  
            BufferedReader assignedReader = new BufferedReader(new FileReader(gameFilename));

            String line = assignedReader.readLine();
            
            // load the info into the storage
            while (line != null) {
                // split the data
                String[] fields = line.split(" ");

                if (fields[0].equals("hairLength")) { // process for hair length data 
                    if (player == null) { // process for choice data
                        for (int i = 1; i < fields.length; i++) {   
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    } 
                    else { // process for player data
                        player.setHairLength(fields[1]);
                    }
                }
                else if (fields[0].equals("glasses")) { // process for glasses data
                    if (player == null) { // process for choice data
                        for (int i = 1; i < fields.length; i++) {
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    }
                    else { // process for player data
                        player.setGlasses(fields[1]);
                    }
                }
                else if (fields[0].equals("facialHair")) { // process for facial hair data
                    if (player == null) {  // process for choice data
                        for (int i = 1; i < fields.length; i++) {
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    }
                    else { // process for player data
                        player.setFacialHair(fields[1]);
                    }
                }
                else if (fields[0].equals("eyeColor")) { // process for eye color data
                    if (player == null) { // process for choice data
                        for (int i = 1; i < fields.length; i++) {
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    }
                    else { // process for player data
                        player.setEyeColor(fields[1]);
                    }
                }
                else if (fields[0].equals("pimples")) { // process for pimples data
                    if (player == null) { // process for choice data
                        for (int i = 1; i < fields.length; i++) {
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    }
                    else { // process for player data
                        player.setPimples(fields[1]);
                    }
                }
                else if (fields[0].equals("hat")) { // process for hat data
                    if (player == null) { // process for choice data
                        for (int i = 1; i < fields.length; i++) {
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    }
                    else { // process for player data
                        player.setHat(fields[1]);
                    }
                }
                else if (fields[0].equals("hairColor")) { // process for hair Color data
                    if (player == null) { // process for choice data
                        for (int i = 1; i < fields.length; i++) {
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    }
                    else { // process for player data
                        player.setHairColor(fields[1]);
                    }
                }
                else if (fields[0].equals("noseShape")) { // process for nose Shape data
                    if (player == null) { // process for choice data
                        for (int i = 1; i < fields.length; i++) {
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    }
                    else { // process for player data
                        player.setNoseShape(fields[1]);
                    }
                }
                else if (fields[0].equals("faceShape")) { // process for face shape data
                    if (player == null) { // process for choice data
                        for (int i = 1; i < fields.length; i++) {
                            int mapNo = choiceMap.size() + 1;
                            choiceMap.put(mapNo,fields[0]+","+fields[i]);
                        }
                    }
                    else { // process for player data
                        player.setFaceShape(fields[1]);
                    }
                }
                else if (fields[0].equals("")) { // process for empty line
                    if (player == null) { // skip when non player section
                    }
                    else { // process player data
                        // store for storage of guessing opponent player list
                        int no2 = playerOpponent.size() + 1;
                        playerOpponent.put(no2,player);

                        // store holding player info
                        if (chosenName.equals(player.getName())) {
                            playerHold = player;
                        }

                        player = null;
                    }
                }
                else { // process for player name info section
                    // initialize player and set player name
                    player = new Player();
                    player.setName(fields[0]);
                }

                // get next line info
                line = assignedReader.readLine();
                
                // process for last line record 
                if (line == null) {
                    // store for storage of guessing opponent player list
                    int no2 = playerOpponent.size() + 1;
                    playerOpponent.put(no2,player);

                     // store holding player info
                    if (chosenName.equals(player.getName())) {
                        playerHold = player;
                    }

                    player = null;
                }
            }

            assignedReader.close();
        }
		catch(FileNotFoundException ex) {
			System.err.println("Missing file " + ex.getMessage() + ".");
		}
		catch(IOException ex) {
			System.err.println(ex.getMessage());
		}

    } // end of RandomGuessPlayer()


    public Guess guess() {

        Guess guess = null;
        
        if (playerOpponent.size() > 1) { // guess player attribute when the opponent player list is more than 1
            // get the random number from the choice list 
            Random rand = new Random();
            int valueR = rand.nextInt(choiceMap.size()); 
            
            Iterator<Map.Entry<Integer, String>> i = choiceMap.entrySet().iterator();

            int count = 0;
            
            String attribute = "";
            String value = ""; 
            
            //iterate the choice list
            while (i.hasNext()) {
                Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)i.next();
                if (count == valueR) { // pick the choice that is same as the random number
                    
                    String tempvalue = me.getValue();
                    String[] values = tempvalue.split(",");
                    
                    // get the guess attribute and sttribute's value 
                    attribute = values[0];
                    value = values[1];

                    break;    
                }
                count++;
            }
            // construct the guess data
            guess = new Guess(Guess.GuessType.Attribute, attribute, value);
        }
        else { // guess player opponent when the opponent player list is remaining 1
            Map.Entry<Integer, Player> i = playerOpponent.entrySet().iterator().next();

            // get the player info
            Player tempPlayer = i.getValue(); 
            // construct the guess data
            guess = new Guess(Guess.GuessType.Person, "", tempPlayer.getName()); 
        } 

        // placeholder, replace
        return guess;
    } // end of guess()


    public boolean answer(Guess currGuess) {

        // extract dataa from the opponent guess data
        Guess.GuessType gt = currGuess.getType();
        String attribute = currGuess.getAttribute();
        String value = currGuess.getValue();

        // reply anser
        boolean answer = false;
        
        if (gt == Guess.GuessType.Attribute) { // process on guessing attribute data
            if (attribute.equals("hairLength")) { // process for hair length data
                // process for match data
                if (value.equals(playerHold.getHairLength())) {
                    answer = true;
                }
            }
            else if (attribute.equals("glasses")) { // process for glasses data
                // process for match data
                if (value.equals(playerHold.getGlasses())) {
                    answer = true;
                }
            }
            else if (attribute.equals("facialHair")) { // process for facial hair data
                // process for match data
                if (value.equals(playerHold.getFacialHair())) {
                    answer = true;
                }
            }
            else if (attribute.equals("eyeColor")) { // process for eye color data
                // process for match data
                if (value.equals(playerHold.getEyeColor())) {
                    answer = true;
                }
            }
            else if (attribute.equals("pimples")) { // process for pimples data
                // process for match data
                if (value.equals(playerHold.getPimples())) {
                    answer = true;
                }
            }
            else if (attribute.equals("hat")) { // process for hat data
                // process for match data
                if (value.equals(playerHold.getHat())) {
                    answer = true;
                }
            }
            else if (attribute.equals("hairColor")) { // process for hair color data
                // process for match data
                if (value.equals(playerHold.getHairColor())) {
                    answer = true;
                }
            }            
            else if (attribute.equals("noseShape")) { // process for nose shape data
                // process for match data
                if (value.equals(playerHold.getNoseShape())) {
                    answer = true;
                }
            }
            else if (attribute.equals("faceShape")) { // process for face shape data
                // process for match data
                if (value.equals(playerHold.getFaceShape())) {
                    answer = true;
                }
            }  
        }
        else if (gt == Guess.GuessType.Person) {
            if (value.equals(playerHold.getName())) {
                answer = true;
            } 
        }

        // placeholder, replace
        return answer;
    } // end of answer()


	public boolean receiveAnswer(Guess currGuess, boolean answer) {

        // extract the guess data type
        Guess.GuessType gt = currGuess.getType();

        // data for game termination (true is game over, false is continue game)
        boolean result = false;

        if (gt == Guess.GuessType.Attribute) { // process for attibute guess
            // extrate attribute data from guess data 
            String attribute = currGuess.getAttribute();
            String value = currGuess.getValue();

            // construct the choice data that is match with the choice format store
            String compareValue = attribute + "," + value; 

            Iterator<Map.Entry<Integer, String>> i = choiceMap.entrySet().iterator(); 
            
            // check all the choice list
            while (i.hasNext()) {
                Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)i.next();
                
                // retrieve the choice data from the choice list 
                String tempvalue = me.getValue();
                
                if (answer == false) { // process for the incorrect answer
                    if (tempvalue.equals(compareValue)) {
                        i.remove();
                        // early termination if possible
                        break;
                    }
                }
                else { // process for correct answer
                    // remove the whole attribute group data from the correct guess attribute data   
                    String[] values = tempvalue.split(",");
                    
                    if (attribute.equals(values[0])) {
                        i.remove();
                    }    
                }                
            }

            Iterator<Map.Entry<Integer, Player>> j = playerOpponent.entrySet().iterator();

            // check on the opponent player list
            while (j.hasNext()) {
                Map.Entry<Integer, Player> ne = (Map.Entry<Integer, Player>)j.next();
                
                Player tempPlayer = ne.getValue();
                    
                if (attribute.equals("hairLength")) { // process for hair length data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getHairLength())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getHairLength())) {
                            j.remove();
                        }                        
                    }
                }
                else if (attribute.equals("glasses")) { // process for glasses data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getGlasses())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getGlasses())) {
                            j.remove();
                        }                        
                    }
                }
                else if (attribute.equals("facialHair")) { // process for facial hair data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getFacialHair())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getFacialHair())) {
                            j.remove();
                        }                        
                    }
                }
                else if (attribute.equals("eyeColor")) { // process for eye color data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getEyeColor())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getEyeColor())) {
                            j.remove();
                        }                        
                    }
                }
                else if (attribute.equals("pimples")) { // process for pimples data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getPimples())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getPimples())) {
                            j.remove();
                        }                        
                    }
                }
                else if (attribute.equals("hat")) { // process for hat data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getHat())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getHat())) {
                            j.remove();
                        }                        
                    }
                }
                else if (attribute.equals("hairColor")) { // process for hair color data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getHairColor())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getHairColor())) {
                            j.remove();
                        }                        
                    }
                }            
                else if (attribute.equals("noseShape")) { // process for nose shape data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getNoseShape())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getNoseShape())) {
                            j.remove();
                        }                        
                    }
                }
                else if (attribute.equals("faceShape")) { // process for face shape data
                    if (answer == false) { // process for the incorrect answer
                        // remove loaded player that is having the same attribute's value
                        if (value.equals(tempPlayer.getFaceShape())) {
                            j.remove();
                        }
                    }
                    else { // process for the correct answer
                        // remove loaded player that is not having the same attribute's value
                        if (!value.equals(tempPlayer.getFaceShape())) {
                            j.remove();
                        }                        
                    }
                }                                        
            }
        }
        else if (gt == Guess.GuessType.Person) {
            // process on the correct guessing on the player
            if (answer == true) {
                result = true;
            }
        }

        // placeholder, replace
        return result;
    } // end of receiveAnswer()

    // player data structure
    public class Player {
        protected String name;
        protected String hairLength;
        protected String glasses;
        protected String facialHair;
        protected String eyeColor;
        protected String pimples;
        protected String hat;
        protected String hairColor;
        protected String noseShape;
        protected String faceShape;

        public Player() {
            this.name = "-";
            this.hairLength = "-";
            this.glasses = "-";
            this.facialHair = "-";
            this.eyeColor = "-";
            this.pimples = "-";
            this.hat = "-";
            this.hairColor = "-";
            this.noseShape = "-";
            this.faceShape = "-";            
        }

        public String getName() {
            return this.name;
        } 

        public void setName(String name) {
            this.name = name;
        }
        
        public String getHairLength() {
            return this.hairLength;
        } 

        public void setHairLength(String hairLength) {
            this.hairLength = hairLength;
        }

        public String getGlasses() {
            return this.glasses;
        } 

        public void setGlasses(String glasses) {
            this.glasses = glasses;
        }

        public String getFacialHair() {
            return this.facialHair;
        } 

        public void setFacialHair(String facialHair) {
            this.facialHair = facialHair;
        }
        
        public String getEyeColor() {
            return this.eyeColor;
        } 

        public void setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
        }

        public String getPimples() {
            return this.pimples;
        } 

        public void setPimples(String pimples) {
            this.pimples = pimples;
        }

        public String getHat() {
            return this.hat;
        } 

        public void setHat(String hat) {
            this.hat = hat;
        }

        public String getHairColor() {
            return this.hairColor;
        } 

        public void setHairColor(String hairColor) {
            this.hairColor = hairColor;
        } 

        public String getNoseShape() {
            return this.noseShape;
        } 

        public void setNoseShape(String noseShape) {
            this.noseShape = noseShape;
        } 

        public String getFaceShape() {
            return this.faceShape;
        } 

        public void setFaceShape(String faceShape) {
            this.faceShape = faceShape;
        } 

        public String toString() {
            String value = "[";
            value = value + "name:" + this.name;
            value = value + ", hairLength:" + this.hairLength;
            value = value + ", glasses:" + this.glasses;
            value = value + ", facialHair:" + this.facialHair;
            value = value + ", eyeColor:" + this.eyeColor;
            value = value + ", pimples:" + this.pimples;
            value = value + ", hat:" + this.hat;
            value = value + ", hairColor:" + this.hairColor;
            value = value + ", noseShape:" + this.noseShape;
            value = value + ", faceShape:" + this.faceShape;
            value = value + "]";
            return value;
        }
    }

} // end of class RandomGuessPlayer

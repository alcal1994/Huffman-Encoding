public class CharFreq {

	//This instance variable to hold the character
		private char character;
		
		// This stores the frequency of particular character
		private int frequency = 0;

		/**
		 * This is the constructor of the CharacterFrequency class to initialize the CharacterFrequency object
		 * @param character : Character for which object needs to be initialized
		 * @param frequency : Frequency of the character
		 */
		public CharFreq(char character, int frequency) {
			//call the setCharacter method to set the character
			setCharacter(character);
			
			//Call the setFrequency method to set the frequency
			setFrequency(frequency);
		}

		/**
		 * This is the getter method for the character instance variable
		 * @return : return the character instance variable 
		 */
		public char getCharacter() {
			//Return character
			return character;
		}

		/**
		 * This is the setter method to set the character instance variable
		 * @param character : character which needs to be set
		 */
		public void setCharacter(char character) {
			
			//Set the character instance variable with the value received in parameter
			this.character = character;
		}

		/**
		 * This is the getter method of Frequency instance variable 
		 * @return : return the frequency instance variable
		 */
		public int getFrequency() {
			
			//Return the frequency
			return frequency;
		}

		/**
		 * This is the setter method of the frequency instance variable
		 * @param frequency : frequency which needs to be set
		 */
		public void setFrequency(int frequency) {
			
			//Set the frequency instance variable with the value received in parameter
			this.frequency = frequency;
		}

		/**
		 * This method used to increase the frequency of a character by 1
		 */
		public void increment() {
			
			//Increase the frequency by 1
			frequency++;
		}

		
		/**
		 * This method is for comparing two CharacterFrequency Objects
		 * @param objectToCompare : Object which needs to be compared
		 * @return L Return true if objects are same otherwise return false
		 */
		public boolean equals(CharFreq objectToCompare) {  
			// If both object are same then return True
			if (this == objectToCompare)
			{
				return true;
			
			} 
			//If both object have same character then return true
			else if (this.character == objectToCompare.character) 
			{
				return true;
			}
			//If both do not have same character then return false
			else 
			{
				return false;
			}
		}

		/**
		 * This method used convert the instance variables of this class in the formatted string to show the object detail in better way
		 * @return : Return the string
		 */
		public String toString() {
			//Format the output string
			String str = String.format("%-6s", Character.toString(character)+"("+(int)character+")");
			return str+"\t" + frequency;
		}

}
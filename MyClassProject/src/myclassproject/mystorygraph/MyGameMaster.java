package myclassproject.mystorygraph;

import java.lang.reflect.Field;

//Daron
public class MyGameMaster {
	//Values for the game
	public static final int MAX_VALUE = 100;
	
	public static final int INIT_VALUE = 0;
	
	public static final int MIN_VALUE = -100;
	
	private static int PeasantReputation = INIT_VALUE;
	
	private static int NobelReputation = INIT_VALUE;
	
	private static int MerchantReputation = INIT_VALUE;
	
	private static int DiplomaticReputation = INIT_VALUE;
	
	private static int MilitaryStrength = INIT_VALUE;
	
	private static int EconomicStrength = INIT_VALUE;
	
	private static int Stability = INIT_VALUE;
	
	public static void increment_value(String value_name, int increment){
		 try {
			 Field value_to_be_incremented = MyGameMaster.class.getDeclaredField(value_name);
			 value_to_be_incremented.setAccessible(true);
			 value_to_be_incremented.set(MyGameMaster.class,value_to_be_incremented.getInt(value_to_be_incremented) + increment);
			 
			 
		 } catch (NoSuchFieldException e) {
			 e.printStackTrace();
		 }

	}
	
	
	
}

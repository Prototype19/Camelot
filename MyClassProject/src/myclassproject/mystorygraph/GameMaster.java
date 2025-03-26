package myclassproject.mystorygraph;

import java.lang.reflect.Field;

public class GameMaster {
	private static final int MAX_VALUE = 100;
	private static final int INIT_VALUE = 0;
	private static final int MIN_VALUE = -100;
	private static int PeasantReputation = INIT_VALUE;
	private static int NobelReputation = INIT_VALUE;
	private static int MerchantReputation = INIT_VALUE;
	private static int DiplomaticReputation = INIT_VALUE;
	private static int MilitaryStrength = INIT_VALUE;
	private static int EconomicStrength = INIT_VALUE;
	private static int Stability = INIT_VALUE;
	
	public static void incrementValue(String field_name, int increment) {
		try {
			Field field = GameMaster.class.getDeclaredField(field_name);
			field.setAccessible(true); // Allow access to private fields
            field.set(null, field.getInt(null) + increment);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

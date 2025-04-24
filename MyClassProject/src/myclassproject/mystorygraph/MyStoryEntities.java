package myclassproject.mystorygraph;

import com.entities.Characters;
import com.entities.Furniture;
import com.entities.Item;
import com.entities.Place;
import com.enums.BodyTypes;
import com.enums.Clothing;
import com.enums.Colors;
import com.enums.FurnitureTypes;
import com.enums.HairStyle;
import com.enums.ItemTypes;
import com.enums.PlaceTypes;

public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	
	// Daron
	public static final Characters player = new Characters("Player", BodyTypes.H, Clothing.King, HairStyle.Spiky, Colors.Black, 6);
	public static final Characters peasantJohn = new Characters("Peasant John", BodyTypes.F, Clothing.Peasant, HairStyle.Bald, Colors.Brown, 4);
	public static final Characters noble1 = new Characters("Sir Cibo", BodyTypes.D, Clothing.Noble, HairStyle.Long, Colors.Blonde, 5);
	public static final Place bedroom = new Place("Home", PlaceTypes.CastleBedroom);
	public static final Place greatHall = new Place("Hall", PlaceTypes.GreatHall);
	public static final Place hallway = new Place("Hallway", PlaceTypes.Hallway);
	public static final Place outside = new Place("Outside", PlaceTypes.ForestPath);
	public static final Furniture bedroomDoor = new Furniture(bedroom, FurnitureTypes.Door);
	public static final Furniture greatHallDoor = new Furniture(greatHall, FurnitureTypes.Gate);
	public static final Furniture hallwayDoor = new Furniture(hallway, FurnitureTypes.Door);
	public static final Furniture hallwayBackDoor = new Furniture(hallway, FurnitureTypes.Door);
	public static final Characters peasant1 = new Characters("Peasant1", BodyTypes.C, Clothing.Peasant, HairStyle.Straight, Colors.Blonde, 3);
	public static final Characters peasant2 = new Characters("Peasant2", BodyTypes.A, Clothing.Peasant, HairStyle.Short, Colors.Blonde, 2);
	public static final Item torch = new Item("LitTorch", ItemTypes.LitTorch);
	public static final Item hammer = new Item("Hammer", ItemTypes.Hammer);

}

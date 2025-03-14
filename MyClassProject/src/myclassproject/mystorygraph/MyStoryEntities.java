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
	public static final Characters peasant1 = new Characters("Peasant John", BodyTypes.F, Clothing.Peasant, HairStyle.Bald, Colors.Black, 4);
	public static final Place cottage = new Place("Home", PlaceTypes.Cottage);
	public static final Place town = new Place("Town", PlaceTypes.City);
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Furniture cottageDoor = new Furniture(cottage, FurnitureTypes.Door);
	public static final Furniture table = new Furniture(cottage, FurnitureTypes.Table);
	public static final Furniture chair = new Furniture(cottage, FurnitureTypes.Chair);
	public static final Furniture cityDoor = new Furniture(town, FurnitureTypes.RedHouseDoor);
	public static final Furniture cityExit = new Furniture(town, FurnitureTypes.NorthEnd);
}

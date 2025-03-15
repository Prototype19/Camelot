package myclassproject.mystorygraph;

import java.util.List;

//Daron - Added three imports

import com.storygraph.*;

import com.sequences.*;

import com.actions.*;

import static myclassproject.mystorygraph.MyStoryEntities.*;


public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	//Daron 
	@BuilderMethod
	public void rootActions() {
		var root = get(MyNodeLabels.root.toString());

		root
		.add(new CreateAll(List.of(bedroom, greatHall, peasantJohn, noble1)))
		.add(new CreateCharacterSequence(peasantJohn))
		.add(new SetPosition(peasantJohn, greatHall, "LeftFoyer"))
		.add(new CreateCharacterSequence(noble1))
		.add(new SetPosition(noble1, greatHall, "RightFoyer"))
		.add(new CreateCharacterSequence(player))
		.add(new SetPosition(player, bedroom))
		.add(new SetCameraFocus(player))
		.add(new ShowMenu());
	}
	
	public void atBedroomActions() {
		var atBedroom = get(MyNodeLabels.atBedroom.toString());
		
		atBedroom
		.add(new HideMenu())
		.add(new EnableInput());
	}
	
	
	


}

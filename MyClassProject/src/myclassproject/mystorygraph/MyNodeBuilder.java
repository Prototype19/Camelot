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
	//Daron - Added root  
	@BuilderMethod
	public void rootActions() {
		//Example:
		//var root = get(NodeLabels.root.toString());
		//root.add(new CreateAll(List.of(cottage, town, sword)));
		var root = get(MyNodeLabels.root.toString());

		root.add(new CreateAll(List.of(cottage, town, sword))).add(new CreateCharacterSequence(peasant1))
		.add(new CreateCharacterSequence(player)).add(new SetPosition(peasant1, cottage, "Chest"))
		.add(new SetPosition(player, cottage)).add(new Face(peasant1, player)).add(new Draw(peasant1, sword))
		.add(new SetCameraFocus(player)).add(new ShowMenu());
	}
}

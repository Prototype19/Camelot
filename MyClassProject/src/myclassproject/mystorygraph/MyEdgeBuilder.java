package myclassproject.mystorygraph;

import static myclassproject.mystorygraph.MyStoryEntities.*;


import java.util.List;

import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.BuilderMethod;
import com.storygraph.Edge;
import com.storygraph.NodeBuilder;
import com.storygraph.Node;




public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method should add the edges of the node one by one. 
	 * These methods must have a BuilderMethod annotation.
	 */
	
	// Daron
	@BuilderMethod
	public void rootEdges() {

		var root = get(MyNodeLabels.root.toString());
		var startChoice = new MenuChoice(MenuChoice.Options.Start);
		//var creditsChoice = new MenuChoice(MenuChoice.Options.Credits);
		var atBedroomNode = get(MyNodeLabels.atBedroom.toString());
		root.add(new Edge(startChoice, atBedroomNode));
		//root.add(new Edge(creditsChoice, nextNode));
		
	}
	@BuilderMethod
	public void atBedroomEdges() {
		var atBedroomNode = get(MyNodeLabels.atBedroom.toString());
		var leavebedroom = new PlayerInteraction(MyChoiceLabels.LeaveBedroom.toString(), bedroomDoor, Icons.exit, "Go to Throne Room");
		var chooseAudienceNode = get(MyNodeLabels.ChooseAudience.toString());
		atBedroomNode.add(new Edge(leavebedroom, chooseAudienceNode));
	}
	
	@BuilderMethod
	public void ChooseAudienceEdges() {
		var chooseAudienceNode = get(MyNodeLabels.ChooseAudience.toString());
		var chooseJohn = new PlayerInteraction(MyChoiceLabels.TalkToJohn.toString(), peasantJohn, Icons.talk,
				"Talk to the Peasant John.");
		var chooseNobles = new PlayerInteraction(MyChoiceLabels.TalkToNobles.toString(), noble1, Icons.talk,
				"Talk to the Quarelling Nobles.");
		var JohnDialogNode = get(MyNodeLabels.JohnDialog.toString());
		var NobleQuarrelDialog = get(MyNodeLabels.NobleQuarrelDialog.toString());
		chooseAudienceNode.add(new Edge(chooseJohn, JohnDialogNode));
		chooseAudienceNode.add(new Edge(chooseNobles, NobleQuarrelDialog));
	}
	
	@BuilderMethod
	public void JohnDialogEdges() { 
		var johnDialogNode = get(MyNodeLabels.JohnDialog.toString());
		var acceptJohn = new DialogChoice("I will!");
		var rejectJohn = new DialogChoice("I refuse!!");
		var johnDialogAcceptNode = get(MyNodeLabels.JohnDialogAccept.toString());
		var johnDialogRejectNode = get(MyNodeLabels.JohnDialogReject.toString());
		johnDialogNode.add(new Edge(acceptJohn,johnDialogAcceptNode));
		johnDialogNode.add(new Edge(rejectJohn, johnDialogRejectNode));
	}
	
	
	
}

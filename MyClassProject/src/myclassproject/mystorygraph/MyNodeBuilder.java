package myclassproject.mystorygraph;

import java.util.List;

//Daron - Added three imports

import com.storygraph.*;

import com.sequences.*;

import com.actions.*;
import com.actions.utility.*;



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
		
		.add(new CreateAll(List.of(bedroom, greatHall)))
		.add(new CreateCharacterSequence(peasantJohn))
		.add(new SetPosition(peasantJohn, greatHall, "LeftFoyer"))
		.add(new CreateCharacterSequence(noble1))
		.add(new SetPosition(noble1, greatHall, "RightFoyer"))
		.add(new CreateCharacterSequence(player))
		.add(new SetPosition(player, bedroom))
		.add(new SetCameraFocus(player))
		.add(new ShowMenu());
	}
	@BuilderMethod
	public void introAction() {
		var intro = get(MyNodeLabels.intro.toString());
		
		intro
		.add(new SetNarration("Your father and king has passed away under susipious cirumstances. Now you the first born prince will inherit the vacant throne. As King responbility will fall on you to lead your subjects house and the whole of the Kingdom of Forgia to prosperity. This will not be an easy feat by any means. Just beyond the horizon famines raiders and optimistic nobles threaten the longevity of your rein. Fear not! While unexperienced your will and stewdness should be enough for you to be prepared for whatever challenge you face. Long live the King!"))
		.add(new ShowNarration());
		
	}
	@BuilderMethod
	public void atBedroomActions() {
		var atBedroom = get(MyNodeLabels.atBedroom.toString());
		
		atBedroom
		.add(new HideNarration())
		.add(new HideMenu())
		.add(new EnableInput());
	}
	@BuilderMethod
	public void chooseAudienceActions() {
		var chooseAudience = get(MyNodeLabels.ChooseAudience.toString()); 

		chooseAudience
		.add(new DisableInput())
		.add(new Exit(player, bedroomDoor, true))
		.add(new Enter(player, greatHallDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void johnDialongActions() {
		var johnDialong = get(MyNodeLabels.JohnDialog.toString());
		
		johnDialong
		.add(new DialogSequence(player, peasantJohn, List.of("My lord! my region's grain storehouse is beginning to fall apart. I beg of you on behalf of my fellow commoners, please fund the construction of a new storehouse. Otherwise we risk all of our grain to rot and starving in the winter."),
				List.of("I will!", "I refuse!")));
	}
	
	@BuilderMethod
	public void nobleQuarrelDialogActions() {
		var nobleQuarrelDialog = get(MyNodeLabels.NobleQuarrelDialog.toString());
		
		nobleQuarrelDialog
		.add(new DialogSequence(player, peasantJohn, List.of("My liege! me and my peer have been quarreling over the borders of our newly inherited lands. Particularly there's one village whose ownership is 'vague'. Me and the fellow noble petition for you to resolve this issue."),
				List.of("The village's rent will be split equally between you two.", "I will take the village for myself!")));
	}
	
	//Kyler
	@BuilderMethod
	public void johnDialogAcceptActions() {
		var johnDialogAccept = get(MyNodeLabels.JohnDialogAccept.toString());
		
		johnDialogAccept
		.add(new SetDialog("May god bless your soul."))
		.add(new HideDialog())
		.add(new SetNarration("The peasants now see you as generious"))
		.add(new ShowNarration())
		.add(new Dance(peasantJohn))
		.add(new Wait(3))
		.add(new HideNarration());
		//.add(new AdjustReputation(10));
		
	}
	
	@BuilderMethod
	public void johnDialogRejectActions() {
		var johnDialogReject = get(MyNodeLabels.JohnDialogReject.toString());
		
		johnDialogReject
		.add(new SetDialog("You can't..."))
		.add(new HideDialog())
		.add(new SetNarration("The peasants now resent you"))
		.add(new ShowNarration())
		.add(new Wait(3))
		.add(new HideNarration());
		//.add(new PlaySound(Cry1, peasantJohn,true))
		//.add(new AdjustReputation(-10))

	}


		
			
	
	


}

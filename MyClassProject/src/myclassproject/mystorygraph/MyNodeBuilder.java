package myclassproject.mystorygraph;

import java.util.List;

//Daron - Added three imports

import com.storygraph.*;

import com.sequences.*;

import com.actions.*;
import com.actions.Wait;
import com.actions.SetCameraMode.Mode;

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
	@BuilderMethod
	public void atBedroomActions() {
		var atBedroom = get(MyNodeLabels.atBedroom.toString());
		
		atBedroom
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
		.add(new DialogSequence(player, peasantJohn, List.of("My lord, my region's grain storehouse is beginning to fall apart. I beg of you on behalf of my fellow commoners, please fund the construction of a new storehouse. Otherwise we risk all of our grain to rot and starving in the winter."),
				List.of("I will!", "I refuse!")));
	}
	
	@BuilderMethod
	public void nobleQuarrelDialogActions() {
		var nobleQuarrelDialog = get(MyNodeLabels.NobleQuarrelDialog.toString());
		
		nobleQuarrelDialog
		.add(new DialogSequence(player, peasantJohn, List.of("My liege, me and my peer have been quarreling over the borders of our newly inherited lands. Particularly there's one village whose ownership is 'vague'. Me and the fellow noble petition for you to resolve this issue."),
				List.of("The village's rent will be split equally between you two.", "I will take the village for myself!")));
	}
	
	//Kyler
	@BuilderMethod
	public void johnDialogAcceptActions() {
		var johnDialogAccept = get(MyNodeLabels.JohnDialogAccept.toString());
		
		johnDialogAccept
		.add(new HideDialog())
		.add(new SetCameraFocus(peasantJohn))
		.add(new SetCameraMode(Mode.focus))
		.add(new Dance(peasantJohn))
		.add(new Wait(3))
		.add(new SetCameraFocus(player))
		.add(new SetCameraMode(Mode.follow));
		//.add(new ShowNotification("The peasants cheer for you and your generous gesture!"))
		//.add(new AdjustReputation(player, peasantJohn, 10)) 
		//.add(new ContinueStory());
		
	}
	
	@BuilderMethod
	public void johnDialogRejectActions() {
		var johnDialogReject = get(MyNodeLabels.JohnDialogReject.toString());
		
		johnDialogReject
		.add(new HideDialog())
		.add(new SetCameraFocus(peasantJohn))
		.add(new SetCameraMode(Mode.focus))
		//.add(new PlaySound(Cry1, peasantJohn,true))
		.add(new Wait(3))
		.add(new SetCameraFocus(player))
		.add(new SetCameraMode(Mode.follow));
		//.add(new ShowNotification("The peasants are disappointed."))
		//.add(new AdjustReputation(player, peasantJohn, -10))
		//.add(new ContinueStory());
	}


		
			
	
	


}

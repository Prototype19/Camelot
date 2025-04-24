package myclassproject.mystorygraph;

import java.util.List;

//Daron - Added three imports

import com.storygraph.*;

import com.sequences.*;

import com.actions.*;
import com.actions.utility.*;



import static myclassproject.mystorygraph.MyStoryEntities.*;
import static myclassproject.questexample.QuestStoryEntities.bandit;
import static myclassproject.questexample.QuestStoryEntities.sword;




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
		
		.add(new CreateAll(List.of(bedroom, greatHall,hallway,outside)))
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
		.add(new NarrationSequence("Your father and king has passed away under susipious cirumstances. "
				+ "Now you the first born prince will inherit the vacant throne. "
				+ "As King responbility will fall on you to lead your subjects house and the whole of the Kingdom of Forgia to prosperity. "
				+ "This will not be an easy feat by any means. "
				+ "Just beyond the horizon famines raiders and optimistic nobles threaten the longevity of your rein. Fear not! "
				+ "While unexperienced your will and stewdness should be enough for you to be prepared for whatever challenge you face. "
				+ "Long live the King!"));

		
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
	public void hallwayinActions() {
		var hallwayin = get(MyNodeLabels.hallwayin.toString());
		
		hallwayin
		.add(new DisableInput())
		.add(new Exit(player, bedroomDoor, true))
		.add(new Enter(player, hallwayDoor, true))
		.add(new EnableInput());
	}
	
	@BuilderMethod
	public void chooseAudienceActions() {
		var chooseAudience = get(MyNodeLabels.ChooseAudience.toString()); 

		chooseAudience
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, greatHallDoor, true))
		.add(new EnableInput());
	}
	
	
		@BuilderMethod
		public void johnDialongActions() {
			var johnDialong = get(MyNodeLabels.JohnDialog.toString());
			
			johnDialong
			.add(new DialogSequence(player, peasantJohn, List.of("My lord! my region's grain storehouse is beginning to fall apart. "
					+ "I beg of you on behalf of my fellow commoners, "
					+ "please fund the construction of a new storehouse. "
					+ "Otherwise we risk all of our grain to rot and starving in the winter."),
					List.of("I will!", "I refuse!")));
		}
		
		@BuilderMethod
			public void johnDialogAcceptActions() {
			var johnDialogAccept = get(MyNodeLabels.JohnDialogAccept.toString());
			
			johnDialogAccept
			.add(new HideDialog())
			.add(new SetNarration("The peasants now see you as generious"))
			.add(new ShowNarration());
			
			
		}
		@BuilderMethod
				public void chooseAudiencePostJohnAcceptActions() {
			var chooseAudiencePostJohnAccept = get(MyNodeLabels.ChooseAudiencePostJohnAccept.toString());
			chooseAudiencePostJohnAccept
			.add(new HideNarration())
			.add(new Dance(peasantJohn));
		}
		@BuilderMethod
				public void nobleQuarrelDialogPostJohnAcceptActions() {
			var nobleQuarrelDialog = get(MyNodeLabels.NobleQuarrelPostJohnAccept.toString());
			
			nobleQuarrelDialog
			.add(new DialogSequence(player, noble1, List.of("My liege! me and my peer have been quarreling over the borders of our newly inherited lands. Particularly there's one village whose ownership is 'vague'. Me and the fellow noble petition for you to resolve this issue."),
					List.of("The village's rent will be split equally between you two.", "I will take the village for myself!")));
		}
		@BuilderMethod
					public void nobleQuarrelDialogSolvedPostJohnAcceptActions() {
			var NobleQuarrelSolved = get(MyNodeLabels.NobleQuarrelSolvedPostJohnAccept.toString());
			
			NobleQuarrelSolved
			.add(new HideDialog())
			.add(new SetNarration("The nobles are satfied with your decision"))
			.add(new ShowNarration());
	
		}
		@BuilderMethod
					public void nobleQuarrelDialogTryantPostJohnAcceptActions() {
			var NobleQuarrelSolved = get(MyNodeLabels.NobleQuarrelTyrantPostJohnAccept.toString());
			
			NobleQuarrelSolved
			.add(new HideDialog())
			.add(new SetNarration("The nobles are upset with your decision"))
			.add(new ShowNarration());
		}
		@BuilderMethod
			public void johnDialogRejectActions() {
			var johnDialogReject = get(MyNodeLabels.JohnDialogReject.toString());
			
			johnDialogReject
			.add(new HideDialog())
			.add(new SetNarration("The peasants now resent you!"))
			.add(new ShowNarration());
		}
		@BuilderMethod
				public void chooseAudiencePostJohnRejectActions() {
			var chooseAudiencePostJohnReject = get(MyNodeLabels.ChooseAudiencePostJohnReject.toString());
			chooseAudiencePostJohnReject
			.add(new HideNarration());
		}
		@BuilderMethod
				public void nobleQuarrelDialogPostJohnRejectActions() {
			var nobleQuarrelDialog = get(MyNodeLabels.NobleQuarrelPostJohnReject.toString());
			
			nobleQuarrelDialog
			.add(new DialogSequence(player, noble1, List.of("My liege! me and my peer have been quarreling over the borders of our newly inherited lands. Particularly there's one village whose ownership is 'vague'. Me and the fellow noble petition for you to resolve this issue."),
					List.of("The village's rent will be split equally between you two.", "I will take the village for myself!")));
		}
		@BuilderMethod
		public void nobleQuarrelDialogSolvedPostJohnRejectActions() {
var NobleQuarrelSolved = get(MyNodeLabels.NobleQuarrelSolvedPostJohnReject.toString());

NobleQuarrelSolved
.add(new HideDialog())
.add(new SetNarration("The nobles are satfied with your decision"))
.add(new ShowNarration());

}
@BuilderMethod
		public void nobleobleQuarrelTyrantPostJohnRejectActions() {
var NobleQuarrelTyrant = get(MyNodeLabels.NobleQuarrelTyrantPostJohnReject.toString());

NobleQuarrelTyrant 
.add(new HideDialog())
.add(new SetNarration("The nobles are upset with your decision"))
.add(new ShowNarration());
}				
		@BuilderMethod
		public void nobleQuarrelDialogActions() {
			var nobleQuarrelDialog = get(MyNodeLabels.NobleQuarrelDialog.toString());
			
			nobleQuarrelDialog
			.add(new DialogSequence(player, noble1, List.of("My liege! me and my peer have been quarreling over the borders of our newly inherited lands. Particularly there's one village whose ownership is 'vague'. Me and the fellow noble petition for you to resolve this issue."),
					List.of("The village's rent will be split equally between you two.", "I will take the village for myself!")));
		}
		
		@BuilderMethod
			public void nobleQuarrelDialogSolvedActions() {
			var NobleQuarrelSolved = get(MyNodeLabels.NobleQuarrelSolved.toString());
			
			NobleQuarrelSolved
			.add(new HideDialog())
			.add(new SetNarration("The nobles are satfied with your decision"))
			.add(new ShowNarration());
			
	
			
		}
		@BuilderMethod
				public void chooseAudiencePostNobleSolvedActions() {
			var chooseAudiencePostNobleSolved = get(MyNodeLabels.ChooseAudiencePostNobleSolved.toString());
			chooseAudiencePostNobleSolved
			.add(new HideNarration())
			.add(new Dance(noble1));
		}
		@BuilderMethod
				public void johnDialongActionsPostNobleSolvedActions() {
			var johnDialong = get(MyNodeLabels.JohnDialogPostNobleSolved.toString());
			
			johnDialong
			.add(new DialogSequence(player, peasantJohn, List.of("My lord! my region's grain storehouse is beginning to fall apart. I beg of you on behalf of my fellow commoners, please fund the construction of a new storehouse. Otherwise we risk all of our grain to rot and starving in the winter."),
					List.of("I will!", "I refuse!")));
		}
		@BuilderMethod
					public void johnDialogAcceptPostNobleSolvedActions() {
			var johnDialogAccept = get(MyNodeLabels.JohnDialogAcceptPostNobleSolved.toString());
			
			johnDialogAccept
			.add(new HideDialog())
			.add(new SetNarration("The peasants now see you as generious"))
			.add(new ShowNarration());
		}
		@BuilderMethod
					public void johnDialogRejectPostNobleSolvedActions() {
			var johnDialogReject = get(MyNodeLabels.JohnDialogRejectPostNobleSolved.toString());
			
			johnDialogReject
			.add(new HideDialog())
			.add(new SetNarration("The peasants now resent you!"))
			.add(new ShowNarration());
	
	
		}
		@BuilderMethod
			public void nobleQuarrelDialogTryantActions() {
			var NobleQuarrelSolved = get(MyNodeLabels.NobleQuarrelTyrant.toString());
			
			NobleQuarrelSolved
			.add(new HideDialog())
			.add(new SetNarration("The nobles are upset with your decision"))
			.add(new ShowNarration());
		}
		@BuilderMethod
				public void chooseAudiencePostNobleTyrant() {
			var chooseAudiencePostNobleTyrant = get(MyNodeLabels.ChooseAudiencePostNobleTyrant.toString());
			chooseAudiencePostNobleTyrant
			.add(new HideNarration());
		}
		@BuilderMethod
				public void johnDialongActionsPostNobleTyrant() {
			var johnDialong = get(MyNodeLabels.JohnDialogPostNobleTyrant.toString());
			
			johnDialong
			.add(new DialogSequence(player, peasantJohn, List.of("My lord! my region's grain storehouse is beginning to fall apart. I beg of you on behalf of my fellow commoners, please fund the construction of a new storehouse. Otherwise we risk all of our grain to rot and starving in the winter."),
					List.of("I will!", "I refuse!")));
		}
		@BuilderMethod
					public void johnDialogAcceptPostNobleTyrantActions() {
			var johnDialogAccept = get(MyNodeLabels.JohnDialogAcceptPostNobleTyrant.toString());
			
			johnDialogAccept
			.add(new HideDialog())
			.add(new SetNarration("The peasants now see you as generious"))
			.add(new ShowNarration());
			
		}
		@BuilderMethod
					public void johnDialogRejectPostNobleTyrantActions() {
		var johnDialogReject = get(MyNodeLabels.JohnDialogRejectPostNobleTyrant.toString());
		
		johnDialogReject
		.add(new HideDialog())
		.add(new SetNarration("The peasants now resent you!"))
		.add(new ShowNarration());

	}
	
	//FINAL SEQUENCE
	@BuilderMethod
	public void LeavingHallPostJohnAcceptPostNobleSolvedActions() {
		var LeavingHallPostJohnAcceptPostNobleSolved = get(MyNodeLabels.LeavingHallPostJohnAcceptPostNobleSolved.toString());
		
		LeavingHallPostJohnAcceptPostNobleSolved
		.add(new HideNarration())
		.add(new Dance(peasantJohn));
	}
	@BuilderMethod
	public void LeavingHallPostJohnRejectPostNobleSolvedActions() {
		var LeavingHallPostJohnRejectPostNobleSolved = get(MyNodeLabels.LeavingHallPostJohnRejectPostNobleSolved.toString());
		
		LeavingHallPostJohnRejectPostNobleSolved
		.add(new HideNarration());
	}
	@BuilderMethod
	public void LeavingHallPostJohnAcceptPostNobleTyrantActions() {
		var LeavingHallPostJohnAcceptPostNobleTyrant = get(MyNodeLabels.LeavingHallPostJohnAcceptPostNobleTyrant.toString());
		
		LeavingHallPostJohnAcceptPostNobleTyrant
		.add(new HideNarration())
		.add(new Dance(peasantJohn));
	}
	@BuilderMethod
	public void LeavingHallPostJohnRejectPostNobleTyrantActions() {
		var LeavingHallPostJohnRejectPostNobleTyrant = get(MyNodeLabels.LeavingHallPostJohnRejectPostNobleTyrant.toString());
		
		LeavingHallPostJohnRejectPostNobleTyrant
		.add(new HideNarration());
	}
	@BuilderMethod
	public void LeavingHallPostNobleSolvedPostJohnAcceptActions() {
		var LeavingHallPostNobleSolvedPostJohnAccept = get(MyNodeLabels.LeavingHallPostNobleSolvedPostJohnAccept.toString());
		
		LeavingHallPostNobleSolvedPostJohnAccept
		.add(new HideNarration())
		.add(new Dance(noble1));
	}
	@BuilderMethod
	public void LeavingHallPostNobleTyrantPostJohnAcceptActions() {
		var LeavingHallPostNobleTyrantPostJohnAccept = get(MyNodeLabels.LeavingHallPostNobleTyrantPostJohnAccept.toString());
		
		LeavingHallPostNobleTyrantPostJohnAccept
		.add(new HideNarration());
	}
	@BuilderMethod
	public void LeavingHallPostNobleSolvedPostJohnRejectActions() {
		var LeavingHallPostNobleSolvedPostJohnReject = get(MyNodeLabels.LeavingHallPostNobleSolvedPostJohnReject.toString());
		
		LeavingHallPostNobleSolvedPostJohnReject
		.add(new HideNarration())
		.add(new Dance(noble1));
	}
	@BuilderMethod
	public void LeavingHallPostNobleTyrantPostJohnRejectActions() {
		var LeavingHallPostNobleTyrantPostJohnReject = get(MyNodeLabels.LeavingHallPostNobleTyrantPostJohnReject.toString());
		
		LeavingHallPostNobleTyrantPostJohnReject
		.add(new HideNarration());
	}


	@BuilderMethod
	public void HallwayoutPostJohnAcceptPostNobleSolvedActions() {
		var hallwayout = get(MyNodeLabels.HallwayoutPostJohnAcceptPostNobleSolved.toString());
		
		hallwayout
		.add(new DisableInput())
		.add(new Exit(player, greatHallDoor, true))
		.add(new Enter(player, hallwayBackDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void HallwayoutPostJohnRejectPostNobleSolvedActions() {
		var hallwayout = get(MyNodeLabels.HallwayoutPostJohnRejectPostNobleSolved.toString());
		
		hallwayout
		.add(new DisableInput())
		.add(new Exit(player, greatHallDoor, true))
		.add(new Enter(player, hallwayBackDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void HallwayoutPostJohnAcceptPostNobleTyrantActions() {
		var hallwayout = get(MyNodeLabels.HallwayoutPostJohnAcceptPostNobleTyrant.toString());
		
		hallwayout
		.add(new DisableInput())
		.add(new Exit(player, greatHallDoor, true))
		.add(new Enter(player, hallwayBackDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void HallwayoutPostJohnRejectPostNobleTyrantActions() {
		var hallwayout = get(MyNodeLabels.HallwayoutPostJohnRejectPostNobleTyrant.toString());
		
		hallwayout
		.add(new DisableInput())
		.add(new Exit(player, greatHallDoor, true))
		.add(new Enter(player, hallwayBackDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void HallwayoutPostNobleSolvedPostJohnAcceptActions() {
		var hallwayout = get(MyNodeLabels.HallwayoutPostNobleSolvedPostJohnAccept.toString());
		
		hallwayout
		.add(new DisableInput())
		.add(new Exit(player, greatHallDoor, true))
		.add(new Enter(player, hallwayBackDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void HallwayoutPostNobleTyrantPostJohnAcceptActions() {
		var hallwayout = get(MyNodeLabels.HallwayoutPostNobleTyrantPostJohnAccept.toString());
		
		hallwayout
		.add(new DisableInput())
		.add(new Exit(player, greatHallDoor, true))
		.add(new Enter(player, hallwayBackDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void HallwayoutPostNobleSolvedPostJohnRejectActions() {
		var hallwayout = get(MyNodeLabels.HallwayoutPostNobleSolvedPostJohnReject.toString());
		
		hallwayout
		.add(new DisableInput())
		.add(new Exit(player, greatHallDoor, true))
		.add(new Enter(player, hallwayBackDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void HallwayoutPostNobleTyrantPostJohnRejectActions() {
		var hallwayout = get(MyNodeLabels.HallwayoutPostNobleTyrantPostJohnReject.toString());
		
		hallwayout
		.add(new DisableInput())
		.add(new Exit(player, greatHallDoor, true))
		.add(new Enter(player, hallwayBackDoor, true))
		.add(new EnableInput());
	}
	//Bedtime
	@BuilderMethod
	public void BedtimePostJohnAcceptPostNobleSolvedActions() {
		var bedtime = get(MyNodeLabels.BedtimePostJohnAcceptPostNobleSolved.toString());
		
		bedtime
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, bedroomDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void BedtimePostJohnRejectPostNobleSolvedActions() {
		var bedtime = get(MyNodeLabels.BedtimePostJohnRejectPostNobleSolved.toString());
		
		bedtime
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, bedroomDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void BedtimePostJohnAcceptPostNobleTyrantActions() {
		var bedtime = get(MyNodeLabels.BedtimePostJohnAcceptPostNobleTyrant.toString());
		
		bedtime
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, bedroomDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void BedtimePostJohnRejectPostNobleTyrantActions() {
		var bedtime = get(MyNodeLabels.BedtimePostJohnRejectPostNobleTyrant.toString());
		
		bedtime
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, bedroomDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void BedtimePostNobleSolvedPostJohnAcceptActions() {
		var bedtime = get(MyNodeLabels.BedtimePostNobleSolvedPostJohnAccept.toString());
		
		bedtime
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, bedroomDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void BedtimePostNobleTyrantPostJohnAcceptActions() {
		var bedtime = get(MyNodeLabels.BedtimePostNobleSolvedPostJohnAccept.toString());
		
		bedtime
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, bedroomDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void BedtimePostNobleSolvedPostJohnRejectActions() {
		var bedtime = get(MyNodeLabels.BedtimePostNobleSolvedPostJohnReject.toString());
		
		bedtime
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, bedroomDoor, true))
		.add(new EnableInput());
	}
	@BuilderMethod
	public void BedtimePostNobleTyrantPostJohnRejectActions() {
		var bedtime = get(MyNodeLabels.BedtimePostNobleTyrantPostJohnReject.toString());
		
		bedtime
		.add(new DisableInput())
		.add(new Exit(player, hallwayBackDoor, true))
		.add(new Enter(player, bedroomDoor, true))
		.add(new EnableInput());
	}
	
	
	
	@BuilderMethod
	public void PeasantRevoltActions() {
		var PeasantRevolt = get(MyNodeLabels.PeasantRevolt.toString());
		PeasantRevolt
		.add(new DisableInput())
		.add(new CreateCharacterSequence(peasant1))
		.add(new SetPosition(peasant1, bedroom, "Door"))
		.add(new CreateCharacterSequence(peasant2))
		.add(new SetPosition(peasant2, bedroom, "Door"))
		//.add(new Draw(peasant1, torch))
		//.add(new Draw(peasant2, hammer))
		.add(new Exit(peasant1, bedroomDoor, true))
		.add(new Exit(peasant2, bedroomDoor, true))
		.add(new Enter(peasant1, greatHallDoor, true))
		.add(new Enter(peasant2, greatHallDoor, true))
		.add(new Attack(peasant1, player, true))
		//.add(new Attack(peasant2, player, true))
		.add(new Die(player))
		.add(new FadeOut());
	}
	
	
	
	@BuilderMethod
	public void NobleCoupActions() {
		var NobleCoup = get(MyNodeLabels.NobleCoup.toString());
		NobleCoup
		.add(new SetNarration("NobleCoup"));
	}
	@BuilderMethod
	public void SuccessfulReinActions() {
		var NobleCoup = get(MyNodeLabels.SuccessfulRein.toString());
		NobleCoup
		.add(new SetNarration("SuccessfulRein"));
	}
	
	
	
	


		
			
	
	


}

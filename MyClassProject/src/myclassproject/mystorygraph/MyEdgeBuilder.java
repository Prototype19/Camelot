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
	
	// INITIAL STATE
	@BuilderMethod
	public void rootEdges() {

		var root = get(MyNodeLabels.root.toString());
		var startChoice = new MenuChoice(MenuChoice.Options.Start);
		//var creditsChoice = new MenuChoice(MenuChoice.Options.Credits);
		var intro = get(MyNodeLabels.intro.toString());
		root.add(new Edge(startChoice, intro));
		//root.add(new Edge(creditsChoice, nextNode));
		
	}
	@BuilderMethod
	public void introEdges() {
		var intro = get(MyNodeLabels.intro.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var atBedroomNode = get(MyNodeLabels.atBedroom.toString());
		intro.add(new Edge(closeNarrationChoice,atBedroomNode));
	}
	@BuilderMethod
	public void atBedroomEdges() {
		var atBedroomNode = get(MyNodeLabels.atBedroom.toString());
		var leavebedroom = new PlayerInteraction(MyChoiceLabels.LeaveBedroom.toString(), bedroomDoor, Icons.exit, "Go to Hallway");
		var hallwayinNode = get(MyNodeLabels.hallwayin.toString());
		atBedroomNode.add(new Edge(leavebedroom, hallwayinNode));
	}
	@BuilderMethod
	public void atHallEdges() {
		var hallwayinNode = get(MyNodeLabels.hallwayin.toString());
		var leavebedroom = new PlayerInteraction(MyChoiceLabels.EnterHall.toString(), hallwayBackDoor, Icons.exit, "Go to Throne Room");
		var chooseAudienceNode = get(MyNodeLabels.ChooseAudience.toString());
		hallwayinNode.add(new Edge(leavebedroom, chooseAudienceNode));
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
		var rejectJohn = new DialogChoice("I refuse!");
		var johnDialogAcceptNode = get(MyNodeLabels.JohnDialogAccept.toString());
		var johnDialogRejectNode = get(MyNodeLabels.JohnDialogReject.toString());
		johnDialogNode.add(new Edge(acceptJohn,johnDialogAcceptNode));
		johnDialogNode.add(new Edge(rejectJohn, johnDialogRejectNode));
	}
		// BRANCH: JOHN ACCEPT
	@BuilderMethod
		public void JohnDialogAcceptEdges() {
		var johnDialogAcceptNode = get(MyNodeLabels.JohnDialogAccept.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var chooseAudiencePostJohnAcceptNode = get(MyNodeLabels.ChooseAudiencePostJohnAccept.toString());
		johnDialogAcceptNode.add(new Edge(closeNarrationChoice,chooseAudiencePostJohnAcceptNode));
	}
	@BuilderMethod
	public void ChooseAudiencePostJohnAcceptEdges() {
		var chooseAudiencePostJohnAcceptNode = get(MyNodeLabels.ChooseAudiencePostJohnAccept.toString());
		var chooseNobles = new PlayerInteraction(MyChoiceLabels.TalkToNobles.toString(), noble1, Icons.talk,
				"Talk to the Quarelling Nobles.");
		var NobleQuarrelDialog = get(MyNodeLabels.NobleQuarrelPostJohnAccept.toString());
		chooseAudiencePostJohnAcceptNode.add(new Edge(chooseNobles, NobleQuarrelDialog));
	}
	@BuilderMethod
	public void NobleQuarrelDialogPostJohnAcceptEdges() { 
		var NobleQuarrelDialogNode = get(MyNodeLabels.NobleQuarrelPostJohnAccept.toString());
		var solutionChoice = new DialogChoice("The village's rent will be split equally between you two.");
		var tyrantChoice = new DialogChoice("I will take the village for myself!");
		var NobleQuarrelSolvedNode = get(MyNodeLabels.NobleQuarrelSolvedPostJohnAccept.toString());
		var NobleQuarrelTyrantNode = get(MyNodeLabels.NobleQuarrelTyrantPostJohnAccept.toString());
		NobleQuarrelDialogNode.add(new Edge(solutionChoice,NobleQuarrelSolvedNode));
		NobleQuarrelDialogNode.add(new Edge(tyrantChoice, NobleQuarrelTyrantNode));
	}
	@BuilderMethod
	public void NobleQuarrelSolvedPostJohnAcceptEdges() { 
		var nobleQuarrelSolvedNode = get(MyNodeLabels.NobleQuarrelSolvedPostJohnAccept.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var LeavingHallPostNobleSolvedPostJohnAcceptNode = get(MyNodeLabels.LeavingHallPostNobleSolvedPostJohnAccept.toString());
		nobleQuarrelSolvedNode.add(new Edge(closeNarrationChoice,LeavingHallPostNobleSolvedPostJohnAcceptNode));
	}
	@BuilderMethod
	public void NobleQuarrelTyrantPostJohnAcceptEdges() { 
		var nobleQuarrelSolvedNode = get(MyNodeLabels.NobleQuarrelTyrantPostJohnAccept.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var LeavingHallPostNobleTyrantPostJohnAcceptNode = get(MyNodeLabels.LeavingHallPostNobleTyrantPostJohnAccept.toString());
		nobleQuarrelSolvedNode.add(new Edge(closeNarrationChoice,LeavingHallPostNobleTyrantPostJohnAcceptNode));
	}
	
	
	@BuilderMethod
	public void JohnDialogRejectEdges() {
		var johnDialogRejectNode = get(MyNodeLabels.JohnDialogReject.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var chooseAudiencePostJohnRejectNode = get(MyNodeLabels.ChooseAudiencePostJohnReject.toString());
		johnDialogRejectNode.add(new Edge(closeNarrationChoice,chooseAudiencePostJohnRejectNode));
	}
	@BuilderMethod
	public void ChooseAudiencePostJohnRejectEdges() {
		var chooseAudiencePostJohnRejectNode = get(MyNodeLabels.ChooseAudiencePostJohnReject.toString());
		var chooseNobles = new PlayerInteraction(MyChoiceLabels.TalkToNobles.toString(), noble1, Icons.talk,
				"Talk to the Quarelling Nobles.");
		var NobleQuarrelDialog = get(MyNodeLabels.NobleQuarrelPostJohnReject.toString());
		chooseAudiencePostJohnRejectNode.add(new Edge(chooseNobles, NobleQuarrelDialog));
	}
	@BuilderMethod
	public void NobleQuarrelDialogPostJohnRejectEdges() { 
		var NobleQuarrelDialogNode = get(MyNodeLabels.NobleQuarrelPostJohnReject.toString());
		var solutionChoice = new DialogChoice("The village's rent will be split equally between you two.");
		var tyrantChoice = new DialogChoice("I will take the village for myself!");
		var NobleQuarrelSolvedNode = get(MyNodeLabels.NobleQuarrelSolvedPostJohnReject.toString());
		var NobleQuarrelTyrantNode = get(MyNodeLabels.NobleQuarrelTyrantPostJohnReject.toString());
		NobleQuarrelDialogNode.add(new Edge(solutionChoice,NobleQuarrelSolvedNode));
		NobleQuarrelDialogNode.add(new Edge(tyrantChoice, NobleQuarrelTyrantNode));
	}
	@BuilderMethod
	public void NobleQuarrelSolvedPostJohnRejectEdges() { 
		var nobleQuarrelSolvedNode = get(MyNodeLabels.NobleQuarrelSolvedPostJohnReject.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var LeavingHallPostNobleSolvedPostJohnRejectNode = get(MyNodeLabels.LeavingHallPostNobleSolvedPostJohnReject.toString());
		nobleQuarrelSolvedNode.add(new Edge(closeNarrationChoice,LeavingHallPostNobleSolvedPostJohnRejectNode));
	}
	@BuilderMethod
	public void NobleQuarrelTyrantPostJohnRejectEdges() { 
		var nobleQuarrelSolvedNode = get(MyNodeLabels.NobleQuarrelTyrantPostJohnReject.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var LeavingHallPostNobleTyrantPostJohnRejectNode = get(MyNodeLabels.LeavingHallPostNobleTyrantPostJohnReject.toString());
		nobleQuarrelSolvedNode.add(new Edge(closeNarrationChoice,LeavingHallPostNobleTyrantPostJohnRejectNode));
	}
	
	@BuilderMethod
	public void NobleQuarrelDialogEdges() { 
		var nobleQuarrelDialogNode = get(MyNodeLabels.NobleQuarrelDialog.toString());
		var solutionChoice = new DialogChoice("The village's rent will be split equally between you two.");
		var tyrantChoice = new DialogChoice("I will take the village for myself!");
		var NobleQuarrelSolvedNode = get(MyNodeLabels.NobleQuarrelSolved.toString());
		var NobleQuarrelTyrantNode = get(MyNodeLabels.NobleQuarrelTyrant.toString());
		nobleQuarrelDialogNode.add(new Edge(solutionChoice,NobleQuarrelSolvedNode));
		nobleQuarrelDialogNode.add(new Edge(tyrantChoice, NobleQuarrelTyrantNode));
	}
	
	@BuilderMethod
	public void NobleQuarrelSolvedEdges() {
		var nobleQuarrelSolvedNode = get(MyNodeLabels.NobleQuarrelSolved.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var chooseAudiencePostNobleSolvedNode = get(MyNodeLabels.ChooseAudiencePostNobleSolved.toString());
		nobleQuarrelSolvedNode.add(new Edge(closeNarrationChoice,chooseAudiencePostNobleSolvedNode));
	}
	@BuilderMethod
	public void ChooseAudiencePostNobleSolvedEdges() {
		var chooseAudiencePostNobleSolvedNode = get(MyNodeLabels.ChooseAudiencePostNobleSolved.toString());
		var chooseJohn = new PlayerInteraction(MyChoiceLabels.TalkToJohn.toString(), peasantJohn, Icons.talk,
				"Talk to the Peasant John.");
		var JohnDialogNode = get(MyNodeLabels.JohnDialogPostNobleSolved.toString());
		chooseAudiencePostNobleSolvedNode.add(new Edge(chooseJohn, JohnDialogNode));
	}
	@BuilderMethod
	public void JohnDialogPostNobleSolvedEdges() { 
		var johnDialogNode = get(MyNodeLabels.JohnDialogPostNobleSolved.toString());
		var acceptJohn = new DialogChoice("I will!");
		var rejectJohn = new DialogChoice("I refuse!!");
		var johnDialogAcceptNode = get(MyNodeLabels.JohnDialogAcceptPostNobleSolved.toString());
		var johnDialogRejectNode = get(MyNodeLabels.JohnDialogRejectPostNobleSolved.toString());
		johnDialogNode.add(new Edge(acceptJohn,johnDialogAcceptNode));
		johnDialogNode.add(new Edge(rejectJohn, johnDialogRejectNode));
	}
	@BuilderMethod
	public void JohnDialogAcceptPostNobleSolvedEdges() {
		var johnDialogAcceptNode = get(MyNodeLabels.JohnDialogAcceptPostNobleSolved.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var LeavingHallPostJohnAcceptPostNobleSolvedNode = get(MyNodeLabels.LeavingHallPostJohnAcceptPostNobleSolved.toString());
		johnDialogAcceptNode.add(new Edge(closeNarrationChoice,LeavingHallPostJohnAcceptPostNobleSolvedNode));
	}
	@BuilderMethod
	public void JohnDialogRejectPostNobleSolvedEdges() {
		var johnDialogRejectNode = get(MyNodeLabels.JohnDialogRejectPostNobleSolved.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var LeavingHallPostJohnRejectPostNobleSolvedNode = get(MyNodeLabels.LeavingHallPostJohnRejectPostNobleSolved.toString());
		johnDialogRejectNode.add(new Edge(closeNarrationChoice,LeavingHallPostJohnRejectPostNobleSolvedNode));
	}
	
	
	@BuilderMethod
	public void NobleQuarrelTyrantEdges() {
		var nobleQuarrelTyrantNode = get(MyNodeLabels.NobleQuarrelTyrant.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var chooseAudiencePostNobleTyrantNode = get(MyNodeLabels.ChooseAudiencePostNobleTyrant.toString());
		nobleQuarrelTyrantNode.add(new Edge(closeNarrationChoice,chooseAudiencePostNobleTyrantNode));
	}
	@BuilderMethod
	public void ChooseAudiencePostNobleTyrantEdges() {
		var chooseAudiencePostNobleTyrantNode = get(MyNodeLabels.ChooseAudiencePostNobleTyrant.toString());
		var chooseJohn = new PlayerInteraction(MyChoiceLabels.TalkToJohn.toString(), peasantJohn, Icons.talk,
				"Talk to the Peasant John.");
		var JohnDialogNode = get(MyNodeLabels.JohnDialogPostNobleTyrant.toString());
		chooseAudiencePostNobleTyrantNode.add(new Edge(chooseJohn, JohnDialogNode));
	}
	@BuilderMethod
	public void JohnDialogPostPostNobleTyrantEdges() { 
		var johnDialogNode = get(MyNodeLabels.JohnDialogPostNobleTyrant.toString());
		var acceptJohn = new DialogChoice("I will!");
		var rejectJohn = new DialogChoice("I refuse!!");
		var johnDialogAcceptNode = get(MyNodeLabels.JohnDialogAcceptPostNobleTyrant.toString());
		var johnDialogRejectNode = get(MyNodeLabels.JohnDialogRejectPostNobleTyrant.toString());
		johnDialogNode.add(new Edge(acceptJohn,johnDialogAcceptNode));
		johnDialogNode.add(new Edge(rejectJohn, johnDialogRejectNode));
	}
	@BuilderMethod
	public void JohnDialogAcceptPostNobleTyrantEdges() {
		var johnDialogAcceptNode = get(MyNodeLabels.JohnDialogAcceptPostNobleTyrant.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var LeavingHallPostJohnAcceptPostNobleTyrantNode = get(MyNodeLabels.LeavingHallPostJohnAcceptPostNobleTyrant.toString());
		johnDialogAcceptNode.add(new Edge(closeNarrationChoice,LeavingHallPostJohnAcceptPostNobleTyrantNode));
	}
	@BuilderMethod
	public void JohnDialogRejectPostNobleTyrantEdges() {
		var johnDialogRejectNode = get(MyNodeLabels.JohnDialogRejectPostNobleTyrant.toString());
		var closeNarrationChoice = new CloseNarrationChoice();
		var LeavingHallPostJohnRejectPostNobleTyrantNode = get(MyNodeLabels.LeavingHallPostJohnRejectPostNobleTyrant.toString());
		johnDialogRejectNode.add(new Edge(closeNarrationChoice,LeavingHallPostJohnRejectPostNobleTyrantNode));
	}
	//Leaving Hall
	@BuilderMethod
	public void LeavingHallPostJohnAcceptPostNobleSolvedEdges() {
		var LeavingHallNode = get(MyNodeLabels.LeavingHallPostJohnAcceptPostNobleSolved.toString());
		var leavehall = new PlayerInteraction(MyChoiceLabels.LeaveHall.toString(), greatHallDoor, Icons.exit, "Leave Throne Room");
		var hallwayoutNode = get(MyNodeLabels.HallwayoutPostJohnAcceptPostNobleSolved.toString());
		LeavingHallNode.add(new Edge(leavehall, hallwayoutNode));
	}
	@BuilderMethod
	public void LeavingHallPostJohnRejectPostNobleSolvedEdges() {
		var LeavingHallNode = get(MyNodeLabels.LeavingHallPostJohnRejectPostNobleSolved.toString());
		var leavehall = new PlayerInteraction(MyChoiceLabels.LeaveHall.toString(), greatHallDoor, Icons.exit, "Leave Throne Room");
		var hallwayoutNode = get(MyNodeLabels.HallwayoutPostJohnRejectPostNobleSolved.toString());
		LeavingHallNode.add(new Edge(leavehall, hallwayoutNode));
	}
	@BuilderMethod
	public void LeavingHallPostJohnAcceptPostNobleTyrantEdges() {
		var LeavingHallNode = get(MyNodeLabels.LeavingHallPostJohnAcceptPostNobleTyrant.toString());
		var leavehall = new PlayerInteraction(MyChoiceLabels.LeaveHall.toString(), greatHallDoor, Icons.exit, "Leave Throne Room");
		var hallwayoutNode = get(MyNodeLabels.HallwayoutPostJohnAcceptPostNobleTyrant.toString());
		LeavingHallNode.add(new Edge(leavehall, hallwayoutNode));
	}
	@BuilderMethod
	public void LeavingHallPostJohnRejectPostNobleTyrantEdges() {
		var LeavingHallNode = get(MyNodeLabels.LeavingHallPostJohnRejectPostNobleTyrant.toString());
		var leavehall = new PlayerInteraction(MyChoiceLabels.LeaveHall.toString(), greatHallDoor, Icons.exit, "Leave Throne Room");
		var hallwayoutNode = get(MyNodeLabels.HallwayoutPostJohnRejectPostNobleTyrant.toString());
		LeavingHallNode.add(new Edge(leavehall, hallwayoutNode));
	}
	@BuilderMethod
	public void LeavingHallPostNobleSolvedPostJohnAcceptEdges() {
		var LeavingHallNode = get(MyNodeLabels.LeavingHallPostNobleSolvedPostJohnAccept.toString());
		var leavehall = new PlayerInteraction(MyChoiceLabels.LeaveHall.toString(), greatHallDoor, Icons.exit, "Go to Throne Room");
		var hallwayoutNode = get(MyNodeLabels.HallwayoutPostNobleSolvedPostJohnAccept.toString());
		LeavingHallNode.add(new Edge(leavehall, hallwayoutNode));
	}
	@BuilderMethod
	public void LeavingHallPostNobleTyrantPostJohnAcceptEdges() {
		var LeavingHallNode = get(MyNodeLabels.LeavingHallPostNobleTyrantPostJohnAccept.toString());
		var leavehall = new PlayerInteraction(MyChoiceLabels.LeaveHall.toString(), greatHallDoor, Icons.exit, "Leave Throne Room");
		var hallwayoutNode = get(MyNodeLabels.HallwayoutPostNobleTyrantPostJohnAccept.toString());
		LeavingHallNode.add(new Edge(leavehall, hallwayoutNode));
	}
	@BuilderMethod
	public void LeavingHallPostNobleSolvedPostJohnRejectEdges() {
		var LeavingHallNode = get(MyNodeLabels.LeavingHallPostNobleSolvedPostJohnReject.toString());
		var leavehall = new PlayerInteraction(MyChoiceLabels.LeaveHall.toString(), greatHallDoor, Icons.exit, "Leave Throne Room");
		var hallwayoutNode = get(MyNodeLabels.HallwayoutPostNobleSolvedPostJohnReject.toString());
		LeavingHallNode.add(new Edge(leavehall, hallwayoutNode));
	}
	@BuilderMethod
	public void LeavingHallPostNobleTyrantPostJohnRejectEdges() {
		var LeavingHallNode = get(MyNodeLabels.LeavingHallPostNobleTyrantPostJohnReject.toString());
		var leavehall = new PlayerInteraction(MyChoiceLabels.LeaveHall.toString(), greatHallDoor, Icons.exit, "Leave Throne Room");
		var hallwayoutNode = get(MyNodeLabels.HallwayoutPostNobleTyrantPostJohnReject.toString());
		LeavingHallNode.add(new Edge(leavehall, hallwayoutNode));
	}
	//HallwayOut
	@BuilderMethod
	public void HallwayoutPostJohnAcceptPostNobleSolvedEdges() {
		var LeavingHallNode = get(MyNodeLabels.HallwayoutPostJohnAcceptPostNobleSolved.toString());
		var leavehallway = new PlayerInteraction(MyChoiceLabels.EnterBedroom.toString(), hallwayDoor, Icons.exit, "Enter Bedroom");
		var BedtimeNode = get(MyNodeLabels.BedtimePostJohnAcceptPostNobleSolved.toString());
		LeavingHallNode.add(new Edge(leavehallway, BedtimeNode));
	}
	@BuilderMethod
	public void HallwayoutPostJohnRejectPostNobleSolvedEdges() {
		var LeavingHallNode = get(MyNodeLabels.HallwayoutPostJohnRejectPostNobleSolved.toString());
		var leavehallway = new PlayerInteraction(MyChoiceLabels.EnterBedroom.toString(), hallwayDoor, Icons.exit, "Enter Bedroom");
		var BedtimeNode = get(MyNodeLabels.BedtimePostJohnRejectPostNobleSolved.toString());
		LeavingHallNode.add(new Edge(leavehallway, BedtimeNode));
	}
	@BuilderMethod
	public void HallwayoutPostJohnAcceptPostNobleTyrantEdges() {
		var LeavingHallNode = get(MyNodeLabels.HallwayoutPostJohnAcceptPostNobleTyrant.toString());
		var leavehallway = new PlayerInteraction(MyChoiceLabels.EnterBedroom.toString(), hallwayDoor, Icons.exit, "Enter Bedroom");
		var BedtimeNode = get(MyNodeLabels.BedtimePostJohnAcceptPostNobleTyrant.toString());
		LeavingHallNode.add(new Edge(leavehallway, BedtimeNode));
	}
	@BuilderMethod
	public void HallwayoutPostJohnRejectPostNobleTyrantEdges() {
		var LeavingHallNode = get(MyNodeLabels.HallwayoutPostJohnRejectPostNobleTyrant.toString());
		var leavehallway = new PlayerInteraction(MyChoiceLabels.EnterBedroom.toString(), hallwayDoor, Icons.exit, "Enter Bedroom");
		var BedtimeNode = get(MyNodeLabels.BedtimePostJohnRejectPostNobleTyrant.toString());
		LeavingHallNode.add(new Edge(leavehallway, BedtimeNode));
	}
	@BuilderMethod
	public void HallwayoutPostNobleSolvedPostJohnAcceptEdges() {
		var LeavingHallNode = get(MyNodeLabels.HallwayoutPostNobleSolvedPostJohnAccept.toString());
		var leavehallway = new PlayerInteraction(MyChoiceLabels.EnterBedroom.toString(), hallwayDoor, Icons.exit, "Enter Bedroom");
		var BedtimeNode = get(MyNodeLabels.BedtimePostNobleSolvedPostJohnAccept.toString());
		LeavingHallNode.add(new Edge(leavehallway, BedtimeNode));
	}
	@BuilderMethod
	public void HallwayoutPostNobleTyrantPostJohnAcceptEdges() {
		var LeavingHallNode = get(MyNodeLabels.HallwayoutPostNobleTyrantPostJohnAccept.toString());
		var leavehallway = new PlayerInteraction(MyChoiceLabels.EnterBedroom.toString(), hallwayDoor, Icons.exit, "Enter Bedroom");
		var BedtimeNode = get(MyNodeLabels.BedtimePostNobleTyrantPostJohnAccept.toString());
		LeavingHallNode.add(new Edge(leavehallway, BedtimeNode));
	}
	@BuilderMethod
	public void HallwayoutPostNobleSolvedPostJohnRejectEdges() {
		var LeavingHallNode = get(MyNodeLabels.HallwayoutPostNobleSolvedPostJohnReject.toString());
		var leavehallway = new PlayerInteraction(MyChoiceLabels.EnterBedroom.toString(), hallwayDoor, Icons.exit, "Enter Bedroom");
		var BedtimeNode = get(MyNodeLabels.BedtimePostNobleSolvedPostJohnReject.toString());
		LeavingHallNode.add(new Edge(leavehallway, BedtimeNode));
	}
	@BuilderMethod
	public void HallwayoutPostNobleTyrantPostJohnRejectEdges() {
		var LeavingHallNode = get(MyNodeLabels.HallwayoutPostNobleTyrantPostJohnReject.toString());
		var leavehallway = new PlayerInteraction(MyChoiceLabels.EnterBedroom.toString(), hallwayDoor, Icons.exit, "Enter Bedroom");
		var BedtimeNode = get(MyNodeLabels.BedtimePostNobleTyrantPostJohnReject.toString());
		LeavingHallNode.add(new Edge(leavehallway, BedtimeNode));
	}





	
	
	
	
}

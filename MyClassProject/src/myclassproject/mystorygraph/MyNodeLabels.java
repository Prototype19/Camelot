package myclassproject.mystorygraph;

//Fill this enum with the labels you chose for the NODES of your story graph.
public enum MyNodeLabels{
	root, intro, atBedroom, 
	//Choose Audience
	ChooseAudience, JohnDialog, NobleQuarrelDialog, 
		//JohnDialog
		JohnDialogAccept,JohnDialogReject, 
		//NobleQuarrelDialog
		NobleQuarrelSolved, NobleQuarrelTyrant, 
	
	//Choose Audience Post Noble Solved
	ChooseAudiencePostNobleSolved, JohnDialogPostNobleSolved,
		//JohnDialog
		JohnDialogAcceptPostNobleSolved,JohnDialogRejectPostNobleSolved,

	//Choose Audience Post Noble Tyrant
	ChooseAudiencePostNobleTyrant, JohnDialogPostNobleTyrant,
		//JohnDialog
		JohnDialogAcceptPostNobleTyrant,JohnDialogRejectPostNobleTyrant,
	
	//Choose Audience Post John Accept
	ChooseAudiencePostJohnAccept, NobleQuarrelPostJohnAccept,
		//NobleQuarrelDialog
		NobleQuarrelSolvedPostJohnAccept, NobleQuarrelTyrantPostJohnAccept, 
	
	//Choose Audience Post John Reject
	ChooseAudiencePostJohnReject, NobleQuarrelPostJohnReject,
		//NobleQuarrelDialog
		NobleQuarrelSolvedPostJohnReject, NobleQuarrelTyrantPostJohnReject, 
		
	//Endings
	PeasantRevolt,NobleCoup,SuccessfulRein
}

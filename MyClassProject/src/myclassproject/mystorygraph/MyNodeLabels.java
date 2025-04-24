package myclassproject.mystorygraph;

//Fill this enum with the labels you chose for the NODES of your story graph.
public enum MyNodeLabels{
	root, intro, atBedroom, hallwayin,
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
	
	
	//Leave Hall
	LeavingHallPostJohnAcceptPostNobleSolved,
	LeavingHallPostJohnRejectPostNobleSolved,
	LeavingHallPostJohnAcceptPostNobleTyrant,
	LeavingHallPostJohnRejectPostNobleTyrant,
	LeavingHallPostNobleSolvedPostJohnAccept,
	LeavingHallPostNobleTyrantPostJohnAccept,
	LeavingHallPostNobleSolvedPostJohnReject,
	LeavingHallPostNobleTyrantPostJohnReject,
	//Hallway
	HallwayoutPostJohnAcceptPostNobleSolved,
	HallwayoutPostJohnRejectPostNobleSolved,
	HallwayoutPostJohnAcceptPostNobleTyrant,
	HallwayoutPostJohnRejectPostNobleTyrant,
	HallwayoutPostNobleSolvedPostJohnAccept,
	HallwayoutPostNobleTyrantPostJohnAccept,
	HallwayoutPostNobleSolvedPostJohnReject,
	HallwayoutPostNobleTyrantPostJohnReject,
	//Bed Scenes
	BedtimePostJohnAcceptPostNobleSolved,
	BedtimePostJohnRejectPostNobleSolved,
	BedtimePostJohnAcceptPostNobleTyrant,
	BedtimePostJohnRejectPostNobleTyrant,
	BedtimePostNobleSolvedPostJohnAccept,
	BedtimePostNobleTyrantPostJohnAccept,
	BedtimePostNobleSolvedPostJohnReject,
	BedtimePostNobleTyrantPostJohnReject,
	
	//Endings
	PeasantRevolt,NobleCoup,SuccessfulRein
}

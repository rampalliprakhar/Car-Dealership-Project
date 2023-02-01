import java.util.LinkedList;

public class Report {
	
private int salesStat;
private String salesPersonOTY;
private int salesPersonAmt;

private String[] sevenCandidateCars;

//Assuming this is the sales records for each employee
private String[][] salesRecords;
private String[][] carLotHistory;

public int getsalesStat() {
	return salesStat;
}


public String getsalesPersonOTY() {
	return salesPersonOTY;
}

public int getSalesPersonAmt() {
	
	return salesPersonAmt;
}

public String[] getsevenCandidateCars() {
	
    return sevenCandidateCars;
}


public String[][] getsalesRecords() {
	//I'm sure this will be a while loop until null or end of data
	
	return salesRecords;
	
}

public String[][] getcarLotHistory() {
	//I'm sure this will be a while loop until null or end of data
	return carLotHistory;
}

}



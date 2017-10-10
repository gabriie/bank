package modelLayer;

public class Report extends Entity {
	
	private int idReport;
	private String action;
	private String date;
	int idUser;
	
	public Report(){
		
	}
	
	public Report(int idReport, String action, String date, int idUser){
		this.idReport=idReport;
		this.action=action;
		this.date=date;
		this.idUser=idUser;
	}

	public int getIdReport() {
		return idReport;
	}

	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



}

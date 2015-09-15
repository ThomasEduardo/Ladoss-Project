import java.util.Date;

public class Agenda {
	private int quant;
	private Date date;
	private String açucar;

	 public int getQuant(){ 
		  return quant;
		  }
	  public void setQuant(int quant){
		  this.quant = quant;
	  }
	  public Date getDate(){
		  return date; 
		  }
	  public void setDate(Date date) {
	    this.date = date;
	  }
	 
	  public String getAçucar(){
		  return açucar; 
		  }
	  public void setAçucar(String açucar){
	      this.açucar = açucar;
	  }

	
	}
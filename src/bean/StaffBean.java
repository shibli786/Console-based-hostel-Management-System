package bean;


public class StaffBean  extends BeanClass{
	private String qualification;
	private byte previous_experience;
	private boolean previous_college;
	
	private String joining_date;

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public byte getPrevious_experience() {
		return previous_experience;
	}

	public void setPrevious_experience(byte previous_experience) {
		this.previous_experience = previous_experience;
	}

	public boolean isPrevious_college() {
		return previous_college;
	}

	public void setPrevious_college(boolean previous_college) {
		this.previous_college = previous_college;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}}

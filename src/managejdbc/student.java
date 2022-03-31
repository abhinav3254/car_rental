package managejdbc;
public class student {
    private int studentID;
    private String studdentName;
    private String studentPhone;
    private String studentCity;


    public student(int studentID,String studdentName,String studentPhone,String studentCity) {
        super();
        this.studentID = studentID;
        this.studdentName = studdentName;
        this.studentPhone = studentPhone;
        this.studentCity = studentCity;
    }

    public student(String studdentName,String studentPhone,String studentCity) {
        super();
        this.studdentName = studdentName;
        this.studentPhone = studentPhone;
        this.studentCity = studentCity;
    }
    
    public student() {
        super();
    }

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStuddentName() {
		return studdentName;
	}

	public void setStuddentName(String studdentName) {
		this.studdentName = studdentName;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	@Override
	public String toString() {
		return "student [studentID=" + studentID + ", studdentName=" + studdentName + ", studentPhone=" + studentPhone
				+ ", studentCity=" + studentCity + "]";
	}

    
}

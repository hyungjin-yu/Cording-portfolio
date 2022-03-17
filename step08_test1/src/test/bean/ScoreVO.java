package test.bean;

public class ScoreVO {
	private String studNo;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private String logtime;

	@Override
	public String toString() {
		return "ScoreVO [studNo=" + studNo + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", tot=" + tot + ", avg=" + avg + ", logtime=" + logtime + "]";
	}

	public String getStudNo() {
		return studNo;
	}

	public void setStudNo(String studNo) {
		this.studNo = studNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

}
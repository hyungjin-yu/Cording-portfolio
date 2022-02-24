package imageboard.bean;

public class ImageboardDTO {
	private int seq; 					// 글 번호
	private String imageId; 			// 상품 코드
	private String imageName; 			// 상품명
	private int imagePrice;				// 단가
	private int imageQty; 				// 개수
	private String imageContent;		// 내용
	private String image1; 				// 파일 이름
	private String logtime;				// 작성일

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getImagePrice() {
		return imagePrice;
	}

	public void setImagePrice(int imagePrice) {
		this.imagePrice = imagePrice;
	}

	public int getImageQty() {
		return imageQty;
	}

	public void setImageQty(int imageQty) {
		this.imageQty = imageQty;
	}

	public String getImageContent() {
		return imageContent;
	}

	public void setImageContent(String imageContent) {
		this.imageContent = imageContent;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

}

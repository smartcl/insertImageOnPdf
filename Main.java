public class Main {
	public static void main(String[] args) {
		insertImgOnPdf obj = insertImgOnPdf.init();
		try {
			obj.insertImage("example/res.pdf", "example/1.pdf", "example/title.png", 330, 40, 200, 200);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
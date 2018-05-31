public class Main {
	public static void main(String[] args) {
		editPdf obj = editPdf.init();
		try {
			// obj.insertImage("example/res.pdf", "example/1.pdf", "example/title.png", 330, 40, 200, 200);
			String[] arr = {"transOldSubsName1", "123", "transSubsServnumber1", "456"};
			obj.insertFormText("example/1.pdf", "example/res.pdf", arr);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
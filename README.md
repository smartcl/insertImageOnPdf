java:

	Compile:
			javac -cp lib/iText-2.1.7.jar:lib/itext-asian.jar insertImgOnPdf.java Main.java

	Run:
			java -cp lib/iText-2.1.7.jar:lib/itext-asian.jar:./ Main

	Compiling jar packages:
			jar -cvf insertImgOnPdf.jar insertImgOnPdf.class

node:

	need java and python environment

	install java model:
			npm install java

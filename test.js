var java = require('java');

java.classpath.push(__dirname + "/lib/iText-2.1.7.jar");
java.classpath.push(__dirname + "/lib/itext-asian.jar");
java.classpath.push(__dirname + "/insertImgOnPdf.jar");

var insertImgOnPdf = java.import("insertImgOnPdf");

insertImgOnPdf.insertImage("example/123.pdf", "example/1.pdf", "example/title.png", 330, 40, 200, 200);
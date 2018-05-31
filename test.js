var java = require('java');

java.classpath.push(__dirname + "/lib/iText-2.1.7.jar");
java.classpath.push(__dirname + "/lib/itext-asian.jar");
java.classpath.push(__dirname + "/editPdf.jar");

var editPdf = java.import("editPdf");

//insertImgOnPdf.insertImage("example/123.pdf", "example/1.pdf", "example/title.png", 330, 40, 200, 200);

var arr = ["transOldSubsName1", "123321", "transSubsServnumber1", "456654"];
editPdf.insertFormTextSync("example/1.pdf", "example/res.pdf", arr);
<?php
require("Library/doc2txt.class.php");
include 'db.php';
require 'vendor/autoload.php';

//$client = new Elasticsearch\Client();
$client = Elasticsearch\ClientBuilder::create()->setHosts(['localhost:9200'])->build();

if(isset($_FILES["fileToUpload"]["name"]))
{

$fn=$_POST["fname"];
$ln=$_POST["lname"];
$email=$_POST["email"];
$mobile=$_POST["mobile"];
$linkedin=$_POST["linkedin"];
$tenth=$_POST["tenth"];
$twelfth=$_POST["twelfth"];
$ug=$_POST["ug"];
$pg=$_POST["pg"];
$experience=$_POST["experience"];


//$filename=$_POST["semail"];
$filename=$_FILES["fileToUpload"]["name"];
$ext = pathinfo($filename, PATHINFO_EXTENSION);
$filename=$email.".".$ext;
$temp=$_FILES["fileToUpload"]["tmp_name"];
//echo $temp;
$txt="";
if(move_uploaded_file($temp, "./uploads/".$filename))
{

	$docObj = new Doc2Txt("./uploads/".$filename);
    //$docObj = new Doc2Txt("test.doc");
    $txt = $docObj->convertToText();
}

$file = file_get_contents($linkedin);
$linkedindata=strip_tags($file);
//elastic insert
$params = array();
$params["body"]  = array(
  "fname" => $fn,
  "lname" => $ln,
  "email" => $email ,
  "mobile"=>$mobile,
  "linked"=>$linkedin,
  "linkedindata"=>$linkedindata,
  "resumedata"=>$txt
);
/*
MySQL => Databases => Tables => Columns/Rows
Elasticsearch => Indices => Types => Documents with Properties
*/
$params['index'] = 'application';
$params['type']  = 'resumebot';

$result = $client->index($params);
//

$stmt = $pdo->prepare("INSERT INTO applicants ( 
	fname, lname, email, mobile, linkedin, linkedindata,resume,resumedata,tenth,twelfth,ug,pg,experience)
 VALUES ( :fn, :ln, :email, :mobile,:l,:ld,:r,:rd,:tenth,:twelfth,:ug,:pg,:exp)");
		
		$stmt->execute(array(
			'fn' => $fn,
			'ln'=>$ln,
			'email'=>$email,
			'mobile'=>$mobile,
			'l'=>$linkedin,
			'ld'=>$linkedindata,
			'r'=>$filename,
			'rd'=>$txt,
			'tenth'=>$tenth,
			'twelfth'=>$twelfth,
			'ug'=>$ug,
			'pg'=>$pg,
			'exp'=>$experience));
		if($stmt->rowCount()==1)
		{
			
			echo "Success";
		}
		else
			echo "Failed";

}		
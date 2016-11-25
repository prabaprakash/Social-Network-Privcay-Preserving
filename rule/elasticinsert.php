<?php
$con=mysqli_connect("localhost","root","","abi");
require 'vendor/autoload.php';

//$client = new Elasticsearch\Client();
$client = Elasticsearch\ClientBuilder::create()->setHosts(['localhost:9200'])->build();

$query="select * from applicants";
$r=mysqli_query($con,$query);
while($a=$r->fetch_assoc())
{
$params = array();
$params["body"]  = array(
  "fname" => $a["fname"],
  "lname" => $a["lname"],
  "email" => $a["email"] ,
  "mobile"=>$a["mobile"],
  "linked"=>$a["linked"],
  "linkedindata"=>$a["linkedindata"],
  "resumedata"=>$a["resumedata"]

);
$params['index'] = 'application';
$params['type']  = 'resumebot';

$result = $client->index($params);

}
/*
MySQL => Databases => Tables => Columns/Rows
Elasticsearch => Indices => Types => Documents with Properties
*/

/*

 $query = $es->search([
	'body' =>[
		'query' =>[
			'bool'=>[
				'should' =>[
					'exists' =>['phone_mobile' =>'456'],
					'exists' =>['phone_home'=>'456'] 
					
				]
			]
		]
	]
]);
//for search with filter

$params['index'] = 'applications';
$params['type']  = 'resumebots';

$params['body']['query']['filtered']['filter']['and'][]['term']['resumedata'] = 10;
$params['body']['query']['filtered']['filter']['and'][]['term']['resumedata'] = 8;

$result = $client->search($params);



Search
$params = array();
$params['body']  = array(
  'name' => 'Brock',
  'age' => 15,
  'badges' => 0 
);

$raw_json = '{"took":13,"timed_out":false,"_shards":{"total":5,"successful":5,"failed":0},"hits":{"total":2242,"max_score":1.0,"hits":[{"_index":"999999"}]}}';

$decoded_json = json_decode($raw_json);

echo '<pre>';
print_r($decoded_json);
echo '</pre>';

$params['index'] = 'pokemon';
$params['type']  = 'pokemon_trainer';
$params['id'] = '1A-000';

$result = $client->index($params);

*/

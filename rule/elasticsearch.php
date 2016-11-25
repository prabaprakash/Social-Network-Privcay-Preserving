<?php
require 'vendor/autoload.php';

//$client = new Elasticsearch\Client();
$client = Elasticsearch\ClientBuilder::create()->setHosts(['localhost:9200'])->build();

$params = array();

$params = [
	'index' => 'application',
	'type' => 'resumebot',
	'body' => [
		'query' => [
			'match' => [
				'resumedata' => 'java',
				'resumedata' => 'hadoop',

			]
		]
	]
];


$result = $client->search($params);


print("<pre>".print_r($result,true)."</pre>");

/*
$result= $client->search([
	'body' =>[
		'query' =>[
			'bool'=>[
				'should' =>[
					'exists' =>['mobile' =>'555'],
					'exists' =>['email'=>'456'] 
					
				]
			]
		]
	]
]);
//for search with filter

$params['index'] = 'applications';
$params['type']  = 'resumebots';


$params['body']['query']['filtered']['filter']['and'][]['term']['email'] = 8;
$params['body']['query']['filtered']['filter']['and'][]['term']['mobile'] = 555;

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

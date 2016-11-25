<?php

$file = file_get_contents('https://in.linkedin.com/in/prabaprakash');
echo strip_tags($file);

?>
<?php
 
 header('Content-Type: application/json; charset=utf-8');  

	$host = "localhost";
	$userName = "root";
	$pass = "";
    $db = "imagedatabase";
    
    $connection = mysqli_connect($host,$userName,$pass,$db);

    mysqli_query($connection,"SET character_set_results = 'utf8', character_set_client = 'utf8', character_set_connection = 'utf8', 
        character_set_database = 'utf8', character_set_server = 'utf8'");

    if ($connection) 
    {
        $image = $_POST["image"];
        $caption = $_POST["caption"];

        $myquery = "INSERT INTO allimage(imagecaption) VALUES ('$caption')";
        
        $upload_path = "uploads/$caption.png";

        if (mysqli_query($connection,$myquery)) 
        {
            file_put_contents($upload_path,base64_decode($image));
            echo json_encode(array('response'=>'Image Upload Successfully'));
        }
        else 
        {
            echo json_encode(array('response'=>'Image Upload Failed'));

        }
    }
    else 
    {
        echo json_encode(array('response'=>'Server/Somethings Went Wrong,Try Again'));

    }

    mysqli_close($connection);
 

 ?>
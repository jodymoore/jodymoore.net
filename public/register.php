<?php

    //configuration
    require("../includes/config.php");

    $region='us-east-1';
    $bucket='%bucket%';
    $tmp='';
    $table_name = 'users';
    require ('../aws-autoloader.php');
    date_default_timezone_set('UTC');
    try {
        $sdk = new Aws\Sdk([
            'region'    => $region,
            'version'   => 'latest'
        ]);

        $dynamodb = $sdk->createDynamoDb();

    }
    catch(Exception $e) {
        $tmp=$e->getMessage();        
    }
  

    // if form was submitted
    if ($_SERVER["REQUEST_METHOD"] == "POST")
    {
        // if username is empty apologize
        if (empty($_POST["username"]))
        {
            apologize("You must provide your username.");
        }
        // if password is empty apologize
        if (empty($_POST["password"]))
        {
            apologize("You must provide your password.");
        }
        // if password doesnt match confimation apologize
        if ($_POST["password"] != $_POST["confirmation"])
        {
              apologize("Invalid username and/or password.");
        }

        // update DynamoDB table with id and time()     
        $results = $dynamodb->putItem([
            'TableName' => $table_name,
            'Item' => [
            'id' => ['S' => uniqid()],
            'username' =>['S' => $_POST["username"]],
            'password' => ['S' => crypt($_POST["password"])]
                    ]
        ]);

        if ($result === false )
        {
            render("register_form.php", ["title" => "Register"]); 
        }
        else
        {
            //$rows = query("SELECT LAST_INSERT_ID() AS id");

            $rows = $dynamodb->scan(['TableName' => 'users']);
            
             foreach ($row['Items'] as $key => $value) {  // ***** Debugging *****
                 print($value);
             }

            $id = $rows[0]["id"];
           
            // remember that user's now logged in by storing user's ID in session
            $_SESSION["id"] = $rows["id"];
              
            // redirect to portfolio
            redirect("/");
        }
                        
    }
    else
    {
        //else render form
        render("register_form.php", ["title" => "Register"]);
    }
    
?>
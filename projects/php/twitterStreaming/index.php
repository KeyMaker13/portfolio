<?php
/* 
This is an app to search tiwtter statuses. Written in php.
*/


function queryTwitter($search) 
{
    $url = "https://api.twitter.com/1.1/search/tweets.json";
    if($search != "")
        $search = "#".$search;
    $query = array( 'count' => 100, 'q' => urlencode($search), "result_type" => "recent");
    $oauth_access_token = "1146226588406767618-WiHdtzQY6cvcCORM0yQgGzs9NIQr18";
    $oauth_access_token_secret = "TWoHbQvjG8EJNodjb182oedFg1ELo5j5mtvRSYwcCmHLA";
    $consumer_key = "Cf3QAR0kIt2vSw0rSwVlB30JV";
    $consumer_secret = "cIWbOUS88qFHsgKnmu48mnHumlOBElTa63iFUA9TEYdYvrORXN";

    $oauth = array(
                    'oauth_consumer_key' => $consumer_key,
                    'oauth_nonce' => time(),
                    'oauth_signature_method' => 'HMAC-SHA1',
                    'oauth_token' => $oauth_access_token,
                    'oauth_timestamp' => time(),
                    'oauth_version' => '1.0');

    $base_params = empty($query) ? $oauth : array_merge($query,$oauth);
    $base_info = buildBaseString($url, 'GET', $base_params);
    $url = empty($query) ? $url : $url . "?" . http_build_query($query);

    $composite_key = rawurlencode($consumer_secret) . '&' . rawurlencode($oauth_access_token_secret);
    $oauth_signature = base64_encode(hash_hmac('sha1', $base_info, $composite_key, true));
    $oauth['oauth_signature'] = $oauth_signature;

    $header = array(buildAuthorizationHeader($oauth), 'Expect:');
    $options = array( CURLOPT_HTTPHEADER => $header,
                      CURLOPT_HEADER => false,
                      CURLOPT_URL => $url,
                      CURLOPT_RETURNTRANSFER => true,
                      CURLOPT_SSL_VERIFYPEER => false);

    $feed = curl_init();
    curl_setopt_array($feed, $options);
    $json = curl_exec($feed);
    curl_close($feed);
    return  json_decode($json);
}

function buildBaseString($baseURI, $method, $params)
{
    $r = array(); 
    ksort($params);
    foreach($params as $key=>$value){
        $r[] = "$key=" . rawurlencode($value); 
    }
    return $method."&" . rawurlencode($baseURI) . '&' . rawurlencode(implode('&', $r)); 
}

function buildAuthorizationHeader($oauth)
{
    $r = 'Authorization: OAuth '; 
    $values = array(); 
    foreach($oauth as $key=>$value)
        $values[] = "$key=\"" . rawurlencode($value) . "\""; 
    $r .= implode(', ', $values); 
    return $r; 
}


function displayTweets($object){

    $myArray = json_decode(json_encode($object), true);
    //if(array_key_exists("statuses", $myArray) {
    if(isset($myArray['statuses'])) {      
        foreach ($myArray["statuses"] as $tweet) {
            echo "<div class='col-md-12' style='border:1px solid black;height:500px;width:100%;padding: 20px;background-color:SkyBlue;border-radius:25px;'>";
                echo "<div class='container' >";
        
                    echo "<div class='row'>";
                        echo "<div class='five columns' style='background-color:CornSilk;padding-left:30px;background:url(".$tweet["user"]["profile_background_image_url"].");'>";
                        

                            echo "<h3>User :";
                            echo $tweet['user']['screen_name']."</h3>";
                            echo "<br>";
                            echo "<img src='".$tweet['user']['profile_image_url']."' width='100' height = '100'  style='margin-left:30px;' >";
                            echo "<br>";
                            echo "<br>";


        
                        echo "</div>";
                        echo "<div class='seven columns' style='padding-left:30px;'>";
                        
                            echo "<span style='color:mintcream;font-size:20px;'>";
                            echo "Tweet: ";
                            echo $tweet['text'];
                            echo "<br>";
                            echo "<br>";
                            echo "<br>";
                            echo "Name: ";
                            echo $tweet["user"]["name"];
                            echo "<br>";
                            echo "<br>";
                            echo "<br>";
                            echo "Location: ";
                            echo $tweet['user']['location'];
                            echo "<br>"; 
                            echo "<br>";
                            echo "url: "; 
            
                                foreach ($tweet["entities"]["urls"] as $url){
                                    //echo "<a onclick=\"openNewWindow('".$url["url"]."')\" href='".$url["url"]."' > ".$url["url"]." </a>";
                                    echo "<a onclick=\"openNewWindow('".$url["url"]."')\" href='#' > ".$url["url"]." </a>";
                                    echo "<br>";
                                    echo "expanded url: ";
                                    //echo "<a onclick=\"openNewWindow('".$url["expanded_url"]."')\" href='".$url["expanded_url"]."' > ".$url["expanded_url"]." </a>";
                                    echo "<a onclick=\"openNewWindow('".$url["expanded_url"]."')\" href='#' > ".$url["expanded_url"]." </a>";
                                    echo "<br>";
                                }
                            
                            
                            
                            echo "</span>";
                
                        echo "</div>";
                    echo "</div>";
                echo "</div>";
            echo "</div>";

        
        }
    }
}
?>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Twitter Stream API</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="Skeleton-2.0.4/css/skeleton.css"> 
  <link rel="stylesheet" href="Skeleton-2.0.4/css/normalize.css"> 


  <script async defer src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap"
  type="text/javascript"></script>

    <script>

        function openNewWindow(link){

            //alert(link);
            myWindow = window.open(link)


        }

    </script>


</head>
<body style="background-Color:snow;">


<div id="headerDiv" style='width:100%;height:50px;color:snow;border:5px solid black;background: rgb(2,0,36);
background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(7,7,198,1) 55%, rgba(0,212,255,1) 100%);'>

<h6>Welcome to Twitter Stream API. This allows you to search twitter statuses. Type in the keyword and you will see a tweet.</h6>


  
</div>


<form method="post" name="postForm" action="index.php">    
    <label>Search status</label>
    <input type="text" name="search" id="search" placeholder="Twitter">
    <input type="submit" value="Send" class="btn btn-primary" />
</form>


<div style="width:100%;background-color:snow;">
<?php


if (isset($_POST["search"])){

    if ($_POST["search"]  == ""){


    } else {
        
        displayTweets(queryTwitter($_POST["search"]));

    }
    
}

?>
</div>
</body>
</html>
<?php

$email = urldecode($_REQUEST["email"]);

require_once('../_Banco/bd_config.php');

$stmt = mysqli_prepare($conn, "SELECT Email FROM Usuario_Professor WHERE Email = ?");
mysqli_stmt_bind_param($stmt,'s',$email);
mysqli_stmt_execute($stmt);
mysqli_stmt_bind_result($stmt, $rows->Email);

while(mysqli_stmt_fetch($stmt)){
   $string_Email = utf8_encode($rows->Email);
   $result = $string_Email;
}
if($result==$email){
    $output = array( 'Retorno' => 1);
}else{
    $output = array( 'Retorno' => 0);
}
mysqli_close($conn);
echo json_encode($output);

?>
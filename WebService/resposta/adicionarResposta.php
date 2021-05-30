<?php
	
$Corpo_Resposta = urldecode($_REQUEST["Corpo_Resposta"]);
$Nota_Resposta = urldecode($_REQUEST["Nota_Resposta"]);

require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "INSERT INTO Resposta (Corpo_Resposta, Nota_Resposta) VALUES (?,?)");
mysqli_stmt_bind_param($stmt,'ss',$Corpo_Resposta, $Nota_Resposta);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);


?>
<?php
	

$Corpo_Questao = urldecode($_REQUEST["Corpo_Questao"]);
$Gabarito = urldecode($_REQUEST["Gabarito"]);
$Qualificacao_Questao = urldecode($_REQUEST["Qualificacao_Questao"]);


require_once('../_Banco/bd_config.php');


if (mysqli_connect_errno()){
    trigger_error(mysqli_connect_error(), E_USER_ERROR);
}
$stmt = mysqli_prepare($conn, "INSERT INTO Questao (Corpo_Questao, Gabarito, Qualificacao_Questao) VALUES (?,?,?)");
mysqli_stmt_bind_param($stmt,'sss',$Corpo_Questao, $Gabarito, $Qualificacao_Questao);

mysqli_stmt_execute($stmt);
if(mysqli_stmt_affected_rows($stmt) > 0){
$output = array('Resultado' => true);
}else{	
$output = array('Resultado' => false);
}
mysqli_close($conn);
echo json_encode($output, JSON_UNESCAPED_UNICODE);


?>
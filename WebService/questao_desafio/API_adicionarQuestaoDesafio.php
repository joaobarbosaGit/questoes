<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

    header('Content-type: application/json');

    $API_Token = urldecode($_REQUEST["API_Token"]);
    $Corpo_Questao = urldecode($_REQUEST["Corpo_Questao"]);
    $Gabarito = urldecode($_REQUEST["Gabarito"]);
    $Qualificacao_Questao = urldecode($_REQUEST["Qualificacao_Questao"]);
    
    if ($API_Token == '@*Bo^UTaQkKg') {

        require_once('../_Banco/bd_config.php');
        mysqli_set_charset($conn, $charset);
        $response = array();
      
        $stmt = mysqli_prepare($conn,"INSERT Questao_Desafio (Corpo_Questao, Gabarito, Qualificacao_Questao) VALUES (?,?,?)");
        mysqli_stmt_bind_param($stmt,'sss', $Corpo_Questao, $Gabarito, $Qualificacao_Questao);
        mysqli_stmt_execute($stmt);
        
        if (mysqli_stmt_affected_rows($stmt) > 0) {

           $response["result"] = "true";
            
            echo json_encode($response); 
            
        } else {

            $response["result"] = "false";
           // $response["SQL"] = $sql;
            
            echo json_encode($response);
        }
    } else {

        $response['result'] = "token-false";
        echo json_encode($response);
    }
}
?>

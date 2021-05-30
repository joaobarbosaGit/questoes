<?php

    require_once('../_Banco/bd_config.php');

    mysqli_set_charset($conn, $charset);
    $stmt = mysqli_prepare($conn," SELECT MAX(idQuestao_Desafio) AS idQuestao_Desafio FROM Questao_Desafio");
    mysqli_stmt_execute($stmt);
    $stmt->store_result();
        if($stmt->num_rows > 0){
            mysqli_stmt_bind_result($stmt, $rows->idQuestao_Desafio);

                while(mysqli_stmt_fetch($stmt)){
                    $response = array('Resultado' => true, 'ID' => $rows->idQuestao_Desafio);
                }

        }else{
            $response = array( 'Resultado' => false);
        }    

    echo json_encode($response);
       
?>
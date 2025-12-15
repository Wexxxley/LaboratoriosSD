<?php

// Captura os dados enviados pelo formulário
$num1 = $_GET['num1'] ?? 0;
$num2 = $_GET['num2'] ?? 0;
$operacao = $_GET['operacao'] ?? 'somar';

// Montando a url da api
$url = "http://localhost:8080/$operacao/$num1/$num2";

// Inicializa o cURL para fazer a requisição
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// Executa a requisição e guarda a resposta
$resposta = curl_exec($ch);

// Verifica se houve erro na conexão
if (curl_errno($ch)) {
    die("Erro na requisição: " . curl_error($ch));
}

curl_close($ch);

// Redireciona para a tela de resultado enviando a resposta na URL
header("Location: resultado.php?resposta=" . urlencode($resposta));

?>

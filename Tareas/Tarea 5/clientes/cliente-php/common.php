<?php
$API_BASE = 'http://192.168.0.115:8000/api';

function http_request($method, $path, $token = null, $data = null) {
    global $API_BASE;

    $url = rtrim($API_BASE, '/') . '/' . ltrim($path, '/');

    $headers = "Accept: application/json\r\n" .
               "Content-Type: application/json\r\n";
    if ($token) {
        $headers .= "Authorization: Bearer " . $token . "\r\n";
    }
    $options = [
        'http' => [
            'method' => strtoupper($method),
            'header' => $headers,
            'ignore_errors' => true,
        ]
    ];

    if ($data !== null) {
        $options['http']['content'] = json_encode($data);
    }

    $context = stream_context_create($options);
    $response = @file_get_contents($url, false, $context);
    $status = 0;
    if (isset($http_response_header) && is_array($http_response_header)) {
        foreach ($http_response_header as $h) {
            if (preg_match('/HTTP\/\d+\.\d+\s+(\d+)/', $h, $m)) {
                $status = (int)$m[1];
                break;
            }
        }
    }
    $body = null;
    if ($response !== false && $response !== '') {
        $body = json_decode($response, true);
    }

    return ['status' => $status, 'body' => $body, 'raw' => $response];
}

function redirect($url) {
    header('Location: ' . $url);
    exit;
}

// Construye el payload 'persona' desde un array (por ejemplo $_POST)
function person_payload_from_array($data) {
    return [
        'nombres' => $data['nombres'] ?? '',
        'apellidos' => $data['apellidos'] ?? '',
        'ci' => $data['ci'] ?? '',
        'direccion' => $data['direccion'] ?? '',
        'telefono' => $data['telefono'] ?? '',
        'email' => $data['email'] ?? '',
    ];
}

?>

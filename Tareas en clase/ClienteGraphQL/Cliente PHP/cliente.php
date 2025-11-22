<?php
session_start();

class AgendaGraphQLClient {
    private $apiUrl = 'http://127.0.0.1:8000/api';
    private $graphqlUrl = 'http://127.0.0.1:8000/graphql';

    public function login($email, $password) {
        $data = json_encode(['email' => $email, 'password' => $password]);
        
        $curl = curl_init();
        curl_setopt_array($curl, [
            CURLOPT_URL => $this->apiUrl . '/login',
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => $data,
            CURLOPT_HTTPHEADER => ['Content-Type: application/json']
        ]);
        
        $response = curl_exec($curl);
        curl_close($curl);
        
        $result = json_decode($response, true);
        
        if (isset($result['token'])) {
            $_SESSION['token'] = $result['token'];
            return ['success' => true, 'message' => 'Login exitoso!'];
        }
        
        return ['success' => false, 'message' => 'Error en login'];
    }

    private function graphqlRequest($query, $variables = []) {
        $data = json_encode([
            'query' => $query,
            'variables' => $variables
        ]);
        
        $headers = [
            'Content-Type: application/json'
        ];
        
        if (isset($_SESSION['token'])) {
            $headers[] = 'Authorization: Bearer ' . $_SESSION['token'];
        }
        
        $curl = curl_init();
        curl_setopt_array($curl, [
            CURLOPT_URL => $this->graphqlUrl,
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => $data,
            CURLOPT_HTTPHEADER => $headers
        ]);
        
        $response = curl_exec($curl);
        curl_close($curl);
        
        return json_decode($response, true);
    }

    public function listarPersonas() {
        $query = '
            query {
                personas {
                    id
                    nombres
                    apellidos
                    ci
                    email
                }
            }
        ';
        
        $result = $this->graphqlRequest($query);
        
        if (isset($result['data']['personas'])) {
            return $result['data']['personas'];
        }
        
        return [];
    }

    public function crearPersona($nombres, $apellidos, $ci, $email) {
        $mutation = '
            mutation CreatePersona($nombres: String!, $apellidos: String!, $ci: String!, $email: String) {
                createPersona(nombres: $nombres, apellidos: $apellidos, ci: $ci, email: $email) {
                    id
                    nombres
                    apellidos
                    ci
                    email
                }
            }
        ';
        
        $variables = [
            'nombres' => $nombres,
            'apellidos' => $apellidos,
            'ci' => $ci,
            'email' => $email
        ];
        
        $result = $this->graphqlRequest($mutation, $variables);
        
        if (isset($result['data']['createPersona'])) {
            return ['success' => true, 'message' => 'Persona creada!'];
        }
        
        return ['success' => false, 'message' => 'Error al crear persona'];
    }
}

$client = new AgendaGraphQLClient();
$message = '';
$personas = [];

if ($_POST) {
    if (isset($_POST['login'])) {
        $result = $client->login($_POST['email'], $_POST['password']);
        $message = $result['message'];
    }
    
    if (isset($_POST['crear'])) {
        $result = $client->crearPersona($_POST['nombres'], $_POST['apellidos'], $_POST['ci'], $_POST['persona_email']);
        $message = $result['message'];
    }
    
    if (isset($_POST['listar'])) {
        $personas = $client->listarPersonas();
        $message = 'Lista cargada con GraphQL';
    }
    
    if (isset($_POST['logout'])) {
        session_destroy();
        $message = 'Sesión cerrada';
    }
}

if (isset($_SESSION['token'])) {
    $personas = $client->listarPersonas();
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Agenda GraphQL - PHP</title>
    <style>
        body { font-family: Arial; margin: 20px; }
        .form-group { margin: 10px 0; }
        input[type="text"], input[type="email"], input[type="password"] { 
            padding: 5px; width: 200px; 
        }
        button { padding: 8px 15px; margin: 5px; }
        .message { 
            padding: 10px; margin: 10px 0; 
            background: #ddd; border-radius: 4px; 
        }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1> Agenda GraphQL - PHP Client</h1>
    
    <?php if ($message): ?>
        <div class="message"><?= htmlspecialchars($message) ?></div>
    <?php endif; ?>
    
    <?php if (!isset($_SESSION['token'])): ?>
        <!-- Login Form -->
        <h3>Login</h3>
        <form method="POST">
            <div class="form-group">
                <label>Email:</label><br>
                <input type="email" name="email" value="admin@test.com" required>
            </div>
            <div class="form-group">
                <label>Password:</label><br>
                <input type="password" name="password" value="password123" required>
            </div>
            <button type="submit" name="login">Iniciar Sesión</button>
        </form>
        
    <?php else: ?>
        <div style="text-align: right;">
            <form method="POST" style="display: inline;">
                <button type="submit" name="logout">Cerrar Sesión</button>
            </form>
        </div>
        
        <h3> Crear Persona (GraphQL Mutation)</h3>
        <form method="POST">
            <div class="form-group">
                <label>Nombres:</label><br>
                <input type="text" name="nombres" required>
            </div>
            <div class="form-group">
                <label>Apellidos:</label><br>
                <input type="text" name="apellidos" required>
            </div>
            <div class="form-group">
                <label>CI:</label><br>
                <input type="text" name="ci" required>
            </div>
            <div class="form-group">
                <label>Email:</label><br>
                <input type="email" name="persona_email">
            </div>
            <button type="submit" name="crear">Crear con GraphQL</button>
        </form>
        
        <h3>Lista de Personas (GraphQL Query)</h3>
        <form method="POST">
            <button type="submit" name="listar">Actualizar Lista</button>
        </form>
        
        <?php if ($personas): ?>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>CI</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($personas as $persona): ?>
                        <tr>
                            <td><?= $persona['id'] ?></td>
                            <td><?= htmlspecialchars($persona['nombres'] ?? '') ?></td>
                            <td><?= htmlspecialchars($persona['apellidos'] ?? '') ?></td>
                            <td><?= htmlspecialchars($persona['ci'] ?? '') ?></td>
                            <td><?= htmlspecialchars($persona['email'] ?? '') ?></td>
                        </tr>
                    <?php endforeach; ?>
                </tbody>
            </table>
        <?php endif; ?>
        
    <?php endif; ?>
</body>
</html>
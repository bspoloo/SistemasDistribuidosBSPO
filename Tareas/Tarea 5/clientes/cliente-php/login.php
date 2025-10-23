<?php
// Página de login muy simple y fácil de entender.
require_once __DIR__ . '/common.php';

$messages = [];

// Si el formulario fue enviado, intentamos autenticar
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Tomamos email y password desde POST
    $email = $_POST['email'] ?? '';
    $password = $_POST['password'] ?? '';

    // Petición a la API: /api/login
    $res = http_request('POST', 'login', null, ['email' => $email, 'password' => $password]);

    if ($res['status'] === 200 && isset($res['body']['token'])) {
        // Guardamos token en cookie para futuras peticiones
        $token = $res['body']['token'];
        setcookie('token', $token, time() + 3600, '/');
        // Redirigimos al index
        redirect('index.php');
    } else {
        $messages[] = 'Login fallido.';
    }
}

?>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Login</title>
  <style>
    body{font-family:Arial;margin:20px}
    form{max-width:400px}
    .msg{background:#f8f8f8;border:1px solid #ddd;padding:8px;margin-bottom:12px}
  </style>
</head>
<body>
  <h1>Login</h1>
  <?php foreach ($messages as $m) { echo '<div class="msg">' . htmlspecialchars($m) . '</div>'; } ?>
  <form method="post">
    <label>Email:<br><input type="email" name="email" required></label><br><br>
    <label>Password:<br><input type="password" name="password" required></label><br><br>
    <button type="submit">Login</button>
  </form>
  <p><a href="index.php">Volver</a></p>
</body>
</html>

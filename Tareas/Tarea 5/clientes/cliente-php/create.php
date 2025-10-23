<?php
require_once __DIR__ . '/common.php';

$messages = [];
$token = $_COOKIE['token'] ?? null;

if (!$token) {
    redirect('login.php');
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {

  $payload = person_payload_from_array($_POST);
  $res = http_request('POST', 'personas', $token, $payload);
    if ($res['status'] === 201) {
        redirect('index.php');
    } else {
        $messages[] = 'Error al crear persona.';
    }
}

?>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Crear Persona</title>
  <style>body{font-family:Arial;margin:20px}form{max-width:500px}.msg{background:#f8f8f8;border:1px solid #ddd;padding:8px;margin-bottom:12px}</style>
</head>
<body>
  <h1>Crear Persona</h1>
  <?php foreach ($messages as $m) { echo '<div class="msg">' . htmlspecialchars($m) . '</div>'; } ?>
  <form method="post">
    <label>Nombres:<br><input type="text" name="nombres" required></label><br><br>
    <label>Apellidos:<br><input type="text" name="apellidos" required></label><br><br>
    <label>CI:<br><input type="text" name="ci"></label><br><br>
    <label>Direccion:<br><input type="text" name="direccion"></label><br><br>
    <label>Telefono:<br><input type="text" name="telefono"></label><br><br>
    <label>Email:<br><input type="email" name="email"></label><br><br>
    <button type="submit">Crear</button>
  </form>
  <p><a href="index.php">Volver</a></p>
</body>
</html>

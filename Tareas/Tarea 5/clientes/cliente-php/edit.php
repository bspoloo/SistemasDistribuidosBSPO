<?php
require_once __DIR__ . '/common.php';

$token = $_COOKIE['token'] ?? null;
if (!$token) redirect('login.php');

$messages = [];
$id = $_GET['id'] ?? '';
if (!$id) {
    // no id => volver al index
    redirect('index.php');
}

// Obtener datos de la persona
$res = http_request('GET', "personas/{$id}", $token, null);
$persona = null;
if ($res['status'] === 200 && is_array($res['body'])) {
    $persona = $res['body'];
} else {
    $messages[] = 'No se pudo cargar la persona.';
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $payload = person_payload_from_array($_POST);
    $res2 = http_request('PUT', "personas/{$id}", $token, $payload);
    if ($res2['status'] === 200) {
        redirect('index.php');
    } else {
        $messages[] = 'Error al actualizar.';
    }
}

?>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>Editar Persona</title>
  <style>body{font-family:Arial;margin:20px}form{max-width:500px}.msg{background:#f8f8f8;border:1px solid #ddd;padding:8px;margin-bottom:12px}</style>
</head>
<body>
  <h1>Editar Persona</h1>
  <?php foreach ($messages as $m) { echo '<div class="msg">' . htmlspecialchars($m) . '</div>'; } ?>
  <?php if ($persona): ?>
  <form method="post">
    <label>Nombres:<br><input type="text" name="nombres" required value="<?php echo htmlspecialchars($persona['nombres'] ?? ''); ?>"></label><br><br>
    <label>Apellidos:<br><input type="text" name="apellidos" required value="<?php echo htmlspecialchars($persona['apellidos'] ?? ''); ?>"></label><br><br>
    <label>CI:<br><input type="text" name="ci" value="<?php echo htmlspecialchars($persona['ci'] ?? ''); ?>"></label><br><br>
    <label>Direccion:<br><input type="text" name="direccion" value="<?php echo htmlspecialchars($persona['direccion'] ?? ''); ?>"></label><br><br>
    <label>Telefono:<br><input type="text" name="telefono" value="<?php echo htmlspecialchars($persona['telefono'] ?? ''); ?>"></label><br><br>
    <label>Email:<br><input type="email" name="email" value="<?php echo htmlspecialchars($persona['email'] ?? ''); ?>"></label><br><br>
    <button type="submit">Guardar</button>
  </form>
  <?php endif; ?>
  <p><a href="index.php">Volver</a></p>
</body>
</html>

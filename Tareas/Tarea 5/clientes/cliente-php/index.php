<?php

require_once __DIR__ . '/common.php';
$messages = [];

$token = $_COOKIE['token'] ?? null;

if (!$token) {
  redirect('login.php');
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
  $action = $_POST['action'] ?? '';

  if ($action === 'logout') {
    setcookie('token', '', time()-3600, '/');
    unset($_COOKIE['token']);
    redirect('login.php');
  }

  // Las acciones create y update se manejan en create.php y edit.php respectivamente.

  if ($action === 'delete') {
    $id = $_POST['id'] ?? '';
    $res = http_request('DELETE', "personas/{$id}", $token, null);
    if ($res['status'] === 204 || $res['status'] === 200) {
      $messages[] = 'Persona eliminada.';
    } else {
      $messages[] = 'Error eliminar.';
    }
  }
}

$list = http_request('GET', 'personas', $token, null);
$personas = [];
if ($list['status'] === 200 && is_array($list['body'])) $personas = $list['body'];
else if ($list['status'] === 401) $messages[] = 'No autorizado - haga login.';
else if ($list['status'] !== 200) $messages[] = 'Error al listar: ' . json_encode($list['body'] ?? $list['raw']);

?>

<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<title></title>
<style>body{font-family:Arial;margin:20px}table{border-collapse:collapse;width:100%}th,td{border:1px solid #ccc;padding:6px;text-align:left}form{margin-bottom:10px}input[type=text],input[type=email],input[type=password]{width:100%;padding:6px;box-sizing:border-box}.msg{background:#f8f8f8;border:1px solid #ddd;padding:8px;margin-bottom:12px}</style>
</head>
<body>
<?php foreach ($messages as $m) { echo '<div class="msg">' . htmlspecialchars($m) . '</div>'; } ?>
<div style="display:flex;gap:8px;align-items:center;margin-bottom:10px">
  <form method="post" style="display:inline-block;margin:0">
    <input type="hidden" name="action" value="logout">
    <button type="submit">Logout</button>
  </form>
  <a href="create.php"><button type="button">Crear</button></a>
</div>
<h2>Lista personas</h2>
<table>
<thead><tr><th>id</th><th>nombres</th><th>apellidos</th><th>ci</th><th>direccion</th><th>telefono</th><th>email</th><th>acciones</th></tr></thead>
<tbody>
<?php if (count($personas)===0): ?><tr><td colspan="8">No hay personas o no autorizado.</td></tr><?php else: foreach($personas as $p): ?>
<tr>
<td><?php echo htmlspecialchars($p['id'] ?? ''); ?></td>
<td><?php echo htmlspecialchars($p['nombres'] ?? ''); ?></td>
<td><?php echo htmlspecialchars($p['apellidos'] ?? ''); ?></td>
<td><?php echo htmlspecialchars($p['ci'] ?? ''); ?></td>
<td><?php echo htmlspecialchars($p['direccion'] ?? ''); ?></td>
<td><?php echo htmlspecialchars($p['telefono'] ?? ''); ?></td>
<td><?php echo htmlspecialchars($p['email'] ?? ''); ?></td>
<td>
  <form method="post" style="display:inline-block" onsubmit="return confirm('Eliminar?')">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="<?php echo htmlspecialchars($p['id'] ?? ''); ?>">
    <button type="submit">Eliminar</button>
  </form>
  <a href="edit.php?id=<?php echo urlencode($p['id'] ?? ''); ?>"><button type="button">Editar</button></a>
</td>
</tr>
<?php endforeach; endif; ?>
</tbody>
</table>
</body>
</html>
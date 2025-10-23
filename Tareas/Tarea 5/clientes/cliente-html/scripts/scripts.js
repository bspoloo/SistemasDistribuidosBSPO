var asente = "asc";
var modal = document.getElementById("myModal");
var openModalBtn = document.getElementById("openModalBtn");
// var closeBtn = document.getElementById("close");

mostrar = function () {
    var modal = document.getElementById("myModal");
    modal.style.display = "block";
};

cerrar = function () {
    document.getElementById("myModal").style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
};

function cargarContenido(abrir) {
    var contenedor;
    contenedor = document.getElementById("contenido");
    fetch(abrir)
        .then((response) => response.text())
        .then((data) => (contenedor.innerHTML = data));
}

function crearPersona() {
    var datos = new FormData(document.querySelector("#form-data"));

    fetch("http://127.0.0.1:8000/api/personas", {
        headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`,
            Accept: "application/json"
        },
        method: "POST",
        body: datos
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            document.querySelector("#titulo-modal").innerHTML = "Mensaje";
            document.querySelector("#contenido-modal").innerHTML = data.message ?? `Persona ${data.nombres} Creada correctamente`;
            mostrar();
            setTimeout(() => {
                cerrar();
                listar()
            }, 2000);
        })
        .catch(err => console.error(err));
}

function eliminar(id) {
    const confirmado = confirm(`¿Estás seguro de que quieres eliminar a la persona`);

    if (confirmado) {
        var url = `http://127.0.0.1:8000/api/personas/${id}`;
        var contenedor = document.getElementById("contenido");
        fetch(url, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem("token")}`,
                Accept: "application/json"
            },
            method: "DELETE",
        })
            .then((response) => response.json())
            .then((data) => {
                document.querySelector("#titulo-modal").innerHTML = "Eliminado"
                document.querySelector("#contenido-modal").innerHTML = `Persona ${data.nombres} Eliminado correctamente`
                document.getElementById("myModal").style.display = "block";
                mostrar();
                setTimeout(() => {
                    cerrar();
                    listar()
                }, 2000);
            }).catch((err) => {
                console.log(err);
            });
    } else {
        console.log("Eliminación cancelada");
    }
}

function cargarPagina(pagina, buscar, orden, ascendente) {
    var url = `read.php?pagina=${pagina}&buscar=${buscar}&orden=${orden}&asendente=${ascendente}`;
    var contenedor = document.getElementById("contenido");
    fetch(url)
        .then((response) => response.text())
        .then((data) => (contenedor.innerHTML = data));
}

function loadForm(id) {
    if (id) {
        var url = `http://127.0.0.1:8000/api/personas/${id}`;
        var contenedor = document.getElementById("contenido");
        fetch(url, {
            headers: {
                Authorization: `Bearer ${localStorage.getItem("token")}`,
                Accept: "application/json"
            }
        })
            .then((response) => response.json())
            .then((data) => {
                document.querySelector("#titulo-modal").innerHTML = "Editar"
                document.querySelector("#contenido-modal").innerHTML = getFormulario(data)
                document.getElementById("myModal").style.display = "block";
            });
        return;
    }
    document.querySelector("#titulo-modal").innerHTML = "Crear"
    document.querySelector("#contenido-modal").innerHTML = getFormulario()
    document.getElementById("myModal").style.display = "block";
}

function guardarEditar(id) {
    const form = document.querySelector("#form-data");

    // Creamos un objeto con los campos del formulario
    const datos = {
        nombres: form.nombres.value,
        apellidos: form.apellidos.value,
        ci: form.ci.value,
        direccion: form.direccion.value,
        telefono: form.telefono.value,
        email: form.email.value
    };

    fetch(`http://localhost:8000/api/personas/${id}`, {
        method: "PUT",
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("token")}`,
            "Accept": "application/json",
            "Content-Type": "application/json"  // MUY importante
        },
        body: JSON.stringify(datos)
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);  // Aquí verás la respuesta actualizada
            document.querySelector("#titulo-modal").innerHTML = "Mensaje";
            document.querySelector("#contenido-modal").innerHTML = data.message ?? `Persona ${data.nombres} actualizada correctamente`;
            mostrar();
            setTimeout(() => {
                cerrar();
                listar()
            }, 2000);
        })
        .catch(err => console.error(err));
}

function listar() {
    var contenedor;
    contenedor = document.getElementById("contenido");
    fetch("http://127.0.0.1:8000/api/personas", {
        headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`,
            Accept: "application/json"
        }
    })
        .then((response) => response.json())
        .then((data) => {
            // data = JSON.parse(data);
            contenedor.innerHTML = renderizarTablaRead(data);
        }).catch((err) => {
            console.log(err);
            alert(err.message);
        });
}

function getFormulario(data) {
    var action = data ? `guardarEditar(${data.id})` : "crearPersona()";
    return /*html*/`
        <form class="form-data" action="javascript:${action}" id="form-data" autocomplete="on" novalidate>
            
            <div class="field">
                <label for="nombres">Nombres</label>
                <input class="input" id="nombres" name="nombres" type="text" value="${data ? data.nombres : ""}" required />
            </div>

            <div class="field">
                <label for="apellidos">Apellidos</label>
                <input class="input" id="apellidos" name="apellidos" type="text" value="${data ? data.apellidos : ""}" required />
            </div>

            <div class="field">
                <label for="ci">CI</label>
                <input class="input" id="ci" name="ci" type="text" value="${data ? data.ci : ""}" required />
            </div>

            <div class="field">
                <label for="direccion">Dirección</label>
                <input class="input" id="direccion" name="direccion" type="text" value="${data ? data.direccion : ""}" required />
            </div>

            <div class="field">
                <label for="telefono">Teléfono</label>
                <input class="input" id="telefono" name="telefono" type="text" value="${data ? data.telefono : ""}" required max=10 />
            </div>

            <div class="field">
                <label for="email">Correo electrónico</label>
                <input class="input" id="email" name="email" type="email" value="${data ? data.email : ""}" required />
            </div>

            <br>
            <div class="row">
                <button class="btn" type="submit">Guardar</button>
                <button class="btn" type="button" onclick="cerrar()">Cancelar</button>
            </div>
        </form>
    `;
}


function renderizarTablaRead(data) {
    let html = /*html*/`
    <div class="menu">
            <h3>Insertar Persona</h3>
            <button class="btn" onclick="loadForm()">Insertar</button>
    </div>
    <table class="data-table">
			<thead>
                <tr>
                    <th>Nro</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>CI</th>
                    <th>Direccion</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                    <th>Operaciones</th>
                </tr>
    		</thead>`;

    data.forEach((item, index) => {
        html += /*html*/ `
        <tr>
            <td>${index + 1}</td>
            <td>${item.nombres}</td>
            <td>${item.apellidos} </td>
            <td>${item.ci}</td>
            <td>${item.direccion} </td>
            <td>${item.email} </td>
            <td>${item.telefono} </td>
        
            <td>
                <a href="javascript:loadForm('${item.id}')">Editar</a>  
                <a href="javascript:eliminar('${item.id}')">Eliminar</a> 
            </td>
        </tr>`;
    });
    html += "</table>";
    return html;
}